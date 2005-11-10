package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikAudioTheme;
import de.hampelratte.plastik.PlastikBackgroundTheme;
import de.hampelratte.plastik.PlastikBorderTheme;
import de.hampelratte.plastik.PlastikColorTheme;
import de.hampelratte.plastik.PlastikFontTheme;
import de.hampelratte.plastik.PlastikIconTheme;
import de.hampelratte.plastik.PlastikTheme;

public class AbstractPlastikTheme implements PlastikTheme {
	
	protected PlastikAudioTheme      audioTheme;
	protected PlastikBackgroundTheme backgroundTheme;
	protected PlastikBorderTheme     borderTheme;
	protected PlastikColorTheme      colorTheme;
	protected PlastikFontTheme       fontTheme;
	protected PlastikIconTheme       iconTheme;

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
}
