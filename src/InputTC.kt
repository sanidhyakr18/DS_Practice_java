fun main() {
    val arr = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(8, 5), intArrayOf(9, 7), intArrayOf(5, 6), intArrayOf(5, 4), intArrayOf(4, 6), intArrayOf(6, 7))

    val n = 10
    println(n)

    println(arr.size)

    for (ints in arr) {
        println(ints[0].toString() + " " + ints[1])
    }
}