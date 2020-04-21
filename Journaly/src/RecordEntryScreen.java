import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.*;
import java.util.*;

import javax.swing.*;

//this class allows user to write a journal entry 
public class RecordEntryScreen extends JPanel implements ActionListener {

	//GUI components on panel
	private JButton saveButton = new JButton("save");
	private JButton backButton = new JButton(new ImageIcon(new ImageIcon("arrow.png").getImage().getScaledInstance(50, 50, 0)));
	private JTextArea entryArea = new JTextArea();
	private JLabel dateLabel = new JLabel();
	private JLabel instruction = new JLabel("Type anything you choose below and click save when you're done");
	private Window window;

	//fields that store user entry and scores
	private ArrayList<String> entryLines = new ArrayList<String>();
	private String[] separateLines;
	private ArrayList<Integer> separateScores = new ArrayList<Integer>();

	//array of keywords based on their scores
	private ArrayList<String> rating1 = new ArrayList<String>();
	private ArrayList<String> rating2 = new ArrayList<String>();
	private ArrayList<String> rating3 = new ArrayList<String>();
	private ArrayList<String> rating4 = new ArrayList<String>();
	private ArrayList<String> rating5 = new ArrayList<String>();

	//score object keeps track of scores
	Score score = new Score(0.0, 0, 0, 0, 0, 0); 

	//counters keep track of how often keywords from each rating category are used (eg. rating1)
	private int count1 = 0;
	private int count2 = 0;
	private int count3 = 0;
	private int count4 = 0;
	private int count5 = 0;

	//sets up the panel to be displayed to user
	public RecordEntryScreen(Window window) {

		//sets the size of panel
		this.window = window;
		setLayout(null);
		setBounds(0, 0, 1050, 725);

		//adding keywords to arraylist based on their score (eg. word with score of 1 added to arraylist rating1)
		rating1.add("great");
		rating1.add("excited");
		rating2.add("happy");
		rating2.add("good");
		rating3.add("sad");
		rating3.add("okay");
		rating4.add("anxious");
		rating4.add("nervous");
		rating5.add("depressed");
		rating5.add("devastated");

		//displays current date to user
		dateLabel.setText(getDateTime());
		dateLabel.setFont(new Font("serif", Font.BOLD, 20));
		dateLabel.setBounds(850, 0, 200, 100);
		add(dateLabel);

		//create scroll pane containing user's entry text field
		//wrap text so it goes to next line if text reaches the end of the text field
		JScrollPane scroll = new JScrollPane(entryArea);
		entryArea.setLineWrap(true);
		entryArea.setWrapStyleWord(true);

		//sets up scroll pane and adds it to panel 
		//https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.htmlhttps://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(150, 100, 700, 450);
		scroll.getViewport();
		add(scroll);

		//set up instruction label
		instruction.setBounds(150, 50, 800, 50);
		instruction.setFont(new Font("serif", Font.BOLD, 25));
		add(instruction);

		//user clicks this button when they're done their entry and want to save it
		saveButton.setBounds(350, 580, 300, 100);
		saveButton.setBorderPainted(false);
		saveButton.setFont(new Font("serif", Font.BOLD, 50));
		saveButton.addActionListener(this);
		
		//if mouse hovers over button, text font enlarges and if mouse leaves button, font returns to original 
		//https://www.daniweb.com/programming/software-development/threads/124033/creating-hover-effect-for-jbutton
		saveButton.addMouseListener(new java.awt.event.MouseAdapter() {

			//changes text font if mouse hovers above the button
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				saveButton.setFont(new Font("serif", Font.BOLD, 100));
			}

			//changes font back to original if mouse leaves the button
			public void mouseExited(java.awt.event.MouseEvent evt) {
				saveButton.setFont(new Font("serif", Font.BOLD, 50));
			}

		});
		
		add(saveButton);

		//if button clicked, will direct user to previous screen
		//sets up the button
		backButton.setBounds(70, 100, 50, 50);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.addActionListener(this);
		add(backButton);

