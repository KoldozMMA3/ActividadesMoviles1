import kotlin.random.Random

fun main() {
    val opciones = listOf("Papel","Tijera","Piedra")
    val IA  = opciones[Random.nextInt(3)]

    println("Elija entre las 3 opciones: $opciones")
    var Humano = readlnOrNull()

    if (Humano !in opciones) {
        println("Opcion Incorrecta")
        return
    }

    println("IA eligio $IA")

    if (Humano ==IA){
        println("Empate")
    } else if (Humano == "Papel" && IA == "Piedra" || Humano == "Tijera" && IA == "Papel" ||Humano == "Piedra" && IA == "Tijera" ){
        println("Ganaste Humano")
    } else {
        println("IA Gano")
    }


}