package edu.pupr.musiclibrary;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

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
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
/** 
 * 
 * Class name: ModifyAlbum.java
 * Description: This class shows a frame that allows the user to change the information
 * 				in a chosen album's database entry.
 * 
 *  
 * @author Edwin
 * @author Jonathan
 * @author Wilfredo
 * @author Cristian
 */
public class ModifyAlbum extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JLabel LabelRank;
	private JTextField textField6;
	private JLabel LabelFormat;
	private JTextField textField7;
	private JLabel LabelPrice;
	private JTextField textField8;
	private String originalID;
	private JButton btnChooseFile;
	private JLabel imageLabel;
	private JFileChooser chooseFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyAlbum frame = new ModifyAlbum();
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
	public ModifyAlbum() {
		setTitle("Modify Albums");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		Music album = new Music();

		JLabel LabelUPS = new JLabel("UPS: ");

		textField1 = new JTextField();
		textField1.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent event) 
			{
				textField1.selectAll();
			}
		});
		textField1.setEnabled(false);
		textField1.setEditable(false);
		textField1.setColumns(10);


		JLabel LabelAlbumName = new JLabel("Album Name: ");

		textField2 = new JTextField();
		textField2.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent event) 
			{
				textField2.selectAll();
			}
		});
		textField2.setEnabled(false);
		textField2.setEditable(false);
		textField2.setColumns(10);
		textField2.setText(album.getAlbumName());

		JLabel LabelArtist = new JLabel("Artist: ");

		textField3 = new JTextField();
		textField3.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent event) 
			{
				textField3.selectAll();
			}
		});
		textField3.setEnabled(false);
		textField3.setEditable(false);
		textField3.setColumns(10);
		textField3.setText(album.getArtist());

		JLabel LabelGenre = new JLabel("Genre:");

		textField4 = new JTextField();
		textField4.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent event) 
			{
				textField4.selectAll();
			}
		});
		textField4.setEnabled(false);
		textField4.setEditable(false);
		textField4.setColumns(10);
		textField4.setText(album.getGenre());


		JLabel LabelReleaseDate = new JLabel("Release Date: ");

		textField5 = new JTextField();
		textField5.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent event) 
			{
				textField5.selectAll();
			}
		});
		textField5.setEnabled(false);
		textField5.setEditable(false);
		textField5.setColumns(10);
		textField5.setText(album.getReleaseDate());

		LabelRank = new JLabel("Rank: ");

		textField6 = new JTextField();
		textField6.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent event) 
			{
				textField6.selectAll();
			}
			@Override
			public void focusLost(FocusEvent event) 
			{
				verifyInput(textField6);
			}
		});
		textField6.setEnabled(false);
		textField6.setEditable(false);
		textField6.setColumns(10);

		LabelFormat = new JLabel("Format:");

		textField7 = new JTextField();
		textField7.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent event) 
			{
				textField7.selectAll();
			}
		});
		textField7.setEnabled(false);
		textField7.setEditable(false);
		textField7.setColumns(10);
		textField7.setText(album.getFormat());

		LabelPrice = new JLabel("Price: ");

		textField8 = new JTextField();
		textField8.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent event) 
			{
				textField8.selectAll();
			}
			@Override
			public void focusLost(FocusEvent event) 
			{
				verifyInput(textField8);
			}
		});
		textField8.setEnabled(false);
		textField8.setEditable(false);
		textField8.setColumns(10);

		JButton buttonSave = new JButton("Save");
		buttonSave.setEnabled(false);
		JButton buttonReset = new JButton("Reset");
		buttonReset.setEnabled(false);

		JButton btnNewButton = new JButton("Modify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) 
			{
				textField1.setEditable(true);
				textField1.setEnabled(true);
				textField2.setEditable(true);
				textField2.setEnabled(true);
				textField3.setEditable(true);
				textField3.setEnabled(true);
				textField4.setEditable(true);
				textField4.setEnabled(true);
				textField5.setEditable(true);
				textField5.setEnabled(true);
				textField6.setEditable(true);
				textField6.setEnabled(true);
				textField7.setEditable(true);
				textField7.setEnabled(true);
				textField8.setEditable(true);
				textField8.setEnabled(true);

				buttonSave.setEnabled(true);
				btnChooseFile.setEnabled(true);
				buttonReset.setEnabled(true);

			}
		});


		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) 
			{
				String str = chooseFile.getSelectedFile().getAbsolutePath();
				MusicQuery query = new MusicQuery();

				query.modifyAlbum(textField1.getText(), textField2.getText(), textField3.getText(),str,
						textField4.getText(), textField5.getText(), Integer.parseInt(textField6.getText()),
						textField7.getText(),Double.parseDouble(textField8.getText()), originalID);

				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				textField6.setText("");
				textField7.setText("");
				textField8.setText("");

				JOptionPane.showMessageDialog(null, "Data Updated");


			}
		});

		buttonReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				textField1.setText(null);
				textField2.setText(null);
				textField3.setText(null);
				textField4.setText(null);
				textField5.setText(null);
				textField6.setText(null);
				textField7.setText(null);
				textField8.setText(null);	
			}
		});

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				dispose();
			}
		});

		btnChooseFile = new JButton("Choose File");
		btnChooseFile.setEnabled(false);
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createfileChooser();
				if (chooseFile.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
					String imagePath = chooseFile.getSelectedFile().getAbsolutePath();
					BufferedImage album = null;
					try {
						album = ImageIO.read(new File(imagePath));
						Image dimg = album.getScaledInstance(imageLabel.getHeight(), imageLabel.getWidth(),
								Image.SCALE_SMOOTH);
						imageLabel.setIcon(new ImageIcon(dimg));
					} catch (IOException e) {
						JOptionPane.showMessageDialog(contentPane, "Please choose a valid image file");
					}catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane, "Please choose a valid image file");
					}
				}
			}
		});

		imageLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(44)
										.addComponent(btnNewButton)
										.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
										.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGap(72)
										.addComponent(buttonReset)
										.addGap(92))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(LabelReleaseDate)
																.addComponent(LabelRank)
																.addComponent(LabelFormat)
																.addComponent(LabelPrice))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																.addComponent(textField8)
																.addComponent(textField7)
																.addComponent(textField5)
																.addComponent(textField6, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(LabelAlbumName)
																.addComponent(LabelArtist)
																.addComponent(LabelGenre)
																.addComponent(LabelUPS))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																.addComponent(textField3)
																.addComponent(textField2)
																.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
																.addComponent(textField4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnClose)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(41)
										.addComponent(btnChooseFile)))
						.addGap(18))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(12)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelUPS)
												.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
										.addGap(29)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelAlbumName)
												.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
												.addComponent(LabelArtist))
										.addGap(29)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelGenre)
												.addComponent(textField4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelReleaseDate)
												.addComponent(textField5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(LabelRank)
												.addComponent(textField6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
										.addGap(18))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnChooseFile)
										.addGap(6)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(LabelFormat)
								.addComponent(textField7, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(LabelPrice)
								.addComponent(textField8, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnClose)
								.addComponent(buttonReset)
								.addComponent(buttonSave))
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(new File("logoppt.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image dimg = logo.getScaledInstance(168, 172,
				Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(dimg));
	}

	/**
	 * Sets the text fields with the chosen album's information
	 * @param album A music object
	 */
	public void setValues(Music album)
	{
		originalID = album.getUPC();
		textField1.setText(album.getUPC());
		textField2.setText(album.getAlbumName());
		textField3.setText(album.getArtist());
		textField4.setText(album.getGenre());
		textField5.setText(album.getReleaseDate());
		textField6.setText(Integer.toString(album.getRank()));
		textField7.setText(album.getFormat());
		textField8.setText(Double.toString(album.getPrice()));
		
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(new File(album.getAlbumImageName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = logo.getScaledInstance(168, 172,
				Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(dimg));
		chooseFile = new JFileChooser();
		chooseFile.setSelectedFile(new File(album.getAlbumImageName()));
	}

	/**
	 * verifies that the number fields are actually filled with numbers
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
	/**
	 * function that creates JFileChooser object so that the users can choose
	 * files from their file system
	 */
	public void createfileChooser() {
		chooseFile = new JFileChooser();
		chooseFile.setCurrentDirectory(new java.io.File("."));

	}
	
}
