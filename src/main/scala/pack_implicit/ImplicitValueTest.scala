package pack_implicit

object ImplicitValueTest extends App{

  implicit val i = 1

  def f(implicit i: Int) = "Hello" + i

  println(f) // Hello1
}
