package de.hampelratte.plastik.theme;

import java.awt.Color;

public class DefaultColorTheme extends AbstractColorTheme {
	
	public DefaultColorTheme() {
		backgroundBrighter =  18;
		backgroundDarker   = -13;
		
		backgroundBrighterMore = 100;
		backgroundDarkerMore   = -100;
		
		setColors(
				new Color(220, 220, 225), // active background
				new Color(  0, 200,   0), // inactive backgound
				new Color(  0,   0, 200), // active foreground
				new Color(200, 100,   0), // inactive foreground   
				new Color(  0,   0, 200), // active border
				new Color(200, 100,   0), // inactive border;   
				new Color(200,   0, 100), // focus
				new Color(123, 123, 123)  // rollover
		);
	}
	
}
