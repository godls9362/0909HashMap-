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
			System.out.println("���� >>");
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
		System.out.println("1. �ܾ����ϱ�");
		System.out.println("2. �ܾ��");
		System.out.println("3. �ܾ����");
		System.out.println("4. �ܾ����");

	}

}
