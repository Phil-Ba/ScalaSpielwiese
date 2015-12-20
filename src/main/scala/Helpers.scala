import java.time.{LocalDateTime, ZoneOffset}
import java.util.Date

/**
  * Created by pbayer.
  */
object Helpers {
  implicit def DateAdapter(s: Date): LocalDateTime = {
    LocalDateTime.ofInstant(s.toInstant, ZoneOffset.UTC)
  }
}
