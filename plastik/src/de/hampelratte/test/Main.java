package de.hampelratte.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import de.hampelratte.plastik.PlastikLookAndFeel;

public class Main {

	private static JCheckBox checkbox;

	private static JRadioButton radiobutton;

	private static JSlider slider;

	private static JTextField textfield;
	
	private static JScrollPane scrollpane;
	
	private static JTextArea textarea;
	
	private static JScrollBar scrollb;
	
	private static JComboBox combo;
	
	private static JTabbedPane tabbedPane;
	
	private static JSpinner spinner;
	
	public static void main(String[] args) {
		try {
			PlastikLookAndFeel.setTextAntialiasing(true);
			UIManager.setLookAndFeel(new PlastikLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		JButton button = new JButton("Hallo Welt!");
		button.setBounds(10, 10, 100, 25);
		button.setToolTipText("was geht ab?");
		panel.add(button);
		
		//JFileChooser fc = new JFileChooser();
		//fc.showOpenDialog(frame);

		JLabel label = new JLabel("Was geht denn hier ab?");
		label.setBounds(10, 50, 200, 25);
		panel.add(label);

		radiobutton = new JRadioButton("radiobutton");
		radiobutton.setToolTipText("hallo kinder");
		radiobutton.setBounds(10, 200, 100, 25);
		panel.add(radiobutton);

		checkbox = new JCheckBox("checkbox");
		checkbox.setBounds(10, 230, 100, 25);
		panel.add(checkbox);
		
		scrollb = new JScrollBar(SwingConstants.VERTICAL);
		scrollb.setBounds(10,100,UIManager.getInt("ScrollBar.width"),100);
		panel.add(scrollb);

		slider = new JSlider(0, 100);
		slider.setValue(50);
		slider.setBounds(200, 10, 150, 50);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTrack(true);
		panel.add(slider);
		
		String[] items = {"hollaradiohiäoiuaasdasdasdasd","was","geht","ab","a1b","2ab","a3b","a4b","a5b","ab6","a7b","a8b","9ab","a0b"};
		combo = new JComboBox(items);
		combo.setBounds(400, 10, 150, 24);
		//combo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		combo.setEditable(true);
		panel.add(combo);

		textfield = new JTextField("zackbumm");
		textfield.setBounds(200, 70, 150, 25);
		panel.add(textfield);
		
		spinner = new JSpinner();
		spinner.setBounds(400,70, 100, 25);
		spinner.setModel(new SpinnerNumberModel(50,0,100,1));
		//spinner.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(spinner);
		
		textarea = new JTextArea(text);
		scrollpane = new JScrollPane(textarea);
		scrollpane.setBounds(200,150, 200,200);
		panel.add(scrollpane);
		//textarea.setBounds(200,150, 200,200);
		//panel.add(textarea);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("wasgehtab",new JPanel());
		tabbedPane.addTab("wasgehtab",new JPanel());
		tabbedPane.addTab("wasgehtab",new JPanel());
		tabbedPane.setBounds(450,150,300,200);
		panel.add(tabbedPane);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 800, 600);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkbox.setEnabled(!checkbox.isEnabled());
				radiobutton.setEnabled(!radiobutton.isEnabled());
				textfield.setEnabled(!textfield.isEnabled());
				textarea.setEnabled(!textarea.isEnabled());
				scrollb.setEnabled(!scrollb.isEnabled());
				//combo.setEnabled(!combo.isEnabled());
				combo.setEditable(!combo.isEditable());
				spinner.setEnabled(!spinner.isEnabled());
			}
		});
	}
	
	private static String text = "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n";
}
