sealed trait VE
case object NameTooShort extends VE
case object InvalidLevel extends VE
case class TooManyHp(current: Int, max: Int) extends VE
