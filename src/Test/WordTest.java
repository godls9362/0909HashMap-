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
	public void input() { // �ؽ��� �����ϱ�
		m.input("melon", "�޷�");
		m.input("cup", "��");
		m.input("song", "�뷡");
		m.input("love", "���");
		m.input("cute", "�Ϳ���");
		
	}


	@Test
	public void remove() {
		m.remove("melon");
	}

	@Test
	public void searchLv1() { // �ܾ� ��ü ������ ��������.
		// ���Ե� �ܾ�� ã�� �� ����

		String k=m.searchOne("brasil");
		System.out.println(k);
	}

	@Test
	public void searchLv2() { // �Է��ϴ� ���ڰ� ���Ե� �ܾ� ��������.
		// ���Ե� �ܾ ã�� �� �ִ�.
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
	public void selectAll() { // ��ü����
		HashMap<String, String> wList = p.output();
		System.out.println(wList);
	}

	@Test
	public void clear() { // ��ü����
		m.clearAll();
	}

	@Test
	public void modify() { // �ܾ�����ϱ�.
		p.modify("�赵��", "cute");
	}
}
