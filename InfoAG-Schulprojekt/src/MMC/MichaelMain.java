package MMC;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * Kleine eigene Klasse zum Testen der KP_Sound Klasse <p>
 * implementiert einen KeyListener zum Testen bei Tastendruck, z.B. ob Threaded funktioniert <p>
 * 
 * Jedoch fehlt eine Implementierung von dynamischer Pfad ansprache, d.h. wir müssen die .wav dateien
 * irgendwo speichern und den standardPath manuell ändern <p>
 * 
 * TODO: Dynamischer Pfad von z.B. eigener package, 2 mal Dateien abspielen können, Threaded abspielen
 * 
 * @author Michael_Kutowski
 */
public class MichaelMain extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;

	KS_Sound soundHandler = new KS_Sound();

	String standardPath = "C:/Users/Michi/Music/";
	String[] fileNames;
	
	public MichaelMain()
	{
		setBounds(100, 100, 300, 300);				//frame setzt position und größe vom fenster
		setTitle("InfoAG - Michael");				//titel für das Fenster
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//Default close
		setLayout(null);		//Layout null, müssen size von koponenten selbst setzen
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		fileNames = new String[2];
		fileNames[0] = "LeviathanPack_Prog_Synth.wav";
		fileNames[1] = "G#m_Bright_Chords.wav";	
	}
	
	public static void main(String[] args)
	{
		MichaelMain mainheader = new MichaelMain();			//Main() wird erstellt 
		mainheader.setVisible(true);			//mainheader wird sichtbar
	}

	@Override
	public void keyPressed(KeyEvent keypress) 
	{
		if (keypress.getKeyChar() == 's')
		{
			soundHandler.setFilePath(standardPath + fileNames[0]);
			soundHandler.playSingleSound();
		}
		else if (keypress.getKeyChar() == 'w')
		{
			soundHandler.setFilePath(standardPath + fileNames[1]);
			soundHandler.playSingleSound();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }
}
