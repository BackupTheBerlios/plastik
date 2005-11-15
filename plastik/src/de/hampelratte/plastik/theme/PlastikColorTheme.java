package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikColorUIResource;
import java.awt.Color;

public interface PlastikColorTheme {
	
//-(first draft)----------------------------------------------------------------
	// Types
	public static final int TYPE_BACKGROUND = 0;
	public static final int TYPE_FOREGROUND = 1;
	public static final int TYPE_BORDER     = 2;
	public static final int TYPE_ROLLOVER   = 3;
	public static final int TYPE_FOCUS      = 4;
	
	// Options
	// (günstig für Arrayimplementierung)
//	public static final int NORMAL        = 0;  // ... 0000 0000  0000 0000
//	public static final int BRIGHTER      = 1;  // ... 0000 0000  0000 0001
//	public static final int BRIGHTER_MORE = 2;  // ... 0000 0000  0000 0010
//	public static final int DARKER        = 3;  // ... 0000 0000  0000 0011
//	public static final int DARKER_MORE   = 4;  // ... 0000 0000  0000 0100
	
	public static final int LIGHT_MASK    = 7;  // ... 0000 0000  0000 0111
	
	public static final int INACTIVE_MASK = 16; // ... 0000 0000  0001 0000
	public static final int ROLLOVER_MASK = 32; // ... 0000 0000  0010 0000
	
	//public Color getButtonColor(int type, int options);
	public Color getColor(int type, int options);
	
//-(second draft)---------------------------------------------------------------
	
	// 1. colors are only created if they are requested
	// 2. colors that are not explicity set by the theme should return the 
	//    common value
	// 3. for each ui-component exists 5 types of colors:
	//    BACKGROUND, FOREGROUND, ...
	// 4. for the types BACKGROUND, FOREGROUND and BORDER existing 5 variants 
	//    (NORMAL, BRIGHTER, ...)
	//    for the types ROLLOVER and FOCUS exists only the variant NORMAL
	// 5. for each variant exists an extra inactive variant.
	
	public static final int COLOR_VARIANTS_MASK = 0x0000000F;
	public static final int COLOR_TYPES_MASK    = 0x000000F0;	
	public static final int COMPONENT_UI_MASK   = 0x0000FF00;
	
	public static final int COLOR_VARIANTS_SHIFT = 0;
	public static final int COLOR_TYPES_SHIFT    = 4;
	public static final int COMPONENT_UI_SHIFT   = 8;
	
	public static final int COLOR_VARIANTS_COUNT = 10;
	public static final int COLOR_TYPES_COUNT    =  5;
	public static final int COMPONENT_UI_COUNT   = 41;
	
	// color variants for the colors
	public static final int NORMAL        = 0; // ..0000 0000 0000 0000
	public static final int BRIGHTER      = 1; // ..0000 0000 0000 0001
	public static final int BRIGHTER_MORE = 2; // ..0000 0000 0000 0010
	public static final int DARKER        = 3; // ..0000 0000 0000 0011
	public static final int DARKER_MORE   = 4; // ..0000 0000 0000 0100
	
	public static final int INACTIVE      = 8; // ..0000 0000 0000 1000

	
	// color types for every ui-component (0x000000#0)
	public static final int BACKGROUND = 0x00000000; // ..0000 0000 0000 0000
	public static final int FOREGROUND = 0x00000010; // ..0000 0000 0001 0000
	public static final int BORDER     = 0x00000020; // ..0000 0000 0010 0000
	public static final int FOCUS      = 0x00000030; // ..0000 0000 0011 0000
	public static final int ROLLOVER   = 0x00000040; // ..0000 0000 0100 0000
	
