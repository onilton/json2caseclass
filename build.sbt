// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "jsonToCaseclass"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

persistLauncher in Compile := true

persistLauncher in Test := false

val assetsDir = "assets/"

//jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"

libraryDependencies ++= Seq(
  "org.querki" %%% "jquery-facade" % "1.0-RC6",
  "org.scala-js" %%% "scalajs-dom" % "0.8.2"
)

libraryDependencies += "com.github.chandu0101.sri" %%% "web" % "0.5.0"
libraryDependencies += "com.github.chandu0101.sri" %%% "scalacss" % "2016.5.0"


crossTarget in(Compile, fullOptJS) := file(assetsDir)
crossTarget in(Compile, fastOptJS) := file(assetsDir)
crossTarget in(Compile, packageScalaJSLauncher) := file(assetsDir)
artifactPath in(Compile, fastOptJS) := ((crossTarget in(Compile, fastOptJS)).value /
  ((moduleName in fastOptJS).value + "-opt.js"))

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature",
  "-language:postfixOps", "-language:implicitConversions",
  "-language:higherKinds", "-language:existentials")
