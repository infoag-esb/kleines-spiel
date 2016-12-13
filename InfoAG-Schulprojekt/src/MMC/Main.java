/*
 InfoAG-Schulprojekt: Anfangsklasse erstellt von Michael Kutowski
 Kommentare sind nicht alle auf gleichen Tabma� wegen GitHub Anzeige- Kommentarisierung m�ssen wir besprechen-
 */

package MMC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Main Klasse f�r eine einfache Frame Erstellung zum Testen von GitHub */
public class Main extends JFrame implements ActionListener	
{
	private static final long serialVersionUID = 1L;	//default warnung nullen
	JButton testButton = new JButton("test");		//Button mit Text "test"
	JLabel testLabel = new JLabel();		//label komponent erstellt	
	
	public Main()
	{
		this.setBounds(100, 100, 300, 300);		//frame setzt position und gr��e vom fenster
		this.setTitle("InfoAG - master");		//titel f�r das Fenster
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		//Default close
		this.setLayout(null);		//Layout null, m�ssen size von koponenten selbst setzen
	
		testButton.setBounds(0, 0, 100, 100);		//position und Gr��e vom Button gesetzt
		testButton.addActionListener(this);		//listener hinzugef�gt
		
		testLabel.setBounds(100, 0, 100, 100);		//pos + size 
		testLabel.setText("einfacher Label");		//text vom label gesetzt
		
		this.add(testButton);		//button komponent wird zum frame geadded
		this.add(testLabel);		//label zum frame geadded
	}
	
	public static void main(String[] args)
	{
		Main mainheader = new Main();		//Main() wird erstellt 
		mainheader.setVisible(true);		//mainheader wird sichtbar
		
		System.out.println("Moin InfoAG!");		//test print
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == this.testButton)		//wenn actionevent == vom testbutton
			System.out.println("wurde Gedr�ckt");		//test print
	}
}
