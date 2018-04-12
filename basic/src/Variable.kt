package variable
// ...

//Defining Variables

//1.Top-level variables
val PI = 3.14
var x = 0

fun incrementX(){
    x++
}

fun foo(){
    //2.Assign-once (read-only) local variables
    val a: Int = 2 //immediate assignment
    val b = 3 // 'Int' type is inferred

    // Type required when no initializer is provided
    val c:Int
    c = 5

    //3.Mutable variables
    var y = 5
    y+=1
}



