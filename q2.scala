package practical_5

import scala.io.StdIn
import scala.collection.mutable.ListBuffer

object q2 {
  case class Book(title: String, author: String, isbn: String)

  val books = ListBuffer(
    Book("1984", "George Orwell", "1"),
    Book("To Kill a Mockingbird", "Harper Lee", "2"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "3"),
    Book("Pride and Prejudice", "Jane Austen", "4")
  )


  def AddNewBook(): Unit = {
    println()
    println("Enter detail about New Book")

    print("Enter Book title : ")
    var title: String = StdIn.readLine();

    print("Enter Book author : ")
    var author: String = StdIn.readLine();

    print("Enter Book isbn : ")
    var isbn: String = StdIn.readLine();

    var NewBook = Book(title, author, isbn)
    books += NewBook;
  }

  //used list buffer because we need to update list
  def removeBook(books: ListBuffer[Book]): Unit = {
    println(s"\nEnter details about the book to remove")
    print("Enter ISBN: ")

    val id: String = StdIn.readLine()

    def recursiveRemove(books: ListBuffer[Book], id: String): ListBuffer[Book] = {
      if (books.isEmpty) {
        println("Book not found")
        books
      } else if (books.head.isbn == id) {
        println(s"Book found and removed: ${books.head}")
        books.tail
      } else {
        books.head +: recursiveRemove(books.tail, id)
      }
    }

    val updatedBooks = recursiveRemove(books, id)
    books.clear()
    books ++= updatedBooks
  }

  def CheckBook(books: List[Book]): Unit = {
    println(s"\nEnter details about the book to Check")
    print("Enter ISBN: ")

    val id: String = StdIn.readLine()

    def RecursiveCheck(books: List[Book]): Unit = {
      if (books.isEmpty) {
        println("Book is not in Library")
      }
      else if (books.head.isbn == id) {
        println("Book is already in the Library")
      }
      else {
        RecursiveCheck(books.tail)
      }
    }

    RecursiveCheck(books)
  }

  def displayLibrary(books: List[Book]): Unit = {
    val count = books.length
    println(s"Library contains $count books:")

    def displayBooksRecursive(books: List[Book]): Unit = {
      if (books.nonEmpty) {
        val book = books.head
        println(s"Title: ${book.title} \t||| Author: ${book.author} \t||| ISBN: ${book.isbn}")
        displayBooksRecursive(books.tail)
      }
    }

    displayBooksRecursive(books)
  }

  def main(args: Array[String]): Unit = {
    displayLibrary(books.toList)

    AddNewBook()
    println("\n!!!!After add book!!!!\n")
    displayLibrary(books.toList)

    println()

    removeBook(books)
    println("\n!!!!After remove book!!!!\n")
    displayLibrary(books.toList)

    CheckBook(books.toList)
  }

}

