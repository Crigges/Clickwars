package systems.crigges.main;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Clickwars {

	private JFrame frame;
	private JButton buttonSlot1;
	private JButton buttonSlot2;
	private JButton buttonSlot4;
	private JButton buttonSlot5;
	private JComboBox professionBox;
	private BackgroundPanel traitline1;
	private BackgroundPanel traitline2;
	private BackgroundPanel traitline3;
	private JButton[] traitline1Traits;
	private JButton[] traitline2Traits;
	private JButton[] traitline3Traits;
	private JButton hotkeyButton;
	private int hotkeyCode;
	private int hotkeyMod;
	private JPanel panel3;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel;
	private JTextField nameField;
	private final Action action = new SwingAction();
	private JTable profileTable;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;


	/**
	 * Launch the application.
	 * @throws AWTException 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws AWTException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//fixing dpi scaling
		String[] iconOpts = {"OptionPane.errorIcon", 
		  "OptionPane.informationIcon", 
		  "OptionPane.warningIcon", 
		  "OptionPane.questionIcon"};
		for (String key : iconOpts) {
		  ImageIcon icon = (ImageIcon) UIManager.get(key);
		  Image img = icon.getImage();
		  ImageIcon newIcon = new ImageIcon(img.getScaledInstance(img.getWidth(null), img.getHeight(null), 0));
		  UIManager.put(key, newIcon);
		}
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clickwars window = new Clickwars();
					window.frame.setVisible(true);
					window.panel3.updateUI();
					//window.setEditEnabeld(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Clickwars() {
		initialize();
	}
	
	private Component[] getComponents(Component container) {
        ArrayList<Component> list = null;

        try {
            list = new ArrayList<Component>(Arrays.asList(
                  ((Container) container).getComponents()));
            for (int index = 0; index < list.size(); index++) {
                for (Component currentComponent : getComponents(list.get(index))) {
                    list.add(currentComponent);
                }
            }
        } catch (ClassCastException e) {
            list = new ArrayList<Component>();
        }

        return list.toArray(new Component[list.size()]);
    }
	
	private void setEditEnabeld(boolean enable){
		for(Component p : getComponents(panel1)){
			p.setEnabled(enable);
		}
		for(Component p : getComponents(panel2)){
			p.setEnabled(enable);
		}
		for(Component p : getComponents(panel3)){
			p.setEnabled(enable);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//disable logger
		LogManager.getLogManager().reset();
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		//init logger
		try {
			GlobalScreen.setEventDispatcher(new SwingDispatchService());
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 1679, 1004);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Skills", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		buttonSlot1 = new JButton("");
		buttonSlot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SkillSelectDialog d = new SkillSelectDialog(frame, (Profession) professionBox.getSelectedItem(), 1);
				Skill res = d.openDialog();
				if(res != null){
					buttonSlot1.setIcon(new ImageIcon(res.getResource()));
				}
			}
		});
		buttonSlot1.setBorder(null);
		buttonSlot1.setIcon(new ImageIcon(Clickwars.class.getResource("/other/clearslot.png")));
		
		buttonSlot2 = new JButton("");
		buttonSlot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SkillSelectDialog d = new SkillSelectDialog(frame, (Profession) professionBox.getSelectedItem(), 2);
				Skill res = d.openDialog();
				if(res != null){
					buttonSlot2.setIcon(new ImageIcon(res.getResource()));
				}
			}
		});
		buttonSlot2.setIcon(new ImageIcon(Clickwars.class.getResource("/other/clearslot.png")));
		buttonSlot2.setBorder(null);
		
		JButton buttonSlot3 = new JButton("");
		buttonSlot3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SkillSelectDialog d = new SkillSelectDialog(frame, (Profession) professionBox.getSelectedItem(), 3);
				Skill res = d.openDialog();
				if(res != null){
					buttonSlot3.setIcon(new ImageIcon(res.getResource()));
				}
			}
		});
		buttonSlot3.setIcon(new ImageIcon(Clickwars.class.getResource("/other/clearslot.png")));
		buttonSlot3.setBorder(null);
		
		buttonSlot4 = new JButton("");
		buttonSlot4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SkillSelectDialog d = new SkillSelectDialog(frame, (Profession) professionBox.getSelectedItem(), 4);
				Skill res = d.openDialog();
				if(res != null){
					buttonSlot4.setIcon(new ImageIcon(res.getResource()));
				}
			}
		});
		buttonSlot4.setIcon(new ImageIcon(Clickwars.class.getResource("/other/clearslot.png")));
		buttonSlot4.setBorder(null);
		
		buttonSlot5 = new JButton("");
		buttonSlot5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SkillSelectDialog d = new SkillSelectDialog(frame, (Profession) professionBox.getSelectedItem(), 5);
				Skill res = d.openDialog();
				if(res != null){
					buttonSlot5.setIcon(new ImageIcon(res.getResource()));
				}
			}
		});
		buttonSlot5.setIcon(new ImageIcon(Clickwars.class.getResource("/other/clearslot.png")));
		buttonSlot5.setBorder(null);
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGap(15)
					.addComponent(buttonSlot1)
					.addGap(9)
					.addComponent(buttonSlot2)
					.addGap(9)
					.addComponent(buttonSlot3)
					.addGap(9)
					.addComponent(buttonSlot4)
					.addGap(9)
					.addComponent(buttonSlot5))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonSlot1)
						.addComponent(buttonSlot2)
						.addComponent(buttonSlot3)
						.addComponent(buttonSlot4)
						.addComponent(buttonSlot5)))
		);
		panel2.setLayout(gl_panel2);
		
		panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblProfession = new JLabel("Profession");
		
		professionBox = new JComboBox();
		professionBox.setModel(new DefaultComboBoxModel(Profession.values()));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(InterfaceSize.values()));
		
		JLabel lblInterfaceSize = new JLabel("Interface Size");
		
		hotkeyButton = new JButton("???");
		hotkeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotkeyButton.setText("Enter Hotkey...");
				GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
					
					@Override
					public void nativeKeyTyped(NativeKeyEvent arg0) {
						String mod = NativeInputEvent.getModifiersText(arg0.getModifiers());
						if(!mod.equals("")){
							mod = mod + " + ";
						}
						int pressedKeyCode = arg0.getRawCode();
						Object pressedKeyCodeObject = new Integer(pressedKeyCode);
						String pressedKeyText = KeyEvent.getKeyText((Integer)pressedKeyCodeObject);
						if(pressedKeyText.contains("0x")){
							pressedKeyText = "" + arg0.getKeyChar();
						}
						hotkeyButton.setText(mod + pressedKeyText);
						hotkeyCode = pressedKeyCode;
						hotkeyMod = arg0.getModifiers();
						GlobalScreen.removeNativeKeyListener(this);
					}

					@Override
					public void nativeKeyPressed(NativeKeyEvent arg0) {   }

					@Override
					public void nativeKeyReleased(NativeKeyEvent arg0) {   }
				});
			}
		});
		
		JLabel lblHotkeytoapply = new JLabel("Hotkey");
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(professionBox, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProfession))
					.addGap(18)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInterfaceSize))
					.addGap(18)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHotkeytoapply)
						.addComponent(hotkeyButton, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProfession)
						.addComponent(lblInterfaceSize)
						.addComponent(lblHotkeytoapply))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(professionBox, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(hotkeyButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		panel1.setLayout(gl_panel1);
		
		panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Traits", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Profiles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
					.addGap(447))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(157)
							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = profileTable.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(frame, "Select a profile to delete!");
				}else{
					int res = JOptionPane.showConfirmDialog(frame, "Are you sure?");
					if(res == JOptionPane.OK_OPTION){
						DefaultTableModel model = (DefaultTableModel)profileTable.getModel();
						model.removeRow(profileTable.getSelectedRow());
					}
				}
			}
		});
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().equals("")){
					JOptionPane.showMessageDialog(frame, "Enter a profile Name!");
				}else{
					DefaultTableModel model = (DefaultTableModel)profileTable.getModel();
					Object[] o = new Object[3];
					o[0] = nameField.getText();
					o[1] = professionBox.getSelectedItem();
					o[2] = hotkeyButton.getText();
					model.addRow(o);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDelete)
							.addComponent(btnNew)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		profileTable = new JTable();
		profileTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Profession", "Hotkey"
			}
		));
		profileTable.getColumnModel().getColumn(0).setPreferredWidth(115);
		profileTable.getColumnModel().getColumn(1).setPreferredWidth(119);
		profileTable.getColumnModel().getColumn(2).setPreferredWidth(116);
		scrollPane.setViewportView(profileTable);
		panel.setLayout(gl_panel);
		
		traitline1 = new BackgroundPanel((Paint) null);
		traitline1.setImageAlignmentY(0.0f);
		traitline1.setImageAlignmentX(0.0f);
		traitline1.setImage(Toolkit.getDefaultToolkit().getImage(Clickwars.class.getResource("/other/notraitline.png")));
		traitline1.setLayout(null);
		
		traitline2 = new BackgroundPanel((Paint) null);
		traitline2.setImageAlignmentX(0.0f);
		traitline2.setImage(Toolkit.getDefaultToolkit().getImage(Clickwars.class.getResource("/other/notraitline.png")));
		traitline2.setImageAlignmentY(0.0f);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraitlineSelectDialog diag = new TraitlineSelectDialog(frame, (Profession) professionBox.getSelectedItem(), 1);
 				Traitline t = diag.openDialog();
 				if(t != null){
 					traitline2.setImage(t.getImage());
 				}
			}
		});
		button.setIcon(new ImageIcon(Clickwars.class.getResource("/other/traitlabel.png")));
		button.setContentAreaFilled(false);
		button.setBorder(null);
		GroupLayout gl_traitline2 = new GroupLayout(traitline2);
		gl_traitline2.setHorizontalGroup(
			gl_traitline2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_traitline2.createSequentialGroup()
					.addGap(50)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(492, Short.MAX_VALUE))
		);
		gl_traitline2.setVerticalGroup(
			gl_traitline2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_traitline2.createSequentialGroup()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		traitline2.setLayout(gl_traitline2);
		
		traitline3 = new BackgroundPanel((Paint) null);
		traitline3.setImage(Toolkit.getDefaultToolkit().getImage(Clickwars.class.getResource("/other/notraitline.png")));
		traitline3.setImageAlignmentY(0.0f);
		traitline3.setImageAlignmentX(0.0f);
		
		button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraitlineSelectDialog diag = new TraitlineSelectDialog(frame, (Profession) professionBox.getSelectedItem(), 3);
 				Traitline t = diag.openDialog();
 				if(t != null){
 					traitline3.setImage(t.getImage());
 				}
			}
		});
		button_1.setIcon(new ImageIcon(Clickwars.class.getResource("/other/traitlabel.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		GroupLayout gl_traitline3 = new GroupLayout(traitline3);
		gl_traitline3.setHorizontalGroup(
			gl_traitline3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_traitline3.createSequentialGroup()
					.addGap(51)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(491, Short.MAX_VALUE))
		);
		gl_traitline3.setVerticalGroup(
			gl_traitline3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_traitline3.createSequentialGroup()
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		traitline3.setLayout(gl_traitline3);
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
						.addComponent(traitline1, GroupLayout.PREFERRED_SIZE, 681, GroupLayout.PREFERRED_SIZE)
						.addComponent(traitline2, GroupLayout.PREFERRED_SIZE, 681, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel3.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addComponent(traitline3, GroupLayout.PREFERRED_SIZE, 681, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addComponent(traitline1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(traitline2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(traitline3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 				TraitlineSelectDialog diag = new TraitlineSelectDialog(frame, (Profession) professionBox.getSelectedItem(), 1);
 				Traitline t = diag.openDialog();
 				if(t != null){
 					traitline1.setImage(t.getImage());
 				}
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(Clickwars.class.getResource("/other/traitlabel.png")));
		btnNewButton.setBounds(51, 0, 139, 136);
		traitline1.add(btnNewButton);
		panel3.setLayout(gl_panel3);
		frame.getContentPane().setLayout(groupLayout);
		
		traitline1Traits = new JButton[9];
		traitline2Traits = new JButton[9];
		traitline3Traits = new JButton[9];
		int i = 0;
		int startX = 220;
		int stepX = 160;
		int startY = 10;
		for(int x = startX; x<stepX*3 + startX; x+= stepX) {
			for(int y = startY; y<40*3 + startY; y+= 40) {
				traitline1Traits[i] = new JButton(ResourceFactory.getClearTrait());
				traitline1Traits[i].setBorder(null);
				traitline1.add(traitline1Traits[i]);
				traitline1Traits[i].setBounds(x, y, 32, 32);
				i++;
			}
		}
		i = 0;
		for(int x = startX; x<stepX*3 + startX; x+= stepX) {
			for(int y = startY; y<40*3 + startY; y+= 40) {
				traitline2Traits[i] = new JButton(ResourceFactory.getClearTrait());
				traitline2Traits[i].setBorder(null);
				traitline2.add(traitline2Traits[i]);
				traitline2Traits[i].setBounds(x, y, 32, 32);
				i++;
			}
		}
		i = 0;
		for(int x = startX; x<stepX*3 + startX; x+= stepX) {
			for(int y = startY; y<40*3 + startY; y+= 40) {
				traitline3Traits[i] = new JButton(ResourceFactory.getClearTrait());
				traitline3Traits[i].setBorder(null);
				traitline3.add(traitline3Traits[i]);
				traitline3Traits[i].setBounds(x, y, 32, 32);
				i++;
			}
		}
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmExit);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
