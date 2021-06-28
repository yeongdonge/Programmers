public class secret_map {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for(int i = 0; i < answer.length; i++) answer[i] = "";

    for(int i = 0; i < n; i++) {
      String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
      if(Integer.toBinaryString(arr1[i] | arr2[i]).length() == 6) {
        answer[i] = temp;
      } else {
        temp = String.format("%0"+n+"d", Long.parseLong(temp));
        answer[i] = temp;
      }
      answer[i] = answer[i].replaceAll("1", "#");
      answer[i] = answer[i].replaceAll("0", " ");
    }
    return answer;
  }
}
