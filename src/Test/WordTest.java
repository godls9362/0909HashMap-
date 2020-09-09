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
	public void input() { // �ܾ����ϱ�
		w.inputWord("apple","���");
		w.inputWord("cuteOne", "����");
	}

	@Test
	public void remove() { // Key�� �Է��� �ܾ�����ϱ�
		// apple�� �����ϼ���
		w.deleteOne("apple");

	}

	@Test
	public void searchLv1() { // �ܾ� ��ü ������ ��������.
		// ���Ե� �ܾ�� ã�� �� ����
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
	public void searchLv2() { // �Է��ϴ� ���ڰ� ���Ե� �ܾ� ��������.
		// ���Ե� �ܾ ã�� �� �ִ�.
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
	public void selectAll() { // ��ü����
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
	public void clear() { // ��ü����
		HashMap<String, String> wList = new HashMap<String, String>();
		w.clearAll();
		wList = w.selectAll();

	}

	@Test
	public void modify() { // �ܾ�����ϱ�.
		w.updateKor("�赵��", "love");
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
