package de.hampelratte.plastik.theme;

import java.awt.Color;

public class DefaultColorTheme extends AbstractColorTheme {
	
	public DefaultColorTheme() {
		super();
		
	//-COMMON (must be set)-----------------------------------------------------
		// windows
		setColor(239, 239, 239, COMMON | BACKGROUND                          );
		setColor(239, 239, 239, COMMON | BACKGROUND               | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND                          );
		setColor(  0,   0,   0, COMMON | FOREGROUND               | INACTIVE );
		setColor(134, 134, 134, COMMON | BORDER                              );
		setColor(134, 134, 134, COMMON | BORDER                   | INACTIVE );
		// components
		setColor(221, 223, 228, COMMON | BACKGROUND_COMPONENT                );
		setColor(239, 239, 239, COMMON | BACKGROUND_COMPONENT     | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND_COMPONENT                );
		setColor(239, 239, 239, COMMON | FOREGROUND_COMPONENT     | INACTIVE );
		setColor(207, 209, 213, COMMON | BACKGROUND_PRESSED                  );
		setColor(239, 239, 239, COMMON | BACKGROUND_PRESSED       | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND_PRESSED                  );
		setColor(  0,   0,   0, COMMON | FOREGROUND_PRESSED       | INACTIVE );
		setColor( 16,  16,  16, COMMON | FOCUS                               );
		setColor( 16,  16,  16, COMMON | FOCUS                    | INACTIVE );
		setColor(103, 141, 178, 170, COMMON | ROLLOVER                            );
		setColor(  0,   0,   0, COMMON | ROLLOVER                 | INACTIVE );
		setColor(134, 134, 134, COMMON | BORDER_COMPONENT                    );
		setColor(134, 134, 134, COMMON | BORDER_COMPONENT         | INACTIVE );	
		// text
		setColor(255, 255, 255, COMMON | BACKGROUND_TEXT                     );
		setColor(255, 255, 255, COMMON | BACKGROUND_TEXT          | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND_TEXT                     );
		setColor(  0,   0,   0, COMMON | FOREGROUND_TEXT          | INACTIVE );
		setColor(239, 239, 239, COMMON | BACKGROUND_TEXT_SELECTED            );
		setColor(239, 239, 239, COMMON | BACKGROUND_TEXT_SELECTED | INACTIVE );
		setColor(  0,   0,   0, COMMON | FOREGROUND_TEXT_SELECTED            );
		setColor(  0,   0,   0, COMMON | FOREGROUND_TEXT_SELECTED | INACTIVE );
		
		
	// BUTTON (optional)--------------------------------------------------------
		setAdjustmentValue(computeAdjustmentValue(-35, 0), BUTTON | BACKGROUND | DARKER);
		setAdjustmentValue(computeAdjustmentValue(-19, 0), BUTTON | BACKGROUND | DARKER_GRADIENT);
		setAdjustmentValue(computeAdjustmentValue( -4, 0), BUTTON | BACKGROUND_PRESSED | BRIGHTER_GRADIENT);
		setAdjustmentValue(computeAdjustmentValue(  4, 0), BUTTON | BACKGROUND_PRESSED | DARKER_GRADIENT);
		setAdjustmentValue(computeAdjustmentValue( -8, 0), BUTTON | BACKGROUND_PRESSED | BRIGHTER);
		setAdjustmentValue(computeAdjustmentValue(  8, 0), BUTTON | BACKGROUND_PRESSED | DARKER);
		setAdjustmentValue(computeAdjustmentValue( 40, 0), BUTTON | FOREGROUND_COMPONENT | INACTIVE | BRIGHTER);
		setAdjustmentValue(computeAdjustmentValue(-40, 0), BUTTON | FOREGROUND_COMPONENT | INACTIVE | DARKER);
		
	// LABEL (optional)---------------------------------------------------------
		setAdjustmentValue( 40, LABEL | FOREGROUND_COMPONENT | INACTIVE | BRIGHTER);
		setAdjustmentValue(-40, LABEL | FOREGROUND_COMPONENT | INACTIVE | DARKER);
		
		setKDEColor(new Color(245, 240, 220), KDE_BUTTON_BACKGROUND);
		
	}
	
}
