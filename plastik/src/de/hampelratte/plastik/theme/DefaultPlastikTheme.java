package de.hampelratte.plastik.theme;

public class DefaultPlastikTheme extends AbstractPlastikTheme {
	
	public DefaultPlastikTheme() {
//		setAudioTheme(new DefaultAudioTheme());
//		setBackgroundTheme(new DefaultBackgroundTheme());
//		setBorderTheme(new DefaultBorderTheme());
//		setColorTheme(new DefaultColorTheme());
//		setFontTheme(new DefaultFontTheme());
//		setIconTheme(new DefaultIconTheme());
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
