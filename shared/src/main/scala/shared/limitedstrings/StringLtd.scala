package shared.limitedstrings
abstract class StringLtd(val s: String, ltd: Ltd) extends Ltd {
 val limit: Int = ltd.limit
 if (limit < s.length) throw new StringIndexOutOfBoundsException("Parameter s must be less than or equal to " + limit + " in length. Parameter s is " + s.length + " characters long. s=\"" + s + "\"")
 def value(): String = s
 override def toString: String = value().length() + "<=" + limit + "[" + value() + "]"
 override def equals(obj: scala.Any): Boolean = super.equals(obj) || (obj match {
  case sl: StringLtd => sl.limit == limit && sl.s == s
  case _ => false
 })
}
