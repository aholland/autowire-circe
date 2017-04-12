package shared.autowire
import shared.limitedstrings.Email254
import shared.models.StaticData
import scala.concurrent.Future
trait SharedApi {
 def getStaticData(): Future[StaticData]
}
