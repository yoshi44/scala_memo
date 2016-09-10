package pack_for

object ForAndFlatMap extends App {

  val list = List(Some(111), Some(222), None, Some(333))

  val forValue = (for {
    listValue <- list
  } yield {
    println(s"for listValue===${listValue}")
    listValue
  })
  println(s"forValue===${forValue}")

  val mapValue = list.map(listValue => {
    println(s"map listValue===${listValue}")
    listValue
  })
  println(s"mapValue=${mapValue}")
  
  val flatMapValue = list.flatMap(listValue => {
    println(s"flatMap listValue===${listValue}")
    listValue
  })
  println(s"flatMapValue===${flatMapValue}")
  
  //for listValue===Some(111)
  //for listValue===Some(222)
  //for listValue===None
  //for listValue===Some(333)
  //forValue===List(Some(111), Some(222), None, Some(333))
  //map listValue===Some(111)
  //map listValue===Some(222)
  //map listValue===None
  //map listValue===Some(333)
  //mapValue=List(Some(111), Some(222), None, Some(333))
  //flatMap listValue===Some(111)
  //flatMap listValue===Some(222)
  //flatMap listValue===None
  //flatMap listValue===Some(333)
  //flatMapValue===List(111, 222, 333)
}
