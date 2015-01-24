//Ex. 1 Precedence
3 + 4 + 6 -> 5 //performs addition on left, then assigns right to left
//3 -> 4 + 5 breaks

//Ex. 2 pow method vs operator
/* scala is a language based on functional programming,
* following the idea that actions should, when possible
* */

//Ex. 3 Test
import org.s_mach.tylerlucas.{Money, Fraction}
val fiveOverFour = new Fraction(5,4)
//subtract
val res = (fiveOverFour - new Fraction(3,4))
res.getNum
res.getDen
//add
res + fiveOverFour
res.toString
//multiply
res.*(res)
res.toString
//divide
res / res
res.toString
//Ex. 4 m o n e y

val cash = new Money(34,101)
cash.toString