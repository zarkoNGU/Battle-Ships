package BattleShips;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ShipButton extends JButton implements ActionListener{

	ImageIcon fire;
	public static int wins = 0;
	public static int hits = 0;
	
	public ShipButton() {
		fire = new ImageIcon("res/shipOnFire.png");
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		hits += 1;
		if (hits == 14) {
			JOptionPane.showMessageDialog(null, "YOU WON!");
			int restartPanel = JOptionPane.showConfirmDialog(null, "Do you want try again ?");
			if (restartPanel == 0) {
				wins+=1;
				//setVisible(false);
				new GameField();
				new Buttons();
				new ShipButton();
				hits = 0;
				Buttons.attempts = 0;
			}else {
				System.exit(0);
			}
		}
		setIcon(fire);		
		//setEnabled(false);
	}

	
}