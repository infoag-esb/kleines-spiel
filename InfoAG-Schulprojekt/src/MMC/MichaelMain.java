package MMC;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.JFrame;

/**
 * Kleine eigene Klasse zum Testen der KP_Sound Klasse <p>
 * implementiert einen KeyListener zum Testen bei Tastendruck, z.B. ob Threaded funktioniert <p>
 * 
 * TODO: Threaded abspielen / gleichzeitig abspielen lassen,
 * Auﬂerdem versuchen urls aus anderen pfaden (auﬂerhalb vom selben Package zur Ordnung
 * 
 * @author Michael_Kutowski
 */
public class MichaelMain extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;

	KS_Sound soundHandler = new KS_Sound();
	
	URL urlLeviathan, urlBright;
	
	public MichaelMain()
	{
		setSize(300, 300);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		urlLeviathan = getClass().getResource("/MMC/LeviathanPack_Prog_Synth.wav");
		urlBright = getClass().getResource("/MMC/G#m_Bright_Chords.wav");
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
			soundHandler.spieleSound(urlLeviathan);
		
		if (keypress.getKeyChar() == 'w')
			soundHandler.spieleSound(urlBright);
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }
}
