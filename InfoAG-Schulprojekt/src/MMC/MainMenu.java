package MMC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Simples Menü Konzept mit einem Button Array <p>
 * Die Buttons haben alle Events <p>
 * Zusätze zu Optionen usw nötig, Regler sonstiges
 * 
 * @author Michael Kutowski
 */
public class MainMenu extends JFrame implements ActionListener
{
	
	asddasd
	private static final long serialVersionUID = 1L;

	final Dimension frameSize = new Dimension(800, 600);
	final JButton[] buttons = new JButton[4];
	final Sound sounds = new Sound();
	
	public MainMenu() 
	{
		setTitle("Hauptmenü");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameSize.width, frameSize.height);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		for (int i = 0; i < buttons.length; i++) 
			buttons[i] = createButton(i);
				
		initState();
	}
	
	public static void main(String[] args) 
	{
		new MainMenu();
	}
	
	public JButton createButton(int ypos)
	{
		int labelHeight = 50;
		JButton neuerButton = new JButton();
		neuerButton.setFont(new Font("Arial", Font.BOLD, 36));
		neuerButton.setBounds(frameSize.width / 2 - 90, 200 + ypos * labelHeight, 200, labelHeight);
		neuerButton.addActionListener(this);
		neuerButton.setBackground(Color.white);
		add(neuerButton);
		
		return neuerButton;
	}

	public void initState() 
	{	
		for (int i = 0; i < buttons.length; i++) 
			buttons[i].setVisible(true);
		
		buttons[0].setText("Spielen");
		buttons[1].setText("Optionen");
		buttons[2].setText("Exit");
		buttons[3].setText("Zurück");
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if (event.getSource() == buttons[0])
		{
			LevelDesign1 level = new LevelDesign1(1);	//start levelDesign
			level.setVisible(true);
		}
		
		else if (event.getSource() == buttons[1])
			for (int i = 0; i < buttons.length - 1; i++) 
				buttons[i].setVisible(false);
	
		else if (event.getSource() == buttons[2])
		{	
			sounds.spieleSound("schiff_schuss_pew1");
			this.dispose();
		}
		else if (event.getSource() == buttons[3])
			this.initState();
		
	}
}
