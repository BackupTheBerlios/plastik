package de.hampelratte.plastik;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.AttributedCharacterIterator;
import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.text.InternationalFormatter;

import de.hampelratte.plastik.borders.PlastikSpinnerEditorBorder;


//TODO rollover und focus highlight
public class PlastikSpinnerUI extends BasicSpinnerUI implements
		MouseListener, MouseWheelListener {

	private JTextField editor;
	
	private static final ArrowButtonHandler nextButtonHandler = new ArrowButtonHandler(
			"increment", true);

	private static final ArrowButtonHandler previousButtonHandler = new ArrowButtonHandler(
			"decrement", false);
	
	private JButton nextButton;
	private JButton previousButton;

	public static ComponentUI createUI(JComponent c) {
		c.setOpaque(false);
		PlastikSpinnerUI ui = new PlastikSpinnerUI();
		return ui;
	}

	protected Component createNextButton() {
		if (spinner.getComponentOrientation().isLeftToRight()) {
			nextButton = new PlastikSpinnerButton(SwingConstants.NORTH, this, spinner);
		} else {
			nextButton = new PlastikSpinnerButton(SwingConstants.NORTH, this, spinner);
		}
		nextButton.addActionListener(nextButtonHandler);
		nextButton.addMouseListener(nextButtonHandler);
		return nextButton;
	}

	protected Component createPreviousButton() {
		if (spinner.getComponentOrientation().isLeftToRight()) {
			previousButton = new PlastikSpinnerButton(SwingConstants.SOUTH, this, spinner);
		} else {
			previousButton = new PlastikSpinnerButton(SwingConstants.SOUTH, this, spinner);
		}
		previousButton.addActionListener(previousButtonHandler);
		previousButton.addMouseListener(previousButtonHandler);
		return previousButton;
	}

	protected JComponent createEditor() {
		editor = new JTextField();
		editor.setOpaque(false);
		editor.addMouseListener(this);
		return editor;
	}

	protected void installDefaults() {
		spinner.setLayout(createLayout());
		spinner.getEditor().setBorder(new PlastikSpinnerEditorBorder(spinner));
		LookAndFeel.installColorsAndFont(spinner, "Spinner.background",
				"Spinner.foreground", "Spinner.font");
	}

	protected void installListeners() {
		super.installListeners();
		spinner.addMouseWheelListener(this);
	}

	protected void replaceEditor(JComponent oldEditor, JComponent newEditor) {
		super.replaceEditor(oldEditor, newEditor);
		newEditor.setBorder(new PlastikSpinnerEditorBorder(spinner));
		newEditor.setOpaque(false);
		newEditor.addMouseListener(this);
		for(int i=0; i<newEditor.getComponentCount(); i++) {
			newEditor.getComponent(i).addMouseListener(this);
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() == 1) {
			for (int i = 1; i <= e.getClickCount(); i++) {
				// TODO vernünftig abfragen statt exceptions zu fangen
				try {
					Object o = spinner.getModel().getPreviousValue();
					spinner.getModel().setValue(o);
				} catch (Exception ex) {
				}
			}
		} else {
			for (int i = 1; i <= e.getClickCount(); i++) {
				// TODO vernünftig abfragen statt exceptions zu fangen
				try {
					Object o = spinner.getModel().getNextValue();
					spinner.getModel().setValue(o);
				} catch (Exception ex) {
				}
			}
		}
	}

	private static class ArrowButtonHandler extends AbstractAction implements
			MouseListener, UIResource {
		final javax.swing.Timer autoRepeatTimer;

		final boolean isNext;

		JSpinner spinner = null;

		ArrowButtonHandler(String name, boolean isNext) {
			super(name);
			this.isNext = isNext;
			autoRepeatTimer = new javax.swing.Timer(60, this);
			autoRepeatTimer.setInitialDelay(300);
		}

		private JSpinner eventToSpinner(AWTEvent e) {
			Object src = e.getSource();
			while ((src instanceof Component) && !(src instanceof JSpinner)) {
				src = ((Component) src).getParent();
			}
			return (src instanceof JSpinner) ? (JSpinner) src : null;
		}

		public void actionPerformed(ActionEvent e) {
			JSpinner spinner = this.spinner;

			if (!(e.getSource() instanceof javax.swing.Timer)) {
				// Most likely resulting from being in ActionMap.
				spinner = eventToSpinner(e);
			}
			if (spinner != null) {
				try {
					int calendarField = getCalendarField(spinner);
					spinner.commitEdit();
					if (calendarField != -1) {
						((SpinnerDateModel) spinner.getModel())
								.setCalendarField(calendarField);
					}
					Object value = (isNext) ? spinner.getNextValue() : spinner
							.getPreviousValue();
					if (value != null) {
						spinner.setValue(value);
						select(spinner);
					}
				} catch (IllegalArgumentException iae) {
					UIManager.getLookAndFeel().provideErrorFeedback(spinner);
				} catch (ParseException pe) {
					UIManager.getLookAndFeel().provideErrorFeedback(spinner);
				}
			}
		}

		/**
		 * If the spinner's editor is a DateEditor, this selects the field
		 * associated with the value that is being incremented.
		 */
		private void select(JSpinner spinner) {
			JComponent editor = spinner.getEditor();

			if (editor instanceof JSpinner.DateEditor) {
				JSpinner.DateEditor dateEditor = (JSpinner.DateEditor) editor;
				JFormattedTextField ftf = dateEditor.getTextField();
				Format format = dateEditor.getFormat();
				Object value;

				if (format != null && (value = spinner.getValue()) != null) {
					SpinnerDateModel model = dateEditor.getModel();
					DateFormat.Field field = DateFormat.Field
							.ofCalendarField(model.getCalendarField());

					if (field != null) {
						try {
							AttributedCharacterIterator iterator = format
									.formatToCharacterIterator(value);
							if (!select(ftf, iterator, field)
									&& field == DateFormat.Field.HOUR0) {
								select(ftf, iterator, DateFormat.Field.HOUR1);
							}
						} catch (IllegalArgumentException iae) {
						}
					}
				}
			}
		}

		/**
		 * Selects the passed in field, returning true if it is found, false
		 * otherwise.
		 */
		private boolean select(JFormattedTextField ftf,
				AttributedCharacterIterator iterator, DateFormat.Field field) {
			int max = ftf.getDocument().getLength();

			iterator.first();
			do {
				Map attrs = iterator.getAttributes();

				if (attrs != null && attrs.containsKey(field)) {
					int start = iterator.getRunStart(field);
					int end = iterator.getRunLimit(field);

					if (start != -1 && end != -1 && start <= max && end <= max) {
						ftf.select(start, end);
					}
					return true;
				}
			} while (iterator.next() != CharacterIterator.DONE);
			return false;
		}

		/**
		 * Returns the calendarField under the start of the selection, or -1 if
		 * there is no valid calendar field under the selection (or the spinner
		 * isn't editing dates.
		 */
		private int getCalendarField(JSpinner spinner) {
			JComponent editor = spinner.getEditor();

			if (editor instanceof JSpinner.DateEditor) {
				JSpinner.DateEditor dateEditor = (JSpinner.DateEditor) editor;
				JFormattedTextField ftf = dateEditor.getTextField();
				int start = ftf.getSelectionStart();
				JFormattedTextField.AbstractFormatter formatter = ftf
						.getFormatter();

				if (formatter instanceof InternationalFormatter) {
					Format.Field[] fields = ((InternationalFormatter) formatter)
							.getFields(start);

					for (int counter = 0; counter < fields.length; counter++) {
						if (fields[counter] instanceof DateFormat.Field) {
							int calendarField;

							if (fields[counter] == DateFormat.Field.HOUR1) {
								calendarField = Calendar.HOUR;
							} else {
								calendarField = ((DateFormat.Field) fields[counter])
										.getCalendarField();
							}
							if (calendarField != -1) {
								return calendarField;
							}
						}
					}
				}
			}
			return -1;
		}

		public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)
					&& e.getComponent().isEnabled()) {
				spinner = eventToSpinner(e);
				autoRepeatTimer.start();

				focusSpinnerIfNecessary();
			}
		}

		public void mouseReleased(MouseEvent e) {
			autoRepeatTimer.stop();
			spinner = null;
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		/**
		 * Requests focus on a child of the spinner if the spinner doesn't have
		 * focus.
		 */
		private void focusSpinnerIfNecessary() {
			Component fo = KeyboardFocusManager
					.getCurrentKeyboardFocusManager().getFocusOwner();
			if (spinner.isRequestFocusEnabled()
					&& (fo == null || !SwingUtilities.isDescendingFrom(fo,
							spinner))) {
				Container root = spinner;

				if (!root.isFocusCycleRoot()) {
					root = root.getFocusCycleRootAncestor();
				}
				if (root != null) {
					FocusTraversalPolicy ftp = root.getFocusTraversalPolicy();
					Component child = ftp.getComponentAfter(root, spinner);

					if (child != null
							&& SwingUtilities.isDescendingFrom(child, spinner)) {
						child.requestFocus();
					}
				}
			}
		}
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public JButton getPreviousButton() {
		return previousButton;
	}

	public JTextField getEditor() {
		return editor;
	}
	
	public Dimension getPreferredSize(JComponent c) {
		return new Dimension(80,26);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		getNextButton().getModel().setRollover(true);
		getNextButton().repaint();
		getPreviousButton().getModel().setRollover(true);
		getPreviousButton().repaint();
	}

	public void mouseExited(MouseEvent e) {
		getNextButton().getModel().setRollover(false);
		getNextButton().repaint();
		getPreviousButton().getModel().setRollover(false);
		getPreviousButton().repaint();
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
