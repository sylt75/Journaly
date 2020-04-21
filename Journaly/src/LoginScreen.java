import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

//this screen allows users to login to the application
public class LoginScreen extends JPanel implements ActionListener {

	//fields for window object for the panel to be displayed on top and the current user of the application
	private Window window;
	private User currentUser = new User("", "");

	//fields that allow user to login to application
	private JButton nextButton = new JButton("Login");
	private JTextField userName = new JTextField("");
	private JTextField password = new JTextField("");

	//sets up the screen and its contents
	public LoginScreen(Window window) {

		//sets size and location of panel on the window
		this.window = window;
		setLayout(null);
		setBounds(0, 0, 1050, 725);

		//following code sets up and adds label prompts onto panel
		JLabel nameLabel = new JLabel("Type a username:");
		nameLabel.setBounds(150, 200, 200, 50);
		nameLabel.setFont(new Font("serif", Font.BOLD, 20));
		add(nameLabel);
		
		JLabel passLabel = new JLabel("Type a password:");
		passLabel.setBounds(150, 400, 200, 50);
		passLabel.setFont(new Font("serif", Font.BOLD, 20));
		add(passLabel);
		
		//following code sets up text fields for user to type username and password into
		userName.setBounds(400, 200, 300, 50);
		add(userName);
		
		password.setBounds(400, 400, 300, 50);
		add(password);
		
		//sets up the button to go to next screen
		nextButton.setBounds(350, 550, 300, 100);
		nextButton.setBorderPainted(false);
		nextButton.setFont(new Font("serif", Font.BOLD, 50));
		//if mouse hovers over button, text font enlarges and if mouse leaves button, font returns to original 
		//https://www.daniweb.com/programming/software-development/threads/124033/creating-hover-effect-for-jbutton
		nextButton.addMouseListener(new java.awt.event.MouseAdapter() {

			//changes text font if mouse hovers above the button
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				nextButton.setFont(new Font("serif", Font.BOLD, 100));
			}

			//changes font back to original if mouse leaves the button
			public void mouseExited(java.awt.event.MouseEvent evt) {
				nextButton.setFont(new Font("serif", Font.BOLD, 50));
			}

		});

		//add listener for if user clicks the button
		nextButton.addActionListener(this);
		add(nextButton);

		//generates a random number to determine the background image placed on the panel
		Random rand = new Random();
		int index = rand.nextInt(4) + 1;

		//adds a background image onto panel
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("background" + index + ".jpg").getImage().getScaledInstance(1050, 725, 0)));
		background.setBounds(0, 0, 1050, 725);
		add(background);

	}

	//listens to the actions of the button to go to next screen
	@Override
	public void actionPerformed(ActionEvent e) {

		//if next button is clicked by user, direct user to next screen
		if (e.getSource() == nextButton) {

			//store username and password in User class
			currentUser.setUsername(userName.getText());
			currentUser.setPassword(String.valueOf(password.getText()));
			System.out.println(currentUser.getPassword());
			//directs user to next screen
			this.setVisible(false);
			window.getContentPane().add(new MenuScreen(window));

		}
	}

}
