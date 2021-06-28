public class recommend_new_id {
  public String solution(String new_id) {
    String answer = "";
    new_id = new_id.toLowerCase();
    new_id = new_id.replaceAll("[^-_.a-z0-9]",""); // 문자가 "-", "_", ".", "소문자 알파뱃", "숫자가 아닐 경우"
    new_id = new_id.replaceAll("[.]{2,}","."); // 문자가 "."으로 2번 이상 반복할 경우
    new_id = new_id.replaceAll("^[.]|[.]$", ""); // 문자열의 처음이 "." 혹은 마지막이 "."일 경우

    if(new_id.length() == 0) new_id = "a";  // 문자열의 길이가 0일 경우
    if(new_id.length() >= 16) {     // 문자열의 길이가 16 이상일 경우
      new_id = new_id.substring(0,15);
      new_id = new_id.replaceAll("^[.]|[.]$",""); // 문자열의 처음이 "." 혹은 마지막이 "."일 경우
    }
    // 문자열의 길이가 2이하일 경우
    while(new_id.length() < 3) new_id += new_id.charAt(new_id.length()-1);
    answer = new_id;
    return answer;
  }

}
