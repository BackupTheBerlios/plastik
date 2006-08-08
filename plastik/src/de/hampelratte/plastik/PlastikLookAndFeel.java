package de.hampelratte.plastik;

import de.hampelratte.plastik.borders.PlastikMenuBarBorder;
import de.hampelratte.plastik.theme.DefaultPlastikTheme;
import de.hampelratte.plastik.theme.PlastikColorTheme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.IconUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.text.DefaultEditorKit;

import de.hampelratte.plastik.borders.PlastikBorder;
import de.hampelratte.plastik.borders.PlastikButtonBorder;
import de.hampelratte.plastik.borders.PlastikPopupMenuBorder;
import de.hampelratte.plastik.borders.PlastikScrollPaneBorder;
import de.hampelratte.plastik.borders.PlastikTextComponentBorder;
import de.hampelratte.plastik.borders.PlastikToggleButtonBorder;
import de.hampelratte.plastik.theme.PlastikTheme;


/**
 * TODO Diskussion ob sinnvoll oder nicht<br>
 *
 * Hier ein paar Vorschläge aus meinem Avio-Theme:
 * Das PlastikLookAndFeel sollte an spätere Veränderungen durch Themes 
 * (PlastikTheme) entsprechend anpassbar sein. Ein solches Theme besteht aus 
 * mehreren Sub-Themes:
 *  - PlastikAudioTheme
 *  - PlastikBackgroundTheme
 *  - PlastikBorderTheme
 *  - PlastikColorTheme
 *  - PlastikFontTheme
 *
 * Dies hat den Vorteil das man nur bestimmte Teile des gesammten Themes 
 * austauschen braucht.
 * Ein Nachteil ist der höhere Aufwand.
 */
public class PlastikLookAndFeel extends BasicLookAndFeel {
	
	/** The PlastikTheme used by the LookAndFeel */
	private static PlastikTheme theme = null;
		
	/**
	 * Creates a new <code>PlastikLookAndFeel</code> object.
	 * The initialisation is completed after the calling of 
	 * {@link #getDefaults()}. This enables the setup of a theme before the 
	 * default theme is created.
	 */
	public PlastikLookAndFeel() {
	}

	/**
	 * Returns the name of the LookAndFeel as String.
	 * @return the name of the LookAndFeel
	 */
	public String getName() {
		return "Plastik";
	}
	
	/**
	 * Returns the ID of the LookAndFeel as String.
	 * @return the ID of the LookAndFeel
	 */
	public String getID() {
		return "Plastik";
	}
	
	/**
	 * Returns a short description of the LookAndFeel as String.
	 * @return a short description of the LookAndFeel.
	 */
	public String getDescription() {
		return "Plastik Look and Feel";
	}

	/**
	 * Shows that the LookAndFeel depends on a native platform or not. 
	 * The result should always be false.
	 * @return always false for this LookAndFeel
	 */
	public boolean isNativeLookAndFeel() {
		return false;
	}
	
	/**
	 * Shows that the LookAndFeel is supportet on this platform. As long we 
	 * support all platforms this should be always true.
	 * @return always true
	 */
	public boolean isSupportedLookAndFeel() {
		return true;
	}
	
	/**
	 * Returns true if the <code>LookAndFeel</code> returned
	 * <code>RootPaneUI</code> instances support providing Window decorations
	 * in a <code>JRootPane</code>.
	 * <p>
	 * The implementation returns false, until this support is implemented.
	 * @return always false
	 */
	public boolean getSupportsWindowDecorations() {
		return false;
	}
	
	/**
     * Invoked when the user attempts an invalid operation, 
     * such as pasting into an uneditable <code>JTextField</code> 
     * that has focus. The current implementation beeps. 
	 * @param component the <code>Component</code> the error occurred in,
     *                  may be <code>null</code> indicating the error condition 
	 *                  is not directly associated with a <code>Component</code>
	 */
	public void provideErrorFeedback(Component component) { 
		super.provideErrorFeedback(component); 
	}
	
	private static boolean textAntialiasing = false;
	
	public static void setTheme(PlastikTheme newTheme) {
		theme = newTheme;
	}
	
	public static PlastikTheme getTheme() {
		if (theme == null) {
			theme = new DefaultPlastikTheme();
		}
		return theme;
	}

