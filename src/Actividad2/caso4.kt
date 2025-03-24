package Actividad2

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservados(usuario: Usuario)
}

abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numPaginas: Int) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numPaginas")
    }
}

class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

class Biblioteca : IBiblioteca {
    private val materiales = mutableListOf<Material>()
    private val usuarios = mutableListOf<Usuario>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materiales.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materiales.remove(material)) {
            prestamos.computeIfAbsent(usuario) { mutableListOf() }.add(material)
            println("${usuario.nombre} ha tomado prestado: ${material.titulo}")
        } else {
            println("Material no disponible")
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        prestamos[usuario]?.remove(material)?.let {
            materiales.add(material)
            println("${usuario.nombre} ha devuelto: ${material.titulo}")
        } ?: println("El usuario no tenía este material")
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materiales.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservados(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() } ?: println("No tiene materiales prestados")
    }
}

fun main() {
    val biblioteca = Biblioteca()
    val libro = Libro("El Principito", "Saint-Exupéry", 1943, "Ficción", 96)
    val revista = Revista("NatGeo", "Varios", 2023, "1234-5678", 50, 12, "NatGeo Publishing")
    val usuario = Usuario("Juan", "Pérez", 25)

    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)
    biblioteca.registrarUsuario(usuario)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.prestarMaterial(usuario, libro)
    biblioteca.mostrarMaterialesReservados(usuario)
    biblioteca.devolverMaterial(usuario, libro)
    biblioteca.mostrarMaterialesDisponibles()
}