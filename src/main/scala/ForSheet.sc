import java.time.{LocalDateTime, ZoneOffset}
import java.util.Date

val l = (1 to 5).toList

object StringWrapper {
  def unapply(i: Int) = Some("int: " + i.toString)

  def apply(i: Int) = "int: " + i.toString
}

println()
for {
  StringWrapper(n) <- l
} yield n

//for {
// (n)<-l
//} yield n


case class Belag(name: String,
                 vegetarisch: Boolean)

//class Pizza(name: String,
//
//: String,
//sender: String,
//recipient: String)
//
//type EmailFilter = Email => Boolean
//type SizeChecker = Int => Boolean
//
//val sizeConstraint: SizeChecker => EmailFilter = f => email => f(email.text.size)
//val minimumSize: Int => EmailFilter = n => email => email.text.size >= n


implicit def DateAdapter(s: Date): LocalDateTime = {
  LocalDateTime.ofInstant(s.toInstant, ZoneOffset.UTC)
}

def addDays(plusDays: Int, time: LocalDateTime): LocalDateTime = {
  time.plusDays(plusDays)
}
addDays(5, new Date())

object Helpers {

  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      for (i <- 0 to x) {
        f
      }
    }
  }

}

import Helpers._

5 times println("5")


