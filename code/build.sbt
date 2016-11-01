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

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.7"

libraryDependencies += "org.typelevel" %% "cats" % "0.8.0"

libraryDependencies +=
  "com.propensive" %% "rapture-core" % "2.0.0-M7"

