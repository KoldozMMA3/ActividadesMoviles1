package Actividad1_IntroduccionKotlin

import kotlin.random.Random

fun main() {
    val numeroAleatorio = Random.nextInt(1, 31)
    var intentos = 5

    println("Adivina el numero, tienes 5 intentos.")

    while (intentos > 0) {
        print("Ingresa un numero: ")
        val numeroElegido = readlnOrNull()?.toIntOrNull()

        if (numeroElegido == null || numeroElegido !in 1..30) {
            println("Ingrese un numero entre 1 y 30.")
            continue
        }

        if (numeroElegido == numeroAleatorio) {
            println("Eres un Genio, lo Lograste")
            return
        } else if (numeroElegido < numeroAleatorio) {
            println("El numero que ingresaste es menor que el numero aleatorio, tienes otro intento.")
        } else {
            println("El numero ingresado es mayor que el numero aleatorio, tienes otro intento.")
        }

        intentos--

        if (intentos == 0) {
            println("Game Over. El numero era $numeroAleatorio.")
        } else {
            println("Te quedan $intentos intentos.")
        }
    }
}