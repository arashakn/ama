import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main () {

    val keywords = arrayListOf("anacell", "betacellular", "cetracular", "deltacellular", "eurocell","anacel")
    val reviews = arrayListOf(
        "I love anacell Best services; Best services provided by anacell.",
        "betacellular has great services.",
        "deltacellular provides much better services than betacellular.",
        "cetracular is worse than anacell.",
        "Betacellular is better than deltacellular."
        )
    println(topK(keywords , reviews,2))
}

fun topK(keywords : ArrayList<String> , reviews : ArrayList<String> , K : Int) : ArrayList<String> {

    val map = HashMap<String, Int>()
    val keywordsSet = HashSet(keywords)
    for (s in reviews) {
//        var result = s.trim().split(" ")
        var result = s.trim().split("\\W".toRegex())//whatever is not alphanumeric
        val set = HashSet<String>()
        for (r in result) {
//            val m = r.replace("[^a-zA-Z]".toRegex(), "").toLowerCase()
            if(r.length>0) {
                set.add(r)
            }
        }
        for (s in set) {
            if (keywordsSet.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1)
            }
        }
    }
    for ((k,v) in map){
        println("$k -> $v")
    }
    println("-----")

    val pq = PriorityQueue<String>(K) { s1: String, s2: String ->
        if(map.get(s1)!! - map.get(s2)!! == 0) s2.compareTo(s1)
        else map.get(s1)!! - map.get(s2)!!
    }

    for (s in map.keys) {
        pq.add(s)
        if (pq.size > K) {
            pq.poll()
        }
    }
    return ArrayList(pq)
}


//For loops: O(R * W) -> where R is number of reviews and W is the maximum length review
//Queue: O(NlogK) -> where N is number of keywords
//If you maintain a minheap of size K, the time complexity will be O(NlogK), not O(KLogK)




