package BattleShips;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

public class GameField extends JFrame{
	
	JPanel panel = new JPanel();
	Buttons[] water = new Buttons[100];
	ShipButton[] ship = new ShipButton[100];
	
	public GameField() {
		super("Battle Ships by Coruscant");
		
		JMenuBar barMenuBar = new JMenuBar();
		setJMenuBar(barMenuBar);		
		JMenu fileMenu = new JMenu("File");
		JMenu statisticMenu = new JMenu("Statistic");
		barMenuBar.add(fileMenu);
		barMenuBar.add(statisticMenu);
		JMenuItem restartItem = new JMenuItem("Restart");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem statisticItem = new JMenuItem("Stats");
		fileMenu.add(restartItem);
		fileMenu.add(exit);
		statisticMenu.add(statisticItem);
		restartItem.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new GameField();
				new Buttons();
				new ShipButton();
				
			}
		});
		exit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		statisticItem.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "You have " + Buttons.loses + " loses! \n"
						+ "You have " + ShipButton.wins + " wins");
				
			}
		});
		
		setSize(800, 800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel.setLayout(new GridLayout(10,10));
		Random random = new Random();
		int firstShip = random.nextInt(7);  // 4 positions
		int secondShip = random.nextInt((30-20)+1)+(20);  // 3
		int thirdShip = random.nextInt((88-80)+1)+(80);   // 2
		int fourthShip = random.nextInt((65-61)+1)+(61);  // 5
		for (int i = 0; i < 100; i++) {
			
			if ( i==firstShip || i == firstShip + 1 || i == firstShip + 2 || i == firstShip + 3
					|| i == secondShip || i == secondShip + 10 || i == secondShip + 20
					|| i == thirdShip || i == thirdShip + 10
					|| i ==fourthShip || i == fourthShip +1 || i == fourthShip + 2 || i == fourthShip + 3 
					|| i == fourthShip + 4) {
				ship[i] = new ShipButton();
				panel.add(ship[i]);
			}
			else if (i > firstShip + 3 || i<firstShip) {
				water[i] = new Buttons();
				panel.add(water[i]);
			}
		
		}
		
		
		
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GameField();

	}

}
