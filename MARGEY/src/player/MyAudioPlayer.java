package player;
/** A class containing methods to play and manipulate wav files.
 * George Paul 2019
 * 
 * 
 * 
 */
import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;

public class MyAudioPlayer {
	
	private Clip clip;
	private File file;
	//private Scanner sc;
	private JFileChooser fileChooser;
	private AudioInputStream audioInputStream;
	private int status; // 3 = Play, 2 = Pause, 1 = File Loaded, 0 = No file, -1 = Quit
	private byte[] audioBytes;
	private boolean isPlayingForward;
	private AudioFormat format;
	private GAudioFormat gFormat;
	private long byteLength, frameSize, frameLength, songLength, songPosition;
	private float originalSampleRate, sampleRate;
	
	public MyAudioPlayer() // Constructor initialises the filechooser object and sets default sample rate to 44100
	{
		//sc = new Scanner(System.in);
		fileChooser = new JFileChooser();
		sampleRate = 44100;
	}

	//Simple text based menu that takes input from the console.
//	public void menu() throws UnsupportedAudioFileException, IOException, LineUnavailableException
//	{
//		
//		while (status >= 0)
//		{
//			System.out.println("1:Play\r2:Pause\r3:Stop\r4:Pick file\r5:Quit");
//			int c = sc.nextInt();
//			switch (c)
//			{
//				case 1:
//					play();
//					break;
//			
//				case 2:
//					pause();
//					break;
//					
//				case 3:
//					stop();
//					break;
//				
//				case 4:
//					filePick();
//					break;
//					
//				case 5:
//					quit();
//					break;
//			}
//			
//		}
//	}
	/** Plays audio using clip.start.
	 * 
	 * 
	 */
	public void play()
	{
		if(status == 0)
		{
			System.out.println("Please pick a .wav file");
		}
		else
		{
			status = 3;
			clip.start();
		}		
	}
	
	/** Pauses audio using clip.stop.
	 * 
	 * 
	 */
	public void pause()
	{
		if(status == 0)
		{
			System.out.println("No file playing - please pick a .wav file");
		}
		else
		{
			status = 2;
			clip.stop();
		}
	}
	
	/** Stops audio and closes clip using clip.stop and clip.close.
	 * 
	 * 
	 */
	public void stop()
	{
		status = 0;
		clip.stop();
		clip.close();
	}
	
	/** Stops audio audio if playing then exits the program.
	 * 
	 * 
	 */
	public void quit()
	{
		if (status == 3)
	    {
	    	clip.stop();
	    	clip.close();
	    }
		status = -1;
		System.exit(0);
	}
	
