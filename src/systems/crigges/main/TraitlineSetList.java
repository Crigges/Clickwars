package systems.crigges.main;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class TraitlineSetList extends JList<Icon>{
	private static final long serialVersionUID = 1L;
	private TraitlineSet model = null;
	
	public TraitlineSetList(int slot) {
		super();
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayoutOrientation(JList.HORIZONTAL_WRAP);
		if(slot == 2){
			setVisibleRowCount(6);
		}else{
			setVisibleRowCount(5);
		}
		
	}
	
	private void setTraitlineModel(TraitlineSet newModel){
		this.model = newModel;
		if(model != null){
			setPrototypeCellValue(model.getDefaultImage());
		}
	}
	
	@Override
	public void setModel(ListModel<Icon> model) {
		if(model instanceof TraitlineSet){
			setTraitlineModel((TraitlineSet) model);
			super.setModel(model);
		}else{
			throw new RuntimeException("An error occured: \"Error\" for reason: \"Error\"");
		}
		updateUI();
	}
	
	@Override
	public void updateUI() {
		if(model != null){
			setPrototypeCellValue(model.getDefaultImage());
		}
		super.updateUI();
	}
	

	
	
}
