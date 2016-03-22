// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "jsonToCaseclass"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

persistLauncher in Compile := true

persistLauncher in Test := false

//jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"

libraryDependencies ++= Seq(
  "org.querki" %%% "jquery-facade" % "1.0-RC2",
  "org.scala-js" %%% "scalajs-dom" % "0.8.2"
)
