package com.zocdoc.rcs.server

import java.time.Instant

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.StdIn

object RCSService extends App {
  implicit val system = ActorSystem("rcs-service")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher

  val route =
    path("health-check") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, s"<h1>RCS Service has time ${Instant.now}</h1>"))
      }
    }

  val bindingFuture = Http().bindAndHandle(route, "localhost", 7654)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}
