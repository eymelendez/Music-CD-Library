package edu.pupr.musiclibrary;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

/**
 * Class: AddAlbum.java
 * Description: This class presents a Jframe in which the 
 *				user can add a new album to the database
 * 
 * Date: 03/17/2018
 * 
 * @author Johnathan
 * @author Edwin Melendez
 * @author Wilfredo
 * @author Cristian 
 */

public class AddAlbum extends JFrame 
{

	private JPanel contentPane;
	private JTextField UPS_txfld;
	private JTextField albumName_txtfld;
	private JTextField artist_txtfld;
	private JTextField genre_txtfld;
	private JTextField release_txtfld;
	private JTextField rank_txfld;
	private JTextField format_txtfld;
	private JTextField price_txtfld;
	private JFileChooser chooseFile;
	private JButton btnChooseImageFile;
	private JLabel imageLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAlbum frame = new AddAlbum();
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
	 * Creates the JFileChooser object which lets the user choose
	 * image files from their file system
	 */
	
	public void createfileChooser() {
		chooseFile = new JFileChooser();
		chooseFile.setCurrentDirectory(new java.io.File("."));
		
	}
	
	/**
	 * Create the frame.
	 */
	
	public AddAlbum() {
		setTitle("Add CD Album");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1041, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUps = new JLabel("UPS:");
		lblUps.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		UPS_txfld = new JTextField();
		UPS_txfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				UPS_txfld.selectAll();
			}
		});
		UPS_txfld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UPS_txfld.setColumns(10);
		
		JLabel album_Label = new JLabel("Album Name: ");
		album_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		albumName_txtfld = new JTextField();
		albumName_txtfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				albumName_txtfld.selectAll();
			}
		});
		albumName_txtfld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		albumName_txtfld.setColumns(10);
		
		JLabel artist_Label = new JLabel("Artist: ");
		artist_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		artist_txtfld = new JTextField();
		artist_txtfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				artist_txtfld.selectAll();
			}
		});
		artist_txtfld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		artist_txtfld.setColumns(10);
		
		JLabel genre_Label = new JLabel("Genre:");
		genre_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		genre_txtfld = new JTextField();
		genre_txtfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				genre_txtfld.selectAll();
			}
		});
		genre_txtfld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		genre_txtfld.setColumns(10);
		
		JLabel release_Label = new JLabel("Release Date: ");
		release_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		release_txtfld = new JTextField();
		release_txtfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				release_txtfld.selectAll();
			}
		});
		release_txtfld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		release_txtfld.setColumns(10);
		
		JLabel rank_Label = new JLabel("Rank:");
		rank_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		rank_txfld = new JTextField();
		rank_txfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				rank_txfld.selectAll();
			}
		});
		rank_txfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				verifyInput(rank_txfld);
			}
		});
		rank_txfld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rank_txfld.setColumns(10);
		
		JLabel format_Label = new JLabel("Format: ");
		format_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		format_txtfld = new JTextField();
		format_txtfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				format_txtfld.selectAll();
			}
		});
		format_txtfld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		format_txtfld.setColumns(10);
		
		JLabel price_Label = new JLabel("Price: ");
		price_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		price_txtfld = new JTextField();
		price_txtfld.setHorizontalAlignment(SwingConstants.RIGHT);
		price_txtfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				price_txtfld.selectAll();
			}
		});
		price_txtfld.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				verifyInput(price_txtfld);
			}
		});
		price_txtfld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		price_txtfld.setColumns(10);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener()
		{
			/* (non-Javadoc)
			 * action listener for add button. Sets the database entry for the new album.
			 * sets the textfields to blank so the user can make another entry.
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			
			public void actionPerformed(ActionEvent event) 
			{
				String img = chooseFile.getSelectedFile().getAbsolutePath();
				String text1 = null;
				String text2 = null;
				String text3 = null;
				String text4 = null;
				String text5 = null;
				int text6;
				String text7 = null;
				Double text8;
				
				text1 = UPS_txfld.getText();	 
				text2 = albumName_txtfld.getText();   
				text3 = artist_txtfld.getText();	
				text4 = genre_txtfld.getText();	
				text5 = release_txtfld.getText();	
				text6 = Integer.parseInt(rank_txfld.getText());
				text7 = format_txtfld.getText();
				text8 = Double.parseDouble(price_txtfld.getText()); 	
				MusicQuery musica = new MusicQuery();
				try {
					musica.addAlbums(text1, text2, text3, img, text4, text5, text6, text7, text8);
					UPS_txfld.setText("");
					albumName_txtfld.setText("");
					artist_txtfld.setText("");
					genre_txtfld.setText("");
					release_txtfld.setText("");
					rank_txfld.setText("");
					format_txtfld.setText("");
					price_txtfld.setText("");
					BufferedImage album = null;
					try {
						album = ImageIO.read(new File("logoppt.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					Image dimg = album.getScaledInstance(imageLabel.getHeight(), imageLabel.getWidth(),
							Image.SCALE_SMOOTH);
					imageLabel.setIcon(new ImageIcon(dimg));
					JOptionPane.showMessageDialog(null,"Successfully Added ", "Message", JOptionPane.PLAIN_MESSAGE);
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(contentPane, "Error adding entry to the database.");
				}
				
			}
		});
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() 
		{
			/* 
			 * Action listener for the reset button. Erases all
			 * entered information
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			
			public void actionPerformed(ActionEvent event) 
			{
				UPS_txfld.setText(null);
				albumName_txtfld.setText(null);
				artist_txtfld.setText(null);
				genre_txtfld.setText(null);
				release_txtfld.setText(null);
				rank_txfld.setText(null);
				format_txtfld.setText(null);
				price_txtfld.setText(null);
			}
		});
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				dispose();
			}
		});
		
		btnChooseImageFile = new JButton("Choose Image File");
		btnChooseImageFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createfileChooser();
				chooseFile.showOpenDialog(contentPane);
				String imagePath = chooseFile.getSelectedFile().getAbsolutePath();
				BufferedImage album = null;
				try {
					album = ImageIO.read(new File(imagePath));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Image dimg = album.getScaledInstance(imageLabel.getHeight(), imageLabel.getWidth(),
						Image.SCALE_SMOOTH);
				imageLabel.setIcon(new ImageIcon(dimg));
			}
		});
		
		imageLabel = new JLabel("");
		imageLabel.setForeground(Color.DARK_GRAY);
		imageLabel.setBackground(Color.DARK_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(99)
							.addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(price_Label)
									.addGap(78)
									.addComponent(price_txtfld))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUps)
										.addComponent(album_Label)
										.addComponent(artist_Label)
										.addComponent(genre_Label)
										.addComponent(release_Label)
										.addComponent(rank_Label)
										.addComponent(format_Label))
									.addGap(37)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(genre_txtfld)
										.addComponent(UPS_txfld, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
										.addComponent(albumName_txtfld)
										.addComponent(artist_txtfld)
										.addComponent(release_txtfld)
										.addComponent(rank_txfld)
										.addComponent(format_txtfld))))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(119)
									.addComponent(btnChooseImageFile))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(127)
									.addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))))
					.addGap(127))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUps)
								.addComponent(UPS_txfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(album_Label)
								.addComponent(albumName_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(artist_Label)
								.addComponent(artist_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(genre_Label)
								.addComponent(genre_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(release_Label)
								.addComponent(release_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rank_Label)
								.addComponent(rank_txfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(format_Label)
								.addComponent(format_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)))
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(price_Label)
						.addComponent(price_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChooseImageFile))
					.addPreferredGap(ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addButton)
						.addComponent(closeButton)
						.addComponent(resetButton))
					.addGap(65))
		);
		contentPane.setLayout(gl_contentPane);
		BufferedImage album = null;
		try {
			album = ImageIO.read(new File("logoppt.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = album.getScaledInstance(221, 252,
				Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(dimg));
	}
	/**
	 * verifies that the number fields are filled with numbers.
	 * @param textField
	 */
	private void verifyInput(JTextField textField)
	{
		try 
		{
			double num4 = Double.parseDouble(textField.getText());	
		} 
		catch (NumberFormatException e) 
		{
			JOptionPane.showMessageDialog(this, "Need to enter only Numbers");
			textField.requestFocus();
			textField.selectAll();
		}
	}
}

