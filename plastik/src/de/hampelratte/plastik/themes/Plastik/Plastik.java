package de.hampelratte.plastik.themes.Plastik;

import java.net.URL;

import javax.swing.ImageIcon;

import de.hampelratte.plastik.PlastikAudioTheme;
import de.hampelratte.plastik.PlastikBackgroundTheme;
import de.hampelratte.plastik.PlastikBorderTheme;
import de.hampelratte.plastik.PlastikColorTheme;
import de.hampelratte.plastik.PlastikFontTheme;
import de.hampelratte.plastik.PlastikIconTheme;
import de.hampelratte.plastik.PlastikTheme;
import de.hampelratte.plastik.themes.iconthemes.CrystalSVG.CrystalSVGTheme;

public class Plastik extends PlastikTheme {
	
	private PlastikAudioTheme audioTheme;
	private PlastikBackgroundTheme backgroundTheme;
	private PlastikBorderTheme borderTheme;
	private PlastikColorTheme colorTheme;
	private PlastikFontTheme fontTheme;
	private PlastikIconTheme iconTheme;
	
	public Plastik() {
		iconTheme = new CrystalSVGTheme();
	}
	
	public PlastikAudioTheme getAudioTheme() {
		return audioTheme;
	}

	public PlastikBackgroundTheme getBackgroundTheme() {
		return backgroundTheme;
	}

	public PlastikBorderTheme getBorderTheme() {
		return borderTheme;
	}

	public PlastikColorTheme getColorTheme() {
		return colorTheme;
	}

	public PlastikFontTheme getFontTheme() {
		return fontTheme;
	}

	public PlastikIconTheme getIconTheme() {
		return iconTheme;
	}

	public void setAudioTheme(PlastikAudioTheme audioTheme) {
		this.audioTheme = audioTheme;
	}

	public void setBackgroundTheme(PlastikBackgroundTheme backgroundTheme) {
		this.backgroundTheme = backgroundTheme;
	}

	public void setBorderTheme(PlastikBorderTheme borderTheme) {
		this.borderTheme = borderTheme;
	}

	public void setColorTheme(PlastikColorTheme colorTheme) {
		this.colorTheme = colorTheme;
	}

	public void setFontTheme(PlastikFontTheme fontTheme) {
		this.fontTheme = fontTheme;
	}

	public void setIconTheme(PlastikIconTheme iconTheme) {
		this.iconTheme = iconTheme;
	}
}
