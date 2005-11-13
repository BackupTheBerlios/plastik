package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikColorUIResource;
import de.hampelratte.plastik.PlastikUtils;
import java.awt.Color;

public abstract class AbstractColorTheme implements PlastikColorTheme {
	
	private static final int INACTIVE = 5;
	private static final int COLOR_COUNT = 22;
	
	protected int brighter     =  20;
	protected int brighterMore =  40;
	protected int darker       = -20;
	protected int darkerMore   = -40;
	
	protected int brighterInactive     =  20;
	protected int brighterMoreInactive =  40;
	protected int darkerInactive       = -20;
	protected int darkerMoreInactive   = -40;
	
	protected int rollover = 10;
	
	protected Color[] buttonColors = null;
	
	/**
	 * Berechnet aus der übergebenen Farbe eine hellere (1 bis 255) bzw. eine 
	 * dunklere (-1 bis -255) Farbe. Dabei orientiert sich die Berechnung an dem
	 * HSL-Farbmodel (L-Lightness).
	 * 
	 * @param rgb Die Farbe als int von der die hellere oder dunklere Farbe 
	 *            bestimmt werden soll.
	 * @param light Ein Integer zwischen -255 und 255 welcher die 
	 *              Helligkeitsänderung angibt.
	 * @return Die berechnete Farbe als int.
	 */
	public static final int computeAdjustedColor(int rgb, int light) {
		float h, s, l;
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >>  8) & 0xFF;
		int b = (rgb >>  0) & 0xFF;
	
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
		
		return 0xFF000000 | (r << 16) | (g << 8) | (b << 0);
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
		
	/**
	 * Colors:
	 *  +10 for Background
	 *  +10 for Foreground
	 *  + 1 for Focus
	 *  + 1 for Rollover
	 *  -----------------
	 *  = 22 pre-estimated Colors
	 */
	protected void computeColors(
			Color[] target, 
			Color activeColor, 
			Color inactiveColor, 
			Color activeForegroundColor, 
			Color inactiveForegroundColor, 
			Color focusColor,
			Color rolloverColor) {
		
		int rgb;
		
		// background active (0-4)
		rgb = activeColor.getRGB();
		target[0]                 = new PlastikColorUIResource(rgb);
		target[0 + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, brighter));
		target[0 + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, brighterMore));
		target[0 + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, darker));
		target[0 + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, darkerMore));
		
		// background inactive (5-9)
		rgb = inactiveColor.getRGB();
		target[0 + INACTIVE]                 = new PlastikColorUIResource(rgb);
		target[0 + INACTIVE + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, brighterInactive));
		target[0 + INACTIVE + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, brighterMoreInactive));
		target[0 + INACTIVE + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, darkerInactive));
		target[0 + INACTIVE + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, darkerMoreInactive));
		
		// foreground active (10-14)
		rgb = activeForegroundColor.getRGB();
		target[10]                 = new PlastikColorUIResource(rgb);
		target[10 + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, brighter));
		target[10 + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, brighterMore));
		target[10 + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, darker));
		target[10 + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, darkerMore));
		
		// foreground inactive (15-19)
		rgb = inactiveForegroundColor.getRGB();
		target[10 + INACTIVE]                 = new PlastikColorUIResource(rgb);
		target[10 + INACTIVE + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, brighterInactive));
		target[10 + INACTIVE + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, brighterMoreInactive));
		target[10 + INACTIVE + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, darkerInactive));
		target[10 + INACTIVE + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, darkerMoreInactive));
		
		// focus color (20)
		target[20] = focusColor;
		
		// rollover color (21)
		target[21] = rolloverColor;
	}
	
	protected Color getColor(Color[] colors, int type, int options) {
		Color color = null;
		if (type == TYPE_BACKGROUND) {
			int pos = 0;
			if ((options & INACTIVE_MASK) != 0) {
				pos += INACTIVE;
			}
			pos += (options & LIGHT_MASK); // TODO: no check for valid options..
			color = colors[pos];
		} else if (type == TYPE_FOREGROUND) {
			int pos = 10;
			if ((options & INACTIVE_MASK) != 0) {
				pos += INACTIVE;
			}
			pos += (options & LIGHT_MASK); // TODO: no check for valid options..
			color = colors[pos];			
		} else if (type == TYPE_FOCUS) {
			int pos = 20;
			color = colors[20];
		} else if (type == TYPE_ROLLOVER) {
			int pos = 21;
			color = colors[pos];
			//return new PlastikColorUIResource(computeAdjustedColor(color[pos].getRGB(), rollover));
		} else {
			throw new IllegalArgumentException("wrong type");
		}
		
		if ((options & ROLLOVER_MASK) != 0) {
			color = new PlastikColorUIResource(computeAdjustedColor(color.getRGB(), rollover));
		}
		return color;
	}
	
	public void setButtonColor(Color activeColor, Color inactiveColor, Color activeForegroundColor, Color inactiveForegroundColor, Color focusColor, Color rolloverColor) {
		if (buttonColors == null) buttonColors = new Color[COLOR_COUNT];
		computeColors(buttonColors, activeColor, inactiveColor, activeForegroundColor, inactiveForegroundColor, focusColor, rolloverColor);
	}
	
	public Color getButtonColor(int type, int options) {
		return getColor(buttonColors, type, options);
	}
	
}
