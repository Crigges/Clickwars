package systems.crigges.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

public class TraitlineSelectDialog extends JDialog {

	private final ScrollPane contentPanel = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
	private Traitline result;
	private TraitlineSetList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TraitlineSelectDialog dialog = new TraitlineSelectDialog(null, Profession.Chronomancer, 1);
			dialog.openDialog();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Traitline openDialog(){
		setVisible(true);
		return result;
	}

	/**
	 * Create the dialog.
	 */
	public TraitlineSelectDialog(JFrame parent, Profession prof, int slot) {
		super(parent, "Select Traitline", true);
		//Remove java artifacts
		Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
		setIconImage(icon);
		result = null;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 797);
		getContentPane().setLayout(new BorderLayout());
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		list = new TraitlineSetList(slot);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
		);
		list.setModel(new TraitlineSet(prof, slot));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Icon c = list.getSelectedValue();
						if(c != null && c instanceof Traitline){
							result = (Traitline) c;
						}
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
