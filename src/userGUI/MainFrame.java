package userGUI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class MainFrame extends Frame{  // Frame �����̳�/ ���̾ƿ� (border layout, flow Layout)
	
	Label title = new Label("���� ù��° java GUI interface");  // ������Ʈ
	Label east = new Label("east");// ������Ʈ
	Label center = new Label("Center");// ������Ʈ
	
	Button west = new Button("��ư1");// ������Ʈ
	Button west1 = new Button("��ư2");// ������Ʈ
	Button west2 = new Button("��ư3");// ������Ʈ
	
	Panel west_panel= new Panel();   // ������Ʈ �̸鼭 �����̳�
	Panel center_panel = new Panel();  // frame center ������ �Է��� �г�
	Panel center_north_panel = new Panel(); // center_panel�� north�� ��ġ�� �г�
	Panel center_south_panel = new Panel(); // center_panel�� south�� ��ġ�� �г�
	
	Label engLabel= new Label("����ܾ�");
	Label korLabel = new Label("�ѱۼ���");
	
	JTextField engTestF = new JTextField(10);
	JTextField korTestF = new JTextField(10);
	
	JTextField south = new JTextField();// ������Ʈ
	
	
	MainFrame(){
		
		center_north_panel.add(engLabel);
		center_north_panel.add(engTestF);
		
		center_south_panel.add(korLabel);
		center_south_panel.add(korTestF);
		
		center_panel.setLayout(new BorderLayout());
		center_panel.add(center_north_panel,"North");
		center_panel.add(center_south_panel,"Center");
		
		west_panel.setBackground(Color.darkGray);
//		west_panel.add(west);
//		west_panel.add(west1);
//		west_panel.add(west2);
		
		//west_panel�� borderlayout���� �����ϴ� ����
//		west_panel.setLayout(new BorderLayout());
//		west_panel.add(west,"North");
//		west_panel.add(west1,"Center");
//		west_panel.add(west2,"South");
		
		//west_panel�� boxLayout���� �����ϴ� ����
		west_panel.setLayout(new BoxLayout(west_panel, BoxLayout.Y_AXIS));
		west_panel.add(west);
		west_panel.add(west1);
		west_panel.add(west2);	
		
		this.setLayout(new BorderLayout());  // �� �����̳ʴ� �⺻ ���̾ƿ��� ������ �ִ�.
		                                     // Frame�� �⺻ ���̾ƿ��� borderLayout�̴�.
		this.add(title,"North");
		this.add(west_panel,"West");
		this.add(east,"East");
		this.add(center_panel,"Center");
		this.add(south,"South");
		
		this.setBounds(1500, 650, 500, 300);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
}