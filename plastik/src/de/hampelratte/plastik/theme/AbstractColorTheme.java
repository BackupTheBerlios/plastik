package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikColorUIResource;
import de.hampelratte.plastik.PlastikUtils;
import java.awt.Color;
import java.util.ArrayList;

public abstract class AbstractColorTheme implements PlastikColorTheme {
	
	// colors used by KDE
	protected static final int KDE_DEFAULT_BACKGROUND           = 0;
	protected static final int KDE_DEFAULT_TEXT                 = 1;
	protected static final int KDE_SELECTED_BACKGROUND          = 2;
	protected static final int KDE_SELECTED_TEXT                = 3;
	protected static final int KDE_LINK                         = 4;
	protected static final int KDE_USED_LINK                    = 5;
	protected static final int KDE_WINDOW_BACKGROUND            = 6;
	protected static final int KDE_WINDOW_TEXT                  = 7;
	protected static final int KDE_BUTTON_BACKGROUND            = 8;
	protected static final int KDE_BUTTON_TEXT                  = 9;
	protected static final int KDE_ACTIVE_TITLEBAR              = 10;
	protected static final int KDE_ACTIVE_TITLEBAR_TEXT         = 11;
	protected static final int KDE_ACTIVE_TITLEBAR_GRADIENT     = 12;
	protected static final int KDE_ACTIVE_TITLEBAR_BUTTON       = 13;
	protected static final int KDE_INACTIVE_TITLEBAR            = 14;
	protected static final int KDE_INACTIVE_TITLEBAR_TEXT       = 15;
	protected static final int KDE_INACTIVE_TITLEBAR_GRADIENT   = 16;
	protected static final int KDE_INACTIVE_TITLEBAR_BUTTON     = 17;
	protected static final int KDE_ACTIVE_WINDOWBORDER          = 18;
	protected static final int KDE_ACTIVE_WINDOWBORDER_HANDLE   = 19;
	protected static final int KDE_INACTIVE_WINDOWBORDER        = 20;
	protected static final int KDE_INACTIVE_WINDOWBORDER_HANDLE = 21;
	protected static final int KDE_ALTERNATIVE_LIST_BACKGROUND  = 22;
	
	// colors and adjustmentvalues
	protected int colorCount;
	protected int[] adjustmentValues;
	protected PlastikColorUIResource[] colorArray;
	
