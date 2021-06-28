import java.util.Stack;

public class claw_machine_game {
  public static int solution(int[][] board, int[] moves) {
    int answer = 0;
    int bias = -1;
    Stack<Integer> basket = new Stack<Integer>();
    basket.push(bias);

    for(int i = 0; i < moves.length; i++) {
      for(int j = 0; j < board.length; j++) {
        if(board[j][moves[i]-1] != 0) {
          if(basket.peek() == board[j][moves[i]-1]) {
            basket.pop();
            answer += 2;
          } else {
            basket.push(board[j][moves[i]-1]);
          } board[j][moves[i]-1] = 0;
          break;
        }
      }
    }
    return answer;
  }
}
