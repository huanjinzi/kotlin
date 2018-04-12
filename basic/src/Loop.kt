package loop

// ...

val items = listOf("apple","banana","kiwifruit")

// 1.Using a #for loop
fun loopFor(){
    for (item in items){
        println(item)
    }

    // ... or
    for (index in items.indices){
        println("item at $index is ${items[index]}")
    }
}

// 2.Using a #while loop
fun loopWhile(){
        var index = 0
    while (index < items.size){
        println("item at $index is ${items[index]}")
        index++
    }
}

// 3.Using #when expression
fun describe(obj:Any):String=
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }

// 4.Using ranges
// Check a number is within a range using #in operator:
fun range(){
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("range is fits")
    }
}
// Check if a number out of range:
fun range1(){
    val list = listOf("a","b","c")
    if (-1 !in 0..list.lastIndex){
        println("-1 is out of range")
    }
    if (list.size !in list.indices){
        println("list size is out of list valid list indices range too")
    }

    // iterating over a range
    for (x in 1..5){
        print(x)
    }
    // or over a progression
    for (x in 1..10 step 2){
        print(x)
    }
}

// 5.Using collections
// iterating over a collection:
fun collection(){
    for (item in items){
        print(item)
    }
}
//Checking if a collection contains an object using #in operator:
fun collection1(){
    when{
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

// 6.Using lambda expressions to filter and map collections:
fun lambda(){
    items
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach{ println(it) }
}

fun main(args: Array<String>) {
    range1()
    println(describe(1_100))
}

