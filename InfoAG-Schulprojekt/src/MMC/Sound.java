package MMC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Mixer;

/** 
 * Projekt Kleines Spiel - Sound Klasse <p> 
 * 
 * Spielt AudioFiles ab, egal welcher länge, auch looped <p>
 * Diese sind nun abbrechbar und können übereinander gespielt werden<p>
 * Hat standard URLs in einem ansprechbaren URL[], welche gezeigt werden können <p>
 * Kann Audio Mixer listen zum Debuggen<p>
 * 
 * @author Michael_Kutowski 
 * */
public class Sound
{
	protected float gain = 0;
	protected File resFiles[];
	
	/*init von File array, dieser wird dynamisch gesetzt*/
	public Sound() 
	{
		//File Array wird ersetzt durch Oberordner Array
		resFiles = new File("res").listFiles();
	}

	/**zeigt alle Pfade im Array an, damit man im spieleSound den richtigen Index wählen kann*/
	public void zeigePfade()
	{
		for (Integer i = 0; i < resFiles.length; i++)
			System.out.println(i.toString() + " - " + resFiles[i].getName());
	}

	/** simple Sound Ausgabe, kann überlappend gespielt werden, lautstaerke kann vorher gestellt werden */
	public void spieleSound(int URLIndex) 
	{
		try		
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream( resFiles[URLIndex] );	//AudioEingabe erstellt mit File
			
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(audioIn);			//clip öffnet AudioInputStream Datei
			
			FloatControl volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			volumeControl.setValue(gain); 
			
			audioClip.start();					//audio daten gestreamt
		}
		catch (Exception e) { e.printStackTrace(); }	//Wenn irgendein Fehler - Output
	}
	
	/** Wiedergabe von .wav Datei, exakt wie spieleSound(), aber looped*/
	public void spieleLoopedSound(int URLIndex)	
	{
		try		
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream( resFiles[URLIndex] );	//AudioEingabe erstellt mit File
			
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(audioIn);			//clip öffnet AudioInputStream Datei
			
			FloatControl volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			volumeControl.setValue(gain); 
			
			audioClip.start();					//audio daten gestreamt
			audioClip.loop(Clip.LOOP_CONTINUOUSLY);
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
	
	/** Lokale Variable wird auf parameter eingestellt */
	public void setzeLautstaerke(int neueLautstaerke)
	{
		gain = neueLautstaerke;
	}
}
