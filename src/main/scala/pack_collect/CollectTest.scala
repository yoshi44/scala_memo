package pack_collect

object CollectTest extends App{

  val list = List("a", "b")
  val collectList = list.collect { case s if s != "a" => s }
  println(collectList) // List(b)
}

