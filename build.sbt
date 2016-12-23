name := "RestAPI"

version := "1.0"

scalaVersion := "2.12.1"


//resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= {
  val AkkaHttpV = "10.0.0"
  val AkkaV = "2.4.14"
  val Json4sV = "3.5.0"
  val TypeSafeConfigV = "1.3.1"
  val slickVersion = "3.2.0-M2"

  Seq(
    "com.typesafe.akka" %% "akka-actor" % AkkaV,
    "com.typesafe.akka" %% "akka-stream" % AkkaV,
    "com.typesafe.akka" %% "akka-testkit" % AkkaV,
    "com.typesafe.akka" %% "akka-agent" % AkkaV,
    "com.typesafe.akka" %% "akka-http-core" % AkkaHttpV,
    "com.typesafe.akka" %% "akka-http" % AkkaHttpV,
    "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpV,
    "org.json4s" %% "json4s-native" % Json4sV,
    "com.typesafe" % "config" % TypeSafeConfigV,
    "com.zaxxer" % "HikariCP" % "2.4.5",
    "com.typesafe.slick" %% "slick" % slickVersion,


    "mysql" % "mysql-connector-java" % "5.1.12"
  )
}


//Revolver.settings
//enablePlugins(JavaAppPackaging)
//enablePlugins(DockerPlugin)