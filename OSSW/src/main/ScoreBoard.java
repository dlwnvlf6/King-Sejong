/*
 * Original Code
 * https://github.com/janbodnar/Java-Snake-Game/blob/master/src/com/zetcode/Board.java
 */

package main;

import Game.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ScoreBoard extends JFrame{
	
	 public ScoreBoard() {
		 String name = JOptionPane.showInputDialog("Enter your name");
		 Container cp = getContentPane();
		 cp.setLayout(new BorderLayout());
		 JPanel p1 = new JPanel(new FlowLayout());
		 p1.add(new JLabel(name));
		 cp.add(p1);
		    
		 
	     
	     
	     setTitle("스코어보드");
		 setSize(200,160);
		 setVisible(true);
		 
	    }
}
