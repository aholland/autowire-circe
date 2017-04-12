
//resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
//resolvers += Resolver.url("heroku-sbt-plugin-releases",
//  url("https://dl.bintray.com/heroku/sbt-plugins/"))(Resolver.ivyStylePatterns)
// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.0-M2")

// web plugins
addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")

addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.2")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.15")

addSbtPlugin("com.vmunier" % "sbt-play-scalajs" % "0.3.0") // play scala-js!

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.0")

