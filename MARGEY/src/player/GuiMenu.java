package player;

import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.*;

public class GuiMenu {
	
	//MyAudioPlayer m;
	float speedVal;
	JFrame f;
	JButton play, pause, stop, fChoose, quit, reverse, forward; 
	JSpinner speed;
	JSlider position;
	Timer timer;
	
	MyAudioPlayer m = new MyAudioPlayer();
	
	public GuiMenu()
	{
//		try
//		{
//			m = new MyAudioPlayer();
//		}
//		catch (Exception ex)
//		{
//			
//		}
		
	}

	public void myGuiMenu() 
	{

		f = new JFrame("Menu - Audio Player");
		
		play = new JButton("Play", reScale("C:/Users/George/git/repository/MARGEY/src/player/play_0.05.jpg"));
		pause = new JButton("Pause", reScale("C:/Users/George/git/repository/MARGEY/src/player/pause_0.05.jpg"));
		stop = new JButton("Stop", reScale("C:/Users/George/git/repository/MARGEY/src/player/stop_0.05.jpg"));
		fChoose = new JButton("Choose file", reScale("C:/Users/George/git/repository/MARGEY/src/player/new_file_0.05.jpg"));
		quit = new JButton("Quit", reScale("C:/Users/George/git/repository/MARGEY/src/player/quit_0.05.jpg"));
		reverse = new JButton("Play backwards");
		forward = new JButton("Play forwards");
		
		
		SpinnerNumberModel spinModel = new SpinnerNumberModel(100, 1, 200, 5); // Spinner for audio speed
		speed = new JSpinner(spinModel);
		JLabel speedLabel = new JLabel("Speed%");
		//speedLabel.setLabelFor(speed);
		
//		int songLength = (int) m.getSongLength();
//		System.out.println(songLength);
		position = new JSlider(0,100,0);
		
		timer = new Timer(1000, new ActionListener() //Timer that checks the song position and to update the slider
		{
		      public void actionPerformed(ActionEvent e) 
		      {
		    	  if (m.getIsPlayingForward())
		    	  {
		    		  position.setValue((int) m.getPosition());
			    	  //System.out.println(m.getPosition());
		    	  }
		    	  else
		    	  {
		    		  position.setValue((int) (m.getSongLength() - m.getPosition()));
		    	  }
		    	  
		      }
		});
		
		//Adding buttons to GUI
		play.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			 	m.play();
			 	buttonsPlay();
			 	try {
					Process process = Runtime.getRuntime().exec("EventCreate /t INFORMATION /id 123 /l APPLICATION /so Java /d \"PLAY\"");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//play.setMnemonic(KeyEvent.VK_SPACE);
		
		pause.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				m.pause();
				buttonsPause();
				try {
					Process process = Runtime.getRuntime().exec("EventCreate /t INFORMATION /id 123 /l APPLICATION /so Java /d \"PAUSE\"");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		stop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				m.stop();
				buttonsStop();
				timer.stop();
				try {
					Process process = Runtime.getRuntime().exec("EventCreate /t INFORMATION /id 123 /l APPLICATION /so Java /d \"STOP\"");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		fChoose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					m.filePick();
					f.remove(position);
					setSlider();
					Process process = Runtime.getRuntime().exec("EventCreate /t INFORMATION /id 123 /l APPLICATION /so Java /d \"FILE\"");
				}
				
				catch (UnsupportedAudioFileException ex)
				{
					System.out.println("Error - Unsupported file");
				}
				catch (IOException ex1)
				{
					System.out.println("Error - IO");
				}
				catch (LineUnavailableException ex2)
				{
					System.out.println("Error - Line Unavailable");
				}
				
				if(m.getStatus() == 1)
				{
				buttonsFChoose();
				}
				
				timer.start();
				
				//Resets buttons at end of the song
				m.getClip().addLineListener(new LineListener()
				{
					public void update(LineEvent event) 
					{
						if ((event.getType() == LineEvent.Type.STOP) && m.getPosition() == m.getSongLength()) 
						{
							m.stop();
							buttonsStop();
						}
					}
				});
			}
		});
		
		reverse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					if(m.getStatus() == 3)
					{
						m.reverse();
						m.play();
					}
					else
					{
						m.reverse();
					}
					
