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
    var count1 = 0
    var count2 = 0
    for (i in 0..array.size - k) {
        var sum = 0
        for (j in i until i + k) {
            sum += array[j]
        }
        if (sum < lower) {
            count1++
        }
        if (sum > upper) {
            count2++
        }
    }
    return Pair(count1, count2)
}

fun createSortedPartitions(fileName: String, partitionSize: Int): Int{
    throw UnsupportedOperationException()
}

