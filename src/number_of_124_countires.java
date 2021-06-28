public class number_of_124_countires {
  public String solution(int n) {
    String answer = "";
    int temp = n;
    int div = 0;
    while(temp > 0) {
      div = temp % 3;
      temp /= 3;

      if(div == 0) temp--;

      switch(div) {
        case 0:
          answer = 4 + answer;
          break;
        case 1:
          answer = 1 + answer;
          break;
        case 2:
          answer = 2 + answer;
          break;
      }
    }
    return answer;
  }
}
