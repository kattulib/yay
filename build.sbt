import Dependencies._

val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-Wunused:all",
    "-rewrite",
    "-no-indent"
  )
)

lazy val server = project
    .in(file("server"))
    .settings(
        commonSettings,
        name := "yay-server",
    )
    .dependsOn(core)

lazy val client = project
    .in(file("client"))
    .settings(
        commonSettings,
        name := "yay-client",
    )
    .dependsOn(core)

lazy val core = project
    .in(file("core"))
    .settings(
        commonSettings,
        libraryDependencies ++= {
            Seq(
                kuram.value,
            )
        },
    )

lazy val root = project
    .in(file("."))
    .aggregate(core, client, server)
    .settings(
        name := (ThisBuild / name).value,
    )
    .enablePlugins(ScalafixPlugin, AutomateHeaderPlugin)

/* project settings */
ThisBuild / scalaVersion := "3.4.2"
ThisBuild / name := "yay"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "io.github.kattulib"
ThisBuild / organizationName := "kattulib"
ThisBuild / description := "Say something about this template."
ThisBuild / licenses := List(("MIT", url("https://opensource.org/license/mit")))
ThisBuild / startYear := Some(2024)
ThisBuild / homepage := Some(url("https://github.com/kattulib/yay"))
ThisBuild / scmInfo := Some(
    ScmInfo(
        url("https://github.com/kattulib/yay"),
        "git@github.com:kattulib/yay.git"
    )
)

ThisBuild / developers ++= List(
    Developer(
        id      = "csgn", 
        name    = "Sergen Çepoğlu", 
        email   = "dev.csgn@gmail.com", 
        url     = url("https://github.com/csgn")
    ),
)

/* test settings */
ThisBuild / testFrameworks += new TestFramework("munit.Framework")

/* scalafix settings */
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

/* scaladoc settings */
ThisBuild / autoAPIMappings := true
Compile / doc / scalacOptions ++= Seq(
    "-doc-title", (ThisBuild / name).value,
    "-project-version", (ThisBuild / version).value,
    "-project-logo", "docs/icon.jpeg",
)

/* publish settings */
ThisBuild / publishMavenStyle := true

