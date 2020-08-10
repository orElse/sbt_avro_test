import sbt._
import sbt.Keys._

import sbtavrohugger.SbtAvrohugger.autoImport._

ThisBuild / scalaVersion := "2.12.11"
ThisBuild / organization := "com.example"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val avroModels = (project in file("."))
//  .enablePlugins(CloudflowLibraryPlugin)
  .settings(
    name := "AvroTest",
    libraryDependencies ++= Seq(
      "org.apache.avro" % "avro" % "1.8.2" // "sbt-avrohugger" % "2.0.0-RC18"
      // "org.apache.avro" % "avro" % "1.9.1" // "sbt-avrohugger" % "2.0.0-RC22"
    )
  )
  .settings(
    Seq(
      Compile / sourceGenerators += (avroScalaGenerateSpecific in Compile).taskValue,

      Compile / managedSourceDirectories += (Compile / avroSpecificScalaSource).value,
      Compile / managedSourceDirectories += (Compile / crossTarget).value / "java_avro",
      Compile / managedSourceDirectories += (Compile / crossTarget).value / "scalapb",

//      avroScalaCustomTypes in Compile := {
//        avrohugger.format.SpecificRecord.defaultTypes.copy(
//          // array = avrohugger.types.ScalaVector,
//          record = avrohugger.types.ScalaCaseClassWithSchema
//         )
//      }
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