	/** Choosing a file, converts to audioinputstream converts to bytes, opens clip
	 * 
	 * 
	 */
	public void filePick() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); // Sets default file location to user home.
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) // If a file is selected
		{
		    file = fileChooser.getSelectedFile(); 
		    if (status == 3) // If already playing audio, stop and close clip.
		    {
		    	clip.stop();
		    	clip.close();
		    }
		    status = 1;
		    
		    System.out.println("Selected file: " + file.getAbsolutePath());
		    
		    audioInputStream = AudioSystem.getAudioInputStream(file); 
		    frameLength = audioInputStream.getFrameLength(); // Get total number of frames in order to determine size of byte array needed.
		    
		    format = audioInputStream.getFormat();  
		    gFormat = GAudioFormat.convert(format); // Convert to GAudioFormat so to be able to use GFormat methods, see class GAudioFormat.
		    
		    
		    frameSize = gFormat.getFrameSize(); // Get size of frames to determine size of byte array.
		    byteLength = frameLength * frameSize;	
		    audioBytes = new byte[(int)byteLength];
		    
		    originalSampleRate = gFormat.getSampleRate(); // Get sample rate of file
		    gFormat.setSampleRate(originalSampleRate); // Set sample rate to current sample rate, selected on gui.
		    
		    isPlayingForward = true;
		   
		    System.out.println(gFormat);
			
			audioInputStream.read(audioBytes); // Streams into bytearray.
			
		    clip = AudioSystem.getClip(); // Creates clip
		    clip.open(gFormat, audioBytes, 0, (int)byteLength); // Reads byte array into clip
		    songLength = clip.getMicrosecondLength(); 
		}
	}
	
	/** Reverses audio file to play song backwards.
	 * 
	 * 
	 */
	public void reverse() throws LineUnavailableException
	{
		status = 2; //Sets status to pause so that line listener in GuiMenu dosent stop the song when audio stops.
		clip.stop();
		songPosition = clip.getMicrosecondPosition(); // Gets song position so can resume from same point
		clip.close();
//		byte[] audioBytesTemp = audioBytes;
//		
//		for(int i = audioBytesTemp.length - 1, j = 0; i >= 0; i--, j++)
//	    {
//	    	audioBytes[j] = audioBytesTemp[i];
//	    }
		
		byte temp;

		for(int i = 0; i < (audioBytes.length/2); i++) // Reverses byte array
		{
			temp = audioBytes[i];
			audioBytes[i] = audioBytes[audioBytes.length - i - 1];
			audioBytes[audioBytes.length - i - 1] = temp;
		}
		
	    isPlayingForward = !isPlayingForward;
	    gFormat.setBigEndian(!gFormat.isBigEndian());
	    
	    System.out.println(gFormat);
	    
		clip.open(gFormat, audioBytes, 0, (int)byteLength);
		clip.setMicrosecondPosition(songLength - songPosition);
	}
	
	/** Sets speed and pitch of playback by altering sample rate, takes an argument 
	 * 
	 * 
	 */
	public void setSpeed(float speedVal) throws LineUnavailableException
	{
		status = 2; // Sets status to pause so audio is not stopped by line listener
		
		songPosition = clip.getMicrosecondPosition();
		
		clip.stop();
		clip.close();
		
	    sampleRate = (originalSampleRate * ((speedVal)/ 100));
	    gFormat.setSampleRate(sampleRate);
	    
	    System.out.println(gFormat);
	    
		clip.open(gFormat, audioBytes, 0, (int)byteLength);
		clip.setMicrosecondPosition(songPosition);
		
	}
	
	public void setPosition(long sliderPosition) //Setting the song pos
	{
			System.out.println("SongPos:"+clip.getMicrosecondPosition());
			System.out.println("SliderPos:"+sliderPosition);
			clip.setMicrosecondPosition(sliderPosition);
	}
	
	public long getPosition()
	{
		return clip.getMicrosecondPosition();
	}
	
	public Clip getClip()
	{
		return clip;
	}
	
	public int getStatus() 
	{
		return status;
	}
	
	public long getSongLength()
	{
		return songLength;
	}
	
	public boolean getIsPlayingForward()
	{
		return isPlayingForward;
	}
	
//	private byte[] reverseBytes(byte[] audioBytes)
//	{
//		short[] shortArray = new short[audioBytes.length / 2];
//		short[] shortArrayRev = new short[audioBytes.length / 2];
//		byte [] audioBytesRev = new byte[shortArray.length * 2];
//		
//	    for (int i = 0 ; i < shortArray.length; i++)
//	    {
//	         //shortArray[i] = (short)(audioBytes[i*2] | (audioBytes[i*2 + 1] << 8));
//	         shortArray[i] = (short)((short)audioBytes[i*2] << 8 | (short)(audioBytes[i*2 + 1]));
//	    }
//	    
//	    for(int i = shortArray.length - 1, j = 0; i >= 0; i--, j++)
//	    {
//	    	shortArrayRev[j] = shortArray[i];
//	    }  
//
////	    for(int i = 0, j = 0; i < shortArrayRev.length; i++ , j += 2)
////	    {
////	    	audioBytesRev[j] = (byte) ((shortArrayRev[i] >> 8));
////	    	audioBytesRev[j + 1] = (byte) (shortArrayRev[i]);
////	    	
////	    }
//	    
//	    for(int i = 0, j = 0; i < shortArray.length; i++ , j += 2)
//	    {
//	    	audioBytesRev[j] = (byte) (shortArray[i]);
//	    	audioBytesRev[j + 1] = (byte) ((shortArray[i] >> 8));
//	    }
//	    
//		return audioBytesRev;
//	}
}
