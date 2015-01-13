import org.s_mach.tylerlucas.{Bundle, SimpleItem, CheckingAccount}
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