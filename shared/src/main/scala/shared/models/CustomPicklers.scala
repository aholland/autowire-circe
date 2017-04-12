package shared.models
//TODO remove commented-out
//import java.time.{LocalDate, YearMonth}
//import java.time.{Instant, LocalDate, YearMonth}
import java.time.{LocalDate, YearMonth}
import shared.limitedstrings.{Email254, StringLtd30, StringLtd300}
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import cats.syntax.either._
object CustomPicklers {
 implicit val bdWriter: Encoder[BigDecimal] = Encoder.encodeString.contramap[BigDecimal](_.toString)
  // Note that, as explained in the JavaDoc for java.math.BigDecimal.toString():
  // "There is a one-to-one mapping between the distinguishable BigDecimal values and the result of this conversion.
  // That is, every distinguishable BigDecimal value (unscaled value and scale) has a unique string representation
  // as a result of using toString. If that string representation is converted back to a BigDecimal using the
  // BigDecimal(String) constructor, then the original value will be recovered."
  //
  // In short, the toString representation is perfect for serialising to a String and then deserialising again.
 implicit val bdReader: Decoder[BigDecimal] = Decoder.decodeString.emap { str =>
   Either.catchNonFatal(BigDecimal.apply(str)).leftMap(t => "BigDecimal")
 }
 implicit val ldWriter: Encoder[LocalDate] = Encoder.encodeString.contramap[LocalDate](_.toString)
 implicit val ldReader: Decoder[LocalDate] = Decoder.decodeString.emap { str =>
  val yyyy = Integer.parseInt(str.substring(0, 4))
  val mm = Integer.parseInt(str.substring(5, 7))
  val dd = Integer.parseInt(str.substring(8, 10))
  val ld = LocalDate.of(yyyy, mm, dd)
    Either.catchNonFatal(ld).leftMap(t => "LocalDate")
  }
 implicit val ymWriter: Encoder[YearMonth] = Encoder.encodeString.contramap[YearMonth](_.toString)
 implicit val ymReader: Decoder[YearMonth] = Decoder.decodeString.emap { str =>
  val yyyy = Integer.parseInt(str.substring(0, 4))
  val mm = Integer.parseInt(str.substring(5, 7))
  val ym = YearMonth.of(yyyy, mm)
  Either.catchNonFatal(ym).leftMap(t => "YearMonth")
  }
 implicit val sl30Writer: Encoder[StringLtd30] = Encoder.encodeString.contramap[StringLtd30](_.s)
 implicit val sl30Reader: Decoder[StringLtd30] = Decoder.decodeString.emap { str =>
    Either.catchNonFatal(StringLtd30(str)).leftMap(t => "StringLtd30")
  }
 implicit val email254Writer: Encoder[Email254] = Encoder.encodeString.contramap[Email254](_.s)
 implicit val email254Reader: Decoder[Email254] = Decoder.decodeString.emap { str =>
    Either.catchNonFatal(Email254(str)).leftMap(t => "Email254")
  }
 implicit val sl300Writer: Encoder[StringLtd300] = Encoder.encodeString.contramap[StringLtd300](_.s)
 implicit val sl300Reader: Decoder[StringLtd300] = Decoder.decodeString.emap { str =>
    Either.catchNonFatal(StringLtd300(str)).leftMap(t => "StringLtd300")
  }
 //  implicit val instWriter = upickle.default.Writer[Instant] {
 //    case inst => Js.Str(inst.getEpochSecond.toString + "s" + inst.getNano)
 //  }
 //  implicit val instReader = upickle.default.Reader[Instant] {
 //    case Js.Str(str) =>
 //      val (epochSecond,nanoAdjustment) = {
 //        val s = str.split('s').map(_.toLong)
 //        (s(0), s(1))
 //      }
 //      Instant.ofEpochSecond(epochSecond, nanoAdjustment)
 //  }
}
//TODO remove unused commented-out code