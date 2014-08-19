// run with
// sbt "run 2222 127.0.0.1 22"
// to mitm "ssh 127.0.0.1:2222" to 127.0.0.1:22

name := "SSH mitm attack"

version := "1.0"

scalaVersion := "2.11.2"

// -- Must use mangled jar in ./lib -- libraryDependencies += "com.jcraft" % "jsch" % "0.1.51"

