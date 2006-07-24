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
		
		
	// BUTTON
		setColor(229, 231, 236, BUTTON | BACKGROUND);
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
		
	// MENUITEM
		setColor(250, 250, 250, MENU_ITEM | BACKGROUND);
		setColor(103, 141, 178, MENU_ITEM | BACKGROUND | ROLLOVER);
		setColor(Color.WHITE, MENU_ITEM | FOREGROUND_TEXT | ROLLOVER);
		
	// POPUP_MENU
		setColor(141, 141, 141, POPUP_MENU | BORDER);
		
	// SEPARATOR
		setColor(199, 199, 199, SEPARATOR | BACKGROUND);
		
		/*
		setKDEColors(new Color[] {
			new Color(255, 255, 255), // KDE_DEFAULT_BACKGROUND
			new Color(  0,   0,   0), // KDE_DEFAULT_TEXT
			new Color(250, 225, 146), // KDE_SELECTED_BACKGROUND
			new Color(  0,   0,   0), // KDE_SELECTED_TEXT
			new Color(  0,   0, 255), // KDE_LINK
			new Color(100,   0, 100), // KDE_USED_LINK
			new Color(239, 239, 239), // KDE_WINDOW_BACKGROUND
			new Color(  0,   0,   0), // KDE_WINDOW_TEXT
			new Color(220, 223, 226), // KDE_BUTTON_BACKGROUND
			new Color(  0,   0,   0), // KDE_BUTTON_TEXT
			new Color(255,   0,   0), // KDE_ACTIVE_TITLEBAR
			new Color(  0, 255,   0), // KDE_ACTIVE_TITLEBAR_TEXT
			new Color(200,   0,   0), // KDE_ACTIVE_TITLEBAR_GRADIENT
			new Color(  0,   0, 255), // KDE_ACTIVE_TITLEBAR_BUTTON
			new Color(100, 100, 100), // KDE_INACTIVE_TITLEBAR
			new Color(200, 200, 200), // KDE_INACTIVE_TITLEBAR_TEXT
			new Color(120, 120, 120), // KDE_INACTIVE_TITLEBAR_GRADIENT
			new Color( 50,  50,  50), // KDE_INACTIVE_TITLEBAR_BUTTON
			new Color(255, 255,   0), // KDE_ACTIVE_WINDOWBORDER
			new Color(  0, 255, 255), // KDE_ACTIVE_WINDOWBORDER_HANDLE
			new Color(150, 150, 150), // KDE_INACTIVE_WINDOWBORDER
			new Color( 80,  80,  80), // KDE_INACTIVE_WINDOWBORDER_HANDLE
			new Color(255, 245, 230), // KDE_ALTERNATIVE_LIST_BACKGROUND
		});
		*/
	}

}
