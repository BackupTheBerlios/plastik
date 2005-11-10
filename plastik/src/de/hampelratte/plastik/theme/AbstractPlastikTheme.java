package de.hampelratte.plastik.theme;

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
