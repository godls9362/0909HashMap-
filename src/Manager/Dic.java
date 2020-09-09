package Manager;

import java.util.Scanner;

import INF.wordINFImp;


public class Dic {
	private Scanner in = new Scanner(System.in);
	private wordINFImp word = new wordINFImp();

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

			default:
			}
		}
	}


	private void modify() {
		// TODO Auto-generated method stub
		word.modify();
	}


	private void remove() {
		// TODO Auto-generated method stub
		word.remove();
	}


	private void output() {
		// TODO Auto-generated method stub
		word.output();
	}


	private void input() {
		// TODO Auto-generated method stub
		word.input();
	}


	public void menu() {
		System.out.println("1. 단어등록하기");
		System.out.println("2. 단어보기");
		System.out.println("3. 단어삭제");
		System.out.println("4. 단어수정");

	}

}
