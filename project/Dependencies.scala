import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
  lazy val akkaHttp = "com.typesafe.akka" % "akka-http_2.12" % "10.1.4"
  lazy val akkaActor = "com.typesafe.akka" % "akka-actor_2.12" % "2.5.15"
  lazy val akkaStream = "com.typesafe.akka" % "akka-stream_2.12" % "2.5.15"
}
