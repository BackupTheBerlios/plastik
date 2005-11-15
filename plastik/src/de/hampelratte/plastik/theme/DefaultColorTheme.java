package de.hampelratte.plastik.theme;

import java.awt.Color;

public class DefaultColorTheme extends AbstractColorTheme {
	
	public DefaultColorTheme() {
		super();
		
		setColor(new Color(200, 200, 200), COMMON | BACKGROUND);
		setColor(new Color(200, 200, 200), COMMON | BACKGROUND | INACTIVE);
		
		setColor(new Color(50,50,50), COMMON | FOREGROUND);
		setColor(new Color(50,50,50), COMMON | FOREGROUND | INACTIVE);
		
		setColor(new Color(100,100,100), COMMON | BORDER);
		setColor(new Color(100,100,100), COMMON | BORDER | INACTIVE);
		
		setColor(new Color(100,200,100), COMMON | FOCUS);
		setColor(new Color(100,200,100), COMMON | FOCUS | INACTIVE);
		
		setColor(new Color(100,100,200), COMMON | ROLLOVER);
		setColor(new Color(100,100,200), COMMON | ROLLOVER | INACTIVE);
		
	}
	
}
