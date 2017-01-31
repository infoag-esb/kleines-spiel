package MMC;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

//Info AG | David Ronschka

public class LevelDesign1 extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	Sound sounds = new Sound();
	
	JButton button = new JButton("Test");
	public JButton[][] buttons = new JButton[200][200]; 
	public Dimension screenSize = new Dimension(); 
	public int screenHeight, screenWidth, buttonAmountCol, buttonAmountRow; 
	
	public static void main(String[] args)
	{
		LevelDesign1 level = new LevelDesign1();	//start levelDesign
		level.setVisible(true);
	}
	
	public LevelDesign1()
	{
		System.out.println("ay ay captain"); //Test-print
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //save screensize in Dimension class
		this.setSize(screenSize); 
		this.setTitle("InfoAG - Galaxienebene");	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setLayout(null);
		
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();
		
		grid();
	}
	
	public void grid()
	{
		Integer counter = 0;   
		
		int generalButtonSize = 70; //changes the button bounds (<10 requires a bigger array)
		int buttonPossibility = 10; //changes the possibility how often a button will be generated (bigger --> fewer)
		
		//save the amount of buttons in a public variable
		buttonAmountCol = screenHeight/generalButtonSize; 
		buttonAmountRow = screenWidth/generalButtonSize;
		
		for(int col = 0; col < buttonAmountCol; col++) //create as many columns as buttons fit in the screenheight 
		{
			for(int row = 0; row < buttonAmountRow; row++) //create for each column a row which contains as many buttons as fit in screenwidth
			{
				int random = new Random().nextInt(buttonPossibility ); //generate a random number 0 - "buttonPossibility" 
				counter++;
				
				if(random == 0) //if the random is zero -> create button
				{
					buttons[row][col] = new JButton(counter.toString()); 
					buttons[row][col].setBounds(row*generalButtonSize, col*generalButtonSize, generalButtonSize, generalButtonSize); //create a button with "generalButtonSize" proportions 	
					buttons[row][col].addActionListener(this);
					this.add(buttons[row][col]); 
				}
	
			}
		}
		//if (buttons[0][0] != null)
		//	buttons[0][0].setText("Test");
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		for(int i = 0; i < buttonAmountCol; i++)
		{	
			for(int j = 0; j < buttonAmountRow; j++)
			{
				if(event.getSource() == buttons[i][j])		//button click
				{
					System.out.println("wurde Gedrückt");		//debug print
					sounds.spieleSound("schiff_schuss_pew1");
			
				}
			}
		}	
	}
	
}