	public AbstractColorTheme() {
		colorCount = 256 * UI_COUNT; // 256 colors per ui
		adjustmentValues = new int[colorCount];
		precomputeAdjustmentValues();
		colorArray = new PlastikColorUIResource[colorCount];
	}
	
	
	/**
	 * This assigns the given KDE-colors to the Plastik-Theme color-mapping.
	 * The given Colors must in the same order as the constants above.
	 * This method deletes all predefined Colors, assignes the kde-colors to 
	 * the normal colors and set the correct adjustmentvalues.
	 * TODO: not completly implemented
	 */
	protected void setKDEColors(Color[] kdeColors) {
		// 1. delete all colors
		// TODO replace this calls by one call of deleteAllColors()
		deleteColors(BACKGROUND);
		deleteColors(BACKGROUND_COMPONENT);
		deleteColors(BACKGROUND_PRESSED);
		deleteColors(BORDER);
		deleteColors(BORDER_COMPONENT);
		
		// 2. define all colors
		setColor(kdeColors[KDE_WINDOW_BACKGROUND], BACKGROUND);
		setColor(kdeColors[KDE_WINDOW_BACKGROUND], BACKGROUND | INACTIVE);
		setColor(kdeColors[KDE_BUTTON_BACKGROUND], BACKGROUND_COMPONENT);
		setColor(kdeColors[KDE_WINDOW_BACKGROUND], BACKGROUND_COMPONENT | INACTIVE);
		setColor(kdeColors[KDE_BUTTON_BACKGROUND], BACKGROUND_PRESSED);
		setColor(kdeColors[KDE_WINDOW_BACKGROUND], BACKGROUND_PRESSED | INACTIVE);
		setColor(kdeColors[KDE_WINDOW_BACKGROUND], BORDER);
		setColor(kdeColors[KDE_WINDOW_BACKGROUND], BORDER | INACTIVE);
		setColor(kdeColors[KDE_BUTTON_BACKGROUND], BORDER_COMPONENT);
		setColor(kdeColors[KDE_WINDOW_BACKGROUND], BORDER_COMPONENT | INACTIVE);
		
		//3. define adjustmentvalues
		// The first adjustment in the array acts like an offset for all the 
		// other adjustments. 
		setMultipleAdjustments(
				BACKGROUND, 
				new int[] {   0,  21,  40,  10, -21, -40, -10,   0,  // active
				             -3,   6,  12,   3,  -6, -12,  -3,   0}, // inactive
				new int[] {   0,   0,   0,   0,   0,   0,   0,   0,
				              0,   0,   0,   0,   0,   0,   0,   0});
		setMultipleAdjustments(
				BACKGROUND_COMPONENT,
				new int[] {   0,  21,  40,  10, -21, -40, -10,   0,
				             -3,   6,  12,   3,  -6, -12,  -3,   0},
				new int[] {   0,   0,   0,   0,   0,   0,   0,   0,
				              0,   0,   0,   0,   0,   0,   0,   0});
		setMultipleAdjustments(
				BACKGROUND_PRESSED,
				new int[] { -24,  21,  40,  10, -21, -40, -10,   0,
				            -12,   6,  12,   3,  -6, -12,  -3,   0},
				new int[] {   0,   0,   0,   0,   0,   0,   0,   0,
				              0,   0,   0,   0,   0,   0,   0,   0});
		setMultipleAdjustments(
				BORDER,
				new int[] {   0,   0,   0,   0,   0,   0,   0,   0,
				              0,   0,   0,   0,   0,   0,   0,   0},
				new int[] {   0,   0,   0,   0,   0,   0,   0,   0,
				              0,   0,   0,   0,   0,   0,   0,   0});
		setMultipleAdjustments(
				BORDER_COMPONENT,
				new int[] { -88,  50,  70,  30,   0,   0,   0,   0,
				            -20,   0,   0,   0,   0,   0,   0,   0},
				new int[] {   0,   0,   0,   0,   0,   0,   0,   0,
				              0,   0,   0,   0,   0,   0,   0,   0});
		
	}
	
	// TODO remove this method if it is no longer needed
	protected void deleteColors(int colorType) {
		int nextColorStep = 256;
		// Alle Komponenten durchlaufen und an die Stelle des betreffenden
		// colorTypes springen.
		for (int i=colorType; i<colorCount; i+=nextColorStep) {
			
			// Jede Variation (inactive/darker etc.) l�schen.
			for (int j=0; j<16; j++) {
				colorArray[i+j] = null;
			}
		}
	}
	
