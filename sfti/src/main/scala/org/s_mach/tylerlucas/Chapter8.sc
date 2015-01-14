import org.s_mach.tylerlucas._
import java.util.Calendar
val checking = new CheckingAccount(1000)
checking.currentBalance
checking.deposit(2)
checking.currentBalance
checking.withdraw(50)
val date1 = Calendar.getInstance().getTime()
val date2 = Calendar.getInstance().getTime()
val mat = date2.compareTo(date1)

val textbook = new SimpleItem(100, "Math and science book")
val shoes = new SimpleItem(50, "Nike Sneakers")
val bundle = new Bundle(textbook, shoes)
bundle.description
bundle.price
val sq = new Square()
val sq2 = new Square(40)
val sq3 = new Square(new Point(3,5),40)
val creat = new Ant()
creat.range
creat.env.length

