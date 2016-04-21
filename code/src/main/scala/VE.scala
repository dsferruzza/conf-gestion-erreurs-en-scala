sealed trait VE extends Exception
//						^ Because Rapture needs it
case object NameTooShort extends VE
case object InvalidLevel extends VE
case class TooManyHp(current: Int, max: Int) extends VE
