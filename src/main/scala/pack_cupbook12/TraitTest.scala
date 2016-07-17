package pack_cupbook12

import scala.collection.mutable.ArrayBuffer


object TraitTest extends App{
  // 12.6, 12.7
  println("-----")
  println("-----12.6,12.7 start-----")
  val queue = new BasicIntQueue
  queue.put(10)
  queue.put(20)

  println(queue.get()) // 10
  println(queue.get()) // 20

  // 12.8
  println("-----12.8 start-----")
  class MyQueue extends BasicIntQueue with Doubling

  val queue2 = new MyQueue
  queue2.put(10) // 2 * 10 = 20
  println(queue2.get()) // 20

  // 12.9
  println("-----12.9 start-----")
  val queue3 = new BasicIntQueue with Doubling
  queue3.put(10)
  println(queue3.get()) // 20

  // 12.10
  println("-----12.10 start-----")
  val queue4 = (new BasicIntQueue with Incrementing with Filtering)
  queue4.put(-1) // no put
  queue4.put(0) // Filtering put(0) and Incrementing put(1)
  queue4.put(1) //
  println(queue4.get()) // 1
  println(queue4.get()) // 2

  // 12.10 for test
  println("-----12.10 for test start-----")
  val queue4test = (new BasicIntQueue with Incrementing with Filtering)
  queue4test.put(-10) // no put
  queue4test.put(10) // Filtering put(0) and Incrementing put(1)
  queue4test.put(20) //
  println(queue4test.get()) // 11
  println(queue4test.get()) // 22

  // 12.10 for test2
  println("-----12.10 for test2 start-----")
  val queuetest = (new BasicIntQueue with TraitTestB with TraitTestA)
  queuetest.put(-10) // -10 + 111 = 101 in TraitTestA, 101 + 222 = 323 in TraitTestB
  queuetest.put(10) // 10 + 111 = 121 in TraitTestA, 121 + 222 = 343 in TraitTestB
  queuetest.put(20) // 20 + 111 = 131 in TraitTestA, 131 + 222 = 353 in TraitTestB
  println(queuetest.get()) // 323
  println(queuetest.get()) // 343
  println(queuetest.get()) // 353
}

/**
  * 12.6
  */
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

/**
  * 12.7
  */
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit = { buf += x}
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x)}
}

/**
  * 12.10
  */
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {
    println(s"Incrementing put method x===${x}")
    super.put(x + 1)
  }
}
trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) {
      println(s"Filterling put method x===${x}")
      super.put(x)
    }
  }
}
/**
  * 12.10 for test
  */
trait TraitTestA extends IntQueue {
  abstract override def put(x: Int) {
    println(s"TraintTestA put method x===${x}")
    super.put(x + 111)
  }
}
trait TraitTestB extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) {
      println(s"TraitTestB put method x===${x}")
      super.put(x + 222)
    }
  }
}
