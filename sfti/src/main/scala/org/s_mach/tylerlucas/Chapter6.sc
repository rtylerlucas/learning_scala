import org.s_mach.tylerlucas
import org.s_mach.tylerlucas.Chapter6.PlayingCard._
import org.s_mach.tylerlucas.{Chapter6, Chapter5}

object Origin extends java.awt.Point
//Ex. 3
println(Origin)
object Reverse extends App {
  var counter = 0
  var current = ""
  if(args.length>0){
    for(i<-args.length-1 until 0 by -1) {
      if(args(i)!=" "){
        counter+= 1
        current = args(i) + current
      }
      else{
        counter = 0
        print(current + " ")
        current = ""
      }
    }
    print(current)
  }
  else println("Empty Args!")

}
val word = Reverse.main(Array("Hello", "World"))
println(word)
val chp6 = Chapter6
chp6.PlayingCard.Heart.toString
//Ex. 7
val heartcard = chp6.PlayingCard.Heart

def checkColor(card: PlayingCard): String = {
  if (card == Heart || card == Diamond) "Red"
  else "Black"
}
checkColor(heartcard)
