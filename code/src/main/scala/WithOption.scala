import ValidationFn._

object WithOption {
  def validate(player: Player): Option[ValidPlayer] = {
    if (validateName(player.name)
    && validateLevel(player.level)
    && validateHp(player.level, player.hp)) {
      Some(ValidPlayer(player.name, player.level, player.hp))
    }
    else None
  }
}
