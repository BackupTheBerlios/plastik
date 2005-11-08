package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.basic.BasicLookAndFeel;
import de.hampelratte.plastik.borders.PlastikBorder;
import de.hampelratte.plastik.borders.PlastikButtonBorder;
import de.hampelratte.plastik.borders.PlastikScrollPaneBorder;
import de.hampelratte.plastik.borders.PlastikTextComponentBorder;


/**
 * TODO Diskussion ob sinnvoll oder nicht<br>
 *
 * Hier ein paar Vorschl�ge aus meinem Avio-Theme:
 * Das PlastikLookAndFeel sollte an sp�tere Ver�nderungen durch Themes 
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
 * Ein Nachteil ist der h�here Aufwand.
 */
// TODO ALLE runden ecken m�ssen nachgearbeitet werden. im moment sind die nicht transparent. 
// zu sehen wenn man dem Panel in der Main.java ne andere hintergrundfarbe verpasst. 
public class PlastikLookAndFeel extends BasicLookAndFeel {
	
	/** The PlastikTheme used by the LookAndFeel */
	private PlastikColorTheme theme = null;
		
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
	
	public void setTheme(PlastikColorTheme theme) {
		this.theme = theme;
	}

	protected void initClassDefaults(UIDefaults table) {
		super.initClassDefaults(table);
		table.put("ButtonUI", "de.hampelratte.plastik.PlastikButtonUI");
		table.put("CheckBoxUI", "de.hampelratte.plastik.PlastikCheckBoxUI");
		table.put("ComboBoxUI", "de.hampelratte.plastik.PlastikComboBoxUI");
		table.put("LabelUI", "de.hampelratte.plastik.PlastikLabelUI");
		table.put("RadioButtonUI",
		"de.hampelratte.plastik.PlastikRadioButtonUI");
		table.put("ScrollBarUI", "de.hampelratte.plastik.PlastikScrollBarUI");
		table.put("SpinnerUI", "de.hampelratte.plastik.PlastikSpinnerUI");
		table.put("TextFieldUI", "de.hampelratte.plastik.PlastikTextFieldUI");
		table.put("TextAreaUI", "de.hampelratte.plastik.PlastikTextAreaUI");
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
	
	protected void initComponentDefaults(UIDefaults table) {
		super.initComponentDefaults(table);

		// borders
		table.put("Common.border", new PlastikBorder());
		table.put("Button.border", new PlastikButtonBorder());
		table.put("ComboBox.border", null);
		table.put("ScrollPane.border", new PlastikScrollPaneBorder());
		table.put("TextArea.border", new PlastikTextComponentBorder());
		table.put("TextField.border", new PlastikTextComponentBorder());
		

		// fonts
		table.put("Common.font", new FontUIResource(new Font(
				"Bitstream Vera Sans", Font.PLAIN, 14)));
		table.put("Button.font", table.getFont("Common.font"));
		table.put("ComboBox.font", table.getFont("Common.font"));
		table.put("Label.font", table.getFont("Common.font"));
		table.put("Panel.font", table.getFont("Common.font"));
		table.put("RadioButton.font", table.getFont("Common.font"));
		table.put("TextField.font", table.getFont("Common.font"));
		table.put("TextArea.font", table.getFont("Common.font"));
		table.put("ToolTip.font", table.getFont("Common.font"));
		table.put("TabbedPane.font", table.getFont("Common.font"));

		// colors
		table.put("Common.background", new ColorUIResource(new Color(239, 239,
				239)));
		table.put("Common.foreground", new ColorUIResource(Color.BLACK));
		table.put("Common.contour", new PlastikColorUIResource(new Color(0, 0,
				0, 97)));
		table.put("Common.contourSmoother", new PlastikColorUIResource(
				new Color(0, 0, 0, 49)));
		table.put("Common.contourDisabled", new PlastikColorUIResource(
				new Color(0, 0, 0, 69)));
		table.put("Common.contourDisabledSmoother", new PlastikColorUIResource(
				new Color(0, 0, 0, 31)));
		table.put("Common.innerContour", new PlastikColorUIResource(new Color(
				0, 0, 0, 204)));
		table.put("Common.innerContourSmoother", new PlastikColorUIResource(
				new Color(0, 0, 0, 102)));
		table.put("Common.innerContourPressed", new PlastikColorUIResource(
				new Color(0, 0, 0, 114)));
		table.put("Common.innerContourPressedSmoother",
				new PlastikColorUIResource(new Color(0, 0, 0, 81)));
		table.put("Common.highlight", new PlastikColorUIResource(new Color(103,
				141, 178, 170)));
		table.put("Common.highlightSmoother", new PlastikColorUIResource(
				new Color(103, 141, 178, 100)));
		table.put("Common.focus", new ColorUIResource(Color.BLACK));
		table.put("Common.disabledText", table.get("textInactiveText"));
		table
				.put("RadioButton.background", table
						.getColor("Common.background"));
		table.put("Button.background", new PlastikColorUIResource(new Color(229, 231, 236)));
		table.put("Label.background", table.getColor("Common.background"));
		table.put("Panel.background", table.getColor("Common.background"));
		table.put("ScrollPane.background", table.getColor("Common.background"));
		table.put("Slider.background", table.getColor("Common.background"));
		table.put("ComboBox.background", Color.WHITE);
	    table.put("ComboBox.foreground", table.get("Common.foreground"));
		table.put("ComboBox.disabledBackground", table.get("Common.background"));
	    table.put("ComboBox.disabledForeground",table.get("Common.disabledText"));
	    table.put("ComboBox.selectionForeground", Color.WHITE );
	    table.put("ComboBox.selectionBackground", table.getColor("textHighlight") );
	    table.put("TextField.disabledBackground", table.get("Common.background"));
	    
	    //table.put("Spinner.editorBorderPainted", new Boolean(true));

		// TODO farben f�r die ganzen gradienten handeln
	}

	public static boolean isTextAntialiasing() {
		return textAntialiasing;
	}

	public static void setTextAntialiasing(boolean textAntialiasing) {
		PlastikLookAndFeel.textAntialiasing = textAntialiasing;
	}
	
	private static boolean defaultOpacity = true;

	public static boolean isDefaultOpacity() {
		return defaultOpacity;
	}

	public static void setDefaultOpacity(boolean defaultOpacity) {
		PlastikLookAndFeel.defaultOpacity = defaultOpacity;
	} 
}
