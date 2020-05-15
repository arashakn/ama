
fun main(){
val grid = arrayListOf(
    arrayOf('O', 'O', 'O', 'O'), arrayOf('D', 'O','D', 'O'), arrayOf('O','O','O','O') , arrayOf('X','D','D','O'))
    val res = minSteps(grid)
    println(res)
}
var ans = 1000011
fun minSteps(grid : ArrayList<Array<Char>>) : Int {
    dfs(grid, 0,0,0)
    return ans
}

fun dfs (grid : ArrayList<Array<Char>> , col : Int , row : Int , curSteps : Int){
    if(col < 0 || row < 0 || col >= grid.size || row >= grid[0].size || grid[col][row] == 'D' || grid[col][row] == ' '){
        return
    }
    if(grid[col][row] == 'X'){
        ans = Math.min(curSteps, ans)
        return
    }
    val temp = grid[col][row]
    grid[col][row] = ' '
    dfs(grid,col+1, row, curSteps+1)
    dfs(grid,col, row+1, curSteps+1)
    dfs(grid,col-1, row, curSteps+1)
    dfs(grid,col, row-1, curSteps+1)
    grid[col][row] = temp
}




