package de.hampelratte.plastik.theme;

import java.awt.Color;

public class DefaultColorTheme extends AbstractColorTheme {
	
	public DefaultColorTheme() {
		super();
		
		setColor(new Color(239, 239, 239), COMMON | BACKGROUND);
		setColor(new Color(239, 239, 239), COMMON | BACKGROUND | INACTIVE);
		
		setColor(new Color(  0,   0,   0), COMMON | FOREGROUND);
		setColor(new Color(  0,   0,   0), COMMON | FOREGROUND | INACTIVE);
		
		setColor(new Color(134,134,134), COMMON | BORDER);
		setColor(new Color(134,134,134), COMMON | BORDER | INACTIVE);
		
		setColor(new Color(100,200,100), COMMON | FOCUS);
		setColor(new Color(100,200,100), COMMON | FOCUS | INACTIVE);
		
		setColor(new Color(100,100,200), COMMON | ROLLOVER);
		setColor(new Color(100,100,200), COMMON | ROLLOVER | INACTIVE);
		
	}
	
}
