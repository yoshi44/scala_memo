package pack_for

object ForTest extends App {
  val intList = List(111,222,333)
  for {
    i <- intList
  } yield println("i==="+i)
//  i===111
//  i===222
//  i===333

  val stringList = List("aaa", "bbb", "ccc")
  for {
    s <- stringList
  } yield println("s==="+s)
//  s===aaa
//  s===bbb
//  s===ccc

  val stringList2 = List(List("aaaa", "bbbb"), List("cccc"))
  for {
    s2 <- stringList2
  } yield {
    println("s2==="+s2)
    // s2===List(aaaa, bbbb)
    // s2===List(cccc)
    for {
      s22 <- s2
    } yield println("s22==="+s22)
    // s22===aaaa
    // s22===bbbb
    // s22===cccc
  }

  for {
    s2a <- stringList2
    //println("s2a"+s2a)
    s22a <- s2a
  } yield {
    println("s22a==="+s22a)
//    s22a===aaaa
//    s22a===bbbb
//    s22a===cccc
  }

  for {
    s2b <- stringList2
    s22b <- s2b
    s22c <- s22b
  } yield {
    println("s22c==="+s22c)
//    s22c===a
//    s22c===a
//    s22c===a
//    s22c===a
//    s22c===b
//    s22c===b
//    s22c===b
//    s22c===b
//    s22c===c
//    s22c===c
//    s22c===c
//    s22c===c
  }

}
