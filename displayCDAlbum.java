package edu.pupr.musiclibrary;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
/** 
 * 
 * Class name: DisplayCDAlbum.java
 * History:
 * 			03-04-18 - File Created.
 * 			03-06-18 - modified the layout of the album information 
 * 			03-12-18 - Added the capability to show image and information from database.
 *  
 * @author Edwin
 * @author Jonathan
 * @author Wilfredo
 * @author Cristian
 */

public class displayCDAlbum extends JPanel {

	/**
	 * 
	 */
	MusicQuery db = new MusicQuery();
	private JPanel infoPanel;
	private JLabel artistLabel;
	private JLabel priceLabel;
	private JLabel releaseDateLabel;
	private JLabel albumLabel;
	private JLabel GenreLabel;
	private JLabel rankLabel;
	private JLabel formatLabel;
	private JLabel upcLabel;
	private JLabel imageLabel;
	private Music CurrentAlbum;
	private JPanel panel;
	private static final long serialVersionUID = 1L;
	private JButton btnNewSearch;
	

	/**
	 * Main function.
	 * @param args command line arguments
	 */
	
	public static void main (String args[]) {
		displayCDAlbum displayCDAlbum = new displayCDAlbum();
		displayCDAlbum.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	public displayCDAlbum() {
		setBackground(new Color(0, 102, 255));

		imageLabel = new JLabel("");


		imageLabel.setBounds(24, 120, 253, 227);

		//panel where Thread info will be shown
		infoPanel = new JPanel();
		infoPanel.setBounds(309, 94, 419, 294);
		infoPanel.setBackground(new Color(0, 0, 102));

		btnNewSearch = new JButton("New Search");
		btnNewSearch.setBounds(592, 411, 136, 29);
		btnNewSearch.setForeground(new Color(255, 255, 255));
		btnNewSearch.setBackground(new Color(0, 0, 128));
		btnNewSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean fail = true;
				String upcEntry = JOptionPane.showInputDialog(null, "Enter the album's UPC:");
				while (fail) {
					try {
						if (upcEntry != null) {
							if (!upcEntry.isEmpty()) {
								setCurrentAlbum(upcEntry);
								fail = false;
							}
						}
						fail = false;
					}catch (HeadlessException e) {
						upcEntry = JOptionPane.showInputDialog(null, "Error, Enter the album's UPC.");
					} catch (IOException e) {
						upcEntry = JOptionPane.showInputDialog(null, "Error, Enter the album's UPC.");
					} catch (Exception e) {
						upcEntry = JOptionPane.showInputDialog(null, "Error, Enter the album's UPC.");
					} 
				}
			}
		});
		btnNewSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(24, 12, 216, 76);
		// sets the logo of the software
		BufferedImage logo = null;
		try {
			logo = ImageIO.read(new File("logoppt.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = logo.getScaledInstance(216, 76,
				Image.SCALE_SMOOTH);
		logoLabel.setIcon(new ImageIcon(dimg));


		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		//panel that shows the category labels
		JPanel panel_2 = new JPanel();
		infoPanel.add(panel_2);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtist.setForeground(Color.WHITE);
		lblArtist.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArtist.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(lblArtist);

		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbum.setForeground(Color.WHITE);
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblAlbum);

		JLabel lblReleaseDate = new JLabel("Release Date");
		lblReleaseDate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblReleaseDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblReleaseDate.setForeground(Color.WHITE);
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblReleaseDate);

		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblGenre);

		JLabel lblRank = new JLabel("Rank");
		lblRank.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		lblRank.setForeground(Color.WHITE);
		lblRank.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblRank);

		JLabel lblFormat = new JLabel("Format");
		lblFormat.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblFormat.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormat.setForeground(Color.WHITE);
		lblFormat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblFormat);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblPrice);

		JLabel lblUpc = new JLabel("UPC");
		lblUpc.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpc.setForeground(Color.WHITE);
		lblUpc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUpc.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(lblUpc);
		//panel that shows the album's information
		panel = new JPanel();
		infoPanel.add(panel);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 128));

		artistLabel = new JLabel("<dynamic>");
		artistLabel.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		artistLabel.setHorizontalAlignment(SwingConstants.CENTER);
		artistLabel.setForeground(new Color(255, 255, 255));
		artistLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		albumLabel = new JLabel("<dynamic>");
		albumLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		albumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		albumLabel.setForeground(new Color(255, 255, 255));
		albumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		releaseDateLabel = new JLabel("<dynamic>");
		releaseDateLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		releaseDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		releaseDateLabel.setForeground(new Color(255, 255, 255));
		releaseDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		GenreLabel = new JLabel("<dynamic>");
		GenreLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GenreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GenreLabel.setForeground(new Color(255, 255, 255));
		GenreLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		rankLabel = new JLabel("<dynamic>");
		rankLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setForeground(new Color(255, 255, 255));
		rankLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		formatLabel = new JLabel("<dynamic>");
		formatLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		formatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		formatLabel.setForeground(new Color(255, 255, 255));
		formatLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		priceLabel = new JLabel("<dynamic>");
		priceLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setForeground(new Color(255, 255, 255));
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(artistLabel);
		panel.add(albumLabel);
		panel.add(releaseDateLabel);
		panel.add(GenreLabel);
		panel.add(rankLabel);
		panel.add(formatLabel);
		panel.add(priceLabel);


		upcLabel = new JLabel("<dynamic>");
		upcLabel.setHorizontalAlignment(SwingConstants.CENTER);
		upcLabel.setForeground(Color.WHITE);
		upcLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		upcLabel.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel.add(upcLabel);
		setLayout(null);
		add(imageLabel);
		add(infoPanel);
		add(logoLabel);
		add(btnNewSearch);

	}
	/**
	 * Returns the current chosen album
	 * @return
	 */
	public Music getCurrentAlbum() {
		return CurrentAlbum;
	}
	/**
	 * Writes the chosen album's information on the display labels and shows the album's image.
	 * @param uPC
	 * @throws IOException
	 */
	public void setCurrentAlbum(String uPC) throws IOException {
		List<Music> albums = db.getAlbumByUPC(uPC);
		Music currAlbum = albums.get(0);
		artistLabel.setText(currAlbum.getArtist());
		this.albumLabel.setText(currAlbum.getAlbumName());
		this.releaseDateLabel.setText(currAlbum.getReleaseDate());
		this.GenreLabel.setText(currAlbum.getGenre());
		this.rankLabel.setText(String.valueOf(currAlbum.getRank()));
		this.formatLabel.setText(currAlbum.getFormat());
		this.priceLabel.setText(String.valueOf(currAlbum.getPrice()));
		upcLabel.setText(uPC);

		BufferedImage logo = null;
		logo = ImageIO.read(new File(currAlbum.getAlbumImageName()));
		Image dimg = logo.getScaledInstance(imageLabel.getHeight(), imageLabel.getWidth(),
				Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(dimg));

	}
	/**
	 * hides the DisplayCDalbum panel
	 */
	void hideInfo() {
		infoPanel.setVisible(false);
	}
	/**
	 * Shows the DisplayCDAlbum panel
	 */
	void showInfo() {
		infoPanel.setVisible(true);
	}
}
