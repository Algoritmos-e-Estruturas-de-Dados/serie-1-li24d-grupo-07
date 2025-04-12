package serie1.parte1

import java.io.File                                             // Biblioteca implementa um ficheiro externo ao código

fun createSortedPartitions(fileName: String, partitionSize: Int): Int {
    val file = File(fileName)                                   // Coloca o ficheiro numa variável
    val linesInFile = file.readLines().map { it.toInt() }       // Lê e transforma o número de linhas para uma variável (Lista)
    var numWays = linesInFile.size / partitionSize              // É o número de ficheiros que serão criados
    var index0 = 0
    for (i in 0.. numWays) {
        val index1 = if (index0 + partitionSize <= linesInFile.size) index0 + partitionSize else linesInFile.size
        var partition = linesInFile.subList(index0, index1).sorted()
        val newFileName = "$i.txt"
        File(newFileName).writeText(partition.joinToString("\n"))
        index0 = index1
    }
    return numWays
}







/*
1-
fun createSortedPartitions(fileName: String, partitionSize: Int): Int {
    var n = fileName.count()
    var numWays = n % partitionSize
    ...
}





2-
import java.io.File

fun createSortedPartitions(fileName: String, partitionSize: Int): Int {
    // 1. Ler o conteúdo do ficheiro
    val file = File(fileName)
    val numbers = file.readLines().map { it.toInt() } // Converte as linhas do ficheiro para inteiros

    // 2. Calcular o número de subficheiros a ser criados
    val numWays = numbers.size / partitionSize + if (numbers.size % partitionSize > 0) 1 else 0

    // 3. Ordenar o conteúdo em partes
    var startIndex = 0
    for (i in 1..numWays) {
        // Definir o final do subficheiro (não ultrapassar o tamanho do vetor)
        val endIndex = if (startIndex + partitionSize <= numbers.size) startIndex + partitionSize else numbers.size

        // Pegar a parte dos números a ser ordenada e escrita
        val partition = numbers.subList(startIndex, endIndex).sorted()

        // 4. Escrever o subficheiro
        val subFileName = "$i.txt"
        File(subFileName).writeText(partition.joinToString("\n"))

        // Atualizar o índice de início para o próximo subficheiro
        startIndex = endIndex
    }

    // Retornar o número de subficheiros criados
    return numWays
}


 */