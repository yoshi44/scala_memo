package pack_implicit

object implicitParameter extends App{

  implicit val implicitParameterValue = 5
  val tax = new Tax
  println(tax.tax) // implicitParameterValue 5 becomes a parameter, then 0.05
  println(tax.tax(10)) // 0.1
}

class Tax {
  def tax(implicit rate: Int) = rate * 0.01
}