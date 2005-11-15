package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikColorUIResource;
import de.hampelratte.plastik.PlastikUtils;
import java.awt.Color;

public abstract class AbstractColorTheme implements PlastikColorTheme {
	
	// active
	protected int backgroundBrighter     =  20;
	protected int backgroundBrighterMore =  40;
	protected int backgroundDarker       = -20;
	protected int backgroundDarkerMore   = -40;
	
	protected int foregroundBrighter     =  20;
	protected int foregroundBrighterMore =  40;
	protected int foregroundDarker       = -20;
	protected int foregroundDarkerMore   = -40;
	
	protected int borderBrighter         =  20;
	protected int borderBrighterMore     =  40;
	protected int borderDarker           = -20;
	protected int borderDarkerMore       = -40;
	
	// inactive
	protected int inactiveBackgroundBrighter     =  20;
	protected int inactiveBackgroundBrighterMore =  40;
	protected int inactiveBackgroundDarker       = -20;
	protected int inactiveBackgroundDarkerMore   = -40;
	
	protected int inactiveForegroundBrighter     =  20;
	protected int inactiveForegroundBrighterMore =  40;
	protected int inactiveForegroundDarker       = -20;
	protected int inactiveForegroundDarkerMore   = -40;
	
	protected int inactiveBorderBrighter         =  20;
	protected int inactiveBorderBrighterMore     =  40;
	protected int inactiveBorderDarker           = -20;
	protected int inactiveBorderDarkerMore       = -40;
	
	// rollover extra add
	protected int rollover = 10;
	
	// indices for colors
	private static final int BACKGROUND_INDEX =  0;
	private static final int FOREGROUND_INDEX = 10;
	private static final int BORDER_INDEX     = 20;
	private static final int FOCUS_INDEX      = 30;
	private static final int ROLLOVER_INDEX   = 31;
	
	private static final int INACTIVE_BLOCK_SIZE = 5;
	private static final int COLOR_COUNT = 32;
	
//	protected int brighter     =  20;
//	protected int brighterMore =  40;
//	protected int darker       = -20;
//	protected int darkerMore   = -40;
//	
//	protected int brighterInactive     =  20;
//	protected int brighterMoreInactive =  40;
//	protected int darkerInactive       = -20;
//	protected int darkerMoreInactive   = -40;
//	
//	protected int rollover = 10;
	
