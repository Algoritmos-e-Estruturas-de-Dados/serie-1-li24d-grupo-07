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

fun main() {
    val arr1 = intArrayOf(3, 6, 9,104, 275)
    println(counter(arr1, 1, 3, 3))
}



/*
1- CERTO
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

Este é mais complicado. Usa .slice .


2- CERTO
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
Ver explicação do código em:

https://chatgpt.com/share/67d8a107-2150-800f-ad8f-a34b44a94d70

Está no fundo da conversa.
 */