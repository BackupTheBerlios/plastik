package de.hampelratte.plastik.theme;

import java.awt.Color;

public class DefaultColorTheme extends AbstractColorTheme {
	
	public DefaultColorTheme() {
		brighter =  18;
		darker   = -13;
		
		brighterMore = 100;
		darkerMore = -100;
		
		setButtonColor(
				new Color(220, 220, 225), // active background
				new Color(  0, 200,   0), // inactive backgound
				new Color(  0,   0, 200), // actove foreground
				new Color(200, 100,   0), // inactive foreground   
				new Color(200,   0, 100), // focus
				new Color(123, 123, 123)  // rollover
		); 
	}
	
}
