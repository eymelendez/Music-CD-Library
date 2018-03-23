package edu.pupr.musiclibrary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

import javax.swing.JSeparator;


/**
 * 
 * Description of Login - This Login frame executes after the splash screen finishes. 
 * 						  It's a basic system that requires the user to enter credentials that are in the program for 
 * 						  it to be able to access said program. If the user fails to enter the correct username and
 * 						  password, the program will shut down
 * 
 * @author Edwin
 * @author Jonathan 
 * @author Wilfredo
 * @author Cristian
 * 
 * 
 *
 */

public class LoginFrame extends JFrame
{

	/**
	 *  counter - // Variable that counts the number of tries done by the user before it closes the program.
	 */
	private JPanel contentPane;
	private JTextField user_txtfld;
	private JPasswordField password_txtfld;
	public static int counter = 0; 

	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Changed it to dispose instead of exit, to see if the jar file works.
		setBounds(100, 100, 601, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * user_Label - Text indicating that the TextField to the right side is where the user has to put the valid user name.
		 */
		JLabel user_Label = new JLabel("Username: ");
		user_Label.setFont(new Font("Dialog", Font.BOLD, 14));
		
		
		/**
		 * password_Label - Text indicating that the TextField to the right side is where the user has to put a valid password.
		 */
		JLabel password_Label = new JLabel("Password:");
		password_Label.setFont(new Font("Dialog", Font.BOLD, 14));
		
		
		/**
		 * User Textfield - It is the entry where the user writes the username that is valid to be able to enter the main menu. 
		 * 					Added focusGained so you can delete it from a single backspace in case of any change.
		 */
		user_txtfld = new JTextField();
		user_txtfld.setFont(new Font("Dialog", Font.BOLD, 14));
		user_txtfld.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent event) 
			{
				user_txtfld.selectAll();
			}
		});
		user_txtfld.setHorizontalAlignment(SwingConstants.LEFT);
		user_txtfld.setColumns(10);
		
		/**
		 * Password textfield - It is the entry where the user writes the username that is valid to enter the main menu. 
		 * 						Added focusGained so you can delete it from a single backspace in case of any change.
		 */
		password_txtfld = new JPasswordField();
		password_txtfld.setFont(new Font("Dialog", Font.BOLD, 14));
		password_txtfld.setHorizontalAlignment(SwingConstants.LEFT);
		
		/**
		 * Login - Button to press when the user entered the user and password valid. If it is correct, start running the JFrame program of the MainMenu. 
		 * 			  If invalid, the user must enter the credentials again. If the user fails 3 times, the program closes.
		 */
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent event)
			{
				String uName = user_txtfld.getText();
				String pass = password_txtfld.getText(); 
				
				if(uName.equals("name") && pass.equals("pass")) // Here are the credentials for the user to be able to enter the main program
				{
					JOptionPane.showMessageDialog(LoginFrame.this, "Logged in Sucessfully!");
					
					
					MainMenuFrame menu = new MainMenuFrame();
					MainMenuFrame.main(null); // This is how you execute the next program
					dispose(); // Disposes of the current frame.
					
				}	
				
				else
				{
					// JOptionPane.showMessageDialog(LoginFrame.this, "Wrong UserName or Password! Please Try Again!");
					
					counter++;
													  			/* Message to display*/   			/*Frame Title*/  	/*Error symbol*/
					JOptionPane.showMessageDialog(null, "Invalid Login Details. Attempt #" + counter, "Login Error", JOptionPane.ERROR_MESSAGE);
					
				
					if(counter == 3) 
					{
						JOptionPane.showMessageDialog(null, "Login max attempts reached... Closing Program.", "Login Error", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					} // end if.
					
				} // end else
				
				
			}
		});
		
		JLabel LoginSys_Label = new JLabel("Login System");
		LoginSys_Label.setFont(new Font("Dialog", Font.BOLD, 25));
		LoginSys_Label.setHorizontalAlignment(SwingConstants.CENTER);
		
		/**
		 * Reset - When this button is pressed , it puts the textfield to null.
		 */
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Dialog", Font.BOLD, 14));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				user_txtfld.setText(null);
				password_txtfld.setText(null);
				
			}
		});
		
		/**
		 * Exit - When this button is pressed, it pops a showDialongBox message asking the user to confirm to close the program.
		 */
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Dialog", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) // Confirmation
			{
				JFrame Loginframe = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(LoginFrame.this, "Confirm if you want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(152)
							.addComponent(LoginSys_Label, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(167)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(password_Label)
								.addComponent(user_Label))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(password_txtfld, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(user_txtfld, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(12, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(LoginSys_Label)
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(user_Label)
						.addComponent(user_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(password_Label)
						.addComponent(password_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnReset)
						.addComponent(btnExit))
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
