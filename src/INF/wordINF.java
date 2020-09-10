package INF;

import java.util.HashMap;

public interface wordINF {
	public void input(String eng,String kor); //단어 입력하기 
	public HashMap<String, String> output(); //단어보기
	public void remove(String eng); //단어 삭제하기
	public void modify(String mkor,String eng); //단어 수정하기
	public void clear();
}