	protected void initClassDefaults(UIDefaults table) {
		super.initClassDefaults(table);
		String s = "de.hampelratte.plastik.Plastik";
		table.put("ButtonUI",         s + "ButtonUI");
		table.put("CheckBoxUI",       s + "CheckBoxUI");
		table.put("CheckBoxMenuItemUI", s + "CheckBoxMenuItemUI");
		table.put("ComboBoxUI",       s + "ComboBoxUI");
		table.put("LabelUI",          s + "LabelUI");
		table.put("MenuUI",           s + "MenuUI");
		table.put("MenuBarUI",        s + "MenuBarUI");
		table.put("MenuItemUI",       s + "MenuItemUI");
		table.put("PopupMenuUI",      s + "PopupMenuUI");
		//table.put("PopupMenuSeparatorUI", s + "PopupMenuSeparatorUI");
		table.put("RadioButtonUI",    s + "RadioButtonUI");
		table.put("RadioButtonMenuItemUI", s + "RadioButtonMenuItemUI");
		table.put("ScrollBarUI",      s + "ScrollBarUI");
		table.put("SeparatorUI",      s + "SeparatorUI");
		table.put("SpinnerUI",        s + "SpinnerUI");
		table.put("TextFieldUI",      s + "TextFieldUI");
		table.put("TextAreaUI",       s + "TextAreaUI");
		table.put("ToggleButtonUI",   s + "ToggleButtonUI");
		table.put("ToolTipUI",        s + "ToolTipUI");
	}

	protected void initSystemColorDefaults(UIDefaults table) {
//		table.put("desktop", getDesktopColor());
//		table.put("activeCaption", getWindowTitleBackground());
//		table.put("activeCaptionText", getWindowTitleForeground());
//		table.put("activeCaptionBorder", Color.WHITE/* getPrimaryControlShadow()*/);
//		table.put("inactiveCaption", getWindowTitleInactiveBackground());
//		table.put("inactiveCaptionText", getWindowTitleInactiveForeground());
//		table.put("inactiveCaptionBorder", getControlShadow());
//		table.put("window", Color.WHITE/*new ColorUIResource(new Color(239,239,239))*/);
//		table.put("windowBorder", getControl());
//		table.put("windowText", getUserTextColor());
//		table.put("menu", getMenuBackground()); /* Background color for menus */
//		table.put("menuText", getMenuForeground()); /* Text color for menus */
//		table.put("text", getWindowBackground()); /* Text background color */
//		table.put("textText", getUserTextColor());
//		table.put("textHighlight", new PlastikColorUIResource(new Color(103,
//				141, 178)));
//		table.put("textHighlightText", Color.WHITE);
//		table.put("textInactiveText", new ColorUIResource(new Color(200, 200,
//				200)));
//		table.put("control", getControl());
//		table.put("controlText", getControlTextColor());
//		table.put("controlHighlight", getControlHighlight());
//		table.put("controlLtHighlight", getControlHighlight());
//		table.put("controlShadow", getControlShadow()); 
//		table.put("controlDkShadow", getControlDarkShadow());
//		table.put("scrollbar", getControl());
//		table.put("info", new ColorUIResource(new Color(255,255,220))); // tooltip bg
//		table.put("infoText", new ColorUIResource(Color.BLACK)); // tooltip fg

	}
	
	Object fieldInputMap = new UIDefaults.LazyInputMap(new Object[] {
					   "ctrl C", DefaultEditorKit.copyAction,
					   "ctrl V", DefaultEditorKit.pasteAction,
					   "ctrl X", DefaultEditorKit.cutAction,
					     "COPY", DefaultEditorKit.copyAction,
					    "PASTE", DefaultEditorKit.pasteAction,
					      "CUT", DefaultEditorKit.cutAction,
				   "shift LEFT", DefaultEditorKit.selectionBackwardAction,
		        "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction,
			      "shift RIGHT", DefaultEditorKit.selectionForwardAction,
			   "shift KP_RIGHT", DefaultEditorKit.selectionForwardAction,
					"ctrl LEFT", DefaultEditorKit.previousWordAction,
			     "ctrl KP_LEFT", DefaultEditorKit.previousWordAction,
			       "ctrl RIGHT", DefaultEditorKit.nextWordAction,
			    "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction,
			  "ctrl shift LEFT", DefaultEditorKit.selectionPreviousWordAction,
		   "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction,
			 "ctrl shift RIGHT", DefaultEditorKit.selectionNextWordAction,
		  "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction,
					   "ctrl A", DefaultEditorKit.selectAllAction,
					     "HOME", DefaultEditorKit.beginLineAction,
					      "END", DefaultEditorKit.endLineAction,
			       "shift HOME", DefaultEditorKit.selectionBeginLineAction,
			        "shift END", DefaultEditorKit.selectionEndLineAction,
			       "typed \010", DefaultEditorKit.deletePrevCharAction,
		               "DELETE", DefaultEditorKit.deleteNextCharAction,
		                "RIGHT", DefaultEditorKit.forwardAction,
		                 "LEFT", DefaultEditorKit.backwardAction,
		             "KP_RIGHT", DefaultEditorKit.forwardAction,
		              "KP_LEFT", DefaultEditorKit.backwardAction,
					    "ENTER", JTextField.notifyAction,
		      "ctrl BACK_SLASH", "unselect"/*DefaultEditorKit.unselectAction*/,
		      "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
	});
	
