package systems.crigges.main;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;

import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class JImageList extends JList<Icon>{
	private static final long serialVersionUID = 1L;
	private SkillSet model = null;
	private int currentFrameWidth = 200;
	
	public JImageList() {
		super();
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayoutOrientation(JList.HORIZONTAL_WRAP);
	}
	
	public void fitToWidth(int frameWidth){
		currentFrameWidth = frameWidth;
		if(model != null){
			int width = model.getDefaultImage().getIconWidth();
			int breakAt = (frameWidth - 20) / (width + 2);
			int rowCount = (model.getSize() / breakAt) + 1;
			setVisibleRowCount(rowCount);
		}
	}
	
	private void setMpqModel(SkillSet newModel){
		this.model = newModel;
		if(model != null){
			setPrototypeCellValue(model.getDefaultImage());
		}
	}
	
	@Override
	public void setModel(ListModel<Icon> model) {
		if(model instanceof SkillSet){
			setMpqModel((SkillSet) model);
			super.setModel(model);
		}else{
			throw new RuntimeException("An error occured: \"Error\" for reason: \"Error\"");
		}
	}
	
	@Override
	public void updateUI() {
		if(model != null){
			setPrototypeCellValue(model.getDefaultImage());
		}
		fitToWidth(currentFrameWidth);
		super.updateUI();
	}
	

	
	
}
