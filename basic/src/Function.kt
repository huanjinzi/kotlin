package function
// ...

//Defining Functions
// 1.Function #sum having two Int parameters with Int return type
fun sum(a:Int,b:Int):Int{
    return a + b
}
//2.Function with an expression and inferred return type
/*
fun sum(a:Int,b:Int) = a + b
* */
//3.Function returning no meaningful value:
fun printSum(a:Int,b:Int):Unit{
    println("sum of a and b is ${a + b}")

}
//4.Unit return type can be omitted
/*fun printSum(a:Int,b:Int){
    println("sum of a and b is ${a + b}")
}
* */

fun main(args:Array<String>){
    println("hello world")
}