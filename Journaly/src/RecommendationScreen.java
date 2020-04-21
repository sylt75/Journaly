import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

//this class displays a recommendation to motivate or uplift user
public class RecommendationScreen extends JPanel implements ActionListener {

	//contents of the screen
	private Window window;
	private JButton backButton = new JButton(new ImageIcon(new ImageIcon("arrow.png").getImage().getScaledInstance(50, 50, 0)));
	private JLabel tip = new JLabel();
	
	//contains path of images of recommendations to user based on rating
	private ArrayList<String> tip1 = new ArrayList<String>();
	private ArrayList<String> tip2 = new ArrayList<String>();
	private ArrayList<String> tip3 = new ArrayList<String>();
	private ArrayList<String> tip4 = new ArrayList<String>();
	private ArrayList<String> tip5 = new ArrayList<String>();

	private JLabel recommendation;
	
	Score score;

	//set up panel
	public RecommendationScreen(Window window, Score score) {
		
		//define the objects
		this.window = window;
		this.score = score;
		//setup panel size and location on window
		setLayout(null);
		setBounds(0, 0, 1050, 725);
		
		//add recommendations to arrayList based on the ratings they belong to (eg. rating 5 tips are about depression, rating 4 about anxiety)
		tip1.add("tip0.jpg");
		tip2.add("tip3.jpg");
		tip3.add("tip4.jpg");
		tip3.add("tip5.jpg");
		tip4.add("tip6.jpg");
		tip4.add("tip2.jpg");
		tip5.add("tip1.png");
				
		//set up features of button
		backButton.setBounds(50, 100, 50, 50);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.addActionListener(this);
		add(backButton);
		
		//generates a random number to determine the background image placed on the panel
		Random rand = new Random();
		int index = rand.nextInt(4) + 1;

		display();
				
		setVisible(true);
		
	}

	//display recommendation to user based on their score
	public void display() {
						
		//if score is lower, display a message telling them to keep it up (more keywords from rating 1)
		if (score.getCount1() > score.getCount2() && score.getCount1() > score.getCount3() && score.getCount1() > score.getCount4() && score.getCount1() > score.getCount5()) {
			
			//generates a random number to determine the image placed on the panel
			Random rand = new Random();
			int index = rand.nextInt(tip1.size());
			
			tip.setIcon(new ImageIcon(new ImageIcon(tip1.get(index)).getImage().getScaledInstance(1050, 725, 0)));
			
		}
		
		//display message to uplift user (majority keywords from rating 2)
		else if (score.getCount2() > score.getCount1() && score.getCount2() > score.getCount3() && score.getCount2() > score.getCount4() && score.getCount2() > score.getCount5()) {
			
			//generates a random number to determine the image placed on the panel
			Random rand = new Random();
			int index = rand.nextInt(tip2.size());
			
			tip.setIcon(new ImageIcon(new ImageIcon(tip2.get(index)).getImage().getScaledInstance(1050, 725, 0)));
			
		}
		
		//display message to try and uplift or motivate user and maybe suggest a form of stress reliever (majority keywords from rating 3)
		else if (score.getCount3() > score.getCount1() && score.getCount3() > score.getCount2() && score.getCount3() > score.getCount4() && score.getCount3() > score.getCount5()) {
			
			//generates a random number to determine the image placed on the panel
			Random rand = new Random();
			int index = rand.nextInt(tip3.size());
			
			tip.setIcon(new ImageIcon(new ImageIcon(tip3.get(index)).getImage().getScaledInstance(1050, 725, 0)));
			
		}
		
		//suggestions to relieve anxiety (majority keywords from rating 4)
		else if (score.getCount4() > score.getCount1() && score.getCount4() > score.getCount2() && score.getCount4() > score.getCount3() && score.getCount4() > score.getCount5()) {
			
			//generates a random number to determine the image placed on the panel
			Random rand = new Random();
			int index = rand.nextInt(tip4.size());
			
			tip.setIcon(new ImageIcon(new ImageIcon(tip4.get(index)).getImage().getScaledInstance(1050, 725, 0)));
			
		}
		
		//display a hotline number majority keywords from rating 5
		else {

			//generates a random number to determine the image placed on the panel
			Random rand = new Random();
			int index = rand.nextInt(tip5.size());
			
			tip.setIcon(new ImageIcon(new ImageIcon(tip5.get(index)).getImage().getScaledInstance(1050, 725, 0)));
		
		}
		
		
		tip.setBounds(0, 0, 1050, 725);
		add(tip);
		
	}
	
	//go back to previous screen if back button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == backButton) {
			
			this.setVisible(false);
			window.getContentPane().add(new RecordEntryScreen(window));
			
		}
		
	}
	
}
