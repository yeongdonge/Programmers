public class keypad {
  class hands {
    private char hand;
    private int index;

    public hands(char hand) {
      if(hand == 'L') {
        this.hand = hand;
        this.index = 10;
      } else {
        this.hand= hand;
        this.index = 12;
      }
    }

    public void set(char hand, int index) {
      this.hand = hand;
      this.index = index;
    }

    public int getI() {
      return this.index;
    }
  }
  private hands left = new hands('L');
  private hands right = new hands('R');

  public String solution(int[] numbers, String hand) {
    String answer = "";


    // L,R 구분 (1)
    for (int i = 0; i < numbers.length; i++) {
      switch (numbers[i]) {
        case 1:
        case 4:
        case 7:
          answer += "L";
          left.set('L', numbers[i]);
          break;
        case 3:
        case 6:
        case 9:
          answer += "R";
          right.set('R', numbers[i]);
          break;
        default:
          if (getDistance(numbers[i], left.getI()) > getDistance(numbers[i], right.getI())) {
            answer += "R";
            right.set('R',numbers[i]);
          } else if (getDistance(numbers[i], left.getI()) < getDistance(numbers[i], right.getI())) {
            answer += "L";
            left.set('L',numbers[i]);
          } else {
            if (hand.equals("right")) {
              answer += "R";
              right.set('R',numbers[i]);
            } else {
              answer += "L";
              left.set('L',numbers[i]);
            }
          }
      }
    }
    return answer;
  }

  // 거리 계산
  public int getDistance(int index, int curIndex) {
    if(index == 2) {
      switch (curIndex) {
        case 1: case 3: case 5:
          return 1;
        case 4: case 6: case 8:
          return 2;
        case 7: case 9: case 0:
          return 3;
        case 10: case 12:
          return 4;
        default:
          return 0;
      }
    }
    if(index == 5) {
      switch (curIndex) {
        case 2: case 4: case 6: case 8:
          return 1;
        case 1: case 3: case 7: case 9: case 0:
          return 2;
        case 10: case 12:
          return 3;
        default:
          return 0;
      }
    }
    if(index == 8) {
      switch (curIndex) {
        case 5: case 7: case 9: case 0:
          return 1;
        case 2: case 4: case 6: case 10: case 12:
          return 2;
        case 1: case 3:
          return 3;
        default:
          return 0;
      }
    }
    if(index == 0) {
      switch (curIndex) {
        case 8: case 10: case 12:
          return 1;
        case 5: case 7: case 9:
          return 2;
        case 2: case 4: case 6:
          return 3;
        case 1: case 3:
          return 4;
        default:
          return 0;
      }
    }
    return 99;
  }
}
