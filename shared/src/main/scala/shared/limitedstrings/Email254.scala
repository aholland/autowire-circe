package shared.limitedstrings
class Email254(s: String) extends StringLtd(s, Email254)
object Email254 extends Ltd {
 def apply(s: String) = new Email254(s)
 val limit = 254
 val empty = new Email254("")
}