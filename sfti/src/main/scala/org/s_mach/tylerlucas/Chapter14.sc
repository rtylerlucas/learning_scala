import com.sun.deploy.security.MozillaJSSDSASignature.NONEwithDSA
import com.sun.source.tree.BinaryTree

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
def listSum(list: List[Any]) = {
  val f = (i: Any) => i match{
    case i: List[Int] => i.sum
    case i: Int => i
    case _ => 0
  }

  list.reduceLeft(f(_) + f(_))

}
val list = List[Any](List[Int](3, 8), 2, List[Int](5))
listSum(list)
//Ex. 6 & //Ex. 7 Repeat ex 6 but allow for arbitrary number of children


sealed abstract class BTree
case class Leaf(value: Int) extends BTree
case class Node(left: BTree, right: BTree) extends BTree
case class KidNode(children: BTree*) extends BTree
def leafSum(bt: BTree): Int = {
  bt match{
    case bt: Leaf => bt.value
    case bt: Node => (leafSum(bt.left) + leafSum(bt.right))
    case bt: KidNode =>
      bt.children.foldLeft(0)(((r: Int,c: BTree) => r+leafSum(c)))
  }
}
//Ex. 6 Test
val btree = Node(Node(Leaf(3), Leaf(8)), Leaf(2))
leafSum(btree)
//Ex. 7 Test
val binaryKidTree = KidNode(Node(Leaf(3), Leaf(8)), Leaf(2), KidNode(Leaf(5)))
leafSum(binaryKidTree)
//Ex. 8 extend tree in last ex. so each nonleaf node stores an operator
//in addition to their child nodes. Write a func eval that computes the value
trait NonLeaf {
  def operator: String
}
sealed abstract class BTreePlus
case class LeafPlus(value: Int) extends BTreePlus
case class NodePlus(operator: String, children: BTreePlus*) extends BTreePlus with NonLeaf
def treeOps(bt: BTreePlus): Int = {
  bt match{
    case bt: LeafPlus => bt.value
    case bt: NodePlus => bt.operator match {
      case "+" => bt.children.foldLeft(0)(((r: Int,c: BTreePlus) => r+treeOps(c)))
      case "-" => bt.children.foldLeft(0)(((r: Int,c: BTreePlus) => r-treeOps(c)))
      case "*" => bt.children.foldLeft(1)(((r: Int,c: BTreePlus) => r*treeOps(c)))
      case "/" => bt.children.foldLeft(1)(((r: Int,c: BTreePlus) => r/treeOps(c)))
      case _ => 0
    }
  }
}
val bTreePlus = NodePlus("+", NodePlus("*", LeafPlus(3), LeafPlus(8)), LeafPlus(2), NodePlus("-", LeafPlus(5)))
treeOps(bTreePlus)
//Ex. 9
def nonNoneSums(list: List[Option[Int]]): Int = {
  val f = (i: Option[Int]) => i match {
    case Some(i) => i
    case None => 0
  }
  list.foldLeft(0)((b, a) => b+f(a))
}
def nonNoneSums2(list: List[Option[Int]]): Int = {
  list.map(_.getOrElse(0)).sum
}

val listNum9 = List[Option[Int]](Some(1),None,Some(2), Some(4))
nonNoneSums(listNum9)
nonNoneSums2(listNum9)

//Ex. 10
def compose(f1: Double => Option[Double], f2: Double => Option[Double]): Double => Option[Double]  ={
  (x: Double) => f2(x) match{
    case Some(x) => f1(x)
    case None => None
  }
}
def f(x: Double) = if(x>=0) Some(Math.sqrt(x)) else None
def g(x: Double) = if(x!=1) Some (1 / (x-1)) else None

val h = compose (f,g)
h(20)
h(2)
h(1)
h(0)

