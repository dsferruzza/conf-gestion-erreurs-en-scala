import ValidationFn._

object WithException {
  def validate(player: Player): ValidPlayer = {
    if (!validateName(player.name)) {
      throw new RuntimeException("Invalid name")
    }
    if (!validateLevel(player.level)) {
      throw new RuntimeException("Invalid level")
    }
    if (!validateHp(player.level, player.hp)) {
      throw new RuntimeException("Invalid HP")
    }
    ValidPlayer(player.name, player.level, player.hp)
  }
}
