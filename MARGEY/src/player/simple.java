package player;

import java.awt.event.*;  
import javax.sound.sampled.*;
import javax.swing.*; 
import java.io.*;
public class simple {  
public static void main(String[] args) 
{  
	try 
	{
		  AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/Users/George/Downloads/cash.wav"));
		  byte[] audioBytes = new byte[120000000];
		  audioInputStream.read(audioBytes);
		  AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 88200, 16, 1, 2, 44100.0f, false);
		  Clip clip = AudioSystem.getClip(); //generates a generic audio clip check API doc for more info
		  clip.open(format, audioBytes, 0, audioBytes.length);
		  clip.start();
		  Thread.sleep(clip.getMicrosecondLength());
	} 
	catch (Exception e) 
	{
		  System.out.println("woohoo");
	}    
}
}