	/**
	 * This method is used to directly assign multiple adjustmentvalues at once.
	 * The adjustments apply to all ui-components as once. (COMMON, BUTTON, ...)
	 *
	 * @param colorType the type for that the adjustmentvalues should be set. 
	 * @param brightnessAdjustments an array of 16 Elements, that define the 
	 *                              brigtnesscorrection for the set color.
	 * @param alphaAdjustments an array of 16 Elements, that define the 
	 *                              alphacorrection for the set color.
	 */
	protected void setMultipleAdjustments(int colorType, int[] brightnessAdjustments, int[] alphaAdjustments) {
		int length = 16;
		if (brightnessAdjustments == null || brightnessAdjustments.length != length)
			throw new IllegalArgumentException("brightnessAdjustments can't be null and must have "+length+" elements");
		if (alphaAdjustments == null || alphaAdjustments.length != length)
			throw new IllegalArgumentException("alphaAdjustments can't be null and must have "+length+" elements");
		
		int[] adjustmentValues = new int[length];
		for (int i=0; i<length; i++) {
			adjustmentValues[i] = computeAdjustmentValue(brightnessAdjustments[i], alphaAdjustments[i]);
		}
		
		int nextColorStep = 256;
		for (int i=colorType; i<colorCount; i+=nextColorStep) {
			for (int j=0; j<length; j++) {
				this.adjustmentValues[i+j] = adjustmentValues[j];
			}
		}
	}
	
	
	private void precomputeAdjustmentValues() {
		for (int i=0; i<colorCount; i+=16) {
			// active
			adjustmentValues[i]    = computeAdjustmentValue(  0, 0); // normal
			adjustmentValues[i+1]  = computeAdjustmentValue( 20, 0); // brighter
			adjustmentValues[i+2]  = computeAdjustmentValue( 40, 0); // brighter more
			adjustmentValues[i+3]  = computeAdjustmentValue( 10, 0); // brighter gradient
			adjustmentValues[i+4]  = computeAdjustmentValue(-20, 0); // darker
			adjustmentValues[i+5]  = computeAdjustmentValue(-40, 0); // darker more
			adjustmentValues[i+6]  = computeAdjustmentValue(-10, 0); // darker gradient
			// inactive
			adjustmentValues[i+8]  = computeAdjustmentValue(  0, 0); // normal
			adjustmentValues[i+9]  = computeAdjustmentValue( 10, 0); // brighter
			adjustmentValues[i+10] = computeAdjustmentValue( 20, 0); // brighter more
			adjustmentValues[i+11] = computeAdjustmentValue(  5, 0); // brighter gradient
			adjustmentValues[i+12] = computeAdjustmentValue(-10, 0); // darker
			adjustmentValues[i+13] = computeAdjustmentValue(-20, 0); // darker more
			adjustmentValues[i+14] = computeAdjustmentValue( -5, 0); // darker gradient
		}
	}
	
	/**
	 * Bestimmt einen Korrekturwert, bestehend aus der �nderung der Helligkeit
	 * und des Alpha-Wertes.
	 *
	 * @param brightnessAdjustment Helligkeits�nderung im Bereich (-255..255)
	 * @param alphaAdjustment Alphakanal�nderung im Bereich (-255..255)
	 * @return Es wird ein Wert zur�ckgegeben welcher die beiden �nderungen
	 *         vereint.
	 * TODO translate comment
	 */
	public static int computeAdjustmentValue(int brightnessAdjustment, int alphaAdjustment) {
		if (brightnessAdjustment < -255 || brightnessAdjustment > 255)
			throw new IllegalArgumentException("brightnessAdjustment "+brightnessAdjustment+" out of range (-255..255)");
		if (alphaAdjustment < -255 || brightnessAdjustment > 255)
			throw new IllegalArgumentException("alphaAdjustment "+alphaAdjustment+" out of range (-255..255)");
		brightnessAdjustment += 255; //max = 255+255 = 510, min = -255+255 = 0 (9 Bit)
		alphaAdjustment      += 255; //max = 255+255 = 510, min = -255+255 = 0 (9 Bit)
		int adjustmentValue = brightnessAdjustment | (alphaAdjustment << 16);
		return adjustmentValue;
	}
	
	/**
	 * Gewinnt aus einem Korrekturwert die Helligkeits�nderung.
	 */
	public static int getBrightnessAdjustment(int adjustmentValue) {
		return (adjustmentValue & 0xFFFF) - 255;
	}
	
	/**
	 * Gewinnt aus einem Korrekturwert die Alpha�nderung
	 */
	public static int getAlphaAdjustment(int adjustmentValue) {
		return ((adjustmentValue >> 16) & 0xFFFF) - 255;
	}
	
	/**
	 * Setzt den Helligkeitskorrekturwert f�r eine einzelne Farbe.
	 * Die entsprechende Farbe wird dabei aber nicht aktualisiert, dies muss
	 * manuel geschehen.
	 */
	public void setAdjustmentValue(int adjustmentValue, int type) {
		adjustmentValues[type] = adjustmentValue;
	}
	
