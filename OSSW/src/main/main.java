package main;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import Game.*;

public class main extends JFrame {
	main() {
		setTitle("Game!");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField txtfield = new JTextField();
		JLabel label = new JLabel("게임을 선택해주세요");
		JButton btn1 = new JButton("TicTacToe 시작");
		JButton btn2 = new JButton("오목 시작");
		JButton btn3 = new JButton("1 to 50 시작");
		JButton btn4 = new JButton("가위바위보 시작");
		JButton btn5 = new JButton("369 시작");
		JButton btn6 = new JButton("슈팅게임 시작");
		JButton btn7 = new JButton("스네이크 게임 시작");
		JPanel MainContainer = new JPanel();
		setContentPane(MainContainer);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SetBoardSize();
			}

		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OmokGame();
			}

		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long startTime = System.currentTimeMillis();
				new One2FiftyGame(startTime);
			}

		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RSP();
			}

		
		});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game369();
			}

		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Ex5();
			}

		});
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Snake();
			}

		});
		
		add(label);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		
		setLayout(null);
		
		label.setBounds(100, 60, 150, 30);
		btn1.setBounds(90, 110, 120, 40);
		btn2.setBounds(90, 150, 120, 40);
		btn3.setBounds(90, 190, 120, 40);
		btn4.setBounds(90, 230, 120, 40);
		btn5.setBounds(90, 270, 120, 40);
		btn6.setBounds(90, 310, 120, 40);
		btn7.setBounds(90, 350, 120, 40);
		
		setSize(300, 500);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		main mf = new main();
	}
}