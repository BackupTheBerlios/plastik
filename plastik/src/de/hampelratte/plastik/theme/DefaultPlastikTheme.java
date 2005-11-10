package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikAudioTheme;
import de.hampelratte.plastik.PlastikBackgroundTheme;
import de.hampelratte.plastik.PlastikBorderTheme;
import de.hampelratte.plastik.PlastikColorTheme;
import de.hampelratte.plastik.PlastikFontTheme;
import de.hampelratte.plastik.PlastikIconTheme;
import de.hampelratte.plastik.PlastikTheme;
import de.hampelratte.plastik.themes.iconthemes.CrystalSVG.CrystalSVGTheme;

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