	/**
	 * Gibt den Helligkeitskorrekturwert f�r eine einzelne Farbe zur�ck.
	 */
	public int getAdjustmentValue(int type) {
		return adjustmentValues[type];
	}
	
	public void setColor(int r, int g, int b, int a, int type) {
		setColor(new Color(r,g,b,a), type);
	}
	
	public void setColor(int r, int g, int b, int type) {
		setColor(new Color(r,g,b), type);
	}
	
	/**
	 * Setzt eine eine einzelne Grundfarbe (Farbe ohne Varianten). Dabei wird
	 * aber sehr wohl zwischen ACTIVE und INACTIVE unterschieden.
	 */
	public void setColor(Color color, int type) {
		int index = type & (INACTIVE_MASK | TYPES_MASK | UI_MASK); // ignoring the variants
		int ad = adjustmentValues[index];
		int rgb = color.getRGB();
		if (ad != 0) {
			rgb = computeAdjustedColor(rgb, ad);
		}
		colorArray[index] = new PlastikColorUIResource(rgb);
	}
	
	/**
	 * This function should return a cached version of the color if the param
	 * color is an instance of PlastikColorUIResource. If the param is no
	 * UIResource then it should return a computed color.
	 *
	 * @param color the color-object of the component.
	 * @param type the requested type.
	 */
	public Color getColor(Color color, int type) {
		if (color instanceof PlastikColorUIResource) {
			return getColor(type);
		}
		// the next line ensures that secondary colors are computed correctly,
		// so first the variant is left out
		color = computeColor(color, type & (UI_MASK | TYPES_MASK | INACTIVE_MASK));
		return computeColor(color, type);
	}
	
	/**
	 * Diese Funktion schaut nach ob die gesuchte Farbe bereits definiert ist 
	 * oder nicht. In dem Falle das die Farbe bereits definiert ist wird dise 
	 * ohne weiteren Umweg zur�ckgegeben.
	 *
	 * Die Grundfarben von COMMON sollten immer existieren. Wir allerdings nach 
	 * einer Variante davon gefragt, dann wird diese entsprechend aus der 
	 * Grundfarbe und dem zugeh�rigen Adjustment-Wert berechnet.
	 *
	 * Bei anderen UI-Komponenten wird zun�chst auch auf die Grundfarbe der 
	 * Komponente zur�ckgegriffen und mit Hilfe des zugeh�rigen 
	 * Adjustment-Wertes die neue Farbe berechnet. Sollte die Grundfarbe der 
	 * Komponente nicht existieren, so wird diese von COMMON durch nochmaligen 
	 * Aufruf der Methode vorher besorgt.
	 */
	public PlastikColorUIResource getColor(int type) {
		PlastikColorUIResource color = colorArray[type];
		
		if (color != null) {
			return color; // Farbe ist bereits gestgelegt worden
		}
		
		// Die Farbe existiert nicht, daher wird als Erstes die Frage
		// gestellt ob es sich um eine Variante oder eine "Grundfarbe"
		// (Variante ist NORMAL) handelt. 
		// index zeigt auf die Grundfarbe, da die Variante ignoriert wird.
		int index = type & (INACTIVE_MASK | TYPES_MASK | UI_MASK);
		
		if (index == type) {
			// Es ist eine "Grundfarbe", da die Variante NORMAL (0) ist.
			// Es wird nun bei COMMON nachgefragt, da dort die "Grundfarbe" auf
			// jeden Fall vorhanden sein sollte, es sei denn dieser Aufruf fragt
			// bereits nach COMMON
			if ((type & UI_MASK) == COMMON) {
				throw new IllegalStateException("at least the basecolors for COMMON must be defined");
			} else {
				// Die Farbe wird von COMMON abgefragt, entsprechend des
				// Adjustments ver�ndert (falls != 0) und gespeichert.
				color = getColor(COMMON + (index & (INACTIVE_MASK | TYPES_MASK)));
				if (adjustmentValues[index] != 0) {
					color = new PlastikColorUIResource(computeAdjustedColor(color.getRGB(), adjustmentValues[index]));
				}
				colorArray[index] = color;
			}
		} else {
			// Es ist keine "Grundfarbe", da die Variante nicht NORMAL (0) ist.
			// Es wird zun�chst die Grundfarbe der Komponente erfragt und 
			// entsprechend des Adjustments ver�ndert (falls != 0) und 
			// gespeichert.
			color = getColor(index);
			if (adjustmentValues[type] != 0) {
				color = new PlastikColorUIResource(computeAdjustedColor(color.getRGB(), adjustmentValues[type]));
			}
			colorArray[type] = color;
		}
		return color;
	}
	
