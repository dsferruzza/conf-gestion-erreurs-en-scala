name := """code"""

version := "1.0"

scalaVersion := "2.11.8"

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xfatal-warnings",
  "-Xfuture",
  "-Xlint"
)

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.2"
