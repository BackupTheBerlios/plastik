package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

import de.hampelratte.plastik.borders.PlastikComboBoxArrowButtonBorder;

// TODO editor cornerns are not transparent
public class PlastikComboBoxUI extends BasicComboBoxUI implements MouseListener, MouseWheelListener {

	public static ComponentUI createUI(JComponent c) {
		if(PlastikLookAndFeel.getDefaultOpacity() == false) {
			c.setOpaque(false);
		}
		return new PlastikComboBoxUI();
	}
	
	protected void installDefaults() {
        super.installDefaults();
        UIDefaults defaults = UIManager.getDefaults();
        comboBox.setPreferredSize(new Dimension(comboBox.getWidth(), defaults.getInt("ComboBox.height")));
        
        Object obj;
		obj = PlastikLookAndFeel.getDefaultOpacity() ? Boolean.TRUE : Boolean.FALSE;
		LookAndFeel.installProperty(comboBox, "opaque", obj);
    }
	
	protected void uninstallListeners() {
		super.uninstallListeners();
		if(editor != null) {
			editor.removeMouseListener(this);
		}
	}

	protected JButton createArrowButton() {
		JButton button = new PlastikComboBoxButton(comboBox,
				new PlastikComboBoxIcon(), comboBox.isEditable(),
				currentValuePane, listBox);
		button.setMargin(new Insets(0, 2, 1, 3));
		button.setBorder(new PlastikComboBoxArrowButtonBorder(comboBox));
		return button;
	}

	protected ComboBoxEditor createEditor() {
		PlastikComboBoxEditor editor = new PlastikComboBoxEditor(comboBox);
		editor.addMouseWheelListener(this);
		return editor;
	}

	public PropertyChangeListener createPropertyChangeListener() {
		return new PlastikPropertyChangeListener(this);
	}
	
	public class PlastikPropertyChangeListener extends
			BasicComboBoxUI.PropertyChangeHandler {
		
		private PlastikComboBoxUI ui;
		
		public PlastikPropertyChangeListener(PlastikComboBoxUI ui) {
			this.ui = ui;
		}
		
		public void propertyChange(PropertyChangeEvent e) {
			super.propertyChange(e);
			String propertyName = e.getPropertyName();

			if (propertyName.equals("editable")) {
				PlastikComboBoxButton button = (PlastikComboBoxButton) arrowButton;
				button.setIconOnly(comboBox.isEditable());
				
				if(comboBox.isEditable()) {
					editor.addMouseListener(ui);
				} else {
					button.addMouseWheelListener(ui);
				}
				
				comboBox.repaint();
			} else if (propertyName.equals("background")) {
				Color color = (Color) e.getNewValue();
				arrowButton.setBackground(color);
				listBox.setBackground(color);

			} else if (propertyName.equals("foreground")) {
				Color color = (Color) e.getNewValue();
				arrowButton.setForeground(color);
				listBox.setForeground(color);
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		arrowButton.getModel().setRollover(true);
	}

	public void mouseExited(MouseEvent e) {
		arrowButton.getModel().setRollover(false);
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() == 1) { // mouswheel down
			int index = comboBox.getSelectedIndex();
		    index += e.getClickCount();
		    index = index > comboBox.getItemCount()-1 ? comboBox.getItemCount()-1 : index;
			comboBox.setSelectedIndex(index);
		} else { // mouswheel up
			int index = comboBox.getSelectedIndex();
		    index -= e.getClickCount();
		    index = index < 0 ? 0 : index;
			comboBox.setSelectedIndex(index);
		}
	}
	
	protected LayoutManager createLayoutManager() {
        return new PlastikComboBoxLayoutManager();
    }
	
	public class PlastikComboBoxLayoutManager extends BasicComboBoxUI.ComboBoxLayoutManager {
        public void layoutContainer( Container parent ) {
        	if (comboBox.isEditable()) {
    			int width = comboBox.getWidth();
    			int height = comboBox.getHeight();

    			Insets insets = getInsets();
    			int buttonHeight = height - (insets.top + insets.bottom);
    			int buttonWidth = 17;
    			Rectangle cvb;

    			if (arrowButton != null) {
    				if (comboBox.getComponentOrientation().isLeftToRight()) {
    					arrowButton.setBounds(width - (insets.right + buttonWidth),
    							insets.top, buttonWidth, buttonHeight);
    				} else {
    					arrowButton.setBounds(insets.left, insets.top, buttonWidth,
    							buttonHeight);
    				}
    			}
    			if (editor != null) {
    				cvb = rectangleForCurrentValue();
    				editor.setBounds(cvb);
    			}
            } else {
                if ( arrowButton != null ) {
                    Insets insets = comboBox.getInsets();
                    int width = comboBox.getWidth();
                    int height = comboBox.getHeight();
                    arrowButton.setBounds( insets.left, insets.top,
                                           width - (insets.left + insets.right),
                                           height - (insets.top + insets.bottom) );
                }
            }
        }
    }
	
	protected ComboPopup createPopup() {
        return new PlastikComboPopup( comboBox );
    }
}
