package hackerrank

/**
 * Ice Cream Parlor (https://www.hackerrank.com/challenges/icecream-parlor/problem)
 */
fun icecreamParlor(m: Int, arr: Array<Int>): Array<Int> {
    val costMap = mutableMapOf<Int, Int>()

    for ((i, v) in arr.withIndex()) {
        val diff = m - v
        if (costMap.containsKey(diff)) {
            return arrayOf(costMap[diff]!!, i + 1)
        } else {
            costMap[v] = i + 1
        }
    }
    return emptyArray()
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val m = readLine()!!.trim().toInt()

        val n = readLine()!!.trim().toInt()

        val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = icecreamParlor(m, arr)

        println(result.joinToString(" "))
    }
}
