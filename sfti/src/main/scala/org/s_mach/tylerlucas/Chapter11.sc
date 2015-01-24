//Ex. 1 Precedence
3 + 4 + 6 -> 5 //performs addition on left, then assigns right to left
//3 -> 4 + 5 breaks

//Ex. 2 pow method vs operator
/* scala is a language based on functional programming,
* following the idea that actions should, when possible
* */

//Ex. 3 Test
import org.s_mach.tylerlucas.{Fraction}
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
//Ex. 4 M o n e y
class Money(var dollar: Int, var cents: Int){
  if(cents > 100) dollar = dollar + (cents / 100); cents = cents % 100
  var centString = "0."+cents
  private val total: Float = (dollar + (centString.toFloat))
  override def toString = "$%.2f".format(total) //Format not proper

  def + (money: Money): Money = {
    new Money(dollar + money.dollar, cents + money.cents)
  }
  def - (money: Money): Money = {
    new Money(dollar - money.dollar, cents - money.cents)
  }
  def < (money: Money): Boolean = {
    if(this.total < money.total) true
    else false
  }
  def > (money: Money): Boolean = {
    if(this.total > money.total) true
    else false
  }
  def == (money: Money): Boolean = {
    if(this.total == money.total) true
    else false
  }
  def copy: Money = new Money(dollar, cents)
}
val cash = new Money(45,65)
cash - new Money(133,101)
val moreCash = cash + new Money(50,12)
moreCash < cash
moreCash > cash
moreCash == cash
val moreCash2 = moreCash.copy
moreCash == moreCash2
//In my opinion multiply / divide would require
// a crude implementation as money is not typically
//multiplied by itself, or processed with integer division.

//Ex. 5 (Awesome exercise)
class Table() {
  private var body = ""
  private final val closeRow = "</tr>"

  def | (data: String): Table= {
    if(body.equals("")) body+= "<tr>"
    body += "<td>" + data + "</td>"
    this

  }
  def || (data: String): Table = {
    if(body.equals("")) this | data
    else
      body += "</tr><tr>" + "<td>" + data + "</td>"
    this
  }

  override def toString: String = {
    if(!body.equals("")) body += closeRow
    "<table>" +  body + "</table>"
  }
}
object Table{
  def apply() = new Table()
}
var newTable: Table = Table() | "Java" | "Scala" || "Tyler" | "Lucas"
//Ex. 6 ASCIIArt
object ASCIIArt {
  private val newline = "\n"
  private val catArray: Array[String] = Array("""    /\/\""", """  ( ^ ^ )""", """  |v   v|""", """   B___B""")
  private val helloScala: Array[String] = Array("""  -----""", """/ Hello \""", """< Scala |""", """\ Coder /""", """  -----""")

  def drawCat: Array[String] = {
    for (str <- catArray) println(str)
    catArray
  }

  def drawHelloScala: Array[String] = {
    for (str <- helloScala) println(str);
    helloScala
  }
}
//working on class integration for adding method
//  class ASCIIArt(artType: String) {
//  val artArr = {
//    if(artType.contains("cat")) this.cat
//}
ASCIIArt.drawCat
ASCIIArt.drawHelloScala
