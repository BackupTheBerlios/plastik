package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikColorUIResource;
import java.awt.Color;

/**
 * This interface defines the basic constants and functions that a 
 * PlastikColorTheme should provide. The constants are used to define a special 
 * type of color. The theme themself should provide real Color objects for all 
 * the possible combinations of types. The types are build by a simple OR 
 * connection of the variant, active state, color parts and the component type.
 */
public interface PlastikColorTheme {

	// Masks
	/** 
	 * This constant is used to indicate that bits that are affected to create 
	 * the different variants of the color. The different Variants are:
	 * <ul>
	 * <li>{@link PlastikColorTheme#NORMAL}</li>
	 * <li>{@link PlastikColorTheme#BRIGHTER}</li>
	 * <li>{@link PlastikColorTheme#BRIGHTER_MORE}</li>
	 * <li>{@link PlastikColorTheme#BRIGHTER_GRADIENT}</li>
	 * <li>{@link PlastikColorTheme#DARKER}</li>
	 * <li>{@link PlastikColorTheme#DARKER_MORE}</li>
	 * <li>{@link PlastikColorTheme#DARKER_GRADIENT}</li>
	 * </ul>
	 */
	public static final int VARIANTS_MASK = 0x00000007;
	
	/**
	 * This constant is used to indiacte that bit that is used to differ 
	 * between the active and inactive state. The different states are: 
	 * <ul>
	 * <li>{@link PlastikColorTheme#ACTIVE}</li>
	 * <li>{@link PlastikColorTheme#INACTIVE}</li>
	 * </ul>
	 */
	public static final int INACTIVE_MASK = 0x00000008;
	
	/**
	 * This constant is used to indicate that bits that are affected to create 
	 * colors for the different parts of a component. The types are:
	 * <ul>
	 * <li>{@link PlastikColorTheme#BACKGROUND}</li>
	 * <li>{@link PlastikColorTheme#FOREGROUND}</li>
	 * <li>{@link PlastikColorTheme#BORDER}</li>
	 * <li>{@link PlastikColorTheme#BACKGROUND_COMPONENT}</li>
	 * <li>{@link PlastikColorTheme#FOREGROUND_COMPONENT}</li>
	 * <li>{@link PlastikColorTheme#BACKGROUND_PRESSED}</li>
	 * <li>{@link PlastikColorTheme#FOREGROUND_PRESSED}</li>
	 * <li>{@link PlastikColorTheme#BORDER_COMPONENT}</li>
	 * <li>{@link PlastikColorTheme#FOCUS}</li>
	 * <li>{@link PlastikColorTheme#ROLLOVER}</li>
	 * <li>{@link PlastikColorTheme#BACKGROUND_TEXT}</li>
	 * <li>{@link PlastikColorTheme#FOREGROUND_TEXT}</li>
	 * <li>{@link PlastikColorTheme#BACKGROUND_TEXT_SELECTED}</li>
	 * <li>{@link PlastikColorTheme#FOREGROUND_TEXT_SELECTED}</li>
	 * </ul>
	 */
	public static final int TYPES_MASK    = 0x000000F0;
	
