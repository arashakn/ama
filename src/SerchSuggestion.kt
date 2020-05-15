import java.util.*


fun main(){
    val sw = arrayOf("mobile","mouse","moneypot","monitor","mousepad")
    val kw = "mouse"
    val result = suggestedProducts(sw,kw)
}


fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {

    val ans = ArrayList<ArrayList<String>>()
    val pq = PriorityQueue<String>(3){
        s1 : String , s2 : String -> s1.compareTo(s2)
    }

    for (i in  1..searchWord.length){
        val curSuggestion = ArrayList<String>()
        val sub = searchWord.substring(0,i)
        if(sub.length>0) {

            for (pName in products) {
                if (pName.startsWith(sub)) {
                    pq.offer(pName)
                }
            }

            for (j in 0..2) {
                if (pq.peek() != null) {
                    curSuggestion.add(pq.poll())
                }
            }

            ans.add(curSuggestion)
            println("$sub -> ")
            curSuggestion.forEach {
                println(it)
            }
            println("------------------")
            pq.clear()
        }
    }

    return ans
}