					Process process = Runtime.getRuntime().exec("EventCreate /t INFORMATION /id 123 /l APPLICATION /so Java /d \"REVERSE\"");
				}
				
				catch (LineUnavailableException | IOException ex2)
				{
					System.out.println("Error - Line Unavailable");
				}
				
				buttonsReverse();
			}
		});
		
		forward.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					if(m.getStatus() == 3)
					{
						m.reverse();
						m.play();
					}
					else
					{
						m.reverse();
					}
					
					Process process = Runtime.getRuntime().exec("EventCreate /t INFORMATION /id 123 /l APPLICATION /so Java /d \"FORWARD\"");
				}
				
				catch (LineUnavailableException | IOException ex2)
				{
					System.out.println("Error - Line Unavailable");
				}
				
				buttonsForward();
			}
		});
		
		speed.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent e)
			{
				try
				{
					speedVal = (float)(int) speed.getValue();
					if (m.getStatus() == 3)
					{
						m.setSpeed(speedVal);
						m.play();
					}
					else
					{
						m.setSpeed(speedVal);
					}
					
					Process process = Runtime.getRuntime().exec("EventCreate /t INFORMATION /id 123 /l APPLICATION /so Java /d \"SPEED\"");
				}
				
				catch (LineUnavailableException | IOException ex)
				{
					System.out.println("Speed error");
				}
			}
		});
		
		quit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				m.quit();
				
				try {
					Process process = Runtime.getRuntime().exec("EventCreate /t INFORMATION /id 123 /l APPLICATION /so Java /d \"PLAY\"");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		//
		play.setEnabled(false);
		pause.setEnabled(false);
		stop.setEnabled(false);
		reverse.setEnabled(false);
		forward.setEnabled(false);
		speed.setEnabled(false);
		position.setEnabled(false);
		
		//Setting bounds for GUI
		play.setBounds(0,0,100,100);
		pause.setBounds(100,0,100,100);
		stop.setBounds(200,0,100,100);
		fChoose.setBounds(300,0,100,100);
		quit.setBounds(400,0,100,100);
		reverse.setBounds(0,100,250,100);
		forward.setBounds(250,100,250,100);
		position.setBounds(0,240,500,20);
		
		speed.setBounds(252, 210, 40, 25);
		speedLabel.setBounds(206,210,50,25);
		
		f.add(play);
		f.add(pause);
		f.add(stop);
		f.add(fChoose);
		f.add(quit);
		f.add(reverse);
		f.add(forward);
		f.add(position);
		
		f.add(speed);
		f.add(speedLabel);
		
		f.setSize(516,300);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	//Enabling /disabling buttons depending on play mode
	private void buttonsPlay()
	{
		play.setEnabled(false);
		pause.setEnabled(true);
		stop.setEnabled(true);
	}
	
	private void buttonsPause()
	{
		play.setEnabled(true);
		pause.setEnabled(false);
		stop.setEnabled(true);
	}
	
	private void buttonsStop()
	{
		play.setEnabled(false);
		pause.setEnabled(false);
		stop.setEnabled(false);
		reverse.setEnabled(false);
		forward.setEnabled(false);
		position.setEnabled(false);
	}
	
	private void buttonsFChoose()
	{
		play.setEnabled(true);
		pause.setEnabled(false);
		stop.setEnabled(false);
		reverse.setEnabled(true);
		forward.setEnabled(false);
		speed.setEnabled(true);
		position.setEnabled(true);
	}
	
	private void buttonsReverse()
	{
		reverse.setEnabled(false);
		forward.setEnabled(true);
	}
	
	private void buttonsForward()
	{
		reverse.setEnabled(true);
		forward.setEnabled(false);	
	}
	
	//Method to rescale button images to right size
	private ImageIcon reScale(String filepath)
	{
		ImageIcon icon = new ImageIcon(filepath);
		Image image = icon.getImage().getScaledInstance(112, 100, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);
		
		return icon;
	}
	
	
	//Method to set slider to current songpos
	private void setSlider()
	{
		position = new JSlider(0, (int) m.getSongLength(), 0);
		f.add(position);
		position.setBounds(0,240,500,20);
		
		position.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent e)
			{
				if (m.getIsPlayingForward() && (m.getPosition() < position.getValue() - 100000 
						|| m.getPosition() > position.getValue() + 100000))
				{
					m.setPosition(position.getValue());
				}
				if (!m.getIsPlayingForward() && (m.getSongLength() - m.getPosition() < position.getValue() - 100000
						|| m.getSongLength() - m.getPosition() > position.getValue() + 100000))
				{
					m.setPosition(m.getSongLength() - position.getValue());
				}
			}
		});
	}
	
	
}