	// constants for every ui-component (0x0000##00)
	public static final int BUTTON                  = 0x00000000; // ..0000 0000 0000 0000
	public static final int CHECK_BOX               = 0x00000100; // ..0000 0001 0000 0000
	public static final int CHECK_BOX_MENU_ITEM     = 0x00000200; // ..0000 0010 0000 0000
	public static final int COLOR_CHOOSER           = 0x00000300; // ..0000 0011 0000 0000
	public static final int COMBO_BOX               = 0x00000400; // ..0000 0100 0000 0000
	public static final int DESKTOP_ICON            = 0x00000500; // ..0000 0101 0000 0000
	public static final int DESKTOP_PANE            = 0x00000600; // ..0000 0110 0000 0000
	public static final int EDITOR_PANE             = 0x00000700; // ..0000 0111 0000 0000
	public static final int FORMATTED_TEXT_FIELD    = 0x00000800; // ..0000 1000 0000 0000
	public static final int INTERNAL_FRAME          = 0x00000900; // ..0000 1001 0000 0000
	public static final int LABEL                   = 0x00000A00; // ..0000 1010 0000 0000
	public static final int LIST                    = 0x00000B00; // ..0000 1011 0000 0000
	public static final int MENU                    = 0x00000C00; // ..0000 1100 0000 0000
	public static final int MENU_BAR                = 0x00000D00; // ..0000 1101 0000 0000
	public static final int MENU_ITEM               = 0x00000E00; // ..0000 1110 0000 0000
	public static final int OPTION_PANE             = 0x00000F00; // ..0000 1111 0000 0000
	public static final int PANEL                   = 0x00001000; // ..0001 0000 0000 0000
	public static final int PASSWORD_FIELD          = 0x00001100; // ..0001 0001 0000 0000
	public static final int POPUP_MENU              = 0x00001200; // ..0001 0010 0000 0000
	public static final int POPUP_MENU_SEPARATOR    = 0x00001300; // ..0001 0011 0000 0000
	public static final int PROGRESS_BAR            = 0x00001400; // ..0001 0100 0000 0000
	public static final int RADIO_BUTTON            = 0x00001500; // ..0001 0101 0000 0000
	public static final int RADIO_BUTTON_MENU_ITEM  = 0x00001600; // ..0001 0110 0000 0000
	public static final int ROOT_PANE               = 0x00001700; // ..0001 0111 0000 0000
	public static final int SCROLL_BAR              = 0x00001800; // ..0001 1000 0000 0000
	public static final int SCROLL_PANE             = 0x00001900; // ..0001 1001 0000 0000
	public static final int SEPARATOR               = 0x00001A00; // ..0001 1010 0000 0000
	public static final int SLIDER                  = 0x00001B00; // ..0001 1011 0000 0000
	public static final int SPINNER                 = 0x00001C00; // ..0001 1100 0000 0000
	public static final int SPLIT_PANE              = 0x00001D00; // ..0001 1101 0000 0000
	public static final int TABBED_PANE             = 0x00001E00; // ..0001 1110 0000 0000
	public static final int TABLE                   = 0x00001F00; // ..0001 1111 0000 0000
	public static final int TABLE_HEADER            = 0x00002000; // ..0010 0000 0000 0000
	public static final int TEXT_AREA               = 0x00002100; // ..0010 0001 0000 0000
	public static final int TEXT_FIELD              = 0x00002200; // ..0010 0010 0000 0000
	public static final int TEXT_PANE               = 0x00002300; // ..0010 0011 0000 0000
	public static final int TOGGLE_BUTTON           = 0x00002400; // ..0010 0100 0000 0000
	public static final int TOOL_BAR                = 0x00002500; // ..0010 0101 0000 0000
	public static final int TOOL_BAR_SEPARATOR      = 0x00002600; // ..0010 0110 0000 0000
	public static final int TOOL_TIP                = 0x00002700; // ..0010 0111 0000 0000
	public static final int TREE                    = 0x00002800; // ..0010 1000 0000 0000
	public static final int VIEWPORT                = 0x00002900; // ..0010 1001 0000 0000
	
	public PlastikColorUIResource getColor(int type);
	
	public Color computeColor(Color color, int type);
	
}
