ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.12"

ThisBuild / name := "scala-kafka-demo"

// https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "3.1.0"

// https://mvnrepository.com/artifact/com.typesafe/config
libraryDependencies += "com.typesafe" % "config" % "1.4.1"

// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.9"


lazy val root = (project in file("."))
  .settings(
    name := "scala-kafka"
  )
