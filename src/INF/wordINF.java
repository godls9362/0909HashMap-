package INF;

import java.util.HashMap;

public interface wordINF {
	public void input(String eng,String kor); //�ܾ� �Է��ϱ� 
	public HashMap<String, String> output(); //�ܾ��
	public void remove(String eng); //�ܾ� �����ϱ�
	public void modify(String mkor,String eng); //�ܾ� �����ϱ�
	public void clear();
}
