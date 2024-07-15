package practical_5

object q1 {
  var products = List[String]();

  def getProductList():Unit={
    var input = ""

    println("Enter product names (type 'done' to finish) :")
    while(input != "done"){
      input = scala.io.StdIn.readLine()
      if(input != "done"){
        products = products :+ input
      }
    }
    println("You entered the following products :")
    products.foreach(println)
  }

  def printProductList():Unit ={
    println()

    for(i <- 0 until products.length){
      println(s"${i+1}. ${products(i)}")
    }
  }

  def getTotalProducts(): Unit = {
    var tot = products.length
    println()
    println(s"Total number of products = ${tot}")
  }

  def main(args: Array[String]): Unit={
    getProductList()
    printProductList()
    getTotalProducts()
  }
}
