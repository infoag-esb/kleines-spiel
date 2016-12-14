package MMC;

import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Mixer;

/** 
 * Projekt Kleines Spiel - Sound Klasse <p> 
 * 
 * Spielt AudioFiles von jeglicher Größe ab und wartet bis diese enden (threaded) <p>
 * Kann Audio Mixer listen zum Debuggen
 * 
 * @author Michael_Kutowski 
 * */
public class KS_Sound
{
	/** Spielt eine File ab, zählt dabei Bytes runter und kann dadurch lange Dateien abspielen */
	public void spieleSound(URL PfadURL)	
	{
		try		
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream( PfadURL );	//AudioEingabe erstellt mit File
					
			AudioFormat format = audioIn.getFormat();	//Format vom File erkannt
			DataLine.Info info = new DataLine.Info(Clip.class, format);	
				
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioIn);			//clip öffnet AudioInputStream Datei
			audioClip.start();					//audio daten gestreamt
			
			
			do	/* Solange clip läuft wartet thread */
			{
			    try 
			    {
			    	Thread.sleep(1000);
			    } 
			    catch ( InterruptedException ie ) { ie.printStackTrace(); }
			} while ( audioClip.isActive() );
			
			
		    audioClip.close();	//nach Ende wird stream Line geschlossen
		} 
		catch (Exception e) { e.printStackTrace(); }	//Wenn irgendein Fehler - Output
	}
	
	/** Listet alle Mixer Line Outputs, manchmal wichtig zum Debuggen */
	public void zeigeMixers()
	{
		Mixer.Info[] mixers = AudioSystem.getMixerInfo();	//alle Mixer Line Outputs in Array gesetzt
		 
		for (Mixer.Info mixerInfo : mixers)	//for each loop, checkt Array durch
		    System.out.println(mixerInfo);
	}
}
