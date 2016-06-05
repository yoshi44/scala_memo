package pack_map

object MapTest extends App{

  val list = List(1,2,3)
  val result = list.map(e => e * 2)
  println(result) // List(2, 4, 6)

  val aaaClassList = List(new AAA(11, 111), new AAA(22, 222), new AAA(33, 333))
  val resultaaaClassList = aaaClassList.map(a => a.aaa)
  println(resultaaaClassList) //List(11, 22, 33)

}

case class AAA(aaa: Int, bbb: Int) {

}
