import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//introduction screen that displays logo and name of app
public class IntroScreen extends JPanel implements ActionListener {

	//private JButton nextButton = new JButton("start");
	private JLabel titleLabel = new JLabel("Welcome to Journaly");
	private JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(350, 350, 0)));
	private Window window;

	//timer object used to display intro screen for limited amount of time before going to next screen
	private Timer timer = new Timer(1000, this);
	private int time = 3;

	//sets up the screen and it's contents
	public IntroScreen(Window window) {
		
		//sets the size of screen
		this.window = window;
		setLayout(null);
		setBounds(0, 0, 1050, 725);
		
		//following sets up the labels (ie. size, location, font, transparent background, add to screen)
		titleLabel.setBounds(320, 15, 400, 70);
		titleLabel.setFont(new Font("serif", Font.BOLD, 30));
		add(titleLabel);
		
		imageLabel.setBounds(300, 200, 350, 350);
		imageLabel.setOpaque(false);
		add(imageLabel);
		
		//adds a background image onto panel
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("background" + 0 + ".jpg").getImage().getScaledInstance(1050, 725, 0)));
		background.setBounds(0, 0, 1050, 725);
		add(background);
		
		//start timer to display screen for limited time to user
		timer.start();
		
		setVisible(true);

	}

	//action listener listens for the timer counting
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//each time the timer counts, decrement time counter (countdown)
		if (e.getSource() == timer) {
			
			time -= 1;
			
			//after the time countdown reaches 0, stop the timer and the next screen will appear
			if (time == 0) {
				
				timer.stop();
				this.setVisible(false);
				window.getContentPane().add(new LoginScreen(window));
				
			}
				
		}
		
	}
	
}
