package Game;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OmokGame extends JFrame {
	int turn = 0;
	protected JButton board[][];

	public OmokGame() {
		setTitle("오목 게임");
		Container cp = getContentPane();
		OmokActionListener l = new OmokActionListener();

		board = new JButton[19][19];

		cp.setLayout(new GridLayout(19, 19));

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = new JButton();
				board[i][j].setText("");
				add(board[i][j]);
				board[i][j].addActionListener(l);
			}
		}

		setSize(900, 900);
		setResizable(false);
		setVisible(true);
	}
	public class OmokActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			int exitOption;
			if (b.getText().equals("")) {
				if (turn % 2 == 0) {
					b.setText("O");
					if (OmokCheckWinner("O")) {
						exitOption = JOptionPane.showConfirmDialog(null, "게임 종료!\nO의 승리\n게임을 종료합니다.", "프로그램 종료",
								JOptionPane.YES_NO_OPTION);
						if (exitOption == JOptionPane.YES_OPTION)
							System.exit(JFrame.EXIT_ON_CLOSE);

						else if (exitOption == JOptionPane.NO_OPTION || exitOption == JOptionPane.CLOSED_OPTION)
							return;
					}

				} else if (turn % 2 == 1) {
					b.setText("X");
					if (OmokCheckWinner("X")) {
						exitOption = JOptionPane.showConfirmDialog(null, "게임 종료!\nX의 승리\n게임을 종료합니다.", "프로그램 종료",
								JOptionPane.YES_NO_OPTION);
						if (exitOption == JOptionPane.YES_OPTION)
							System.exit(JFrame.EXIT_ON_CLOSE);

						else if (exitOption == JOptionPane.NO_OPTION || exitOption == JOptionPane.CLOSED_OPTION)
							return;
					}
				}
			} else if (b.getText().equals("O") || b.getText().equals("X"))
				turn--;

			turn++;
		}

	}

	public boolean OmokCheckWinner(String symbol) {
		int i, j, k;
		int w = 0;
		// �࿡�� �¸� ����
		for (i = 0; i < 19; i++) {
			for (j = 0; j < 19; j++) {
				if (board[i][j].getText().equals(symbol))
					w++;
				if (w == 5)
					return true;
				if (!board[i][j].getText().equals(symbol))
					w = 0;
			}
		}
		w = 0;
		// ������ �¸� ����
		for (i = 0; i < 19; i++) {
			for (j = 0; j < 19; j++) {
				if (board[j][i].getText().equals(symbol))
					w++;
				if (w == 5)
					return true;
				if (!board[j][i].getText().equals(symbol))
					w = 0;
			}
		}
		w = 0;
		
		//�밢�� ������
		for (i = 0; i < 19; i++) {
			for (j = 0; j < 19; j++) {
				if (board[i][j].getText().equals(symbol)) {
					for (k = 1; k <= 5; k++) {
						if(i + k > 18 || j + k > 18)
							break;
						if (!board[i + k][j + k].getText().equals(symbol))
							break;
					}
					if (k == 5)
						return true;
				}
			}
		}
		
		//�밢��(������)
		for (i = 0; i < 19; i++) {
			for (j = 0; j < 19; j++) {
				if (board[i][j].getText().equals(symbol)) {
					for (k = 1; k <= 5; k++) {
						if(i + k > 18 || j - k < 0)
							break;
						if (!board[i + k][j - k].getText().equals(symbol))
							break;
					}
					if (k == 5)
						return true;
				}
			}
		}
		if(w==4)
			return true;
		return false;
	}
}
