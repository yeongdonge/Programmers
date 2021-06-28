public class decimal_flip {
  public int solution(int n) {
    int answer = 0;
    StringBuffer a = new StringBuffer();
    while(n != 0) {
      a.append(n%3);
      n /= 3;
    }
    a = a.reverse();
    for(int i = 0; i < a.length(); i++) {
      answer += Character.getNumericValue(a.charAt(i)) * Math.pow(3, i);
    }
    return answer;
  }
}