	public Color computeColor(Color color, int type) {
		return new Color(computeAdjustedColor(color.getRGB(), adjustmentValues[type]));
	}
	
	/**
	 * Berechnet aus der �bergebenen Farbe eine hellere (1 bis 255) bzw. eine
	 * dunklere (-1 bis -255) Farbe. Dabei orientiert sich die Berechnung an dem
	 * HSL-Farbmodel (L-Lightness).
	 *
	 * @param rgb Die Farbe als int von der die hellere oder dunklere Farbe
	 *            bestimmt werden soll.
	 * @param light Ein Integer zwischen -255 und 255 welcher die
	 *              Helligkeits�nderung angibt.
	 * @return Die berechnete Farbe als int.
	 */
	public static final int computeAdjustedColor(int argb, int adjustmentValue) {
		int light = getBrightnessAdjustment(adjustmentValue);
		int alpha = getAlphaAdjustment(adjustmentValue);
		
		float h, s, l;
		int a = (argb >> 24) & 0xFF;
		int r = (argb >> 16) & 0xFF;
		int g = (argb >>  8) & 0xFF;
		int b = (argb >>  0) & 0xFF;
		
		int max = Math.max(r, Math.max(g, b));
		int min = Math.min(r, Math.min(g, b));
		
		float sum = max + min;
		float dif = max - min;
		
		l = sum / 2.0f / 255.0f;
		if (max == min) {
			h = s = 0.0f;
		} else {
			s = (l <= 0.5f) ? dif/sum : dif/(2.0f*255.0f - sum);
			
			if (r == max) {
				h =             (g-b) / dif / 6.0f;
			} else if (g == max) {
				h = 1.0f/3.0f + (b-r) / dif / 6.0f;
			} else {
				h = 2.0f/3.0f + (r-g) / dif / 6.0f;
			}
			
			if (h < 0.0f) {
				h += 1.0f;
			}
		}
		
		l += (float) light / 255.0f;
		l = Math.max(0.0f, Math.min(1.0f, l));
		
		sum = (l <= 0.5) ? l*(s+1.0f) : l+s - l*s;
		dif = 2.0f * l - sum;
		r = Math.round((255.0f * hueToRGB(dif, sum, h+1.0f/3.0f)));
		g = Math.round((255.0f * hueToRGB(dif, sum, h          )));
		b = Math.round((255.0f * hueToRGB(dif, sum, h-1.0f/3.0f)));
		
		a += alpha;
		a = Math.max(0, Math.min(255, a));
		
		return (a << 24) | (r << 16) | (g << 8) | (b << 0);
	}
	
	private static final float hueToRGB(float dif, float sum, float h) {
		if (h < 0.0f) {
			h += 1.0f;
		} else if (h > 1.0f) {
			h -= 1.0f;
		}
		if (h*6.0f < 1.0f) {
			return dif + (sum - dif) * h * 6.0f;
		}
		if (h*2.0f < 1.0f) {
			return sum;
		}
		if (h*3.0f < 2.0f) {
			return dif + (sum - dif) * (2.0f/3.0f-h) * 6.0f;
		}
		return dif;
	}
}
