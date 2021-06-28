public class triangle_snail {
  public int[] solution(int n) {
    int length = 0;
    for(int i = 1; i <= n; i++) length += i; // 총 배열의 길이
    int[] answer = new int[length];

    // 아래 -> 옆 -> 위 반복 (n, n-1, n-2 ... 1), 1씩 증가
    // 아래 -> x + bias, 옆 -> +1 -> 위 -> x - bias
    char mission = 'd'; // down, side, up
    int value = 1;
    int pointer = 0; // 어디에 찍을것인지
    int bias = 0; // 얼마의 값을 보정해야 하는지
    int deadline = n; // 언제까지 값을 찍어야 하는지

    while(n > 0) {
      if(mission =='d') {
        pointer = pointer + bias; // 인덱스 보정
        answer[pointer] = value;
        value++;
        bias++;
        deadline--; // 아래 모두 수행했을 경우 = n-n
        if(deadline == 0) {
          mission = 's';
          deadline = --n; // 사이드는 n-1만큼 이동하므로
        }
      } else if(mission =='s') {
        pointer++;
        answer[pointer] = value;
        value++;
        deadline--;
        if(deadline == 0) {
          mission = 'u';
          deadline = --n; // 위로는 n-2만큼 이동하므로
        }
      } else {
        pointer = pointer - bias;
        answer[pointer] = value;
        value++;
        bias--;
        deadline--;
        if(deadline == 0) {
          mission = 'd';
          deadline = --n;
        }
      }
    }
    return answer;
  }
}
