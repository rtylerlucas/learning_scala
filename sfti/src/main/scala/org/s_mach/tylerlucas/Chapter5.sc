import org.s_mach.tylerlucas.Chapter5
import org.s_mach.tylerlucas.Chapter5.{Person, Student}


//Exercise 1 Test
val counter = new Chapter5.Counter
counter.current()
counter.increment()
counter.add(Int.MaxValue)
counter.current()

//Exercise 2 Test
val bank = new Chapter5.BankAccount
bank.deposit(500)
bank.current
bank.withdraw(600) //fails, withdraws 0
bank.withdraw(300)

//Exercise 3 Test
val watch = new Chapter5.Time
val watch2 = new Chapter5.Time(3,45)
watch2.current
watch.current
watch.before( new Chapter5.Time(6,30) )
watch2.before(watch)
watch.set(4,44)
watch.current

//Exercise 5 Test
val student = new Student()
student.getId

//Exercise 6 & 7 Test
val person = new Person("Tyler Lucas", 21)
val name = "Tyler Lucas ".split(" ")
name(1)
println(person.firstName)

