package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved.
 * If it is impossible for the state of the board to be solved, return -1.
 *
 * Examples:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 *
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */
public class Leetcode773 {
   private Map<Integer,Integer> resultTree = new HashMap<>();
   private Integer target;

  public int slidingPuzzle(int[][] board) {

    target = boardToString(board);

    int[][] init = {{1,2,3},{4,5,0}};

    int initString = 123450;

    if(initString ==target){
      return 0;
    }

    List<Integer> level = new ArrayList<>();
    level.add(initString);

    resultTree.put(initString,0);

    return bfs(level,0);

  }

  private int bfs(List<Integer> level,int step){

     List<Integer> res =new ArrayList<>();

     for(int s:level){
       List<Integer> temp = oneStep(s,step+1);
       if(temp!=null&& temp.size()>0){
         if(temp.contains(target)){
           return step+1;
         }
         res.addAll(temp);
       }
     }

     if(res.size()>0){
       return bfs(res,step +1);
     }

     return -1;

  }

  private List<Integer> oneStep(int s,int step){
    int[][] board = stringToBoard(s);

    int row = -1;
    int col = -1;

    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        if(board[i][j] == 0){
          row = i;
          col = j;
        }
      }
    }

     List<Integer> result = new ArrayList<>();

     int res;

     //left
     if(col>0){
       int temp = board[row][col-1];
       board[row][col-1] = 0;
       board[row][col] = temp;

       res = boardToString(board);
       if(!resultTree.containsKey(res)){
          resultTree.put(res,step);

          result.add(res);
       }

       board[row][col-1] = temp;
       board[row][col] = 0;
     }

      //right
     if(col<2){
       int temp = board[row][col+1];
       board[row][col+1] = 0;
       board[row][col] = temp;

       res = boardToString(board);
       if(!resultTree.containsKey(res)){
          resultTree.put(res,step);

          result.add(res);
       }

       board[row][col+1] = temp;
       board[row][col] = 0;
     }
      //top
     if(row == 1){
       int temp = board[row -1][col];
       board[row -1][col] = 0;
       board[row][col] = temp;

       res = boardToString(board);
       if(!resultTree.containsKey(res)){
          resultTree.put(res,step);

          result.add(res);
       }

       board[row -1][col] = temp;
       board[row][col] = 0;
     }

      //bottom
     if(row == 0){
       int temp = board[1][col];
       board[1][col] = 0;
       board[0][col] = temp;

       res = boardToString(board);
       if(!resultTree.containsKey(res)){
          resultTree.put(res,step);

          result.add(res);
       }

       board[1][col] = temp;
       board[0][col] = 0;
     }

     return result;
  }

  private int boardToString(int[][] board){
    int res=0;
    for(int i=0;i<2;i++){
      for(int j=0;j<3;j++){
        res = res * 10 + board[i][j];
      }
    }

    return res;
  }

  private int[][] stringToBoard(int s){
    int[][] board = new int[2][3];

    for(int i=1;i>=0;i--){
      for(int j=2;j>=0;j--){
        board[i][j] = s%10;
        s/=10;
      }
    }

    return board;
  }
}
