package Actividad2
import java.util.Scanner

class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    init {
        require(saldo >= 0) { "El saldo inicial no puede ser negativo." }
        require(limiteRetiro > 0) { "El limite de retiro debe ser mayor que cero." }
    }

    fun getSaldo() = saldo

    fun setSaldo(nuevoSaldo: Double) {
        require(nuevoSaldo >= 0) { "El saldo no puede ser negativo." }
        saldo = nuevoSaldo
    }

    fun getLimiteRetiro() = limiteRetiro

    fun setLimiteRetiro(nuevoLimite: Double) {
        require(nuevoLimite > 0) { "El limite de retiro debe ser mayor que cero." }
        limiteRetiro = nuevoLimite
    }

    fun retirar(monto: Double): Boolean {
        if (monto > saldo) {
            println("Fondos insuficientes.")
            return false
        }
        if (monto > limiteRetiro) {
            println("El monto excede el limite de retiro.")
            return false
        }
        saldo -= monto
        println("Retiro exitoso. Nuevo saldo: $$saldo")
        return true
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val cuenta = CuentaBancaria(1450.0, 1450.0)
    println("Saldo inicial: ${cuenta.getSaldo()}")

    print("Ingrese el monto a retirar: ")
    val monto = scanner.nextDouble()
    cuenta.retirar(monto)
}