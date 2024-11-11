import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val vector = Vector<Int>(listOf(34, 7, 23, 32, 5, 62))
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nEscolha uma operação:")
        println("1> Busca Linear")
        println("2> Busca Binária")
        println("3> Tabela Hash")
        println("4> Ordenação Bubble Sort")
        println("5> Ordenação Insertion Sort")
        println("6> Ordenação Selection Sort")
        println("7> Ordenação Merge Sort")
        println("8> Ordenação Quick Sort")
        println("0> Sair")
        print("Opção: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Digite o número para busca linear: ")
                val find = scanner.nextInt()
                println("Resultado da busca linear: ${buscaLinear(vector, find)}")
            }
            2 -> {
                print("Digite o número para busca binária: ")
                val find = scanner.nextInt()
                println("Resultado da busca binária: ${buscaBinaria(vector, find)}")
            }
            3 -> tabelaHash(vector)
            4 -> println("Bubble Sort: ${bubbleSort(vector.clone() as Vector<Int>)}")
            5 -> println("Insertion Sort: ${insertionSort(vector.clone() as Vector<Int>)}")
            6 -> println("Selection Sort: ${selectionSort(vector.clone() as Vector<Int>)}")
            7 -> println("Merge Sort: ${mergeSort(vector.clone() as Vector<Int>)}")
            8 -> println("Quick Sort: ${quickSort(vector.clone() as Vector<Int>, 0, vector.size - 1)}")
            0 -> break
            else -> println("Opção inválida, tente novamente.")
        }
    }
}

fun buscaLinear(vector: Vector<Int>, find: Int):Boolean{
    for(item in vector){
        if(item == find){
            return true
        }
    }
    return false
}

fun buscaBinaria(vector: Vector<Int>, find: Int): Boolean{
    var left = 0
    var right = vector.size -1

    while (left<=right){
        val middle = left + (right - left) / 2
        if (vector[middle] == find) return true
        if (vector[middle] < find) left = middle + 1 else right = middle - 1
    }
    return false
}

fun tabelaHash(vector: Vector<Int>){
    val hashMap = HashMap<Int,Int>()
    vector.forEach { hashMap[it] = it.hashCode()}
    hashMap.forEach { (key, value) -> println("Chave: $key, HashCode: $value") }
}

fun bubbleSort(vector: Vector<Int>): Vector<Int> {
    for (i in 0 until vector.size - 1) {
        for (j in 0 until vector.size - 1 - i) {
            if (vector[j] > vector[j + 1]) {
                val temp = vector[j]
                vector[j] = vector[j + 1]
                vector[j + 1] = temp
            }
        }
    }
    return vector
}

fun insertionSort(vector: Vector<Int>): Vector<Int> {
    for (i in 1 until vector.size) {
        val key = vector[i]
        var j = i - 1
        while (j >= 0 && vector[j] > key) {
            vector[j + 1] = vector[j]
            j--
        }
        vector[j + 1] = key
    }
    return vector
}

fun selectionSort(vector: Vector<Int>): Vector<Int> {
    for (i in 0 until vector.size - 1) {
        var minIndex = i
        for (j in i + 1 until vector.size) {
            if (vector[j] < vector[minIndex]) minIndex = j
        }
        val temp = vector[minIndex]
        vector[minIndex] = vector[i]
        vector[i] = temp
    }
    return vector
}

fun mergeSort(vector: Vector<Int>): Vector<Int> {
    if (vector.size <= 1) return vector
    val middle = vector.size / 2
    val left = mergeSort(Vector(vector.subList(0, middle)))
    val right = mergeSort(Vector(vector.subList(middle, vector.size)))
    return merge(left, right)
}

fun merge(left: Vector<Int>, right: Vector<Int>): Vector<Int> {
    var i = 0
    var j = 0
    val merged = Vector<Int>()
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            merged.add(left[i])
            i++
        } else {
            merged.add(right[j])
            j++
        }
    }
    while (i < left.size) merged.add(left[i++])
    while (j < right.size) merged.add(right[j++])
    return merged
}

fun quickSort(vector: Vector<Int>, low: Int, high: Int): Vector<Int> {
    if (low < high) {
        val pi = partition(vector, low, high)
        quickSort(vector, low, pi - 1)
        quickSort(vector, pi + 1, high)
    }
    return vector
}

fun partition(vector: Vector<Int>, low: Int, high: Int): Int {
    val pivot = vector[high]
    var i = low - 1
    for (j in low until high) {
        if (vector[j] < pivot) {
            i++
            val temp = vector[i]
            vector[i] = vector[j]
            vector[j] = temp
        }
    }
    val temp = vector[i + 1]
    vector[i + 1] = vector[high]
    vector[high] = temp
    return i + 1
}

