package serie1.parte1

fun findMinDifference(elem1: IntArray, elem2: IntArray): Int {
    var dif : Int = 0
    if (elem1.count() == 0 || elem2.count() == 0) {
        dif = -1
        return dif
    }
    for (i in elem1.indices) {
        for (j in elem2.indices) {
            if (elem1[i] - elem2[j] > elem1[i-1] - elem2[j-1])
                dif = elem1[i] - elem2[j]

        }
    }
    return dif
}

fun main() {
    val arr1 = intArrayOf(3, 6, 9)
    val arr2 = intArrayOf(5, 10, 70)
    println(findMinDifference(arr1, arr2))
}

/*

1- ERRADO

fun findMinDifference(elem1: IntArray, elem2: IntArray): Int {
    var dif : Int = 0
    if (elem1.count() == 0 || elem2.count() == 0) {
        dif = -1
        return dif
    }
    for (i in elem1.indices) {
        for (j in elem2.indices) {
            if (elem1[i] - elem2[j] > elem1[i-1] - elem2[j-1])
                dif = elem1[i] - elem2[j]
        }
    }
    return dif
}

 */