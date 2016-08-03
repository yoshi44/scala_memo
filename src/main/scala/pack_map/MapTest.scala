package pack_map

object MapTest extends App{

  val list = List(1,2,3)
  val result = list.map(e => e * 2)
  println(result) // List(2, 4, 6)

  val aaaClassList = List(new AAA(11, 111), new AAA(22, 222), new AAA(33, 333))
  val resultaaaClassList = aaaClassList.map(a => a.aaa)
  println(resultaaaClassList) //List(11, 22, 33)

  val t = List((Some(111), Some(222)), (Some(333), Some(444)), (None, None), (Some(555), Some(666)))
  println("t1==="+t)
  println("t2==="+t.filter(_._2 != None)) // List((Some(111),Some(222)), (Some(333),Some(444)), (Some(555),Some(666)))
  println("t3==="+t.filter(_._2.isDefined)) // List((Some(111),Some(222)), (Some(333),Some(444)), (Some(555),Some(666)))

}

case class AAA(aaa: Int, bbb: Int) {

}
