package de.hampelratte.plastik;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Stroke;

import javax.swing.CellRendererPane;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

import de.hampelratte.plastik.borders.PlastikButtonBorder;
import de.hampelratte.plastik.borders.PlastikComboBoxArrowButtonBorder;


public final class PlastikComboBoxButton extends JButton {

    private static final int LEFT_INSET  = 2;
    private static final int RIGHT_INSET = 3;

    private final JList listBox;
    private final CellRendererPane rendererPane;

    private   JComboBox  comboBox;
    private   Icon       comboIcon;
    protected boolean   iconOnly = false;
    private   boolean   borderPaintsFocus;
    
    private Color contour = UIManager.getColor("Common.contour");
    private Color contourSmoother = UIManager.getColor("Common.contourSmoother");
    private Color background = UIManager.getColor("Common.background");

    
    PlastikComboBoxButton(
        JComboBox comboBox,
        Icon comboIcon,
        boolean iconOnly,
        CellRendererPane rendererPane,
        JList listBox) {
        super("");
        setModel(new DefaultButtonModel() {
            public void setArmed(boolean armed) {
                super.setArmed(isPressed() || armed);
            }
        });
        this.comboBox  = comboBox;
        this.comboIcon = comboIcon;
        this.iconOnly  = iconOnly;
        this.rendererPane = rendererPane;
        this.listBox = listBox;
        setEnabled(comboBox.isEnabled());
        setFocusable(false);
        setRequestFocusEnabled(comboBox.isEnabled());
        setMargin(new Insets(0, LEFT_INSET, 0, RIGHT_INSET));
        borderPaintsFocus = UIManager.getBoolean("ComboBox.borderPaintsFocus");
        
        if(iconOnly) {
        	setBorder(new PlastikComboBoxArrowButtonBorder(comboBox));
        } else {
        	setBorder(new PlastikButtonBorder());
        }
        
        if(PlastikLookAndFeel.isRolloverEnabled()) {
        	setRolloverEnabled(true);
        }
    }

    public JComboBox getComboBox() {
        return comboBox;
    }
    
    public void setComboBox(JComboBox cb) {
        comboBox = cb;
    }

    public Icon getComboIcon() {
        return comboIcon;
    }
    
    public void setComboIcon(Icon i) {
        comboIcon = i;
    }

    public boolean isIconOnly() {
        return iconOnly;
    }
    
    public void setIconOnly(boolean b) {
        iconOnly = b;
        if(!iconOnly) {
        	setBorder(new PlastikButtonBorder());
        } else {
        	setBorder(new PlastikComboBoxArrowButtonBorder(comboBox));
        }
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        // Set the background and foreground to the combobox colors.
        if (enabled) {
            setBackground(comboBox.getBackground());
            setForeground(comboBox.getForeground());
        } else {
            setBackground(UIManager.getColor("ComboBox.disabledBackground"));
            setForeground(UIManager.getColor("ComboBox.disabledForeground"));
        }
    }
    

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean leftToRight = comboBox.getComponentOrientation().isLeftToRight();

        Insets insets = getInsets();

        int width  = getWidth()  - (insets.left + insets.right);
        int height = getHeight() - (insets.top  + insets.bottom);

        if (height <= 0 || width <= 0) {
            return;
        }

        int left   = insets.left + 2;
        int top    = insets.top;
        int right  = left + (width - 2);

        int iconWidth = 0;
        int iconLeft = (leftToRight) ? right : left;

