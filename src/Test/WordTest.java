package Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import DAO.DAOword;
import DTO.wordDTO;

public class WordTest {

	private DAOword w = null;

	@Before
	public void a() {
		w = DAOword.getinstance();
	}

	@Test
	public void input() { // 단어등록하기
		w.inputWord("apple","사과");
		w.inputWord("cuteOne", "도윤");
	}

	@Test
	public void remove() { // Key를 입력해 단어삭제하기
		// apple을 삭제하세요
		w.deleteOne("apple");

	}

	@Test
	public void searchLv1() { // 단어 전체 같은거 가져오기.
		// 포함된 단어는 찾을 수 없다
		HashMap<String, String> wList = new HashMap<String, String>();
		wList = w.searchOne("love");
		Set<String> keys = wList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = wList.get(key);
			System.out.println("(" + key + "," + value + ")");
		}

	}

	@Test
	public void searchLv2() { // 입력하는 글자가 포함된 단어 가져오기.
		// 포함된 단어도 찾을 수 있다.
		HashMap<String, String> wList = new HashMap<String, String>();
		wList = w.selectInc("a");
		Set<String> keys = wList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = wList.get(key);
			System.out.println("(" + key + "," + value + ")");
		}
	}

	@Test
	public void selectAll() { // 전체보기
		HashMap<String, String> wList = new HashMap<String, String>();
		wList = w.selectAll();
		Set<String> keys = wList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = wList.get(key);
			System.out.println("(" + key + "," + value + ")");
		}

	}

	@Test
	public void clear() { // 전체삭제
		HashMap<String, String> wList = new HashMap<String, String>();
		w.clearAll();
		wList = w.selectAll();

	}

	@Test
	public void modify() { // 단어수정하기.
		w.updateKor("김도윤", "love");
		HashMap<String, String> wList = new HashMap<String, String>();
		wList = w.selectAll();
		Set<String> keys = wList.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = wList.get(key);
			System.out.println("(" + key + "," + value + ")");
		}
	}
}
