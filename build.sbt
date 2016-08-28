name := "scalatest-3-playground"

organization := "ted"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test"
)

scalacOptions ++= Seq("-Ywarn-value-discard")