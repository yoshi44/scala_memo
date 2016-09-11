package pack_for


object ForAndMatchCase {

  def method1(s: Option[String]): Option[Boolean] = {
    (s) match {
      case Some(sValue) => Some(true)
      case _ => None
    }
  }
  def method2(s: Option[Boolean]): Option[Boolean] = {
    (s) match {
      case Some(_) => Some(true)
      case _ => None
    }
  }

  def main(args: Array[String]) = {
    println(s"1===${method1(Some("111"))}")
    println(s"2===${method1(None)}")
    println(s"3===${method2(Some(true))}")
    println(s"4===${method2(None)}")

    val a5 = method1(Some("111")).flatMap { optionValue =>
      method2(Some(optionValue))
      //Some(optionValue)
    }
    println(s"5===${a5}")

    val a6 = (for {
      a <- method1(Some("111"))
      aa <- method2(Some(a))
    } yield aa)
    println(s"a6===${a6}")

  }

}
