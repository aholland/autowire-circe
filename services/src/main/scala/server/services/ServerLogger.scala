package server.services
import com.google.inject.Singleton
import org.slf4j.LoggerFactory
import play.api.LoggerLike
@Singleton
class ServerLogger extends LoggerLike {
 override val logger = LoggerFactory.getLogger("server")
}
