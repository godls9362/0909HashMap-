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

public class MainFrame extends Frame{  // Frame 컨테이너/ 레이아웃 (border layout, flow Layout)
	
	Label title = new Label("나의 첫번째 java GUI interface");  // 컴포넌트
	Label east = new Label("east");// 컴포넌트
	Label center = new Label("Center");// 컴포넌트
	
	Button west = new Button("버튼1");// 컴포넌트
	Button west1 = new Button("버튼2");// 컴포넌트
	Button west2 = new Button("버튼3");// 컴포넌트
	
	Panel west_panel= new Panel();   // 컴포넌트 이면서 컨테이너
	Panel center_panel = new Panel();  // frame center 영역에 입력할 패널
	Panel center_north_panel = new Panel(); // center_panel의 north에 위치할 패널
	Panel center_south_panel = new Panel(); // center_panel의 south에 위치할 패널
	
	Label engLabel= new Label("영어단어");
	Label korLabel = new Label("한글설명");
	
	JTextField engTestF = new JTextField(10);
	JTextField korTestF = new JTextField(10);
	
	JTextField south = new JTextField();// 컴포넌트
	
	
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
		
		//west_panel을 borderlayout으로 변경하는 샘플
//		west_panel.setLayout(new BorderLayout());
//		west_panel.add(west,"North");
//		west_panel.add(west1,"Center");
//		west_panel.add(west2,"South");
		
		//west_panel을 boxLayout으로 변경하는 샘플
		west_panel.setLayout(new BoxLayout(west_panel, BoxLayout.Y_AXIS));
		west_panel.add(west);
		west_panel.add(west1);
		west_panel.add(west2);	
		
		this.setLayout(new BorderLayout());  // 각 컨테이너는 기본 레이아웃을 가지고 있다.
		                                     // Frame은 기본 레이아웃이 borderLayout이다.
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