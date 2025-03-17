package Actividad1_IntroduccionKotlin

fun main() {
    while (true) {
        println("==== Menu ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicacion")
        println("4. Division")
        println("5. Salir")
        print("Elige una opcion: ")

        val opcion = readlnOrNull()?.toIntOrNull()

        if (opcion == 5) {
            println("Saliendo...")
            break
        }

        if (opcion !in 1..4) {
            println("Opción inválida\n")
            continue
        }

        print("Ingresa el primer numero: ")
        val num1 = readlnOrNull()?.toDoubleOrNull()
        print("Ingresa el segundo numero: ")
        val num2 = readlnOrNull()?.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            println("Entrada invalida\n")
            continue
        }

        var resultado: Any = "Opcion invalida"

        if (opcion == 1) {
            resultado = num1 + num2
        } else if (opcion == 2) {
            resultado = num1 - num2
        } else if (opcion == 3) {
            resultado = num1 * num2
        } else if (opcion == 4) {
            resultado = num1 / num2
        }

        println("Resultado: $resultado\n")
    }
}
