package Manager;

import java.util.Scanner;

import INF.wordINFImp;
import ex01.wordManager;


public class Dic {
	private Scanner in = new Scanner(System.in);
	private wordManager word=new wordManager();
	

	public	Dic() {
		int selNum = -1;
		while (true) {
			menu();
			System.out.println("선택 >>");
			selNum = in.nextInt();
			in.nextLine();

			switch (selNum) {
			case 1:
				input();
				break;
			case 2:
				output();
				break;
			case 3:
				remove();
				break;
			case 4:
				modify();
				break;
			case 5:
				clear();
				break;

			default:
			}
		}
	}


	private void clear() {
		System.out.println("++단어전체삭제++");
		word.clearAll();
		System.out.println("초기화 완료!");
	}


	private void modify() {
		System.out.println("++단어 수정하기++");
		System.out.println("수정할 영단어를 입력해주세요.");
		String eng=in.nextLine();
		System.out.println("수정된 영어단어의 뜻을 입력해주세요.");
		String mkor=in.nextLine();
		word.modify(eng, mkor);
		System.out.println("수정되었습니다.");
	}


	private void remove() {
		// TODO Auto-generated method stub
		System.out.println("++단어 삭제하기++");
		System.out.println("삭제할 영어단어를 입력하세요.");
		word.remove(in.nextLine());
		
	}


	private void output() {
		// TODO Auto-generated method stub
		System.out.println("++단어 목록입니다.++");
		word.init();
	}


	private void input() {
		// TODO Auto-generated method stub
		System.out.println("++단어등록입니다++");
		System.out.println("등록할 영어를 입력해주세요.");
		String eng=in.nextLine();
		System.out.println("영어의 뜻을 입력해주세요.");
		String kor=in.nextLine();
		word.input(eng, kor);
		System.out.println("입력되었습니다.");
		System.out.println("-------------------");
	}


	public void menu() {
		System.out.println("1. 단어등록하기");
		System.out.println("2. 단어보기");
		System.out.println("3. 단어삭제");
		System.out.println("4. 단어수정");

	}

}
