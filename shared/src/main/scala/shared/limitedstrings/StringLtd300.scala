package shared.limitedstrings
class StringLtd300(s: String) extends StringLtd(s, StringLtd300)
object StringLtd300 extends Ltd {
 def apply(s: String) = new StringLtd300(s)
 val limit = 300
 val empty = new StringLtd300("")
}