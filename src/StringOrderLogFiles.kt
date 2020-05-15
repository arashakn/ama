import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

private fun isLetterLog(log : String) : Boolean{
    return log.split(" ", limit =2)[1][0].isLetter()
}

fun reorderLogFiles(logs: Array<String>): ArrayList<String> {
    val letLogs = ArrayList<String>()
    val digitLogs = ArrayList<String>()

    for (log in logs){
        if(isLetterLog(log)){
            letLogs.add(log)}
        else{
            digitLogs.add(log)
        }
    }

    Collections.sort(letLogs){
        l1 : String , l2 : String ->
        val splitl1 = l1.split(" ", limit = 2)
        val splitl2 = l2.split(" ", limit = 2)
        val result = splitl1[1].compareTo(splitl2[1])
        if(result == 0) splitl1[0].compareTo(splitl2[0]) else  result
    }


    letLogs.addAll(digitLogs)
    return  letLogs
}

