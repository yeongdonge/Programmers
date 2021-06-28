import java.util.TreeSet;

public class pick_two_add {
  public TreeSet<Integer> solution(int[] numbers) {
    TreeSet<Integer> answer = new TreeSet<>();

    for(int i = 0; i < numbers.length; i++) {
      for(int j = numbers.length-1; j >= 0; j--) {
        if(i == j) continue;
        answer.add(numbers[i] + numbers[j]);
      }
    }
    return answer;
  }
}
