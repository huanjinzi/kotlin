package idioms

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

// Creating DTOs (POJOs/POCOs)
data class Customer(val name: String, val email: String)
/*
* provide a #Customer class with the follow functionality:
* --getter(and setter in case of vars for all properties)
* --equals()
* --hashCode()
* --toString()
* --component1(),component2()...
* */

// Default value for function parameters
fun foo(a: Long, name: String = "") {
    // ...

    // String interpolation
    println("Name $name")

    // Instance check
    when (a) {
        is Long -> print("a $a")
        else -> print("a $a")
    }

    // Traversing a map/list of pairs
    val map = mapOf("a" to 1, "b" to 2)
    for ((k, v) in map) {
        println("$k -> $v")
    }

    // Access map
    println(map["a"])

    // Using ranges
    for (i in 1..100) {
    }
    for (i in 1 until 100) {
    }
    for (i in 2..10 step 2) {
    }
    for (i in 2 until 10 step 2) {
    }
    for (i in 10 downTo 1) {
    }
    for (i in 20 downTo 10 step 2) {
    }
}

// Filtering a list
val positives = listOf(1).filter { it > 0 }

// Lazy property
val p: String by lazy { "bcd" }

// Extension Functions
fun String.spaceToCamelCase() {
    //
    "a".spaceToCamelCase()
}

// Creating a singleton
object Resource {
    val name = "Name"
}

// If not null shorthand
val files = File("Test").listFiles()

fun foo() {
    println(files?.size)
}

// Map nullable value if not null
val value = ""
val mapped = value?.let { it.length }

// Return on #when statement
fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

// #try/catch expression
fun test() {
    val result = try {
        1
    } catch (e: Exception) {
        throw java.lang.Exception("test")
    }
}

// #if expression
fun foo(param: Int) {
    val result = if (param == 1) {
        "one"
    } else {
        "two"
    }
}

// Build-style usage of methods that return Unit
fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

// Single-expression functions
fun theAnswer() = 42

// this is equivalent to
fun theAnswer1(): Int {
    return 42
}

// Calling multiple methods on an object instance #with
class Turtal {
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}

    fun test(){
        val myTurtal = Turtal()
        with(myTurtal){ //draw a 100 pix square
            penDown()
            for (i in 1..4) {
                forward(100.0)
                turn(90.0)
            }
            penUp()
        }
    }
}

// Java7's try with resources
val stream = Files.newInputStream(Paths.get("/home/file.txt"))
fun foo2(){
    stream.buffered().reader().use { println(it.readText()) }
}






