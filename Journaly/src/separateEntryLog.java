import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//this class is a screen allowing users to see a previous entry they've written
public class separateEntryLog extends JPanel implements ActionListener {

	//conntents in the panel
	private JButton backButton = new JButton(new ImageIcon(new ImageIcon("arrow.png").getImage().getScaledInstance(50, 50, 0)));
	private Window window;
	
	//set up panel
	public separateEntryLog(Window window) {
		
		//panel size and location on window
		this.window = window;
		setLayout(null);
		setBounds(0, 0, 1050, 725);
		
		//add features to back button (actionListener, transparent background, size)
		backButton.setBounds(70, 100, 50, 50);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.addActionListener(this);
		add(backButton);
		
	}
	
	//return to previous screen if button clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == backButton) {
			
			this.setVisible(false);
			window.getContentPane().add(new RecordEntryScreen(window));
			
		}

	}

}
