import java.util.*

fun main(){
    val ropes = intArrayOf(1, 2, 5, 10, 35, 89)
    val r = steps(ropes)
    println(r)
}

fun steps( ropes : IntArray) : Int{
    if(ropes.size == 1){
        return ropes[0]
    }
    val pq = PriorityQueue<Int>()
    for (i in ropes){
        pq.add(i)
    }
    var steps  = 0
    while(pq.size>1){
        val r1 = pq.poll()
        val r2 = pq.poll()
        steps += r1+r2
        pq.add(r1+r2)
    }
    return steps
}