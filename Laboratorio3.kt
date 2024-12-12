import kotlin.system.measureTimeMillis

fun main() {
    while (true) {
        println("\nSeleccione una opción:")
        println("1. Ordenar una lista usando Bubble Sort")
        println("2. Ordenar una lista usando Quick Sort")
        println("3. Calcular el factorial de un número")
        println("4. Resolver las Torres de Hanoi")
        println("5. Salir")

        when (readLine()?.toIntOrNull()) {
            1 -> ordenarConBubbleSort()
            2 -> ordenarConQuickSort()
            3 -> calcularFactorial()
            4 -> resolverTorresDeHanoi()
            5 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opción no válida. Por favor, intente de nuevo.")
        }
    }
}

// 1. Ordenar usando Bubble Sort
fun ordenarConBubbleSort() {
    println("Ingrese una lista de números separados por comas (ejemplo: 8,3,5,1,9):")
    val input = readLine()?.split(",")?.mapNotNull { it.trim().toIntOrNull() } ?: return println("Entrada no válida.")
    val tiempoEjecucion = measureTimeMillis {
        val ordenado = bubbleSort(input.toMutableList())
        println("Lista ordenada usando Bubble Sort: $ordenado")
    }
    println("Tiempo de ejecución: ${tiempoEjecucion}ms")
}

fun bubbleSort(lista: MutableList<Int>): List<Int> {
    for (i in 0 until lista.size - 1) {
        for (j in 0 until lista.size - 1 - i) {
            if (lista[j] > lista[j + 1]) {
                val temp = lista[j]
                lista[j] = lista[j + 1]
                lista[j + 1] = temp
            }
        }
    }
    return lista
}

// 2. Ordenar usando Quick Sort
fun ordenarConQuickSort() {
    println("Ingrese una lista de números separados por comas (ejemplo: 8,3,5,1,9):")
    val input = readLine()?.split(",")?.mapNotNull { it.trim().toIntOrNull() } ?: return println("Entrada no válida.")
    val tiempoEjecucion = measureTimeMillis {
        val ordenado = quickSort(input)
        println("Lista ordenada usando Quick Sort: $ordenado")
    }
    println("Tiempo de ejecución: ${tiempoEjecucion}ms")
}

fun quickSort(lista: List<Int>): List<Int> {
    if (lista.size <= 1) return lista
    val pivote = lista[lista.size / 2]
    val menores = lista.filter { it < pivote }
    val iguales = lista.filter { it == pivote }
    val mayores = lista.filter { it > pivote }
    return quickSort(menores) + iguales + quickSort(mayores)
}

// 3. Calcular el factorial de un número
fun calcularFactorial() {
    println("Ingrese un número entero positivo:")
    val numero = readLine()?.toIntOrNull()
    if (numero == null || numero < 0) {
        println("Por favor, ingrese un número válido.")
        return
    }
    val resultado = factorial(numero)
    println("El factorial de $numero es: $resultado")
}

fun factorial(n: Int): Long {
    return if (n == 0) 1 else n * factorial(n - 1)
}

// 4. Resolver las Torres de Hanoi
fun resolverTorresDeHanoi() {
    println("Ingrese el número de discos:")
    val discos = readLine()?.toIntOrNull()
    if (discos == null || discos <= 0) {
        println("Por favor, ingrese un número válido.")
        return
    }
    println("Resolviendo Torres de Hanoi con $discos discos:")
    hanoi(discos, "A", "C", "B")
}

fun hanoi(n: Int, origen: String, destino: String, auxiliar: String) {
    if (n == 1) {
        println("Mover disco 1 de $origen a $destino")
    } else {
        hanoi(n - 1, origen, auxiliar, destino)
        println("Mover disco $n de $origen a $destino")
        hanoi(n - 1, auxiliar, destino, origen)
    }
}