import sbt._

object Dependencies {

  private val akkaDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor" % Versions.Akka,
    "com.typesafe.akka" %% "akka-http" % Versions.AkkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % Versions.AkkaHttp,
    "com.typesafe.akka" %% "akka-stream" % Versions.Akka
  )

  private val otherDependencies = Seq(
    "org.slf4j" % "slf4j-api" % Versions.Slf4j
  )

  private val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % Versions.ScalaTest,
    "com.typesafe.akka" %% "akka-testkit" % Versions.Akka,
    "com.typesafe.akka" %% "akka-http-testkit" % Versions.AkkaHttp
  ).map(_ % Test)

  val all
    : Seq[ModuleID] = akkaDependencies ++ otherDependencies ++ testDependencies
}

object Versions {
  val Akka = "2.6.1"
  val AkkaHttp = "10.1.10"
  val Slf4j = "1.7.30"
  val ScalaTest = "3.2.2"
}