	protected Color[] colors = null;
	
//	protected Color[] buttonColors = null;
	
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
	 *  +10 for Border
	 *  + 1 for Focus
	 *  + 1 for Rollover
	 *  -----------------
	 *  = 32 pre-estimated Colors
	 */
	protected void computeColors(
			Color[] target, 
			Color activeBackgroundColor, 
			Color inactiveBackgroundColor, 
			Color activeForegroundColor, 
			Color inactiveForegroundColor, 
			Color activeBorderColor, 
			Color inactiveBorderColor, 
			Color focusColor, 
			Color rolloverColor) {
		
		int rgb;
		
		// background active (0-4)
		rgb = activeBackgroundColor.getRGB();
		target[BACKGROUND_INDEX]                 = new PlastikColorUIResource(rgb);
		target[BACKGROUND_INDEX + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, backgroundBrighter));
		target[BACKGROUND_INDEX + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, backgroundBrighterMore));
		target[BACKGROUND_INDEX + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, backgroundDarker));
		target[BACKGROUND_INDEX + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, backgroundDarkerMore));
		
		// background inactive (5-9)
		rgb = inactiveBackgroundColor.getRGB();
		target[BACKGROUND_INDEX + INACTIVE_BLOCK_SIZE]                 = new PlastikColorUIResource(rgb);
		target[BACKGROUND_INDEX + INACTIVE_BLOCK_SIZE + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveBackgroundBrighter));
		target[BACKGROUND_INDEX + INACTIVE_BLOCK_SIZE + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveBackgroundBrighterMore));
		target[BACKGROUND_INDEX + INACTIVE_BLOCK_SIZE + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveBackgroundDarker));
		target[BACKGROUND_INDEX + INACTIVE_BLOCK_SIZE + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveBackgroundDarkerMore));
		
		// foreground active (10-14)
		rgb = activeBackgroundColor.getRGB();
		target[FOREGROUND_INDEX]                 = new PlastikColorUIResource(rgb);
		target[FOREGROUND_INDEX + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, foregroundBrighter));
		target[FOREGROUND_INDEX + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, foregroundBrighterMore));
		target[FOREGROUND_INDEX + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, foregroundDarker));
		target[FOREGROUND_INDEX + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, foregroundDarkerMore));
		
		// foreround inactive (15-19)
		rgb = inactiveBackgroundColor.getRGB();
		target[FOREGROUND_INDEX + INACTIVE_BLOCK_SIZE]                 = new PlastikColorUIResource(rgb);
		target[FOREGROUND_INDEX + INACTIVE_BLOCK_SIZE + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveForegroundBrighter));
		target[FOREGROUND_INDEX + INACTIVE_BLOCK_SIZE + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveForegroundBrighterMore));
		target[FOREGROUND_INDEX + INACTIVE_BLOCK_SIZE + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveForegroundDarker));
		target[FOREGROUND_INDEX + INACTIVE_BLOCK_SIZE + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveForegroundDarkerMore));
		
		// border active (20-24)
		rgb = activeBackgroundColor.getRGB();
		target[BORDER_INDEX]                 = new PlastikColorUIResource(rgb);
		target[BORDER_INDEX + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, borderBrighter));
		target[BORDER_INDEX + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, borderBrighterMore));
		target[BORDER_INDEX + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, borderDarker));
		target[BORDER_INDEX + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, borderDarkerMore));
		
		// border inactive (25-29)
		rgb = inactiveBackgroundColor.getRGB();
		target[BORDER_INDEX + INACTIVE_BLOCK_SIZE]                 = new PlastikColorUIResource(rgb);
		target[BORDER_INDEX + INACTIVE_BLOCK_SIZE + BRIGHTER]      = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveBorderBrighter));
		target[BORDER_INDEX + INACTIVE_BLOCK_SIZE + BRIGHTER_MORE] = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveBorderBrighterMore));
		target[BORDER_INDEX + INACTIVE_BLOCK_SIZE + DARKER]        = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveBorderDarker));
		target[BORDER_INDEX + INACTIVE_BLOCK_SIZE + DARKER_MORE]   = new PlastikColorUIResource(computeAdjustedColor(rgb, inactiveBorderDarkerMore));
			
		// focus color (30)
		target[FOCUS_INDEX] = focusColor;
		
		// rollover color (31)
		target[ROLLOVER_INDEX] = rolloverColor;
	}
	
	protected Color getColor(Color[] colors, int type, int options) {
		Color color = null;
		int pos;
		
		switch(type) {
			case TYPE_BACKGROUND :
				pos = BACKGROUND_INDEX;
				if ((options & INACTIVE_MASK) != 0)
					pos += INACTIVE_BLOCK_SIZE;
				pos += (options & LIGHT_MASK); // TODO: no check for valid options..
				color = colors[pos];
				break;
			case TYPE_FOREGROUND :
				pos = FOREGROUND_INDEX;
				if ((options & INACTIVE_MASK) != 0)
					pos += INACTIVE_BLOCK_SIZE;
				pos += (options & LIGHT_MASK); // TODO: no check for valid options..
				color = colors[pos];
				break;
			case TYPE_BORDER :
				pos = BORDER_INDEX;
				if ((options & INACTIVE_MASK) != 0)
					pos += INACTIVE_BLOCK_SIZE;
				pos += (options & LIGHT_MASK); // TODO: no check for valid options..
				color = colors[pos];
				break;
			case TYPE_FOCUS :
				pos = FOCUS_INDEX;
				color = colors[pos];
				break;
			case TYPE_ROLLOVER :
				 pos = ROLLOVER_INDEX;
				color = colors[pos]; break;
			default :
				throw new IllegalArgumentException("wrong type");
		}
		
		if ((options & ROLLOVER_MASK) != 0) {
			color = new PlastikColorUIResource(computeAdjustedColor(color.getRGB(), rollover));
		}
		return color;
	}
	
//	public void setButtonColor(Color activeColor, Color inactiveColor, Color activeForegroundColor, Color inactiveForegroundColor, Color focusColor, Color rolloverColor) {
//		if (buttonColors == null) buttonColors = new Color[COLOR_COUNT];
//		computeColors(buttonColors, activeColor, inactiveColor, activeForegroundColor, inactiveForegroundColor, focusColor, rolloverColor);
//	}
//	
//	public Color getButtonColor(int type, int options) {
//		return getColor(buttonColors, type, options);
//	}
	
	public void setColors(
			Color activeBackgroundColor, 
			Color inactiveBackgroundColor, 
			Color activeForegroundColor, 
			Color inactiveForegroundColor, 
			Color activeBorderColor, 
			Color inactiveBorderColor, 
			Color focusColor, 
			Color rolloverColor) {
		if (colors == null) 
			colors = new Color[COLOR_COUNT];
		computeColors(
				colors, 
				activeBackgroundColor, 
				inactiveBackgroundColor, 
				activeForegroundColor, 
				inactiveForegroundColor, 
				activeBorderColor, 
				inactiveBorderColor, 
				focusColor, 
				rolloverColor);
	}
	
	public Color getColor(int type, int options) {
		return getColor(colors, type, options);
	}

	public PlastikColorUIResource getColor(int type) {
		throw new IllegalArgumentException("not implemented");
	}
	
	public Color computeColor(Color color, int type) {
		throw new IllegalArgumentException("not implemented");
	}
	
}
