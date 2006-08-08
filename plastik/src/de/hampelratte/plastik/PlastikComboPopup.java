package de.hampelratte.plastik;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import de.hampelratte.plastik.theme.PlastikColorTheme;

public class PlastikComboPopup extends BasicComboPopup implements ComboPopup {

	public PlastikComboPopup( JComboBox combo ) {
        super(combo);
	}
	
	protected void configureList() {
		super.configureList();
		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();
		Color background = colorTheme.getColor(PlastikColorTheme.POPUP_MENU | PlastikColorTheme.BACKGROUND);
        list.setBackground( background );
    }
}
