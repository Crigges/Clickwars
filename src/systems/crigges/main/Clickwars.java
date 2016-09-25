package systems.crigges.main;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clickwars {

	private JFrame frame;
	private JButton buttonSlot1;
	private JButton buttonSlot2;
	private JButton buttonSlot4;
	private JButton buttonSlot5;
	private JComboBox professionBox;

	/**
	 * Launch the application.
	 * @throws AWTException 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws AWTException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clickwars window = new Clickwars();
					window.frame.setVisible(true);
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 994, 890);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Skills", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		professionBox = new JComboBox();
		professionBox.setModel(new DefaultComboBoxModel(Profession.values()));
		
		JLabel lblProfession = new JLabel("Profession");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(InterfaceSize.values()));
		
		JLabel lblInterfaceSize = new JLabel("Interface Size");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Traits", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProfession)
								.addComponent(professionBox, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInterfaceSize, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(236, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProfession)
						.addComponent(lblInterfaceSize))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(professionBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Crigges\\Desktop\\traitimg\\crig53.png"));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Crigges\\Desktop\\traitimg\\crig18.png"));
		
		JLabel label_1 = new JLabel("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(buttonSlot1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSlot2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSlot3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSlot4, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSlot5, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(236, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonSlot5, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSlot4, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSlot3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSlot2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSlot1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
	}
}
