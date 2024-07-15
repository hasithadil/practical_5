package practical_5

object q3 {
  def fib(n:Int):Int = n match{
    case 0 => 0
    case 1 => 1
    case _ => fib(n-1) + fib(n-2)
  }

  def printFibonacciSequence(count: Int): Unit = {
    // this is a for loop for 0 to count-1
    for (i <- 0 until count) {
      print(fib(i) + " ")
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    printFibonacciSequence(10)
  }
}