	/**
	 * This constant is used to indicate that bits that are affected by the 
	 * assignment to a special type of component. The supported components are:
	 * <ul>
	 * <li>{@link PlastikColorTheme#COMMON}</li> 
	 * <li>{@link PlastikColorTheme#BUTTON}</li>
	 * <li>{@link PlastikColorTheme#CHECK_BOX}</li>
	 * <li>{@link PlastikColorTheme#CHECK_BOX_MENU_ITEM}</li>
	 * <li>{@link PlastikColorTheme#COLOR_CHOOSER}</li>
	 * <li>{@link PlastikColorTheme#COMBO_BOX}</li>
	 * <li>{@link PlastikColorTheme#DESKTOP_ICON}</li>
	 * <li>{@link PlastikColorTheme#DESKTOP_PANE}</li>
	 * <li>{@link PlastikColorTheme#EDITOR_PANE}</li>
	 * <li>{@link PlastikColorTheme#FORMATTED_TEXT_FIELD}</li>
	 * <li>{@link PlastikColorTheme#INTERNAL_FRAME}</li>
	 * <li>{@link PlastikColorTheme#LABEL}</li>
	 * <li>{@link PlastikColorTheme#LIST}</li>
	 * <li>{@link PlastikColorTheme#MENU}</li>
	 * <li>{@link PlastikColorTheme#MENU_BAR}</li>
	 * <li>{@link PlastikColorTheme#MENU_ITEM}</li>
	 * <li>{@link PlastikColorTheme#OPTION_PANE}</li>
	 * <li>{@link PlastikColorTheme#PANEL}</li>
	 * <li>{@link PlastikColorTheme#PASSWORD_FIELD}</li>
	 * <li>{@link PlastikColorTheme#POPUP_MENU}</li>
	 * <li>{@link PlastikColorTheme#POPUP_MENU_SEPARATOR}</li>
	 * <li>{@link PlastikColorTheme#PROGRESS_BAR}</li>
	 * <li>{@link PlastikColorTheme#RADIO_BUTTON}</li>
	 * <li>{@link PlastikColorTheme#RADIO_BUTTON_MENU_ITEM}</li>
	 * <li>{@link PlastikColorTheme#ROOT_PANE}</li>
	 * <li>{@link PlastikColorTheme#SCROLL_BAR}</li>
	 * <li>{@link PlastikColorTheme#SCROLL_PANE}</li>
	 * <li>{@link PlastikColorTheme#SEPARATOR}</li>
	 * <li>{@link PlastikColorTheme#SLIDER}</li>
	 * <li>{@link PlastikColorTheme#SPINNER}</li>
	 * <li>{@link PlastikColorTheme#SPLIT_PANE}</li>
	 * <li>{@link PlastikColorTheme#TABBED_PANE}</li>
	 * <li>{@link PlastikColorTheme#TABLE}</li>
	 * <li>{@link PlastikColorTheme#TABLE_HEADER}</li>
	 * <li>{@link PlastikColorTheme#TEXT_AREA}</li>
	 * <li>{@link PlastikColorTheme#TEXT_FIELD}</li>
	 * <li>{@link PlastikColorTheme#TEXT_PANE}</li>
	 * <li>{@link PlastikColorTheme#TOGGLE_BUTTON}</li>
	 * <li>{@link PlastikColorTheme#TOOL_BAR}</li>
	 * <li>{@link PlastikColorTheme#TOOL_BAR_SEPARATOR}</li>
	 * <li>{@link PlastikColorTheme#TOOL_TIP}</li>
	 * <li>{@link PlastikColorTheme#TREE}</li>
	 * <li>{@link PlastikColorTheme#VIEWPORT}</li>
	 * </ul>
	 */
	public static final int UI_MASK       = 0x0000FF00;
	
	// Shift Constants
	/**
	 * This constant indicates the shift width (to right) that is needed to 
	 * affect the first bit at the lowest position.
	 * @see PlastikColorTheme#VARIANTS_MASK
	 */
	public static final int VARIANTS_SHIFT = 0;
	
	/**
	 * This constant indicates the shift width (to right) that is needed to 
	 * affect the first bit at the lowest position.
	 * @see PlastikColorTheme#INACTIVE_MASK
	 */
	public static final int INACTIVE_SHIFT = 3;
	
	/**
	 * This constant indicates the shift width (to right) that is needed to 
	 * affect the first bit at the lowest position.
	 * @see PlastikColorTheme#TYPES_MASK
	 */
	public static final int TYPES_SHIFT    = 4;
	
	/**
	 * This constant indicates the shift width (to right) that is needed to 
	 * affect the first bit at the lowest position.
	 * @see PlastikColorTheme#UI_MASK
	 */
	public static final int UI_SHIFT       = 8;
	
