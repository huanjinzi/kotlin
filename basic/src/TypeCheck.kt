package typecheck

// ...

// Using type check and automatic cast
// The #is operator checks if an expression is an instance of a type.
// If an immutable local variable or property is checked for a specific type, there
// is no need to cast it explicitly:
fun getStringLength(obj:Any):Int?{

    if (obj is String){
        // #obj is automatically casted to #String in this branch
        return obj.length
    }
    // #obj still of type #Any outside of the type-checked branch
    return null
}

// ... or
fun getStringLength1(obj:Any):Int?{

    if (obj !is String)return null

    // #obj is automatically casted to #String in this branch
    return obj.length
}

// ... or even
fun getStringLength2(obj: Any): Int? {

    // #obj is automatically cast to #String on the right-hand side of #&&
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}