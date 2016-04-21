import rapture.core._
import scala.util.Try
import ValidationFn._

object WithRapture {
  def validate(player: Player)(implicit mode: Mode[_]): mode.Wrap[ValidPlayer, VE] = {
    mode.wrapEither(WithEither.validate(player))
  }

  def validateOption(player: Player): Option[ValidPlayer] = {
    import modes.returnOption._
    validate(player)
  }
  def validateTry(player: Player): Try[ValidPlayer] = {
    import modes.returnTry._
    validate(player)
  }
}
