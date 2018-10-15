package edu.pupr.musiclibrary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;// This uses the swl stuff. Check if compatible.

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;

// ------------------- SQL Extension ------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
// ------------------ SQL Extension -------------------------------------

import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

/**
* 
* Program description - The main menu frame presents the main area of the program where
* the user performs most of the program's functions
* 
*	History: 
*		03-02-2018 - Created the main menu. Added the toolbar. EM
*		03-04-2018 - Added the tabbed pane to the main menu. CS
*		03-05-2018 - Added the DisplayCDAlbum panel to the main menu. CS
*		03-17-2018 - Finished the project - CS
*
* @author Edwin
* @author Jonathan
* @author Wilfredo
* @author Cristian
* 
* 
*
*
*/
public class MainMenuFrame extends JFrame 
{
	private JTabbedPane tabbedPane;
	private JPanel cdPlaceHolderPanel;
	private JPanel cdInfoPanel;
	private JPanel albumReportTab;
	private displayCDAlbum displayCdPanel;
	private JPanel contentPane;
	private CardLayout cl_cdInfoPanel = new CardLayout();
	private Connection connection = null;
	private JTable reportTable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuFrame frame = new MainMenuFrame();
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
	public MainMenuFrame() {
		try {
			connection=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","userName","7minutes"); // Changed the user and password for security purposes.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setTitle("Project CD MUSIC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 575);
		/**
		 * menuBar - Barra de Menu donde todos los menuItems se encuentran para el usuario escojer que quiere hacer, si quiere a~adir, modificar, display una linea nada mas 
		 * o si quiere generar un reporte con todo los albums.
		 */
		JMenuBar menuBar = new JMenuBar(); // Here is the function ot do the File and Help bar
		setJMenuBar(menuBar);
		/**
		 * 	File - Aqui estan los submenus para que cuando el usuario presione una de las opciones de Add, Modify, Display, Report, se ejecucten los programas de los otros frames.
		 */
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		/**
		 * Add CD Album - Ejecuta el programa del frame de Add CD Album
		 */
		JMenuItem menuItem = new JMenuItem("1. Add CD Album");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddAlbum.main(null);
			}
		});
		menu.add(menuItem);
		/**
		 * Modify CD Album - Ejecuta el programa del frame de Modify CD Album
		 */
		JMenuItem menuItem_1 = new JMenuItem("2. Modify CD Album");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchFrame.main(null); // Executes the Search GUI Frame
			}
		});
		menu.add(menuItem_1);
		/**
		 * Display CD Album - Ejectua el programa del frame de Display CD Album.
		 */
		JMenuItem menuItem_2 = new JMenuItem("3. Display CD Album");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean fail = true;
				String upcEntry = JOptionPane.showInputDialog(null,"Enter the album's UPC:");
				while (fail) {
					try {
						if (upcEntry != null) {
							if (!upcEntry.isEmpty()) {
								tabbedPane.setSelectedIndex(1);
								cl_cdInfoPanel.show(cdInfoPanel, "2");
								displayCdPanel.setCurrentAlbum(upcEntry);
								fail = false;
							}
						}
						fail = false;
					} catch (IOException e) {
						upcEntry = JOptionPane.showInputDialog(null,"Error. Enter the album's UPC:");
					} catch (Exception e) {
						upcEntry = JOptionPane.showInputDialog(null,"Error. Enter the album's UPC:");
					} 
				}
			}
		});
		menu.add(menuItem_2);
		/**
		 * Report CD Album - Ejecuta el programa del frame de Report CD Album.
		 */
		JMenuItem menuItem_3 = new JMenuItem("4. Display Album Report");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean fail = true;
				while (fail) {
					try {
								tabbedPane.setSelectedIndex(0);
								cl_cdInfoPanel.show(cdInfoPanel, "1");
								fail = false;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Unknown error has occured");
						System.exit(0);
					} 
				}
			}
		});
		menu.add(menuItem_3);
		
		/**
		 * Exit - Boton que el usuario presiona para salir del programa completamente. Cuando lo presiona aparecera un "show dialog box" preguntando si estas seguro que 
		 * quiere salir del programa. Si el usuario presiona "Ok", termina el programa.
		 */
		JMenuItem Exit_MenuItem = new JMenuItem("Exit");
		Exit_MenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event) 
			{
				if(JOptionPane.showConfirmDialog(MainMenuFrame.this, "Confirm if you want to exit","File SubMenu Warning",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}
			}
		});
		menu.add(Exit_MenuItem);
		
		/**
		 * 	Help - Aqui estan los submenus para que cuando el usuario quiere saber como funciona el programa, ejecute uno de los dos frames de ayuda para el usuario.
		 */
		JMenu menu_1 = new JMenu("Help");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("Help Contents");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpContentsFrame.main(null);
			}
		});
		
		menu_1.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("About");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutFrame.main(null);
			}
		});
		menu_1.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Initializes the tabbed pane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		albumReportTab = new JPanel();
		tabbedPane.addTab("Album Report", null, albumReportTab, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton button = new JButton("Load Albums Data...");
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0, 0, 128));
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buildReportTable();
			}
		});
		
		//Initialize the report table.
		reportTable = new JTable();
		reportTable.setForeground(new Color(255, 255, 255));
		reportTable.setBackground(new Color(0, 0, 128));
		reportTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//labels for the table's columns
		JLabel label = new JLabel("UPC");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("Name");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("Artist");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblImagenName = new JLabel("Image");
		lblImagenName.setForeground(new Color(255, 255, 255));
		lblImagenName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("Genre");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_5 = new JLabel("Date");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_6 = new JLabel("Rank");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_7 = new JLabel("Format");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_8 = new JLabel("Price");
		label_8.setForeground(new Color(255, 255, 255));
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(reportTable, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addGap(56)
							.addComponent(label_1)
							.addGap(42)
							.addComponent(label_2)
							.addGap(42)
							.addComponent(lblImagenName)
							.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
							.addComponent(label_4)
							.addGap(41)
							.addComponent(label_5)
							.addGap(49)
							.addComponent(label_6)
							.addGap(47)
							.addComponent(label_7)
							.addGap(34)
							.addComponent(label_8)
							.addGap(61))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(lblImagenName)
						.addComponent(label_7)
						.addComponent(label_5)
						.addComponent(label_4)
						.addComponent(label_6)
						.addComponent(label_8))
					.addGap(18)
					.addComponent(reportTable, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(button)
					.addGap(46))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_albumReportTab = new GroupLayout(albumReportTab);
		gl_albumReportTab.setHorizontalGroup(
			gl_albumReportTab.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
		);
		gl_albumReportTab.setVerticalGroup(
			gl_albumReportTab.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
		);
		albumReportTab.setLayout(gl_albumReportTab);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
		);
		
		cdInfoPanel = new JPanel();
		tabbedPane.addTab("CD Album Info", null, cdInfoPanel, null);
		cdInfoPanel.setLayout(cl_cdInfoPanel);
		
		cdPlaceHolderPanel = new JPanel();
		cdPlaceHolderPanel.setBackground(new Color(0, 0, 255));
		cdInfoPanel.add(cdPlaceHolderPanel, "1");
		
		//displays the cd album
		displayCdPanel = new displayCDAlbum();
		cdInfoPanel.add(displayCdPanel, "2");
		
		JButton btnEnterAUpc = new JButton("Enter a UPC to show an album's information.");
		btnEnterAUpc.setForeground(new Color(255, 255, 255));
		btnEnterAUpc.setBackground(new Color(0, 0, 128));
		btnEnterAUpc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean fail = true;
				while (fail) {
					String upcEntry = JOptionPane.showInputDialog(null, "Enter the album's UPC.");
					try {
						if (upcEntry != null) {
							if (!upcEntry.isEmpty()) {
								cl_cdInfoPanel.show(cdInfoPanel, "2");
								displayCdPanel.setCurrentAlbum(upcEntry);
								fail = false;
							}
						}
						fail = false;
					} catch (HeadlessException e) {
						upcEntry = JOptionPane.showInputDialog(null, "Error, Enter the album's UPC.");
						// TODO Auto-generated catch block
					} catch (IOException e) {
						// TODO Auto-generated catch block
						upcEntry = JOptionPane.showInputDialog(null, "Error, Enter the album's UPC.");
					} catch (Exception e) {
						upcEntry = JOptionPane.showInputDialog(null, "Error, Enter the album's UPC.");
					} 
				}
			}
		});
		GroupLayout gl_cdPlaceHolderPanel = new GroupLayout(cdPlaceHolderPanel);
		gl_cdPlaceHolderPanel.setHorizontalGroup(
			gl_cdPlaceHolderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_cdPlaceHolderPanel.createSequentialGroup()
					.addContainerGap(267, Short.MAX_VALUE)
					.addComponent(btnEnterAUpc)
					.addGap(263))
		);
		gl_cdPlaceHolderPanel.setVerticalGroup(
			gl_cdPlaceHolderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cdPlaceHolderPanel.createSequentialGroup()
					.addGap(209)
					.addComponent(btnEnterAUpc, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(214, Short.MAX_VALUE))
		);
		cdPlaceHolderPanel.setLayout(gl_cdPlaceHolderPanel);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * Builds the report table by querying the database.
	 */
	public void buildReportTable() {
		String query = "SELECT * FROM ALBUMS.MUSIC";
		ResultSet rs;
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		reportTable.setModel(DbUtils.resultSetToTableModel(rs));
	}
}
