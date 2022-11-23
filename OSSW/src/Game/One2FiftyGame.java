package Game;

import javax.swing.*;
import javax.swing.event.*;

import Error.One2FiftyError;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class One2FiftyGame extends JFrame {
	int SIZE;
	int turn = 1;
	JButton btn[];
	String num[] = new String[51];
	private long startTime;
	
	
	public One2FiftyGame(long startTime) {
		this.startTime = startTime;
		setTitle("1 to 50");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn = new JButton[50];
		Container cp = getContentPane();
		OneActionListener o = new OneActionListener();
		cp.setLayout(new GridLayout(5, 5));
		Random r = new Random();
		
		for (int i = 0; i < 25; i++) {
			num[i] = Integer.toString(r.nextInt(25) + 1);
			for (int j = 0; j < i; j++) {
				if (num[i].equals(num[j]))
					i--;
			}
		}
		
		for(int i = 25; i < 50; i++){
			num[i] = Integer.toString(r.nextInt(25) + 26);
			for (int j = 0; j < i; j++) {
				if (num[i].equals(num[j]))
					i--;
			}
		}
		
		for (int i = 0; i < 25; i++) {
			btn[i] = new JButton();
			btn[i].setText(num[i]);
			add(btn[i]);
			btn[i].addActionListener(o);
		}
		
		setSize(600, 600);
		setResizable(false);
		setVisible(true);
	}
	
	class OneActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			int exitOption;
			if (!b.getText().equals("")) {
				if(b.getText().equals(Integer.toString(turn))) {
					if(turn < 26)
						b.setText(num[24+turn]);
					else
						b.setText(" ");
				}
				else if(!b.getText().equals(Integer.toString(turn))) {
					new One2FiftyError(turn);
					turn--;
				}
				
				if (CheckFin()) {
					long endTime = System.currentTimeMillis();
					long runTime = (endTime - startTime)/1000;
					int is_min = (int)runTime/60;
					String min = runTime/60 > 0 ? is_min + "분 " + runTime%60 + "초" : runTime%60 + "초"; 
					String alertTime = "게임 종료!\n소요시간 : " + min + "\n게임을 종료합니다.";
					exitOption = JOptionPane.showConfirmDialog(null, alertTime, "프로그램 종료",
							JOptionPane.YES_NO_OPTION);
					if (exitOption == JOptionPane.YES_OPTION)
						System.exit(JFrame.EXIT_ON_CLOSE);
					else if (exitOption == JOptionPane.NO_OPTION || exitOption == JOptionPane.CLOSED_OPTION)
						return;
				}
				
			} 
			turn++;
		}
	}
	
	public boolean CheckFin() {
		int i;
		
		// ���� ����
		for (i = 0; i < 25; i++) {
			if (!btn[i].getText().equals(" "))
				break;
		}
		if(i == 25)
			return true;
		return false;
	}
}