	// Counts
	/**
	 * This constant indicates how many different variants exists. This can 
	 * be used for optimized storage of the resulting colors.
	 */
	public static final int VARIANTS_COUNT =  8;

	/**
	 * This constant indicates how many different active states exists. This 
	 * can be used for optimized storage of the resulting colors.
	 */
	public static final int INACTIVE_COUNT =  2;
	
	/**
	 * This constant indicates how many different types exists. This 
	 * can be used for optimized storage of the resulting colors.
	 */
	public static final int TYPES_COUNT    = 16;
	
	/**
	 * This constant indicates how many different ui types exists. This 
	 * can be used for optimized storage of the resulting colors.
	 */	
	public static final int UI_COUNT       = 43;
	
	// color variants for the colors (0x00000007)
	public static final int NORMAL            = 0; // ..0000 0000 0000 0000
	public static final int BRIGHTER          = 1; // ..0000 0000 0000 0001
	public static final int BRIGHTER_MORE     = 2; // ..0000 0000 0000 0010
	public static final int BRIGHTER_GRADIENT = 3; // ..0000 0000 0000 0011
	public static final int DARKER            = 4; // ..0000 0000 0000 0100
	public static final int DARKER_MORE       = 5; // ..0000 0000 0000 0101
	public static final int DARKER_GRADIENT   = 6; // ..0000 0000 0000 0110
//	public static final int UNDEFINED         = 7; // ..0000 0000 0000 0111
	
	// inactive state (0x00000008)
	public static final int ACTIVE        = 0; // ..0000 0000 0000 0000
	public static final int INACTIVE      = 8; // ..0000 0000 0000 1000
	
	// color types for every ui-component (0x000000F0)
	public static final int BACKGROUND               = 0x00000000; // ..0000 0000 0000 0000
	public static final int FOREGROUND               = 0x00000010; // ..0000 0000 0001 0000
	public static final int BORDER                   = 0x00000020; // ..0000 0000 0010 0000
	public static final int BACKGROUND_COMPONENT     = 0x00000030; // ..0000 0000 0011 0000
	public static final int FOREGROUND_COMPONENT     = 0x00000040; // ..0000 0000 0100 0000
	public static final int BACKGROUND_PRESSED       = 0x00000050; // ..0000 0000 0101 0000
	public static final int FOREGROUND_PRESSED       = 0x00000060; // ..0000 0000 0110 0000
	public static final int BORDER_COMPONENT         = 0x00000070; // ..0000 0000 0111 0000
	public static final int FOCUS                    = 0x00000080; // ..0000 0000 1000 0000
	public static final int ROLLOVER                 = 0x00000090; // ..0000 0000 1001 0000
	public static final int BACKGROUND_TEXT          = 0x000000A0; // ..0000 0000 1010 0000
	public static final int FOREGROUND_TEXT          = 0x000000B0; // ..0000 0000 1011 0000
	public static final int BACKGROUND_TEXT_SELECTED = 0x000000C0; // ..0000 0000 1100 0000
	public static final int FOREGROUND_TEXT_SELECTED = 0x000000D0; // ..0000 0000 1101 0000
//	public static final int UNDEFINED                = 0x000000E0; // ..0000 0000 1110 0000
//	public static final int UNDEFINED                = 0x000000F0; // ..0000 0000 1111 0000
	
