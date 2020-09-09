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
		System.out.println("단어입력을 시작합니다.");
		System.out.println("-------------------");
		System.out.println("영어단어를 입력해주세요.");
		String key=in.nextLine();
		System.out.println("뜻을 입력해주세요.");
		System.out.println("-------------------");
		String value=in.nextLine();
		wordDao.inputWord(key, value);
		System.out.println("입력되었습니다.");
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
			System.out.println("(영어단어 :"+key+"/ 뜻:"+value+")");
		}
	}

	@Override
	public void remove() {
		System.out.println("삭제하실 영어단어를 입력하세요.");
		wordDao.deleteOne(in.nextLine());
		System.out.println("삭제되었습니다.");
	}

	@Override
	public void modify() {
		System.out.println("수정하실 영어단어 뜻을 입력해주세요.");
		String k=in.nextLine();
		System.out.println("영단어를 입력해주세요");
		String m=in.nextLine();
		wordDao.updateKor(k, m);
		System.out.println("수정되었습니다.");
	}
	
}
