public class middle_letter {
  public String solution(String s) {
    String answer = "";
    if(s.length()%2 == 0) // 짝수
      answer = s.substring(s.length()/2-1, s.length()/2+1);
    else answer = String.format("%s",s.charAt(s.length()/2));
    return answer;
  }
}