	Object multilineInputMap = new UIDefaults.LazyInputMap(new Object[] {
					   "ctrl C", DefaultEditorKit.copyAction,
					   "ctrl V", DefaultEditorKit.pasteAction,
					   "ctrl X", DefaultEditorKit.cutAction,
					     "COPY", DefaultEditorKit.copyAction,
					    "PASTE", DefaultEditorKit.pasteAction,
					      "CUT", DefaultEditorKit.cutAction,
		           "shift LEFT", DefaultEditorKit.selectionBackwardAction,
                "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction,
		          "shift RIGHT", DefaultEditorKit.selectionForwardAction,
		       "shift KP_RIGHT", DefaultEditorKit.selectionForwardAction,
		       		"ctrl LEFT", DefaultEditorKit.previousWordAction,
		         "ctrl KP_LEFT", DefaultEditorKit.previousWordAction,
		           "ctrl RIGHT", DefaultEditorKit.nextWordAction,
		        "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction,
		      "ctrl shift LEFT", DefaultEditorKit.selectionPreviousWordAction,
	       "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction,
		     "ctrl shift RIGHT", DefaultEditorKit.selectionNextWordAction,
	      "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction,
			           "ctrl A", DefaultEditorKit.selectAllAction,
			             "HOME", DefaultEditorKit.beginLineAction,
			              "END", DefaultEditorKit.endLineAction,
		           "shift HOME", DefaultEditorKit.selectionBeginLineAction,
		            "shift END", DefaultEditorKit.selectionEndLineAction,
		            	   "UP", DefaultEditorKit.upAction,
					    "KP_UP", DefaultEditorKit.upAction,
					     "DOWN", DefaultEditorKit.downAction,
					  "KP_DOWN", DefaultEditorKit.downAction,
					  "PAGE_UP", DefaultEditorKit.pageUpAction,
					"PAGE_DOWN", DefaultEditorKit.pageDownAction,
				"shift PAGE_UP", "selection-page-up",
	          "shift PAGE_DOWN", "selection-page-down",
	       "ctrl shift PAGE_UP", "selection-page-left",
	     "ctrl shift PAGE_DOWN", "selection-page-right",
			 		 "shift UP", DefaultEditorKit.selectionUpAction,
			 	  "shift KP_UP", DefaultEditorKit.selectionUpAction,
		           "shift DOWN", DefaultEditorKit.selectionDownAction,
		        "shift KP_DOWN", DefaultEditorKit.selectionDownAction,
			            "ENTER", DefaultEditorKit.insertBreakAction,
		           "typed \010", DefaultEditorKit.deletePrevCharAction,
                       "DELETE", DefaultEditorKit.deleteNextCharAction,
                        "RIGHT", DefaultEditorKit.forwardAction,
                         "LEFT", DefaultEditorKit.backwardAction, 
                     "KP_RIGHT", DefaultEditorKit.forwardAction,
                      "KP_LEFT", DefaultEditorKit.backwardAction,
			              "TAB", DefaultEditorKit.insertTabAction,
		      "ctrl BACK_SLASH", "unselect"/*DefaultEditorKit.unselectAction*/,
			        "ctrl HOME", DefaultEditorKit.beginAction,
			         "ctrl END", DefaultEditorKit.endAction,
		      "ctrl shift HOME", DefaultEditorKit.selectionBeginAction,
		       "ctrl shift END", DefaultEditorKit.selectionEndAction,
                       "ctrl T", "next-link-action",
                 "ctrl shift T", "previous-link-action",
                   "ctrl SPACE", "activate-link-action",
              "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
	});
	
