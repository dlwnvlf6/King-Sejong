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
import Game.SetBoardSize;
public class TicTacToeError extends JFrame{
	public TicTacToeError() {
		setTitle("오류");
		JTextField txtfield = new JTextField();
		JLabel label = new JLabel("보드 크기는 3 이상이어야 합니다!");
		JButton btn = new JButton("다시 설정");
		JPanel MainContainer = new JPanel();
		setContentPane(MainContainer);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SetBoardSize();
				dispose();
			}

		});
		
		add(label);
		add(btn);
		add(txtfield);
		
		setLayout(null);
		
		btn.setBounds(90, 80, 100, 30);
		label.setBounds(60, 30, 250, 30);
		
		setSize(300, 150);
		setResizable(false);
		setVisible(true);
	}
}