		//generates a random number to determine the background image placed on the panel
		Random rand = new Random();
		int index = rand.nextInt(4) + 1;

		//adds a background image onto panel
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("background" + index + ".jpg").getImage().getScaledInstance(1050, 725, 0)));
		background.setBounds(0, 0, 1050, 725);
		add(background);

		setVisible(true);

	}

	//returns the current date the application is being used
	public String getDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("MMMM dd YYYY");
		Date date = new Date();
		return dateFormat.format(date);

	}

	//reads in entry written by user and separates the entry into its separate sentences
	public void readEntry() {

		//store entire entry into array list
		entryLines.add(getDateTime() + "\n" + entryArea.getText());

		//split the entry into its separate sentences
		separateLines = entryArea.getText().split("\\.\\s*");

		//testing; prints each sentence of entry
		for (int x = 0; x < separateLines.length; x++) 
			System.out.println(separateLines[x]);

	}

	//searches to see if there are keywords in each sentence of user's entry
	public void keywordSearch(int index) {

		//splits the individual words of each sentence into an array
		String[] word = separateLines[index].split("\\s+");

		//iterates based on how many words are in one sentence
		for (int i = 0; i < word.length; i++) {

			//loop compares the words in each sentence to the rating array lists to look for keywords (not case sensitive)
			for (int y = 0; y < rating1.size(); y++) {

				//following selection statement adds score to separateScores arraylist based on keyword and increment counter for how many times in the 
				//entry keywords with that score are used
				if (word[i].equalsIgnoreCase(rating1.get(y))) {

					separateScores.add(1);
					count1++;

				}

				else if (word[i].equalsIgnoreCase(rating2.get(y))) {

					separateScores.add(2);
					count2++;

				}

				else if (word[i].equalsIgnoreCase(rating3.get(y))) {

					separateScores.add(3);					
					count3++;

				}

				else if (word[i].equalsIgnoreCase(rating4.get(y))) {

					separateScores.add(4);
					count4++;

				}

				else if (word[i].equalsIgnoreCase(rating5.get(y))) {

					separateScores.add(5);
					count5++;

				}

			}

		}

	}

	//recurses to gather the scores of each sentence into separateScores arrayList
	public void rateEntrySeparately(String[] separateLines, int index) {

		//if index counter is creater than index number in separateLines array, add 0 to the score
		if (index == separateLines.length) 
			separateScores.add(0);

		//if not, continue keyword searching and continue to the next sentence of the journal entry
		else {

			keywordSearch(index);
			rateEntrySeparately(separateLines, ++index);

		}

	}

	//calculates the average of all individual scores (the overall score of entire entry)
	public double calculateOverallRating() {

		int sum = 0;

		//finds the sum of each 
		for (int i = 0; i < (separateScores.size() - 1); i++) 
			sum += separateScores.get(i);

		return sum / (separateScores.size() - 1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//when user clicks save button, entry is stored in file, score is given to entry, and next screen will be displayed
		if (e.getSource() == saveButton) {

			//saves user's entry to text file
			try {

				readEntry();

				File entryFile = new File("entries.txt");
				entryLines.addAll(Files.readAllLines(Paths.get("entries.txt"), StandardCharsets.UTF_8));
				Files.write(entryFile.toPath(), entryLines, StandardCharsets.UTF_8);

			} catch (IOException e1) {
				e1.printStackTrace();
			}

			//score each sentence of the entry
			rateEntrySeparately(separateLines, 0);
			//find the average score of the entry
			score.setOverallScore(calculateOverallRating());
			//set the counter values to keep track of which category of keywords were used most frequently
			score.setCount1(count1);
			score.setCount2(count2);
			score.setCount3(count3);
			score.setCount4(count4);
			score.setCount5(count5);

			//direct user to recommendations screen after writing their entry and sends entry score to next screen
			this.setVisible(false);
			window.getContentPane().add(new RecommendationScreen(window, score));

		}

		//returns to previous screen
		else if (e.getSource() == backButton) {

			this.setVisible(false);
			window.getContentPane().add(new MenuScreen(window));

		}

	}

}
