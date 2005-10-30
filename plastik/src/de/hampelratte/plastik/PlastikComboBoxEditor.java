package de.hampelratte.plastik;

import java.awt.Component;

import javax.swing.ComboBoxEditor;
import javax.swing.JComponent;
import javax.swing.JTextField;

import de.hampelratte.plastik.borders.PlastikComboBoxEditorBorder;

public class PlastikComboBoxEditor extends JTextField implements ComboBoxEditor {
	
	private Object value ;
	
	public PlastikComboBoxEditor(JComponent c) {
		setBorder(new PlastikComboBoxEditorBorder(c));
	}
	
	public Component getEditorComponent() {
		return this;
	}

	public void setItem(Object anObject) {
		value = anObject ;
		setText(value.toString());
	}

	public Object getItem() {
		return value ;
	}
}
