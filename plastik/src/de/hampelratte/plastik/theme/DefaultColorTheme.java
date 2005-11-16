package de.hampelratte.plastik.theme;

import java.awt.Color;

public class DefaultColorTheme extends AbstractColorTheme {
	
	public DefaultColorTheme() {
		super();
		
		// COMMON (must be set)
		setColor(new Color(239, 239, 239), COMMON | BACKGROUND                    );
		setColor(new Color(239, 239, 239), COMMON | BACKGROUND         | INACTIVE );
		setColor(new Color(  0,   0,   0), COMMON | FOREGROUND                    );
		setColor(new Color(  0,   0,   0), COMMON | FOREGROUND         | INACTIVE );
		setColor(new Color(134, 134, 134), COMMON | BORDER                        );
		setColor(new Color(134, 134, 134), COMMON | BORDER             | INACTIVE );
		setColor(new Color( 16,  16,  16), COMMON | FOCUS                         );
		setColor(new Color( 16,  16,  16), COMMON | FOCUS              | INACTIVE );
		setColor(new Color(103,	141, 178), COMMON | ROLLOVER                      );
		setColor(new Color(  0,   0,   0), COMMON | ROLLOVER           | INACTIVE );
		setColor(new Color(239, 239, 239), COMMON | BACKGROUND_PRESSED            );
		setColor(new Color(239, 239, 239), COMMON | BACKGROUND_PRESSED | INACTIVE );
		setColor(new Color(  0,   0,   0), COMMON | FOREGROUND_PRESSED            );
		setColor(new Color(  0,   0,   0), COMMON | FOREGROUND_PRESSED | INACTIVE );
		
		// BUTTON
		setColor(new Color(240, 230, 220), BUTTON | BACKGROUND                    );
		setColor(new Color(239,   0, 239), BUTTON | BACKGROUND_PRESSED            );
		
		
	}
	
}
