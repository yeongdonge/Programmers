import java.util.ArrayList;
import java.util.HashMap;

public class open_chat_room {

  String uId;
  String text;

  public open_chat_room() {
  }

  public open_chat_room(String uId, String text) {
    this.uId = uId;
    this.text = text;
  }

  public String toString() {
    return String.format("%s, %s\n", uId, text);
  }
}

class Solution {
  public String[] solution(String[] record) {
    String[] answer = {};
    ArrayList<open_chat_room> db = new ArrayList<>();
    HashMap<String, String> member = new HashMap<>();

    for(int i = 0; i < record.length; i++) {
      open_chat_room temp;
      String[] split = record[i].split(" ");
      String text = split[0];
      String uId = split[1];
      if(split.length == 3) {
        String nickname = split[2];
        member.put(uId, nickname);
        if(text.equals("Change")) continue;
      }
      temp = new open_chat_room(uId, text);
      db.add(temp);
    }

    answer = new String[db.size()];
    for(int i = 0; i < db.size(); i++) {
      String text = db.get(i).text;
      switch(text) {
        case "Enter":
          answer[i] = String.format("%s님이 들어왔습니다.", member.get(db.get(i).uId));
          break;
        case "Leave":
          answer[i] = String.format("%s님이 나갔습니다.", member.get(db.get(i).uId));
          break;
      }
    }
    return answer;
  }
}
