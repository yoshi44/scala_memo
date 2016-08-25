package pack_process

import scala.sys.process.Process

object ProcessTest extends App{
  println("Process Test!!")
  val lsResponse = Process("ls") !!

  println("-----")

  val curlResponse = Process("curl -o yahoo.html http://www.yahoo.co.jp/") !!

  println("-----")

  println(s"lsResponse===[${lsResponse}]")
  println(s"curlResponse===[${curlResponse}]")
}