	// constants for every ui-component (0x0000FF00)
	public static final int COMMON                  = 0x00000000; // ..0000 0000 0000 0000 
	public static final int BUTTON                  = 0x00000100; // ..0000 0001 0000 0000
	public static final int CHECK_BOX               = 0x00000200; // ..0000 0010 0000 0000
	public static final int CHECK_BOX_MENU_ITEM     = 0x00000300; // ..0000 0011 0000 0000
	public static final int COLOR_CHOOSER           = 0x00000400; // ..0000 0100 0000 0000
	public static final int COMBO_BOX               = 0x00000500; // ..0000 0101 0000 0000
	public static final int DESKTOP_ICON            = 0x00000600; // ..0000 0110 0000 0000
	public static final int DESKTOP_PANE            = 0x00000700; // ..0000 0111 0000 0000
	public static final int EDITOR_PANE             = 0x00000800; // ..0000 1000 0000 0000
	public static final int FORMATTED_TEXT_FIELD    = 0x00000900; // ..0000 1001 0000 0000
	public static final int INTERNAL_FRAME          = 0x00000A00; // ..0000 1010 0000 0000
	public static final int LABEL                   = 0x00000B00; // ..0000 1011 0000 0000
	public static final int LIST                    = 0x00000C00; // ..0000 1100 0000 0000
	public static final int MENU                    = 0x00000D00; // ..0000 1101 0000 0000
	public static final int MENU_BAR                = 0x00000E00; // ..0000 1110 0000 0000
	public static final int MENU_ITEM               = 0x00000F00; // ..0000 1111 0000 0000
	public static final int OPTION_PANE             = 0x00001000; // ..0001 0000 0000 0000
	public static final int PANEL                   = 0x00001100; // ..0001 0001 0000 0000
	public static final int PASSWORD_FIELD          = 0x00001200; // ..0001 0010 0000 0000
	public static final int POPUP_MENU              = 0x00001300; // ..0001 0011 0000 0000
	public static final int POPUP_MENU_SEPARATOR    = 0x00001400; // ..0001 0100 0000 0000
	public static final int PROGRESS_BAR            = 0x00001500; // ..0001 0101 0000 0000
	public static final int RADIO_BUTTON            = 0x00001600; // ..0001 0110 0000 0000
	public static final int RADIO_BUTTON_MENU_ITEM  = 0x00001700; // ..0001 0111 0000 0000
	public static final int ROOT_PANE               = 0x00001800; // ..0001 1000 0000 0000
	public static final int SCROLL_BAR              = 0x00001900; // ..0001 1001 0000 0000
	public static final int SCROLL_PANE             = 0x00001A00; // ..0001 1010 0000 0000
	public static final int SEPARATOR               = 0x00001B00; // ..0001 1011 0000 0000
	public static final int SLIDER                  = 0x00001C00; // ..0001 1100 0000 0000
	public static final int SPINNER                 = 0x00001D00; // ..0001 1101 0000 0000
	public static final int SPLIT_PANE              = 0x00001E00; // ..0001 1110 0000 0000
	public static final int TABBED_PANE             = 0x00001F00; // ..0001 1111 0000 0000
	public static final int TABLE                   = 0x00002000; // ..0010 0000 0000 0000
	public static final int TABLE_HEADER            = 0x00002100; // ..0010 0001 0000 0000
	public static final int TEXT_AREA               = 0x00002200; // ..0010 0010 0000 0000
	public static final int TEXT_FIELD              = 0x00002300; // ..0010 0011 0000 0000
	public static final int TEXT_PANE               = 0x00002400; // ..0010 0100 0000 0000
	public static final int TOGGLE_BUTTON           = 0x00002500; // ..0010 0101 0000 0000
	public static final int TOOL_BAR                = 0x00002600; // ..0010 0110 0000 0000
	public static final int TOOL_BAR_SEPARATOR      = 0x00002700; // ..0010 0111 0000 0000
	public static final int TOOL_TIP                = 0x00002800; // ..0010 1000 0000 0000
	public static final int TREE                    = 0x00002900; // ..0010 1001 0000 0000
	public static final int VIEWPORT                = 0x00002A00; // ..0010 1010 0000 0000
	
	/**
	 * This function should return a cached version of the color if the param 
	 * color is an instance of PlastikColorUIResource. If the param is no 
	 * UIResource then it should return a computed color.
	 *
	 * @param color the color-object of the component.
	 * @param type the requested type.
	 */
	public Color getColor(Color color, int type);
	
	public PlastikColorUIResource getColor(int type);
	
	public Color computeColor(Color color, int type);
	
}
