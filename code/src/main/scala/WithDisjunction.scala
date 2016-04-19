import scalaz.{ \/, -\/, \/- }
import ValidationFn._

object WithDisjunction {
  def validate(player: Player): VE \/ ValidPlayer = {
    if (!validateName(player.name)) {
      -\/(NameTooShort)
    }
    else if (!validateLevel(player.level)) {
      -\/(InvalidLevel)
    }
    else if (!validateHp(player.level, player.hp)) {
      -\/(TooManyHp(player.hp, 95 + player.level * 5))
    }
    else {
      \/-(ValidPlayer(player.name, player.level, player.hp))
    }
  }
}
