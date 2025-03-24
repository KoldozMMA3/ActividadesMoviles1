package Actividad2

import java.util.Scanner

class Producto(private var precio: Double, private var descuento: Double) {

    init {
        require(precio >= 0) { "El precio no puede ser negativo." }
        require(descuento in 0.0..100.0) { "El descuento debe estar entre 0 y 100." }
    }

    fun getPrecio() = precio

    fun setPrecio(nuevoPrecio: Double) {
        require(nuevoPrecio >= 0) { "El precio no puede ser negativo." }
        precio = nuevoPrecio
    }

    fun getDescuento() = descuento

    fun setDescuento(nuevoDescuento: Double) {
        require(nuevoDescuento in 0.0..100.0) { "El descuento debe estar entre 0 y 100." }
        descuento = nuevoDescuento
    }

    fun calcularPrecioFinal(): Double {
        return precio * (1 - descuento / 100)
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Ingrese el precio del producto: ")
    val precio = scanner.nextDouble()

    print("Ingrese el descuento (%): ")
    val descuento = scanner.nextDouble()

    val producto = Producto(precio, descuento)
    println("Precio original: ${producto.getPrecio()}")
    println("Descuento: ${producto.getDescuento()}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")
}