public class number_of_P_and_Y {
  boolean solution(String s) {
    boolean answer = true;
    int countOfp = 0;
    int countOfy = 0;
    s = s.toLowerCase();
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == 'p') countOfp++;
      else if(s.charAt(i) == 'y') countOfy++;
    }
    if(countOfp == countOfy) answer = true;
    else answer = false;
    return answer;
  }
}
