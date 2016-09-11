package pack_case_class

object UsingTraitTest extends App{
  def method(traitTest:TraitTest): Unit = {
    println(traitTest.field1)
  }
  val caseClass1 = CaseClass1(field1 = "field1Test1", field2 = "field2Test1")
  method(caseClass1)

  val caseClass2 = CaseClass2(field1 = "field1Test2")
  method(caseClass2)
}

trait TraitTest {
  def field1: String
}

case class CaseClass1(field1:String, field2:String) extends TraitTest
case class CaseClass2(field1:String) extends TraitTest



