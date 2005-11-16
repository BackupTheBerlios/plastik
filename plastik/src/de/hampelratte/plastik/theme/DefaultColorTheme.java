package de.hampelratte.plastik.theme;

import java.awt.Color;

public class DefaultColorTheme extends AbstractColorTheme {
	
	public DefaultColorTheme() {
		super();
		
		// COMMON (must be set)
		setColor(239, 239, 239, COMMON | BACKGROUND                          );
		setColor(239, 239, 239, COMMON | BACKGROUND               | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND                          );
		setColor(  0,   0,   0, COMMON | FOREGROUND               | INACTIVE );
		setColor(134, 134, 134, COMMON | BORDER                              );
		setColor(134, 134, 134, COMMON | BORDER                   | INACTIVE );
		setColor( 16,  16,  16, COMMON | FOCUS                               );
		setColor( 16,  16,  16, COMMON | FOCUS                    | INACTIVE );
		setColor(103, 141, 178, COMMON | ROLLOVER                            );
		setColor(  0,   0,   0, COMMON | ROLLOVER                 | INACTIVE );
		setColor(239, 239, 239, COMMON | BACKGROUND_PRESSED                  );
		setColor(239, 239, 239, COMMON | BACKGROUND_PRESSED       | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND_PRESSED                  );
		setColor(  0,   0,   0, COMMON | FOREGROUND_PRESSED       | INACTIVE );
		setColor(239, 239, 239, COMMON | BACKGROUND_TEXT                     );
		setColor(239, 239, 239, COMMON | BACKGROUND_TEXT          | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND_TEXT                     );
		setColor(  0,   0,   0, COMMON | FOREGROUND_TEXT          | INACTIVE );
		setColor(239, 239, 239, COMMON | BACKGROUND_TEXT_SELECTED            );
		setColor(239, 239, 239, COMMON | BACKGROUND_TEXT_SELECTED | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND_TEXT_SELECTED            );
		setColor(  0,   0,   0, COMMON | FOREGROUND_TEXT_SELECTED | INACTIVE );
		
		// BUTTON (optional)
		setAdjustmentValue( 10, BUTTON | BACKGROUND | BRIGHTER_GRADIENT);
		setAdjustmentValue(-10, BUTTON | BACKGROUND | DARKER_GRADIENT);
		setColor(221, 223, 228, BUTTON | BACKGROUND);
		setColor(207, 209, 213, BUTTON | BACKGROUND_PRESSED);
		
		
	}
	
}
