package client.logger
package object logger {
 private val defaultLogger = LoggerFactory.getLogger("Log")
 lazy val log = defaultLogger
}