package shared.limitedstrings
class StringLtd30(s: String) extends StringLtd(s, StringLtd30)
object StringLtd30 extends Ltd {
 def apply(s: String) = new StringLtd30(s)
 val limit = 30
 val empty = new StringLtd30("")
}