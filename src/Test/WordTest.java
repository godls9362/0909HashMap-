package Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import DAO.DAOword;
import INF.wordINFImp;
import ex01.wordManager;

public class WordTest {

	private wordManager m = null;
	private wordINFImp p=new wordINFImp();
	private DAOword w=DAOword.getinstance();

	@Before
	public void a() {
		m = new wordManager();
	}

	@Test
	public void input() { // 해쉬에 저장하기
		m.input("melon", "메론");
		m.input("cup", "컵");
		m.input("song", "노래");
		m.input("love", "사랑");
		m.input("cute", "귀여운");
		
	}


	@Test
	public void remove() {
		m.remove("melon");
	}

	@Test
	public void searchLv1() { // 단어 전체 같은거 가져오기.
		// 포함된 단어는 찾을 수 없다

		String k=m.searchOne("brasil");
		System.out.println(k);
	}

	@Test
	public void searchLv2() { // 입력하는 글자가 포함된 단어 가져오기.
		// 포함된 단어도 찾을 수 있다.
		HashMap<String, String> wList = new HashMap<String, String>();
		wList = m.searchTwo("o");
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
		HashMap<String, String> wList = p.output();
		System.out.println(wList);
	}

	@Test
	public void clear() { // 전체삭제
		m.clearAll();
	}

	@Test
	public void modify() { // 단어수정하기.
		p.modify("김도윤", "cute");
	}
}
