/**
 * @(#)Light.java
 *
 *
 * @author 
 * @version 1.00 2017/2/19
 */

//Swing GUI components
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

//AWT package GUI details
import java.awt.Color;
import java.awt.Dimension;


/**
 * Implements a Light object for the game. The lights
 * in the game Lights Out are buttons that can be either
 * on or off. Once a Light (button) is clicked, it should
 * toggle that light on/off. This class will represent an
 * individual Light in the game. 
 * <p>
 * An individual light has no awareness of other lights in
 * the game, thus all the light should be able to do is 
 * switch itself on/off, it has no ability to effect other
 * lights inside the game.
 * <p>
 * A light is a button in the game, thus we are extending
 * the JButton class so a Light has the same abilities as
 * a JButton.
 *
 */
public class Light extends JButton {
	
	/** Size of a Light will be size of one cell in LightGrid */
	public static final int SIZE = LightGrid.SIZE / LightGrid.CELLS;
	
	/** Color of Light when it is OFF */             
	public static final Color OFF = new Color(208,6, 181);/***purple CHOOSE COLOR TO INDICATE LIGHT IS OFF ***/
	/** Color of Light when it is ON */        
	public static final Color ON = new Color(253, 183, 243); /*** light purple CHOOSE COLOR TO INDICATE LIGHT IS ON ***/
	
	/** Border to appear "raised" when light is off (not pressed) */
	public static final BevelBorder OFF_BORDER = new BevelBorder(BevelBorder.RAISED, new Color(114, 111, 113)/*** grey CHOOSE 1ST COLOR FOR BORDER ***/ , new Color(198, 194, 199)/*** grey CHOOSE 2ND COLOR FOR BORDER ***/ );
	/** Border to appear "pressed" when light is on */
	public static final BevelBorder ON_BORDER = new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(141, 0, 70));   // white & redish
	
	
	/** Switch to determine if light is on */
	private boolean isOn;
	
	
	
	/**
	 * Creates a new Light for the game. The starting state
	 * of a Light has background color set to the off color,
	 * the border set to the off border, and switch should be
	 * set to off.
	 * <p>
	 * A Light will be instantiated inside of a grid layout.
	 * Therefore, it is important to set the preferred size
	 * to a Dimension to a square with given size above.
	 * 
	 */
	public Light()
	{
		
		/********************************************************
		 * Correctly set up the background of the Light, set	*
		 * the border of the Light, set the opaque to true,		*
		 * start the Light is the 'off' state, and size a 		*
		 * Light will be placed inside a layout manager			*
		 * (GridLayout in the grid) set the preferred size		*
		 * of the Light correctly.								*
		 ********************************************************/
		

		this.setBackground(OFF);
		this.setBorder(OFF_BORDER);
		this.setOpaque(true);
		this.isOn = false; 
		this.setSize(SIZE, SIZE);
	}

	/**
	 * Returns true if the light is on
	 *
	 * @return	true when light is on
	 *
	 */
	public boolean isOn()
	{
		return this.isOn;
	}
	
	/**
	 * Change the state of the Light from on
	 * to off, or vice versa. When making the
	 * switch this method also correctly sets
	 * the color and border for the button.
	 *
	 */
	public void toggle()
	{
		
		/********************************************
		 * Correctly switch the state of the light	*
		 * and update the color and border			*
		 ********************************************/
		if ( this.isOn()) {
			this.turnOff();
		}
		else if (!(this.isOn())) {
			 this.isOn = true;
			 this.setBackground(ON);
			 this.setBorder(ON_BORDER);
		}
	}
	
	/**
	 * Changes state of the Light to off. Used
	 * mainly for reseting the game when the
	 * reset button is clicked.
	 *
	 */
	public void turnOff()
	{
		
		/********************************************
		 * Correctly switch the button to the off	*
		 * state and set color and border			*
		 ********************************************/
		 this.isOn = false;
		 this.setBackground(OFF);
		 this.setBorder(OFF_BORDER);
	}
	
}