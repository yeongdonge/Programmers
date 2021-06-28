import java.util.ArrayList;
import java.util.Collections;

public class array_of_divided_numbers {
  public int[] solution(int[] arr, int divisor) {
    int[] answer = {};
    ArrayList<Integer> temp = new ArrayList<>();
    int count = 0;
    for(int i = 0; i < arr.length; i++) {
      if (arr[i] % divisor == 0) {
        temp.add(count, arr[i]);
        count++;
      }
    }
    Collections.sort(temp);
    answer = new int[count];
    if(answer.length == 0) {
      answer = new int[1];
      answer[0] = -1;
    }
    else for(int i = 0; i < answer.length; i++) answer[i] = temp.get(i);

    return answer;
  }
}
