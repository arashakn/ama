fun orangesRotting(grid: Array<IntArray>): Int {

    val fresh = HashSet<Pair<Int, Int>>()
    val rot = HashSet<Pair<Int, Int>>()
    for (col in 0 until grid.size) {
        for (row in 0 until grid[col].size) {
            if (grid[col][row] == 1) {
                fresh.add(Pair(col, row))
            } else if (grid[col][row] == 2){
                rot.add(Pair(col, row))

            }
        }
    }
    val dir = arrayOf(intArrayOf(0,1) ,intArrayOf(0,-1),intArrayOf(1,0),intArrayOf(-1,0))
    var time = 0
    while (fresh.size > 0){
        val curRot = HashSet<Pair<Int, Int>>()
        for (r in rot){
            for (d in dir){
                val newCell = Pair<Int,Int>(r.first+d[0],r.second+d[1])
                if(fresh.contains(newCell)){
                    fresh.remove(newCell)
                    curRot.add(newCell)
                }
            }
        }
        if(curRot.size > 0){
            time++
            rot.addAll(curRot)
        }else {
            return -1
        }
    }
    return time
}