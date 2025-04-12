package serie1.parte1


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
