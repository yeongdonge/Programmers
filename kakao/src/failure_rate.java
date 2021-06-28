import java.util.ArrayList;
import java.util.Comparator;

public class failure_rate {
  private int level;
  private double failureRate;

  public failure_rate(int level, double failureRate) {
    this.level = level;
    this.failureRate = failureRate;
  }
  public void setFailureRate(double failureRate) {
    this.failureRate = failureRate;
  }
  public double getFailureRate() {
    return this.failureRate;
  }
  public int getLevel() {
    return this.level;
  }
}
class Solution implements Comparator<failure_rate> {
  public int[] solution(int N, int[] failure_rates) {
    int[] answer = new int[N];

    ArrayList<failure_rate> game = new ArrayList<>();
    for(int i = 0; i < N; i++) {
      double cleared = 0;
      double failed = 0;
      game.add(i, new failure_rate(i+1, 0));
      for(int j = 0; j < failure_rates.length; j++) {

        if(game.get(i).getLevel() == failure_rates[j]) {
          failed++;
        } else if(game.get(i).getLevel() < failure_rates[j]) {
          cleared++;
        }
      }
      try {
        game.get(i).setFailureRate(failed / (cleared + failed));
      } catch(ArithmeticException e) {
        game.get(i).setFailureRate(0);
      }
    }
    game.sort(this::compare);
    for(int i = 0; i < answer.length; i++) {
      answer[i] = game.get(i).getLevel();
    }
    return answer;
  }
  @Override
  public int compare(failure_rate a, failure_rate b) {
    if(a.getFailureRate() < b.getFailureRate()) return 1;
    if(a.getFailureRate() > b.getFailureRate()) return -1;
    return 0;
  }
}
