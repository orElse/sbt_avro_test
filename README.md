# sbt_avro_test

Checking generation of scala classes from avro using sbt_avrohugger plugin

Generation time degrades on macOS (TODO add version + check jdk - adopt openjdk8 ?) using `avroScalaGenerateSpecific` generator, when adding enums (/src/main/avro/e6)
- problem not observed on macOS when using `avroScalaGenerate` as generator
- problem not observed on macOS when running in docker container using `hseeberger/scala-sbt:graalvm-ce-19.3.0-java8_1.3.8_2.12.10`
- problem not observed on windows 10 with openjdk-11.0.2_windows-x64 or openjdk-13.0.1_windows-x64
  - TODO check with jdk 8

TODO - validate on mac with avro 1.9 & sbt-avrohugger 2.0.0-RC22
