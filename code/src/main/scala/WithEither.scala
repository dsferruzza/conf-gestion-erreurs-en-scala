import ValidationFn._

object WithEither {
  def validate(player: Player): Either[VE, ValidPlayer] = {
    if (!validateName(player.name)) {
      Left(NameTooShort)
    }
    else if (!validateLevel(player.level)) {
      Left(InvalidLevel)
    }
    else if (!validateHp(player.level, player.hp)) {
      Left(TooManyHp(player.hp, 95 + player.level * 5))
    }
    else {
      Right(ValidPlayer(player.name, player.level, player.hp))
    }
  }
}
