package client
import client.logger.logger.log.{error => loge, info => log, trace => logt}
import org.scalajs.dom
import org.scalajs.dom._
import scala.scalajs.js.annotation.JSExport
abstract class PageApp[IDT] {
 @JSExport
 final def main(): Unit = {
  console.clear()
  log("Scala.js Version: " + System.getProperty("java.vm.version"))
  dom.document.body.innerHTML = ""
  dom.document.body.id = "body"
  logt("Loading data begins")
  loadInitialData((initialData: IDT) => {
   logt("Loading data complete")
   app(initialData)
  })
 }
 def loadInitialData(onInitialDataLoaded: IDT => Unit): Unit
 def app(initialData: IDT): Unit
}