	protected void initComponentDefaults(UIDefaults table) {
		super.initComponentDefaults(table);
		
		PlastikColorTheme colorTheme = getTheme().getColorTheme();

		// common
		table.put("Common.background", new ColorUIResource(new Color(239, 239, 239)));
        table.put("Common.border", new PlastikBorder());
		table.put("Common.contour", new PlastikColorUIResource(new Color(0, 0, 0, 97)));
		table.put("Common.contourDisabled", new PlastikColorUIResource(new Color(0, 0, 0, 69)));
		table.put("Common.contourDisabledSmoother", new PlastikColorUIResource(new Color(0, 0, 0, 31)));
		table.put("Common.contourSmoother", new PlastikColorUIResource(new Color(0, 0, 0, 49)));
		table.put("Common.disabledText", table.get("textInactiveText"));
		table.put("Common.focus", new ColorUIResource(Color.BLACK));
		table.put("Common.font", new FontUIResource(new Font("Bitstream Vera Sans", Font.PLAIN, 14)));
		table.put("Common.foreground", new ColorUIResource(Color.BLACK));
		table.put("Common.highlight", new PlastikColorUIResource(new Color(103,	141, 178, 170)));
		table.put("Common.highlightSmoother", new PlastikColorUIResource(new Color(103, 141, 178, 100)));
		table.put("Common.innerContour", new PlastikColorUIResource(new Color(0, 0, 0, 204)));
		table.put("Common.innerContourPressed", new PlastikColorUIResource(new Color(0, 0, 0, 114)));
		table.put("Common.innerContourPressedSmoother",	new PlastikColorUIResource(new Color(0, 0, 0, 81)));
		table.put("Common.innerContourSmoother", new PlastikColorUIResource(new Color(0, 0, 0, 102)));
		
		// button
		table.put("Button.background", colorTheme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND));
		table.put("Button.border", new PlastikButtonBorder());
		table.put("Button.defaultButtonFollowsFocus", Boolean.FALSE);
		table.put("Button.font", table.getFont("Common.font"));
		table.put("Button.foreground", colorTheme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.FOREGROUND_TEXT));
		table.put("Button.margin", new InsetsUIResource(3, 14, 3, 14));
		
		// combobox
		table.put("ComboBox.background", colorTheme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND));
		table.put("ComboBox.border", null);
		table.put("ComboBox.disabledBackground", table.get("Common.background"));
	    table.put("ComboBox.disabledForeground",table.get("Common.disabledText"));
		table.put("ComboBox.font", table.getFont("Common.font"));
	    table.put("ComboBox.foreground", table.get("Common.foreground"));
	    table.put("ComboBox.height", new Integer(26));
	    table.put("ComboBox.selectionBackground", colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND | PlastikColorTheme.ROLLOVER | PlastikColorTheme.BRIGHTER) );
	    table.put("ComboBox.selectionForeground", Color.WHITE ); // TODO color

	    // internalframe
	    table.put("InternalFrame.icon", new UIDefaults.ProxyLazyValue("javax.swing.plaf.metal.MetalIconFactory", "getInternalFrameDefaultMenuIcon"));
	    table.put("InternalFrame.border", new UIDefaults.ProxyLazyValue("javax.swing.plaf.metal.MetalBorders$InternalFrameBorder"));
	    table.put("InternalFrame.optionDialogBorder", new UIDefaults.ProxyLazyValue("javax.swing.plaf.metal.MetalBorders$OptionDialogBorder"));
	    table.put("InternalFrame.paletteBorder", new UIDefaults.ProxyLazyValue("javax.swing.plaf.metal.MetalBorders$PaletteBorder"));
	    table.put("InternalFrame.paletteTitleHeight", new Integer(11));
	    table.put("InternalFrame.paletteCloseIcon", new UIDefaults.ProxyLazyValue("javax.swing.plaf.metal.MetalIconFactory$PaletteCloseIcon"));
	    
	    /*table.put("InternalFrame.closeIcon", 
	          new UIDefaults.ProxyLazyValue(
	             "javax.swing.plaf.metal.MetalIconFactory", 
	             "getInternalFrameCloseIcon",
	             internalFrameIconArgs));
	    table.put("InternalFrame.maximizeIcon", 
	          new UIDefaults.ProxyLazyValue(
	             "javax.swing.plaf.metal.MetalIconFactory", 
	             "getInternalFrameMaximizeIcon",
	             internalFrameIconArgs));
	    table.put("InternalFrame.iconifyIcon", 
	          new UIDefaults.ProxyLazyValue(
	             "javax.swing.plaf.metal.MetalIconFactory", 
	             "getInternalFrameMinimizeIcon",
	             internalFrameIconArgs));
	    table.put("InternalFrame.minimizeIcon", 
	          new UIDefaults.ProxyLazyValue(
	             "javax.swing.plaf.metal.MetalIconFactory", 
	             "getInternalFrameAltMaximizeIcon",
	             internalFrameIconArgs));
	    table.put("InternalFrame.titleFont",  windowTitleValue);*/
	    table.put("InternalFrame.windowBindings", null);

		// label
		table.put("Label.background", new PlastikColorUIResource(239, 239, 239));
		table.put("Label.font", table.getFont("Common.font"));
		table.put("Label.foreground", new PlastikColorUIResource(0, 0, 0));
		
		// menu
		table.put("Menu.acceleratorFont", table.getFont("Common.font")); // TODO use FontTheme
