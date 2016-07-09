package pack_implicit

object ImplicitValueTest extends App{

  implicit val i1 = 1
  implicit val i2 = 2L
  implicit val i3 = "stringVal3"

  def f1(implicit i: Int) = "Hello" + i

  println(f1) // Hello1

  def f2(implicit i: Long) = "Hello" + i
  println(f2) // Hello2

  def f3(implicit i: String) = "Hello" + i
  println(f3) // HellostringVal3

  def f4(implicit i: Double) = "Hello" + i
  //println(f4) error

}
