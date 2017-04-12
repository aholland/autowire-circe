package controllers
import com.google.inject.{Inject, Singleton}
import pages.Skeletons
import play.api.mvc._
import server.services.ServerLogger
@Singleton
class HomeController @Inject()(components: ControllerComponents, srvLog: ServerLogger) extends AbstractController(components) {
 srvLog.info("Startup completed")
 private val mimeType = "text/html"
 def index = Action {
  Ok(Skeletons.skeletonMain.render).as(mimeType)
 }
}
