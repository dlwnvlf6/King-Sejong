package Error;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Game.One2FiftyGame;

public class One2FiftyError extends JFrame{
	public One2FiftyError(int turn) {
		setTitle("����");
		JTextField txtfield = new JTextField();
		JLabel label1 = new JLabel("�߸� �����̽��ϴ�!");
		JLabel label2 = new JLabel("���� ���ʴ� "+turn+" �Դϴ�.");
		JButton btn = new JButton("Ȯ��");
		JPanel MainContainer = new JPanel();
		setContentPane(MainContainer);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		add(label1);
		add(label2);
		add(btn);
		
		setLayout(null);
		
		btn.setBounds(90, 60, 100, 30);
		label1.setBounds(90, 20, 250, 30);
		label2.setBounds(90, 35, 250, 30);
		
		setSize(300, 150);
		setResizable(false);
		setVisible(true);
	}
}