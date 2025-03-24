package Actividad2

import java.util.Scanner

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

class Rectangulo(private val ancho: Double, private val alto: Double) : Shape() {
    override fun calcularArea() = ancho * alto
    override fun calcularPerimetro() = 2 * (ancho + alto)
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Ingrese el lado del cuadrado: ")
    val lado = scanner.nextDouble()
    val cuadrado = Cuadrado(lado)
    println("\nCuadrado:")
    cuadrado.imprimirResultados()

    print("\nIngrese el ancho del rectángulo: ")
    val ancho = scanner.nextDouble()
    print("Ingrese el alto del rectángulo: ")
    val alto = scanner.nextDouble()
    val rectangulo = Rectangulo(ancho, alto)
    println("\nRectángulo:")
    rectangulo.imprimirResultados()

    print("\nIngrese el radio del círculo: ")
    val radio = scanner.nextDouble()
    val circulo = Circulo(radio)
    println("\nCírculo:")
    circulo.imprimirResultados()
}
