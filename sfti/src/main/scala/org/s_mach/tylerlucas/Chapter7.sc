import collection.mutable.{HashMap => ScalaHashMap, Map => ScalaMap}
import java.util.{HashMap => JavaHashMap, Map => JavaMap}
import collection.JavaConversions.mapAsScalaMap
//Ex. 6
val javaHM = new JavaHashMap[String, String]
javaHM.put("firstname", "Tyler")
javaHM.put("lastname", "Lucas")

val scalaHM = new ScalaHashMap[String, String]()

for((k, v) <- javaHM ) scalaHM += (k->v)
println(scalaHM)