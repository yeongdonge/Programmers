public class dart_game {
  public int solution(String dartResult) {
    int answer = 0;
    int[] point = new int[3];
    int count = -1;

    for(int i = 0; i < dartResult.length(); i++) {
      char option = dartResult.charAt(i);
      int score = Character.getNumericValue(option);
      if(score >= 0 && score <= 9) {
        if(score == 1 && Character.getNumericValue(dartResult.charAt(i+1))== 0) {
          i++;
          count++;
          point[count] = 10;
        } else {
          count++;
          point[count] = score;
        }

      } else if(option == 'D') {
        point[count] *= point[count];
      } else if(option == 'T') {
        point[count] *= point[count] * point[count];
      } else if(option == '*') {
        if(count > 0) {
          point[count-1] *= 2;
        }
        point[count] *= 2;
      } else if(option == '#') {
        point[count] *= -1;
      }
    }
    answer = point[0] + point[1] + point[2];
    return answer;
  }
}
