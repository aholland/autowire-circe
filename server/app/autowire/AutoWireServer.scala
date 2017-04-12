package autowire
import io.circe.Json
import io.circe.Decoder
import io.circe.Encoder
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
trait JsonSerializers extends autowire.Serializers[Json, Decoder, Encoder] {
 //TODO error handling improvements (left cases)
 override def write[AnyClassToWrite: Encoder](obj: AnyClassToWrite): Json = obj.asJson
 override def read[AnyClassToRead](json: Json)(implicit ev: Decoder[AnyClassToRead]): AnyClassToRead = {
  val either = ev.decodeJson(json)
  if (either.isLeft) throw new Exception(either.left.get)
  either.right.get
 }
}
object AutoWireServer extends autowire.Server[Json, Decoder, Encoder] with JsonSerializers
