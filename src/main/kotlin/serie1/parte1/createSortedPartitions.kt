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
