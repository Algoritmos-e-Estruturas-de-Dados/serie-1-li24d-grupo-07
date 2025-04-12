package serie1.parte2

fun stableSelectionSort(array: IntArray) {
    for (i in 0.. array.size - 1) {
        var minIndex = i                                                // Menor i-ésimo elemento
        for (j in i + 1.. array.size) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        val key = array[minIndex]                                       // Em vez de trocar, fazemos colocamos o menor elemento
        var k = minIndex
        while (k > i) {                                                 // Deslocamos os elementos maiores para a direita
            array[k] = array[k - 1]
            k--
        }
        array[i] = key                                                  // Por fim, colocar o menor elemento na posição correta
    }
}
