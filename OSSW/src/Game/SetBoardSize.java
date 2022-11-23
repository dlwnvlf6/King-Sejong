package Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Error.TicTacToeError;

public class SetBoardSize extends JFrame {
	public int SIZE;
	public SetBoardSize() {
		setTitle("보드 사이즈 설정");
		JTextField txtfield = new JTextField();
		JLabel label = new JLabel("보드 사이즈를 설정해주세요");
		JButton btn = new JButton("게임 시작");
		JPanel MainContainer = new JPanel();
		setContentPane(MainContainer);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SIZE = Integer.parseInt(txtfield.getText());
				if (SIZE < 3)
					new TicTacToeError();

				else
					new TicTacToeGame(SIZE);
				dispose();
			}

		});
		
		add(label);
		add(btn);
		add(txtfield);
		
		setLayout(null);
		
		btn.setBounds(90, 80, 100, 30);
		label.setBounds(75, 20, 150, 30);
		txtfield.setBounds(70, 50, 150, 20);
		
		setSize(300, 150);
		setResizable(false);
		setVisible(true);
	}
}
