import ValidationFn._
import cats.data.Xor

object WithCats {

  def validate(player: Player): VE Xor ValidPlayer = {
    if (!validateName(player.name)) {
      Xor.left(NameTooShort)
    }
    else if (!validateLevel(player.level)) {
      Xor.left(InvalidLevel)
    }
    else if (!validateHp(player.level, player.hp)) {
      Xor.left(TooManyHp(player.hp, 95 + player.level * 5))
    }
    else {
      Xor.right(ValidPlayer(player.name, player.level, player.hp))
    }
  }

}
