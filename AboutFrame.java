package edu.pupr.musiclibrary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Description of the About Frame - A simple GUI that says the version of the program, the build,
 * 									as well as the names of the people who worked on the project.
 *
 *
 * @author Edwin
 * @author Jonathan
 * @author Wilfredo
 * @author Cristian
 *
 */
public class AboutFrame extends JFrame 
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutFrame frame = new AboutFrame();
					frame.setVisible(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutFrame() {
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("ABOUT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 859, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel thisProgramLabel = new JLabel("The Music Library Program has been brought to you by:");
		thisProgramLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		thisProgramLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel EdwinLabel = new JLabel("Edwin");
		EdwinLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		EdwinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Johnathan = new JLabel("Johnathan");
		Johnathan.setFont(new Font("Tahoma", Font.BOLD, 19));
		Johnathan.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel WilfredoLabel = new JLabel("Wilfredo");
		WilfredoLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		WilfredoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel CristianLabel = new JLabel("Cristian");
		CristianLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		CristianLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel versionLabel = new JLabel("Version: 1.5.2");
		versionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel buildLabel = new JLabel("Build id: 2134994145");
		buildLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel copyrightLabel = new JLabel("(c) Copyright MusicDB 2018.  All rights reserved.");
		copyrightLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel SplashLabel = new JLabel("New label");
		
		SplashLabel.setIcon(new ImageIcon(AboutFrame.class.getResource("splashDeadpool.png")));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addComponent(thisProgramLabel, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(161, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(SplashLabel, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(CristianLabel, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(WilfredoLabel, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(EdwinLabel, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
								.addComponent(Johnathan, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
							.addGap(38))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(buildLabel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
								.addComponent(versionLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(567, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(copyrightLabel)
							.addGap(278))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(thisProgramLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(EdwinLabel)
							.addGap(18)
							.addComponent(Johnathan)
							.addGap(18)
							.addComponent(WilfredoLabel)
							.addGap(18)
							.addComponent(CristianLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(SplashLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addComponent(versionLabel)
					.addGap(18)
					.addComponent(buildLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(copyrightLabel)))
					.addGap(55))
		);
		contentPane.setLayout(gl_contentPane);
	}
}