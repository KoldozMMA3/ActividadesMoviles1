import kotlin.random.Random

fun main() {
    val opciones = listOf("Papel","Tijera","Piedra")
    val IA  = Random.nextInt(1, opciones.size)

    println("Elija entre las 3 opciones: $opciones")
    var Humano = readLine()!!.toInt()
}