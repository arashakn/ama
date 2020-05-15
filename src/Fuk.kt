//
//import java.util.ArrayList
//import java.util.Arrays
//import java.util.HashSet
//import java.util.HashMap
//
//var time = 0
//
//fun main(args: Array<String>) {
//    val numRouters1 = 7
//    val numLinks1 = 7
//    val links1 = arrayOf(
//        intArrayOf(0, 1),
//        intArrayOf(0, 2),
//        intArrayOf(1, 3),
//        intArrayOf(2, 3),
//        intArrayOf(2, 5),
//        intArrayOf(5, 6),
//        intArrayOf(3, 4)
//    )
//    println(getCriticalNodes(links1, numLinks1, numRouters1))
//}
//
//private fun getCriticalNodes(links: Array<IntArray>, numLinks: Int, numRouters: Int): List<Int> {
//    time = 0
//    val map = HashMap<Int, Set<Int>>()
//    for (i in 0 until numRouters) {
//        map[i] = HashSet()
//    }
//    for (link in links) {
//        map[link[0]].add(link[1])
//        map[link[1]].add(link[0])
//    }
//    val set = HashSet<Int>()
//    val low = IntArray(numRouters)
//    val ids = IntArray(numRouters)
//    val parent = IntArray(numRouters)
//    Arrays.fill(ids, -1)
//    Arrays.fill(parent, -1)
//    for (i in 0 until numRouters) {
//        if (ids[i] == -1)
//            dfs(map, low, ids, parent, i, set)
//    }
//    return ArrayList(set)
//}
//
//
//private fun dfs(
//    map: Map<Int, Set<Int>>,
//    low: IntArray,
//    ids: IntArray,
//    parent: IntArray,
//    cur: Int,
//    res: MutableSet<Int>
//) {
//    var children = 0
//    low[cur] = ++time
//    ids[cur] = low[cur]
//    for (nei in map[cur]) {
//        if (ids[nei] == -1) {
//            children++
//            parent[nei] = cur
//            dfs(map, low, ids, parent, nei, res)
//            low[cur] = Math.min(low[cur], low[nei])
//            if (parent[cur] == -1 && children > 1 || parent[cur] != -1 && low[nei] >= ids[cur])
//                res.add(cur)
//        } else if (nei != parent[cur])
//            low[cur] = Math.min(low[cur], ids[nei])
//    }
//}