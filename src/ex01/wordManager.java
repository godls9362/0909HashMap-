package ex01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import INF.wordINFImp;

public class wordManager {
	HashMap<String, String> list = null; //���θ���� �� ���θ�������� ������ ���� ����Ʈ�� �ƴ�
	private wordINFImp imp = new wordINFImp();

	public wordManager() {
		init();

	}

	public void init() {
		list = imp.output();
	}

	public void input(String eng, String kor) { // ���� �Է��ϴ� �κ�
	
		imp.input(eng, kor);

	}

	public String searchOne(String engW) {
		return list.get(engW);
	}

	public void remove(String engW) {
		list.remove(engW);
		imp.remove(engW);

	}

	public void clearAll() {


		imp.clear();
	}

	public HashMap<String, String> searchTwo(String some) {
		HashMap<String, String> tempList = new HashMap<String, String>();
		Set<String> keys = list.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (key.indexOf(some) != -1) {
				tempList.put(key, list.get(key));
			}
		}
		return tempList;
	}
	public void modify(String mkor, String eng) {
		imp.modify(mkor, eng);
	}
}
