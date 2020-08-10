import sbt._
import sbt.Keys._


ThisBuild / scalaVersion := "2.12.11"
ThisBuild / organization := "com.example"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val avroModels = (project in file("."))
  .enablePlugins(CloudflowLibraryPlugin)
  .settings(
    name := "AvroTest"
  )
  .settings(
    Seq(
      Compile / managedSourceDirectories += (Compile / avroSpecificScalaSource).value,
      Compile / managedSourceDirectories += (Compile / crossTarget).value / "java_avro",
      Compile / managedSourceDirectories += (Compile / crossTarget).value / "scalapb",

      sourceGenerators in Compile += (avroScalaGenerate in Compile).taskValue
    )
  )
//  .settings( // for java enums
//    Seq(
//      // Java then Scala for main sources
//      Compile / compileOrder := CompileOrder.JavaThenScala,
//
//      // allow circular dependencies for test sources
//      Test / compileOrder := CompileOrder.Mixed
//    )
//  )
