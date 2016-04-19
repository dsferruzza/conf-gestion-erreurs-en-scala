case class Player(name: String, level: Int, hp: Int)
case class ValidPlayer(name: String, level: Int, hp: Int)

// Test values
object Player {
  val valid = Player("Batman", 100, 200)
  val invalid = Player("A", -5, 99)
}

object ValidationFn {
  def validateName(name: String): Boolean = name.size >= 3
  def validateLevel(level: Int): Boolean = level > 0
  def validateHp(level: Int, hp: Int): Boolean = hp <= 95 + level * 5
}
