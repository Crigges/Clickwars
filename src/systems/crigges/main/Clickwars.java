package systems.crigges.main;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JButton;
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
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.SwingDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import systems.crigges.gui.BackgroundPanel;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Paint;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Clickwars {

	private JFrame frame;
	private JButton[] buttonSlots;
	private JComboBox<Object> professionBox;
	private BackgroundPanel[] traitlines;
	private JButton hotkeyButton;
	private int hotkeyCode;
	private int hotkeyMod;
	private JPanel panel3;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel;
	private JTextField nameField;
	private JTable profileTable;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private Profile currentProfile;
	private ArrayList<Profile> profiles;
	private JComboBox<Object> interfaceBox;
	private ClickBot clicker;
	private JButton[][] traitlineTraits;


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
					window.setEditEnabeld(false);
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
			e1.printStackTrace();
		}
		clicker = new ClickBot();
		
		GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
			
			@Override
			public void nativeKeyTyped(NativeKeyEvent arg0) {
				for(Profile p : profiles){
					int code = arg0.getRawCode();
					int mod = arg0.getModifiers();
					if(p.getHotkeyCode() == code && p.getHotkeyMod() == mod){
						clicker.apply(p);
						System.out.println("appled " + p.getName());
					}
				}
			}

			@Override
			public void nativeKeyPressed(NativeKeyEvent arg0) {}

			@Override
			public void nativeKeyReleased(NativeKeyEvent arg0) {}
			
		});
		
		frame = new JFrame();
		//remove window icon
		Image icon = null;
		try {
			icon = ImageIO.read(ResourceFactory.getResource("/other/gw2icon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		profiles = Profile.get();
		frame.setIconImage(icon);
		frame.setBounds(100, 100, 1227, 938);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Skills", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		buttonSlots = new JButton[5];
		for(int i = 0; i<5; i++){
			buttonSlots[i] = new JButton("");
			buttonSlots[i].addActionListener(new SkillSlotListener(i));
			buttonSlots[i].setBorder(null);
			buttonSlots[i].setIcon(new ImageIcon(Clickwars.class.getResource("/other/clearslot.png")));
		}
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(buttonSlots[0])
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSlots[1])
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSlots[2])
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSlots[3])
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSlots[4])
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING)
						.addComponent(buttonSlots[0])
						.addComponent(buttonSlots[4])
						.addComponent(buttonSlots[1])
						.addComponent(buttonSlots[2])
						.addComponent(buttonSlots[3]))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		panel2.setLayout(gl_panel2);
		
		panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Traits", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Profiles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblProfession = new JLabel("Profession");
		
		professionBox = new JComboBox<Object>();
		professionBox.setModel(new DefaultComboBoxModel<Object>(Profession.values()));
		professionBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				currentProfile.setProf((Profession) professionBox.getSelectedItem());
				DefaultTableModel model = (DefaultTableModel) profileTable.getModel();
				model.setValueAt(professionBox.getSelectedItem(), profileTable.getSelectedRow(), 1);
			}
		});
		
		interfaceBox = new JComboBox<Object>();
		interfaceBox.setModel(new DefaultComboBoxModel<Object>(InterfaceSize.values()));
		interfaceBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				currentProfile.setInterfaceSize((InterfaceSize) interfaceBox.getSelectedItem());
			}
		});
		
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
						currentProfile.setHotkeyCode(pressedKeyCode);
						currentProfile.setHotkeyMod(hotkeyMod);
						currentProfile.setHotkeyName(mod + pressedKeyText);
						DefaultTableModel model = (DefaultTableModel) profileTable.getModel();
						model.setValueAt(mod + pressedKeyText, profileTable.getSelectedRow(), 2);
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
		
		JLabel lblLabel = new JLabel("Advanced Settings");
		
		JButton button_2 = new JButton("???");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProfession)
						.addComponent(professionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInterfaceSize)
						.addComponent(interfaceBox, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(hotkeyButton, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHotkeytoapply))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addGap(33))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProfession)
						.addComponent(lblInterfaceSize)
						.addComponent(lblHotkeytoapply)
						.addComponent(lblLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(professionBox, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(interfaceBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(hotkeyButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel1.setLayout(gl_panel1);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = profileTable.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(frame, "Select a profile to delete!");
				}else{
					int res = JOptionPane.showConfirmDialog(frame, "Are you sure?");
					if(res == JOptionPane.OK_OPTION){
						profiles.remove(profileTable.getSelectedRow());
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
					currentProfile = new Profile();
					currentProfile.setInterfaceSize((InterfaceSize) interfaceBox.getSelectedItem());
					currentProfile.setProf((Profession) professionBox.getSelectedItem());
					currentProfile.setName(nameField.getText());
					profiles.add(currentProfile);
					model.addRow(currentProfile.getModelEntry());
					profileTable.getSelectionModel().setSelectionInterval(0, model.getRowCount() - 1);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNew, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(nameField)
						.addComponent(btnNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		profileTable = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    profileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		profileTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Profession", "Hotkey"
			}
		));

		profileTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				DefaultListSelectionModel mod = (DefaultListSelectionModel) e.getSource();
				if(!e.getValueIsAdjusting()){
					setEditEnabeld(mod.getMinSelectionIndex() != -1);
					if(mod.getMinSelectionIndex() != -1){
						loadProfile(profiles.get(profileTable.getSelectedRow()));
					}
				}
			}
		});
		profileTable.getColumnModel().getColumn(0).setPreferredWidth(115);
		profileTable.getColumnModel().getColumn(1).setPreferredWidth(119);
		profileTable.getColumnModel().getColumn(2).setPreferredWidth(116);
		scrollPane.setViewportView(profileTable);
		panel.setLayout(gl_panel);
		
		traitlines = new BackgroundPanel[3];
		
		
		for (int i = 0; i < traitlines.length; i++) {
			traitlines[i] = new BackgroundPanel((Paint) null);
			traitlines[i].setImageAlignmentY(0.0f);
			traitlines[i].setImageAlignmentX(0.0f);
			traitlines[i].setImage(Toolkit.getDefaultToolkit().getImage(Clickwars.class.getResource("/other/notraitline.png")));
			traitlines[i].setLayout(null);
			JButton button = new JButton("");
			button.addActionListener(new TraitlineSlotListener(i));
			button.setIcon(new ImageIcon(Clickwars.class.getResource("/other/traitlabel.png")));
			button.setContentAreaFilled(false);
			button.setBorder(null);
			button.setBounds(50, 8, 120, 120);
			traitlines[i].add(button);
		}
		
		
	
		
		
		
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel3.createParallelGroup(Alignment.TRAILING)
						.addComponent(traitlines[0], Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
						.addComponent(traitlines[1], Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
						.addComponent(traitlines[2], GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addComponent(traitlines[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(traitlines[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(traitlines[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		panel3.setLayout(gl_panel3);
		frame.getContentPane().setLayout(groupLayout);
		
		traitlineTraits = new JButton[3][9];
		int i = 0;
		int startX = 230;
		int stepX = 160;
		int startY = 10;
		int groupPos = 0;
		for(int lines = 0; lines<traitlineTraits.length; lines++){
			i = 0;
			for(int x = startX; x<stepX*3 + startX; x+= stepX) {
				ArrayList<JButton> group = new ArrayList<>();
				int localPos = 0;
				for(int y = startY; y<40*3 + startY; y+= 40) {
					Trait trait = ResourceFactory.getClearTrait(localPos);
					traitlineTraits[lines][i] = new JButton(trait);
					group.add(traitlineTraits[lines][i]);
					traitlineTraits[lines][i].addActionListener(new TraitListener(groupPos, group, trait));
					traitlineTraits[lines][i].setBorder(null);
					traitlines[lines].add(traitlineTraits[lines][i]);
					traitlineTraits[lines][i].setBounds(x, y, 32, 32);
					i++;
					localPos++;
				}
				groupPos++;
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
	
	private class SkillSlotListener implements ActionListener{
		private int slot;
		
		public SkillSlotListener(int slot) {
			this.slot = slot;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			SkillSelectDialog d = new SkillSelectDialog(frame, (Profession) professionBox.getSelectedItem(), slot);
			Skill res = d.openDialog();
			if(res != null){
				buttonSlots[slot].setIcon(new ImageIcon(res.getResource()));
				currentProfile.setSkillPos(slot, res.getPos());
			}
		}
		
	}
	
	private class TraitlineSlotListener implements ActionListener{
		private int slot;
		
		public TraitlineSlotListener(int slot) {
			this.slot = slot;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			TraitlineSelectDialog diag = new TraitlineSelectDialog(frame, (Profession) professionBox.getSelectedItem(), slot);
			Traitline t = diag.openDialog();
			if(t != null){
				traitlines[slot].setImage(t.getImage());
				currentProfile.setTraitlinePos(slot, t.getPos());
			}
		}
		
	}
	
	private class TraitListener implements ActionListener{
		private int pos;
		private ArrayList<JButton> group;
		private Trait trait;
		
		public TraitListener(int pos, ArrayList<JButton> group, Trait trait) {
			this.pos = pos;
			this.group = group;
			this.trait = trait;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			currentProfile.setTraitPos(pos, trait.getPos());
			for(JButton but : group){
				if(but == e.getSource()){
					but.setIcon(ResourceFactory.getSelectedTrait(trait.getPos()));
				}else{
					but.setIcon(ResourceFactory.getClearTrait(trait.getPos()));
				}
			}
			
		}
		
	}
	
	
	private void loadProfile(Profile p){
		currentProfile = p;
		hotkeyCode = p.getHotkeyCode();
		hotkeyMod = p.getHotkeyMod();
		hotkeyButton.setText(p.getHotkeyName());
		interfaceBox.setSelectedItem(p.getInterfaceSize());
		professionBox.setSelectedItem(p.getProf());
		for (int i = 0; i < buttonSlots.length; i++) {
			if(p.getSkillPos(i) != -1){
				buttonSlots[i].setIcon(ResourceFactory.getSkill(p.getProf(), p.getSkillPos(i), i));
			}else{
				buttonSlots[i].setIcon(new ImageIcon(Clickwars.class.getResource("/other/clearslot.png")));
			}
		}
		for (int i = 0; i < traitlines.length; i++) {
			if(p.getTraitlinePos(i) != -1){
				traitlines[i].setImage(Toolkit.getDefaultToolkit().getImage(ResourceFactory.getTraitline(p.getProf(), p.getTraitlinePos(i), i).getResource()));
			}else{
				traitlines[i].setImage(Toolkit.getDefaultToolkit().getImage(Clickwars.class.getResource("/other/notraitline.png")));
			}
		}
		int[] traitPos = p.getAllTraitPos();
		int sel = 0;
		for(int lines = 0; lines<traitlineTraits.length; lines++){
			for(int group = 0; group<3; group++){
				int sep = 0;
				for (int j = group*3; j < 9; j++) {	
					traitlineTraits[lines][j].setIcon(ResourceFactory.getClearTrait(sep));
					sep++;
				}
				if(traitPos[sel] != -1){
					traitlineTraits[lines][group * 3 + traitPos[sel]].setIcon(ResourceFactory.getSelectedTrait(traitPos[sel]));
				}
				sel++;
			}
			
				
		}
	}
	
}
