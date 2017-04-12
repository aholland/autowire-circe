package client.comms
import io.circe.Json
import io.circe.Decoder
import io.circe.Encoder
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import org.scalajs.dom
import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import client.logger.logger.log.{info => log, error => loge, trace => logt}
object Client extends autowire.Client[Json, Decoder, Encoder] {
 //TODO optimise
 override def doCall(req: Request): Future[Json] = {
  logt("Circe-doCall")
  dom.ext.Ajax.post(
   url = "http://localhost:9000/api/" + req.path.mkString("/")
   , data = {
    val d: String = Json.fromFields(req.args).noSpaces
    //val d: String = req.args.asJson.noSpaces
    logt("Circe outgoing data:"+d)
    d
   }
  ).map(r => {
   logt("Circe.responseText=" + r.responseText)
   parse(r.responseText).right.get
  })
 }
 override def write[AnyClassToWrite: Encoder](obj: AnyClassToWrite): Json = {
  val w = obj.asJson
  logt("Circe.write:"+w)
  w
 }
 override def read[AnyClassToRead: Decoder](json: Json): AnyClassToRead = {
  logt("Circe reading: json string of " + json + "\n Text="+json)
  val e = json.as[AnyClassToRead]
  if (e.isLeft) {
   logt("Left! left=" + e.left.get)
  }
  val r = e.right.get
  //val r = decode[Result](p).right.get
  logt("circe-read:"+r+" class="+r.getClass)
  r match {
   case s: String => logt(s.length.toString)
   case _ => ()
  }
  r
 }
}
