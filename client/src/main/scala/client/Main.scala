package client
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import org.scalajs.dom
import org.scalajs.dom._
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import autowire._
import comms.Client
import shared.autowire.SharedApi
import shared.models.CustomPicklers._
import io.circe.Json
import io.circe.Decoder
import io.circe.Encoder
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import scala.collection.mutable.ListBuffer
import client.logger.logger.log.{error => loge, info => log, trace => logt}
import org.scalajs.dom
import shared.models
import shared.models.StaticData
@JSExportTopLevel("client.Main")
object Main  extends PageApp[StaticData] {
 override def loadInitialData(onInitialDataLoaded: (StaticData) => Unit): Unit = Client[SharedApi].getStaticData().call().foreach(onInitialDataLoaded(_))
 @JSExport
 def app(staticData: StaticData): Unit = {
  console.clear()
  log("Scala.js Version: " + System.getProperty("java.vm.version"))
  dom.document.body.id = "body"
  dom.document.body.innerHTML = staticData.email.s
 }
}
