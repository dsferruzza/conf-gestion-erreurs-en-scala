import ValidationFn._
import cats.implicits._
import scala.util.Either

object WithCats {

  def validate(player: Player): VE Either ValidPlayer = {
    if (!validateName(player.name)) {
      Either.left(NameTooShort)
    }
    else if (!validateLevel(player.level)) {
      Either.left(InvalidLevel)
    }
    else if (!validateHp(player.level, player.hp)) {
      Either.left(TooManyHp(player.hp, 95 + player.level * 5))
    }
    else {
      Either.right(ValidPlayer(player.name, player.level, player.hp))
    }
  }

}
