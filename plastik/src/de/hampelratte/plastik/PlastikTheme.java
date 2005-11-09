package de.hampelratte.plastik;

public abstract class PlastikTheme {
	public abstract PlastikAudioTheme getAudioTheme();
	public abstract PlastikBackgroundTheme getBackgroundTheme();
	public abstract PlastikBorderTheme getBorderTheme();
	public abstract PlastikColorTheme getColorTheme();
	public abstract PlastikFontTheme getFontTheme();
	public abstract PlastikIconTheme getIconTheme();

	public abstract void setAudioTheme(PlastikAudioTheme audioTheme);
	public abstract void setBackgroundTheme(PlastikBackgroundTheme backgroundTheme);
	public abstract void setBorderTheme(PlastikBorderTheme borderTheme);
	public abstract void setColorTheme(PlastikColorTheme colorTheme);
	public abstract void setFontTheme(PlastikFontTheme fontTheme);
	public abstract void setIconTheme(PlastikIconTheme iconTheme);
}
