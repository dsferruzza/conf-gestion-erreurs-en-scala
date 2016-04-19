import scalaz.{ NonEmptyList, ValidationNel, Success, Failure }
import scalaz.syntax.applicative._
import scalaz.syntax.validation._
import ValidationFn._

object WithValidationNel {
  def validate(p: Player): ValidationNel[VE, ValidPlayer] = {
    val vName = if (validateName(p.name)) Success(p.name)
      else Failure[NonEmptyList[VE]](NonEmptyList(NameTooShort))

    val vLevel = if (validateLevel(p.level)) Success(p.level)
      else Failure[NonEmptyList[VE]](NonEmptyList(InvalidLevel))

    val vHp = if (validateHp(p.level, p.hp)) Success(p.hp)
      else {
        val e = TooManyHp(p.hp, 95 + p.level * 5)
        Failure[NonEmptyList[VE]](NonEmptyList(e))
      }

    (vName |@| vLevel |@| vHp) { (n, l, h) =>
      ValidPlayer(n, l, h)
    }
  }
}
