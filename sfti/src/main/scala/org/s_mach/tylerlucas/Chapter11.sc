import java.lang.Long
//Ex. 1 Precedence
3 + 4 + 6 -> 5 //performs addition on left, then assigns right to left
//3 -> 4 + 5 breaks

//Ex. 2 pow method vs operator
/* scala is a language based on functional programming,
* following the idea that actions should, when possible
* */

//Ex. 3 Test
import org.s_mach.tylerlucas.{Fraction}
import scala.collection.mutable
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
    for (str <- helloScala) println(str)
    helloScala
  }

}

//Ex. 6
class ASCIIArt(val arrayArt: Array[String] = Array("""    /\/\""", """  ( ^ ^ )""", """  |v   v|""", """   B___B""")){
  def + (arr: Array[String]): Unit = {
    for (w <- 0 to Math.max(arr.length - 1,arrayArt.length - 1) ){
      if(w != arr.length && w!= arrayArt.length ) println(arrayArt(w) + " " + arr(w))
      else
        if(w >= arrayArt.length) println((" " * (arrayArt(arrayArt.length-1).length+1)) + arr(w))
        else
          if(w >= arr.length) println(arrayArt(w))

    }
  }
  def draw(arr: Array[String]): Unit ={
    for(str <- arr) println(str)
  }
  def v (arr: Array[String]): Unit = {
    draw(arrayArt)
    draw(arr)
  }
}

ASCIIArt.drawCat
val helloScala: Array[String] = Array("""  -----""", """/ Hello \""", """< Scala |""", """\ Coder /""", """  -----""")
val catHello = new ASCIIArt()
catHello + helloScala
val helloCat = new ASCIIArt(helloScala)
helloCat + catHello.arrayArt
catHello v helloScala
"hello".updated(0,'t')
//Ex. 7 (got it, finally)
class BitSequence(private var sequence: Long = 0L){
  private def booleanToChar( value: Boolean): Char = {
    if(value) '1' else '0'
  }
  //updates from indexed binary positions, NOT index of string position
  def update(index: Int, value: Boolean): Boolean ={
    if(index<64 && index >=0){
      var updatedString = this.toString.updated(63-index, booleanToChar(value))
      sequence = Long.parseLong(updatedString,2)
      true
    }
    else
      false
  }
  def getSequence: Long = sequence
  override def toString: String = "%64s".format(Long.toBinaryString(sequence)).replaceAll(" ", "0")
}
object BitSequence{
  def apply(sequence: Long): BitSequence = {
    new BitSequence(sequence)
  }
}
//Apply Test
val x = new BitSequence(34388998L)
val y = BitSequence(343L)
//Update Test
y(0) = false
y.toString
y(0) = true

//Ex. 8
class Matrix(val row: Int = 2, val col: Int = 2){

  private var mat = Array.ofDim[Int](row,col)


  def update(x: Int, y: Int, newVal: Int) = mat(x)(y) = newVal
  def apply(x: Int, y: Int): Int = mat(x)(y)


  def + (addedMat: Matrix) : Matrix = {
    if(row == addedMat.row && col == addedMat.col){
      var newMat = new Matrix(row,col)
      for(x <- 0 until row){
        for(y<- 0 until col){
          newMat(x,y) = mat(x)(y) + addedMat.mat(x)(y)
        }
      }
      newMat
    }
    else null
  }
  def * (multMat: Matrix) : Matrix = {
    if(col == multMat.row){
      var newMat = new Matrix(row, multMat.col)
      for(x <- 0 until row){
        for(mY <- 0 until multMat.col){
          var sum = 0
          for(ry<-0 until col){
            sum = sum + mat(x)(ry)* multMat(ry,mY)
          }
          newMat(x,mY) = sum
        }
      }
      newMat
    }
    else null
  }

  override def toString: String = {
    var res = ""
    for(x<- 0 until row){
      res += ("\n\n | ")
      for(y<-0 until col){
        res += "%03d ".format(mat(x)(y))
      }
     res += "| \n"
    }
    res
  }
}

val testMat = new Matrix(2,3)
testMat(0,0) = 1
testMat(0,1) = 2
testMat(0,2) = 3
testMat(1,0) = 4
testMat(1,1) = 5
testMat(1,2) = 6

val testMat2 = new Matrix(3,2)
testMat2(0,0) = 7
testMat2(1,0) = 9
testMat2(2,0) = 11
testMat2(0,1) = 8
testMat2(1,1) = 10
testMat2(2,1) = 12

val addTest = testMat + testMat
val multTestMat = testMat * testMat2
