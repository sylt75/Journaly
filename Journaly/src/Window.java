import javax.swing.JFrame;

//this class creates a frame/window for future panels to be place on top of
public class Window extends JFrame {

	//set up window 
	public Window() {
		
		//size and title of window
		setLayout(null);
		setSize(1050, 725);
		setTitle("Journaly");
		
		//if user clicks "x" button in frame, discontinue running the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add the first panel onto the window
		add(new IntroScreen(this));
		
		setVisible(true);
		
	}
	
}
