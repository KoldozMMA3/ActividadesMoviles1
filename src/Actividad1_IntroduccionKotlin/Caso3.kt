package Actividad1_IntroduccionKotlin

fun main() {
    val mySet = setOf("Suma", "Resta", "Multiplicacion", "Division", "Salir")
    val myList = mySet.filter { it in mySet }
    println(mySet)
val myList = mySet.filter { it -> it.contains("nivel") }
}