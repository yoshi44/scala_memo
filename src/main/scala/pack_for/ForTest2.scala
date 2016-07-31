package pack_for

object ForTest2 extends App {
  val list1 = List(1,2,3,4,5)
  val list2 = List("aaa", "bbb")
  val test = (for {
    l1 <- list1
    l2 <- list2
  } yield (l1, l2))

  println(test) //List((1,aaa), (1,bbb), (2,aaa), (2,bbb), (3,aaa), (3,bbb), (4,aaa), (4,bbb), (5,aaa), (5,bbb))
}