        // Paint the icon and the seperating border
        if (comboIcon != null) {
            iconWidth = comboIcon.getIconWidth() + 3;
            int iconHeight = comboIcon.getIconHeight();
            int iconTop;

            if (iconOnly) {
                iconLeft = (getWidth()  - iconWidth)  / 2;
                iconTop  = (getHeight() - iconHeight) / 2;
            } else {
                if (leftToRight) {
                    iconLeft = (left + (width - 1)) - iconWidth;
                } else {
                    iconLeft = left;
                }
                iconTop = (getHeight() - iconHeight) / 2;
                
                // paint the border
                int x = 0;
                if(leftToRight) {
                	x = iconLeft - 5;
                } else {
                	x = iconLeft + 10;
                }
                if(isRolloverEnabled() && getModel().isRollover()) {
                	g.setColor(contour);
	                g.drawLine(x,3,x,height);
	                g.setColor(getModel().isPressed() ? new Color(0,0,0,0) : background);
	                g.drawLine(x+1,3,x+1,height);
                } else {
                	g.setColor(contour);
	                g.drawLine(x,1,x,height+2);
	                g.setColor(background);
	                g.drawLine(x+1,2,x+1,height+1);
                }
            }

            if(iconOnly) {
            	iconLeft = 5;
            }
            
            comboIcon.paintIcon(this, g, iconLeft, iconTop);
        }
        
        // Let the renderer paint
        if (!iconOnly && comboBox != null) {
            ListCellRenderer renderer = comboBox.getRenderer();
            boolean renderPressed = getModel().isPressed();
            Component c =
                renderer.getListCellRendererComponent(
                    listBox,
                    comboBox.getSelectedItem(),
                    -1,
                    renderPressed,
                    false);
            c.setFont(rendererPane.getFont());

            if (model.isArmed() && model.isPressed()) {
                if (isOpaque()) {
                    c.setBackground(UIManager.getColor("Button.select"));
                }
                c.setForeground(comboBox.getForeground());
            } else if (!comboBox.isEnabled()) {
                if (isOpaque()) {
                    c.setBackground(
                        UIManager.getColor("ComboBox.disabledBackground"));
                }
                c.setForeground(
                    UIManager.getColor("ComboBox.disabledForeground"));
            } else {
                c.setForeground(comboBox.getForeground());
                c.setBackground(comboBox.getBackground());
            }

            int cWidth = width - (insets.right + iconWidth);

            // Fix for 4238829: should lay out the JPanel.
            boolean shouldValidate = c instanceof JPanel;
            int x = leftToRight ? left : left + iconWidth + 4;
            int myHeight = getHeight() - LEFT_INSET - RIGHT_INSET - 1;


            if (!(c instanceof JComponent)) {
                rendererPane.paintComponent(
                    g,
                    c,
                    this,
                    x,
                    top + 2,
                    cWidth,
                    myHeight,
                    shouldValidate);
            } else if (!c.isOpaque()) {
                rendererPane.paintComponent(
                    g,
                    c,
                    this,
                    x,
                    top + 2,
                    cWidth,
                    myHeight,
                    shouldValidate);
            } else {
                // In case we have a non-transparent
                // JComponent renderer, store the opaque state, set it
                // to transparent, paint, then restore.
                JComponent component = (JComponent) c;
                boolean hasBeenOpaque = component.isOpaque();
                component.setOpaque(false);
                rendererPane.paintComponent(
                    g,
                    c,
                    this,
                    x,
                    top + 2,
                    cWidth,
                    myHeight,
                    shouldValidate);
                component.setOpaque(hasBeenOpaque);
            }
        } 
        
        if (comboIcon != null) {
            // Paint the focus
            boolean hasFocus = comboBox.hasFocus();
            if (!borderPaintsFocus && hasFocus) {
                g.setColor(UIManager.getColor("Common.focus"));
	                int x = LEFT_INSET;
	                int y = LEFT_INSET;
	                int w = getWidth()  - LEFT_INSET - RIGHT_INSET;
	                int h = getHeight() - LEFT_INSET - RIGHT_INSET;

	                Graphics2D g2 = (Graphics2D) g;
                Stroke oldStroke = g2.getStroke();
        		float[] dashes = { 0.2f };
        		BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
        				BasicStroke.JOIN_BEVEL, 1.0f, dashes, 1.0f);
        		g2.setStroke(stroke);
        		if(leftToRight) {
        			g2.drawRect(x+1, y+2, w - 16, h - 3);
        		} else {
        			g2.drawRect(x+15, y+2, w - 16, h - 3);
        		}
        		g2.setStroke(oldStroke);
            }
        }
    }
}
