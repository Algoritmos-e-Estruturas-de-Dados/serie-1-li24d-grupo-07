package serie1.parte3

import java.io.File
import java.util.PriorityQueue

// Função para dividir o ficheiro em subficheiros ordenados
fun createSortedPartitions(fileName: String, partitionSize: Int): Int {
    val file = File(fileName)
    val linesInFile = file.readLines().map { it.toInt() }
    var numWays = linesInFile.size / partitionSize
    var index0 = 0
    for (i in 0 until numWays) {
        val index1 = if (index0 + partitionSize <= linesInFile.size) index0 + partitionSize else linesInFile.size
        val partition = linesInFile.subList(index0, index1).sorted()
        val newFileName = "$i.txt"
        File(newFileName).writeText(partition.joinToString("\n"))
        index0 = index1
    }
    return numWays
}

// Função para intercalação dos subficheiros ordenados
fun mergeSortedFiles(numWays: Int, outputFilename: String) {
    val queues = mutableListOf<PriorityQueue<Int>>()

    // Criar uma fila de prioridade para cada subficheiro
    for (i in 1..numWays) {
        val subFile = File("$i.txt")
        val pq = PriorityQueue<Int>()
        pq.addAll(subFile.readLines().map { it.toInt() })
        queues.add(pq)
    }

    // Ficheiro de saída final
    val outputFile = File(outputFilename)
    outputFile.bufferedWriter().use { writer ->
        while (queues.isNotEmpty()) {
            // Encontrar o menor elemento entre as filas de prioridade
            var minIndex = -1
            var minValue = Int.MAX_VALUE
            for (i in queues.indices) {
                if (queues[i].isNotEmpty() && queues[i].peek() < minValue) {
                    minValue = queues[i].peek()
                    minIndex = i
                }
            }

            // Escrever o menor elemento no ficheiro de saída
            writer.write("$minValue\n")
            queues[minIndex].poll()

            // Se a fila de prioridade de um subficheiro estiver vazia, removê-la
            if (queues[minIndex].isEmpty()) {
                queues.removeAt(minIndex)
            }
        }
    }
}

fun main() {
    val inputFilename = "C:\\Users\\jaiso\\IdeaProjects\\test_1SERIE\\src\\input.txt"
    val outputFilename = "C:\\Users\\jaiso\\IdeaProjects\\test_1SERIE\\src\\output.txt"
    val partitionSize = 1000

    // Criar subficheiros ordenados
    val numWays = createSortedPartitions(inputFilename, partitionSize)

    // Intercalação dos subficheiros
    mergeSortedFiles(numWays, outputFilename)
}