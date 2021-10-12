package player;

import javax.sound.sampled.*;

public class GAudioFormat extends AudioFormat { // Extension of AudioFormat with more setter methods
	
	public GAudioFormat(Encoding encoding, float sampleRate, int sampleSizeInBits, int channels, int frameSize,
			float frameRate, boolean bigEndian) 
	{
		super(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian);
	}
	
	public static GAudioFormat convert (AudioFormat a)
	{
		GAudioFormat gFormat = new GAudioFormat(a.getEncoding(), a.getSampleRate(), a.getSampleSizeInBits(),
				a.getChannels(), a.getFrameSize(), a.getFrameRate(), a.isBigEndian());
		return gFormat;
	}
	
	public void setBigEndian(boolean bigEndian)
	{
		this.bigEndian = bigEndian;
	}
	
	public void setSampleRate(float sampleRate)
	{
		this.sampleRate = sampleRate;
	}

}
