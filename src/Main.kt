fun main(){
    println("Ingrese Puntuación:")
    val puntuacion = readln().toInt()

    println("Ingrese Salario Mensual:")
    val salario = readln().toInt()


    if (puntuacion !in 0..10) {
        println("Puntuación fuera de rango")
    }


    val dineroC = salario * (puntuacion.toDouble() / 10)

    // Determinar nivel de desempeño
    var nivel = ""
    if (puntuacion in 0..3) {
        nivel = "Inaceptable"
    } else if (puntuacion in 4..6) {
        nivel = "Aceptable"
    } else if (puntuacion in 7..10) {
        nivel = "Meritorio"
    }

    // Imprimir resultados
    println("Nivel: $nivel")
    println("Cantidad de dinero recibido: $dineroC")
}