import ValidationFn._

object WithNull {
  def validate(player: Player): ValidPlayer = {
    if (validateName(player.name)
    && validateLevel(player.level)
    && validateHp(player.level, player.hp)) {
      ValidPlayer(player.name, player.level, player.hp)
    }
    else null
  }
}
