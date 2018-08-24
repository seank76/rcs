import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.zocdoc",
      scalaVersion := "2.12.6",
      version      := "0.1.0"
    )),
    name := "rcs",
    libraryDependencies ++= Seq(
      akkaActor,
      akkaHttp,
      akkaStream,
      scalaTest % Test
    )
  )
