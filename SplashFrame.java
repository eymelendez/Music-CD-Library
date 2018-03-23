package edu.pupr.musiclibrary;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Description: This class creates a splash screen with a gif.
 * Date: 03/17/2018
 * 
 * @author Johnathan
 * @author Edwin
 * @author Wilfredo 
 * @author Cristian
 */
public class SplashFrame
{
	private JFrame splash;
	private static Timer t;
	private static ActionListener al;
	static JProgressBar progressBar;
	private static int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashFrame window = new SplashFrame();
					window.splash.setVisible(true);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					window.splash.setLocation(dim.width/2-window.splash.getSize().width/2, dim.height/2-window.splash.getSize().height/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SplashFrame() 
	{	
		initialize();
		t.start();

	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		splash = new JFrame();
		splash.setUndecorated(true);
		splash.setForeground(Color.BLACK);
		splash.setBackground(Color.BLACK);
		splash.setTitle("Loading...");
		splash.setBounds(100, 100, 481, 248);
		splash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		splash.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(0, 219, 480, 30);
		splash.getContentPane().add(progressBar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SplashFrame.class.getResource("/deadpool.gif")));
		label.setBounds(0, 0, 480, 249);
		splash.getContentPane().add(label);
		
		al = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event) 
			{

				if(count < 100)
				{
					progressBar.setValue(count + 10);
					count = count + 10;
				}
				else
				{
					t.stop();
					LoginFrame logIn = new LoginFrame();
					LoginFrame.main(null);
					splash.dispose();
				}
				
			}
		};
		
		
		t = new Timer(600, al);					
	}
}