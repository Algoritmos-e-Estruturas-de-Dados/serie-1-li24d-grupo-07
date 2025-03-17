package parte1

fun findMinDifference(elem1: IntArray, elem2: IntArray): Int {
    var minDif = Int.MAX_VALUE
    var dif : Int = 0
    if (elem1.count() == 0 || elem2.count() == 0) {
        return -1
    }
    for (i in elem1.indices) {
        for (j in elem2.indices) {
            dif = kotlin.math.abs(elem1[i] - elem2[j])
            minDif = kotlin.math.min(minDif, dif)
        }
    }

    return minDif
}

fun counter(array: IntArray, k: Int, lower: Int, upper: Int): Pair<Int, Int> {
    throw UnsupportedOperationException()
}

fun createSortedPartitions(fileName: String, partitionSize: Int): Int{
    throw UnsupportedOperationException()
}

