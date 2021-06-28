import java.util.Arrays;

public class kth_number {
  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    int[] temp;

    for(int i = 0; i < commands.length; i++) {
      temp = new int[commands[i][1]-(commands[i][0]-1)];
      for(int j = 0; j < temp.length; j++) {
        temp[j] = array[j+(commands[i][0]-1)];
      }
      Arrays.sort(temp);
      answer[i] = temp[commands[i][2]-1];
    }

    return answer;
  }

}
