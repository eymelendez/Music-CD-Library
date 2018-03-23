package edu.pupr.musiclibrary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


/**
 * 
 * Description of Help Contents - This is the frame that the user will use for reference if he doesn't know how the program works. 
 * 								  He can select one of the topics on the Jlist to then change the screenshot of the frame and also the text area changes 
 * 								  as he selects the option on the Jlist. The Screenshot panel uses the index of the Jlist to know which photo to display 
 * 								  and what text to display according to the index.
 * @author Edwin
 * @author Jonathan
 * @author Wilfredo 
 * @author Cristian 
 *
 */

public class HelpContentsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpContentsFrame frame = new HelpContentsFrame();
					frame.setVisible(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HelpContentsFrame() {
		setTitle("Help Contents");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 *  names - name of the photos with there extension to be displayed using  the method setIcon(icons[list.getSelectedIndex()]
		 */
		
		final String names[] = {"splashDeadpool.png", "LoginScreen.png", "Main_Resized.png", "add_550.PNG" ,"modify_size_500.png", 
								"Display_Resized.png", "Report_Resized.png", "about_550.png"}; // here you put the names of the screenshots to be used.
		
		
		 /**
		  *   icons - Depending on the selection on the Jlist, it will get the photo that is inside the folder project.
		  */
		
		final Icon[] icons= {new ImageIcon(getClass().getResource(names[0])), new ImageIcon(getClass().getResource(names[1])), 
							 new ImageIcon(getClass().getResource(names[2])), new ImageIcon(getClass().getResource(names[3])),
							 new ImageIcon(getClass().getResource(names[4])), new ImageIcon(getClass().getResource(names[5])),
							 new ImageIcon(getClass().getResource(names[6])), new ImageIcon(getClass().getResource(names[7]))};
		
		
		JLabel selectLabel = new JLabel("Select one of the options:");
		
		JLabel screenshotLabel = new JLabel("ScreenShot Appears Here");
		
		JTextArea txtrRightHereYou = new JTextArea();
		txtrRightHereYou.setText("Descriptions of each of the screenshotts will appear here and the symbol used for a space\r\n"
								+ "would be the one before this.\r\n");
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent event)
			{
				screenshotLabel.setText(null); // set the label to null ready for the image to be displayed

				screenshotLabel.setIcon(icons[list.getSelectedIndex()]);
				
				/**
				 * Base on the value of the index of the Jlist, the text will change to reflect the explanation of said photo that is also dependent of the index value.
				 */
				
				if(list.getSelectedIndex() == 0)
				{
					// SplashScreen Description
					txtrRightHereYou.setText("A Splash Screen is useful when the application has an initialization procedure that can \r\n"
											+ "take a significant amount of time before the application becomes responsive. It may \r\n"
											+ "also contain useful marketing or other information. In short the purpose of a splash \r\n"
											+ "screen is to entertain and inform the user while the program is busy getting ready to \r\n"
											+ "respond. \r\n \r\n"
											+ "Another benefit of showing a splash screen is that it helps the developer and end user \r\n"
											+ " understand how long each initialization step takes and if for some reason the \r\n"
											+ "initialization doesn't complete we know which step caused the problem");
				}
				
				
				if(list.getSelectedIndex() == 1) 
				{
					// Login Frame Description
					txtrRightHereYou.setText("This is the login frame. The user must input the correct values assigned by the \r\n"
											+ "administrator in order to get access to the system. Fail to enter it three times will result \r\n "
											+ "in the program shutting down.\r\n\r\n"
											+ "Login Button - After putting the correct credentials, press this button to verify the \r\n"
											+ "credentials and if correct, you will proceed to the main menu.\r\n \r\n"
											+ "Reset Button - This button will make the username and password fields empty when pressed. \r\n\r\n"
											+ "Exit Button - pressed this button to close the program. it will ask if you are sure you want \r\n"
											+ "to close the program before doing so.");
				}
				
				if(list.getSelectedIndex() == 2)
				{
					// Main Menu Frame Description
					txtrRightHereYou.setText("On the main menu you have various options. You have the file menu and the help menu. On the File\r\n"
											+ "you have the options to Add, Modify, Display a single record or do a whole report of all the albums \r\n"
											+ "currently stored on the database. \r\n \r\n"
											+ "On the Help Menu it has the Help contents submenu. If clicked it will display the current Help Frame \r\n"
											+ "that you are in right now. If you click on the About Menu Item, it will how the programmers behind \r\n"
											+ "the creation of this program you are using.");
					
				}
				
				if(list.getSelectedIndex() == 3)
				{
					// Add CD Album Frame Description
					txtrRightHereYou.setText("This is Add CD Album Frame. Here you can input the details of a given album that you want to add \r\n"
											+ "to the database. It will ask for information such as the Name of the album, the name of the \r\n"
											+ "artist, the genre and someother information but the most inportant information that must be \r\n"
											+ "put is the UPC number because it will be used to search the album when you enter the \r\n "
											+ "modify album frame or the display album frame.");
				}

				if(list.getSelectedIndex() == 4)
				{
					// Modify CD Album Description
					txtrRightHereYou.setText("This is the Modify CD Album Frame. It will first ask you to enter a valid UPC number on the \r\n "
											+ "search frame that is the database to then be searched and display on the same frame if a valid \r\n "
											+ "number was entered. If it's a valid number, it will prompt you to enter the new information for \r\n"
											+ "the album you searched and then add it back to the database with the new information. After \r\n"
											+ "you enter the information that you want to change, hit the save button. \r\n \r\n"
											+ "Save Button - When you want to save the information, press this button.");
				}

				if(list.getSelectedIndex() == 5) 
				{
					// Display CD Album Description
					txtrRightHereYou.setText("This is the Display CD Album Frame. It will first ask you to enter avalid UPC number tht is in the database\r\n"
											+ "to then be searched and dislay the ifnrmation on a second frame if a valid number was entered. If successful, it will \r\n"
											+ "display the information of the given Album you searched. Be aware that since this is a display frame, you cannot modify \r\n"
											+ "any of the information that is on the album's record.");
				}

				if(list.getSelectedIndex() == 6)
				{
					// Report CD Album Description
					txtrRightHereYou.setText("When selecting the Report CD Album, it will display a table containing all the information of the albums\r\n"
											+ " currently on the database. You may only see the information since you can't modify it using this selection.");
				}

				if(list.getSelectedIndex() == 7)
				{
					// About Frame Description
					txtrRightHereYou.setText("In here it will simply display the names of the people who worked on this program.");
				}

				
				
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 23));
		// list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Splash Screen", "Login Frame", "Main Menu", "Add CD Album", 
											"Modify CD Album", "Display CD Album", "Report CD Album", "About"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		selectLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JSeparator separator = new JSeparator();
		
		/**
		 *  Exit button - Button to exit the program and gives a message dialog to confirm.
		 */
		JButton ExitButton = new JButton("EXIT");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JFrame HelpContentsFrame = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(HelpContentsFrame.this, "Confirm if you want to exit","Help Contents",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}
			}
		});
		ExitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		screenshotLabel.setHorizontalAlignment(SwingConstants.CENTER);
		screenshotLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(selectLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 935, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(screenshotLabel, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(158)
							.addComponent(txtrRightHereYou, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(729, Short.MAX_VALUE)
					.addComponent(ExitButton, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(selectLabel)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(list)
						.addComponent(screenshotLabel, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(txtrRightHereYou, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ExitButton)
					.addGap(10))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
