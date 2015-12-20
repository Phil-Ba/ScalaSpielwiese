import org.json4s._
import org.json4s.native.JsonMethods._

/**
  * Created by pbayer.
  */
object ParseJson4s {

  val json = parse(
    """  {
       "key1" : "val1",
       "key2" : ["12", "32"],
       "key3" : {"keyN" : "valN"}
      }""")

  def main(args: Array[String]) {
    val result: List[Tuple3[Any,Any,Any]] = for {
      JObject(child) <- json
      JField("key1", JString(key1)) <- child
      JField("key2", JArray(key2)) <- child
      JField("key3", JObject(key3)) <- child
    } yield (key1, key2, key3)

    //    val result: List[Any] = for {
    // JObject(child) <- json
    //                            JField("key1", JString(key1)) <- child
    //                            JField("key2", JString(key2)) <- child
    //                            JField("key3", JString(key3)) <- child
    //    } yield (key1, key2, key3)
    println(result)
    println(result(0)._1)
    println(result(0)._2)
  }

}
