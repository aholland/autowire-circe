package controllers
import io.circe.Json
import io.circe.Decoder
import io.circe.Encoder
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import autowire.{AutoWireServer, Core}
import com.google.inject.{Inject, Singleton}
import play.api.mvc._
import server.services.ServerLogger
import shared.autowire.SharedApi
import shared.limitedstrings.Email254
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import shared.models.CustomPicklers._
import shared.models.StaticData
@Singleton
class AutowireController @Inject()(components: ControllerComponents, srvLog: ServerLogger) extends AbstractController(components) with SharedApi {
 def getStaticData(): Future[StaticData] = Future.successful(StaticData(Email254("anthony.holland@gmail.com")))
 private val procedureCallRouter: autowire.Core.Request[Json] => Future[Result] = AutoWireServer.route[SharedApi](this)(_).map(_.noSpaces).map(Ok(_))
 def autowireAjax(path: String): Action[String] = {
  srvLog.info("autowireAjax: path="+path)
  Action.async[String](parse.text) { request =>
   srvLog.logger.debug("Circe  request.body=" + request.body)
   val procedureCallRequest: Core.Request[Json] = autowire.Core.Request(path.split('/'), decode[Map[String, Json]](request.body).right.get)
   procedureCallRouter(procedureCallRequest)
  }
 }
}
