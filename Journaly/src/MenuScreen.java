import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

//lets user write a journal entry
public class MenuScreen extends JPanel implements ActionListener {

	//contents of the GUI
	private JButton journalButton = new JButton("Write a journal entry", new ImageIcon(new ImageIcon("button1.png").getImage().getScaledInstance(300, 90, 0)));
	private JLabel headingLabel = new JLabel("Main Menu");
	private Window window;

	//sets up the main menu screen and its features
	public MenuScreen(Window window) {

		//sets location and size of panel on window
		this.window = window;
		setLayout(null);
		setBounds(0, 0, 1050, 725);

		//following sets up the label and button (ie. location, size, font, position of text in button, adding actionListener)
		headingLabel.setBounds(420, 15, 400, 70);
		headingLabel.setFont(new Font("serif", Font.BOLD, 30));
		add(headingLabel);

		//place image on panel used to look more appealing 
		JLabel decor1 = new JLabel(new ImageIcon(new ImageIcon("snowflake.png").getImage().getScaledInstance(100, 100, 0)));
		decor1.setBounds(100, 400, 100, 100);
		add(decor1);
		
		JLabel decor2 = new JLabel(new ImageIcon(new ImageIcon("snowflake.png").getImage().getScaledInstance(100, 100, 0)));
		decor2.setBounds(800, 200, 100, 100);
		add(decor2);
		
		journalButton.setBounds(380, 350, 300, 100);
		journalButton.setFont(new Font("serif", Font.BOLD, 20));
		journalButton.setHorizontalTextPosition(JButton.CENTER);
		journalButton.setVerticalTextPosition(JButton.CENTER);
		journalButton.addActionListener(this);
		add(journalButton);

		//if mouse hovers over button, entire button enlarges and if mouse leaves button, it returns to original 
		//https://www.daniweb.com/programming/software-development/threads/124033/creating-hover-effect-for-jbutton
		journalButton.addMouseListener(new java.awt.event.MouseAdapter() {

			//enlarges if mouse hovers above the button
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				
				journalButton.setBounds(360, 330, 340, 140);
				journalButton.setIcon(new ImageIcon(new ImageIcon("button1.png").getImage().getScaledInstance(340, 130, 0)));
				journalButton.setFont(new Font("serif", Font.BOLD, 25));
				
			}

			//returns back to original if mouse leaves the button
			public void mouseExited(java.awt.event.MouseEvent evt) {
				
				journalButton.setBounds(380, 350, 300, 100);
				journalButton.setIcon(new ImageIcon(new ImageIcon("button1.png").getImage().getScaledInstance(300, 90, 0)));
				journalButton.setFont(new Font("serif", Font.BOLD, 20));
				
				}

		});
		
		//generates a random number to determine the background image placed on the panel
		Random rand = new Random();
		int index = rand.nextInt(4) + 1;

		//adds a background image onto panel
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("background" + index + ".jpg").getImage().getScaledInstance(1050, 725, 0)));
		background.setBounds(0, 0, 1050, 725);
		add(background);

		setVisible(true);

	}

	//directs user to next screen depending on the button clicked
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == journalButton) {

			this.setVisible(false);
			window.getContentPane().add(new RecordEntryScreen(window));

		}

	}

}
