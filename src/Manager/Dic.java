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
			case 5:
				clear();
				break;

			default:
			}
		}
	}


	private void clear() {
		System.out.println("++�ܾ���ü����++");
		word.clearAll();
		System.out.println("�ʱ�ȭ �Ϸ�!");
	}


	private void modify() {
		System.out.println("++�ܾ� �����ϱ�++");
		System.out.println("������ ���ܾ �Է����ּ���.");
		String eng=in.nextLine();
		System.out.println("������ ����ܾ��� ���� �Է����ּ���.");
		String mkor=in.nextLine();
		word.modify(eng, mkor);
		System.out.println("�����Ǿ����ϴ�.");
	}


	private void remove() {
		// TODO Auto-generated method stub
		System.out.println("++�ܾ� �����ϱ�++");
		System.out.println("������ ����ܾ �Է��ϼ���.");
		word.remove(in.nextLine());
		
	}


	private void output() {
		// TODO Auto-generated method stub
		System.out.println("++�ܾ� ����Դϴ�.++");
		word.init();
	}


	private void input() {
		// TODO Auto-generated method stub
		System.out.println("++�ܾ����Դϴ�++");
		System.out.println("����� ��� �Է����ּ���.");
		String eng=in.nextLine();
		System.out.println("������ ���� �Է����ּ���.");
		String kor=in.nextLine();
		word.input(eng, kor);
		System.out.println("�ԷµǾ����ϴ�.");
		System.out.println("-------------------");
	}


	public void menu() {
		System.out.println("1. �ܾ����ϱ�");
		System.out.println("2. �ܾ��");
		System.out.println("3. �ܾ����");
		System.out.println("4. �ܾ����");

	}

}
