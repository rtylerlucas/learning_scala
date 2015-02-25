//Ex.2 write swap that receives pair of Int and
//returns components reversed
def swap(tup: (Int, Int)): (Int, Int) = {
  tup match {
    case t: (Int,Int) => (t._2, t._1)
//    case _ => println("not solvable")
  }
}
val tup1 = (1,2)
val tup2 = swap(tup1)

//Ex.3 swap first to elms of array, provided length is at least 2
def swapArr[A](arr: Array[A]) = {
  arr match {
    case arr: Array[A] => {
      if(arr.length<2){
        println("not big enough")
      }
      else{
        val second = arr(1)
        arr(1) = arr(0)
        arr(0) = second
      }
    }
  }
}
val arr1 = Array(0)
val arr2 = Array(1,2,3)
swapArr(arr1)
swapArr(arr2)
arr1
arr2
//Ex. 4 Add case class Multiple that is subclass of Item class
// Example: Multiple(10,Article("Toaster", 29.95)) describes 10 toasters
abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item
case class Multiple(count: Int, item: Item) extends Item
object Item{
  def price(it: Item): Double = it match {
    case Article(_,p) => p
    case Bundle(_,disc,its @ _*) => its.map(price _).sum - disc
    case Multiple(c,itm) => {
      itm match {
        case a: Article => c * a.price
        case b: Bundle => c * price(b)
        case m: Multiple => c * price(m)
      }
    }
  }
}

val chair = Article("big chair", 15)
val tv = Article("samsung tv", 100)
val tvChairCombo = Bundle("tv and chair", 5, chair, tv)
val chairs = Multiple(10, chair)
Item.price(chair)
Item.price(tv)
Item.price(tvChairCombo)
Item.price(chairs)

//Ex.5
