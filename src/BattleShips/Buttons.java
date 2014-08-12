package BattleShips;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Buttons extends JButton implements ActionListener{

	ImageIcon water;
	public static int loses = 0;
	public static int attempts = 0;
	
	public Buttons() {
		water = new ImageIcon("res/water.png");
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		attempts += 1;
		if (attempts == 14) {
			JOptionPane.showMessageDialog(null, "YOU LOSE!");
			int restartPanel = JOptionPane.showConfirmDialog(null, "Do you want restart the game ?");
			if (restartPanel == 0) {
				loses+=1;
				//setVisible(false);
				new GameField();
				new Buttons();
				new ShipButton();
				attempts = 0;
				ShipButton.hits = 0;
			}else {
				System.exit(0);
			}
		}
		setIcon(water);	
		//setEnabled(false);
	}

	
}