//		table.put("Menu.acceleratorForeground", acceleratorForeground);
//		table.put("Menu.acceleratorSelectionForeground", acceleratorSelectedForeground);
		table.put("Menu.background", colorTheme.getColor(PlastikColorTheme.MENU | PlastikColorTheme.BACKGROUND));
//		table.put("Menu.border", null/*new PlastikMenuBorder()*/);
		table.put("Menu.borderPainted", Boolean.TRUE);
        table.put("Menu.font", table.getFont("Common.font")); // TODO use FontTheme
		table.put("Menu.menuPopupOffsetX", new Integer(0));
		table.put("Menu.menuPopupOffsetY", new Integer(0));
		table.put("Menu.submenuPopupOffsetX", new Integer(-4));
		table.put("Menu.submenuPopupOffsetY", new Integer(-3));
		
		// menubar
		table.put("MenuBar.background", colorTheme.getColor(PlastikColorTheme.MENU_BAR | PlastikColorTheme.BACKGROUND));
		table.put("MenuBar.border", new PlastikMenuBarBorder());
		table.put("MenuBar.font", table.getFont("Common.font")); // TODO use FontTheme
		table.put("MenuBar.foreground", colorTheme.getColor(PlastikColorTheme.MENU_BAR | PlastikColorTheme.FOREGROUND));
		table.put("MenuBar.windowBindings", new Object[] { "F10", "takeFocus" });
		
		// menuitem
		table.put("MenuItem.acceleratorFont", table.getFont("Common.font")); // TODO use FontTheme
		table.put("MenuItem.background", colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND));
//		table.put("MenuItem.border", /*new PlastikMenuItemBoder()*/ null);
		table.put("MenuItem.font", table.getFont("Common.font")); // TODO use FontTheme
		
