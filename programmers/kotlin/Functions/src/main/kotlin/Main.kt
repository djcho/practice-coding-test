fun printMessage(message: String): Unit {                               //1
    println(message);
}

fun printMessageWithPrefix(message: String, prefix: String = "Info"){   //2
    println("[$prefix] $message");
}

fun sum(x: Int, y: Int): Int {                                          //3
    return x + y;
}

fun multiply(x: Int, y: Int) = x * y                                    //4

fun main() {
    printMessage("Hello~")                                              //5
    printMessageWithPrefix("Hello", "Log")               //6
    printMessageWithPrefix("Hello")                            //7
    printMessageWithPrefix(prefix = "Log", message = "Hello")           //8
    println(sum(1, 2))                                            //9
    println(multiply(2, 4));                                      //10

   // infix fun Int.times(str: String) = str.repeat(this)
    //println(2 times "Bye ")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia

    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive your enemies; nothing annoys them so much"
    println(str[0..14])

    operator fun String.times(str: String) = str + this
    println("12" * "34")

    fun printAll(vararg messages: String){
        for (m in messages) println(m)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "안녕")

    fun printAllWithPrefix(vararg messages: String, prefix: String){
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "안녕",
        prefix = "Greeting: "
    )

    fun log(vararg entries: String){
        printAll(*entries)
    }
}

class Person(val name: String){
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }
}