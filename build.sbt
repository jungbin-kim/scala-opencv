import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "kim.jungbin",
      scalaVersion := "2.11.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies ++= Seq(
      scalaTest % Test
    )
  )
javaCppPresetLibs ++= Seq("opencv" -> "3.1.0", "ffmpeg" -> "3.1.2")
