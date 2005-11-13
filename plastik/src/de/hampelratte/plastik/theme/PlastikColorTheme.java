package de.hampelratte.plastik.theme;

import java.awt.Color;

public interface PlastikColorTheme {
	
	// Types
	public static final int TYPE_BACKGROUND = 0;
	public static final int TYPE_FOREGROUND = 1;
	public static final int TYPE_ROLLOVER   = 2;
	public static final int TYPE_FOCUS      = 3;
	
	// Options
	// (günstig für Arrayimplementierung)
	public static final int NORMAL        = 0;  // ... 0000 0000  0000 0000
	public static final int BRIGHTER      = 1;  // ... 0000 0000  0000 0001
	public static final int BRIGHTER_MORE = 2;  // ... 0000 0000  0000 0010
	public static final int DARKER        = 3;  // ... 0000 0000  0000 0011
	public static final int DARKER_MORE   = 4;  // ... 0000 0000  0000 0100
	
	public static final int LIGHT_MASK    = 7;  // ... 0000 0000  0000 0111
	
	public static final int INACTIVE_MASK = 16; // ... 0000 0000  0001 0000
	public static final int ROLLOVER_MASK = 32; // ... 0000 0000  0010 0000
	
	public Color getButtonColor(int type, int options);
}
