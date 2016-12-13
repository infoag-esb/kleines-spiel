package MMC;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.Mixer;

/** 
 * Projekt Kleines Spiel - Sound Klasse <p> 
 * 
 * Spielt AudioFiles von jeglicher Größe ab und wartet bis diese enden (threaded) <p>
 * Kann Audio Mixer listen zum Debuggen
 * 
 * @author Michael_Kutowski 
 * */
public class KS_Sound implements LineListener
{
	private File audioFile = null;
	private boolean fileFinishedReading = false;

	/** 
	 * Setzt Pfad durch einen gegebenen String.
	 * <p>
	 * ACHTUNG: .Wav Format kann auf spezifischen AudioSystemen Fehler geben. <p>
	 * wav mit: PCM_SIGNED 44100.0 Hz, 16 bit, stereo, 4 bytes/frame, little-endian
	 * */
	public void setFilePath(String path)
	{
		audioFile = new File(path);
	}
	
	/** Spielt eine File ab, zählt dabei Bytes runter und kann dadurch lange Dateien abspielen */
	public void playSingleSound()	
	{
		try		
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);	//AudioEingabe erstellt mit File
					
			AudioFormat format = audioIn.getFormat();	//Format vom File erkannt
					
			/* !sehr wichtig! benutzt erkanntes Format und Clip, erstellt neue LINE für audioAusgang */
			DataLine.Info info = new DataLine.Info(Clip.class, format);	
				
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			
			audioClip.addLineListener(this);	//Listener zum Zustand Erkennen von audioClip
			audioClip.open(audioIn);			//clip öffnet AudioInputStream Datei
			audioClip.start();					//audio daten gestreamt
					
			/* Solange File nicht zuende ist, stoppt sleep nicht */
			while (!fileFinishedReading) 
			{
			    try 
			    {
			    	Thread.sleep(1000);
			    } 
			    catch (InterruptedException ie) { ie.printStackTrace(); }
			}
		    audioClip.close();	//nach Ende wird stream Line geschlossen
		} 
		catch (Exception e) { e.printStackTrace(); }	//Wenn irgendein Fehler - Output
	
	}
	
	/** 
	 * Listet alle Mixer Line Outputs, manchmal wichtig zum Debuggen 
	 */
	public void displayMixers()
	{
		Mixer.Info[] mixers = AudioSystem.getMixerInfo();	//alle Mixer Line Outputs in Array gesetzt
		 
		for (Mixer.Info mixerInfo : mixers)	//for each loop, checkt Array durch
		    System.out.println(mixerInfo);
	}
	
	/* Überprüft die Lage der Lines ~ setzt playSound() */
	@Override
	public void update(LineEvent event) 
	{
		LineEvent.Type type = event.getType();	//type init
        
        if (type == LineEvent.Type.START) 
        {		
            System.out.println("Playback started.");   
        } 
        else if (type == LineEvent.Type.STOP) 
        {
        	fileFinishedReading = true;
            System.out.println("Playback completed.");
        } 
	}
}
