package INF;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import DAO.DAOword;

public class wordINFImp implements wordINF {
	private DAOword wordDao=DAOword.getinstance();
	private Scanner in=new Scanner(System.in);
	@Override
	public void input() {
		System.out.println("�ܾ��Է��� �����մϴ�.");
		System.out.println("-------------------");
		System.out.println("����ܾ �Է����ּ���.");
		String key=in.nextLine();
		System.out.println("���� �Է����ּ���.");
		System.out.println("-------------------");
		String value=in.nextLine();
		wordDao.inputWord(key, value);
		System.out.println("�ԷµǾ����ϴ�.");
		System.out.println("-------------------");
		
	}

	@Override
	public void output() {
		HashMap<String, String> wList = new HashMap<String, String>();
		wList=wordDao.selectAll();
		Set<String> keys=wList.keySet();
		Iterator<String> it=keys.iterator();
		while(it.hasNext()) {
			String key=it.next();
			String value=wList.get(key);
			System.out.println("(����ܾ� :"+key+"/ ��:"+value+")");
		}
	}

	@Override
	public void remove() {
		System.out.println("�����Ͻ� ����ܾ �Է��ϼ���.");
		wordDao.deleteOne(in.nextLine());
		System.out.println("�����Ǿ����ϴ�.");
	}

	@Override
	public void modify() {
		System.out.println("�����Ͻ� ����ܾ� ���� �Է����ּ���.");
		String k=in.nextLine();
		System.out.println("���ܾ �Է����ּ���");
		String m=in.nextLine();
		wordDao.updateKor(k, m);
		System.out.println("�����Ǿ����ϴ�.");
	}
	
}
