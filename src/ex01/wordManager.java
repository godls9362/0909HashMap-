package ex01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import DAO.DAOword;
import DTO.wordDTO;

public class wordManager {
	private HashMap<String, String> list = new HashMap<String, String>();
	private DAOword wordDAO = DAOword.getinstance();

	public wordManager() {
		init();
	}

	public void init() {
		list = wordDAO.selectAll();
	}

	public void input(String eng, String kor) { //값을 입력하는 부분
		if (list.put(eng,kor)!=null) {
			wordDAO.updateKor(kor, eng);
		} else {
			wordDAO.inputWord(eng, kor);
		}
	}

	public String searchOne(String engW) {
		wordDAO.searchOne(engW);
		return list.get(engW);
	}

	public void remove(String engW) {
		list.remove(engW);
		wordDAO.deleteOne(engW);
	}

	public void clearAll() {
		wordDAO.clearAll();
		list.clear();
	}

	public HashMap<String, String> searchTwo(String some) {
		HashMap<String, String> tempList = new HashMap<String, String>();
		HashMap<String, String> List = wordDAO.selectAll();
		Set<String> keys = List.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (key.indexOf(some) != -1) {
				tempList.put(key, List.get(key));
			}
		}
		return tempList;
	}

}