//		"MenuItem.borderPainted", Boolean.TRUE,
//		"MenuItem.selectionForeground", menuSelectedForeground,
//		"MenuItem.selectionBackground", menuSelectedBackground,
//		"MenuItem.disabledForeground", menuDisabledForeground,
//		"MenuItem.acceleratorForeground", acceleratorForeground,
//		"MenuItem.acceleratorSelectionForeground", acceleratorSelectedForeground,
//		"MenuItem.acceleratorDelimiter", menuItemAcceleratorDelimiter,
//		"MenuItem.checkIcon", new SwingLazyValue("javax.swing.plaf.metal.MetalIconFactory", "getMenuItemCheckIcon"),
//		"MenuItem.arrowIcon", new SwingLazyValue("javax.swing.plaf.metal.MetalIconFactory", "getMenuItemArrowIcon"),
//		// Menu Item Auditory Cue Mapping
//		"MenuItem.commandSound", "sounds/MenuItemCommand.wav",
		
		// panel
		table.put("Panel.background", table.getColor("Common.background"));
		table.put("Panel.font", table.getFont("Common.font"));
		
		// popup menu
		table.put("PopupMenu.background", colorTheme.getColor(PlastikColorTheme.POPUP_MENU | PlastikColorTheme.BORDER));
		table.put("PopupMenu.border", new PlastikPopupMenuBorder());
		
		// optionpane
		table.put("OptionPane.errorIcon", getTheme().getIconTheme().getErrorIcon());
		table.put("OptionPane.informationIcon", getTheme().getIconTheme().getInfoIcon());
		table.put("OptionPane.questionIcon", getTheme().getIconTheme().getQuestionIcon());
		table.put("OptionPane.warningIcon", getTheme().getIconTheme().getWarningIcon());
		
		// radiobutton
		table.put("RadioButton.background", table.getColor("Common.background"));
		table.put("RadioButton.font", table.getFont("Common.font"));
		table.put("RadioButton.border", new PlastikScrollPaneBorder());
		
		// scrollpane
		table.put("ScrollPane.background", table.getColor("Common.background"));
		table.put("ScrollPane.border", new PlastikScrollPaneBorder());
		
		// separator
		table.put("Separator.background", colorTheme.getColor(PlastikColorTheme.SEPARATOR | PlastikColorTheme.BACKGROUND));
		
		// slider
		table.put("Slider.background", table.getColor("Common.background"));
		
		// tabbedpane
		table.put("TabbedPane.font", table.getFont("Common.font"));
		
		// textarea
		table.put("TextArea.focusInputMap", multilineInputMap);
		table.put("TextArea.border", new PlastikTextComponentBorder());
		table.put("TextArea.font", table.getFont("Common.font"));
		table.put("TextArea.background", colorTheme.getColor(PlastikColorTheme.BACKGROUND_TEXT));
		table.put("TextArea.disabledBackground", colorTheme.getColor(PlastikColorTheme.BACKGROUND_TEXT | PlastikColorTheme.INACTIVE));
		table.put("TextArea.selectionBackground", colorTheme.getColor(PlastikColorTheme.BACKGROUND_TEXT_SELECTED));
		table.put("TextArea.selectionForeground", colorTheme.getColor(PlastikColorTheme.FOREGROUND_TEXT_SELECTED));
		table.put("TextArea.inactiveBackground", colorTheme.getColor(PlastikColorTheme.BACKGROUND_TEXT | PlastikColorTheme.INACTIVE));
		table.put("TextArea.inactiveForeground", colorTheme.getColor(PlastikColorTheme.FOREGROUND_TEXT | PlastikColorTheme.INACTIVE));
		
		// textfield
		table.put("TextField.focusInputMap", fieldInputMap);
		table.put("TextField.background", colorTheme.getColor(PlastikColorTheme.BACKGROUND_TEXT));
		table.put("TextField.border", new PlastikTextComponentBorder());
		table.put("TextField.disabledBackground", colorTheme.getColor(PlastikColorTheme.BACKGROUND_TEXT | PlastikColorTheme.INACTIVE));
		table.put("TextField.font", table.getFont("Common.font"));
		table.put("TextField.selectionBackground", colorTheme.getColor(PlastikColorTheme.BACKGROUND_TEXT_SELECTED));
		table.put("TextField.selectionForeground", colorTheme.getColor(PlastikColorTheme.FOREGROUND_TEXT_SELECTED));
		table.put("TextField.inactiveBackground", colorTheme.getColor(PlastikColorTheme.BACKGROUND_TEXT | PlastikColorTheme.INACTIVE));
		table.put("TextField.inactiveForeground", colorTheme.getColor(PlastikColorTheme.FOREGROUND_TEXT | PlastikColorTheme.INACTIVE));
		
		// togglebutton
		table.put("ToggleButton.background", new PlastikColorUIResource(229, 231, 236));
		table.put("ToggleButton.border", new PlastikToggleButtonBorder());
		table.put("ToggleButton.font", table.getFont("Common.font"));
		table.put("ToggleButton.foreground", new PlastikColorUIResource(0, 0, 0));
		table.put("ToggleButton.margin", new InsetsUIResource(3, 14, 3, 14));


		// tooltip
		table.put("ToolTip.font", table.getFont("Common.font"));
		
	    
	    //table.put("Spinner.editorBorderPainted", new Boolean(true));
		// TODO farben für die ganzen gradienten handeln
	}

	public static boolean isTextAntialiasing() {
		return textAntialiasing;
	}

	public static void setTextAntialiasing(boolean textAntialiasing) {
		PlastikLookAndFeel.textAntialiasing = textAntialiasing;
	}
	
	private static boolean defaultOpacity = true;

	public static boolean getDefaultOpacity() {
		return defaultOpacity;
	}

	public static void setDefaultOpacity(boolean defaultOpacity) {
		PlastikLookAndFeel.defaultOpacity = defaultOpacity;
	} 
	
	private static boolean rolloverEnabled = false;

	public static boolean isRolloverEnabled() {
		return rolloverEnabled;
	}

	public static void setRolloverEnabled(boolean rolloverEnabled) {
		PlastikLookAndFeel.rolloverEnabled = rolloverEnabled;
	}
}
