package serie1.parte1


fun counter(array: IntArray, k: Int, lower: Int, upper: Int): Pair<Int, Int> {
    var count1 = 0
    var count2 = 0
    for (i in 0.. array.size - k) {
        val sum = array.slice( i until i + k ).sum()
        if (sum < lower) {
            count1++
        }
        if (sum > upper) {
            count2++
        }
    }
    return Pair(count1, count2)
}

fun main() {
    val arr1 = intArrayOf(3, 6, 9,104, 275)
    println(counter(arr1, 1, 3, 3))
}