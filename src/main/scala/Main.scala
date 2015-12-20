import java.time.temporal.{ChronoUnit, Temporal}
import java.util.Date

/**
  * Created by pbayer.
  */
object Main {

  def main(args: Array[String]): Unit = {

    import Helpers.DateAdapter
    val aDate: Date = new Date()
    aDate.plusDays(5)

    println(aDate.plusDays(5))

    //    implicit val x = 5
    //    implicit val y = 5

    //    implicit var intToString = (i: Int) => i.toString
    //    implicit var intToChar = (i: Int) => i.toString.charAt(0)
    //    myFunct("as")
    //    new SomeClass().someFunction()
  }

  //
  //  class SomeClass {
  //    def someFunction() = {
  //      implicit val intToString = (i: Int) => i.toString
  //      implicit val intToChar = (i: Int) => i.toStringharAt(0)
  //      myFunct("aString")
  //    }


  def addDays[T <: Temporal](plusDays: Long, time: T)(implicit dateAdapter: Any => T): T = {
    time.plus(plusDays, ChronoUnit.DAYS)
  }

  def addDays2[T <: Temporal](plusDays: Long, time: T): Temporal = {
    time.plus(plusDays, ChronoUnit.DAYS)
  }
}

//def myFunct(aString: String)(implicit implParam1: Int => String, implParam2: Int => Char)
//= aString


//}
