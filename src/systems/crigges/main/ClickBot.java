package systems.crigges.main;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ClickBot {
	private static final int defaultDelay = 25;
	private static final int fadeDelay = 400;
	private Robot robot;
	private KeypointDetection detec;
	
	public ClickBot() {
		try {
			robot = new Robot();
			detec = new KeypointDetection();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void apply(Profile profile){
		detec.takeScreen();
		
		
		
		boolean hadToOpen = false;
		boolean hasTraits = false;
		for(int skill : profile.getAllTraitlinePos()){
			if(skill != -1){
				hasTraits = true;
				System.out.println("hastraits");
			}
		}
		if(hasTraits){
			Point p = detec.find(KeyPointBase.getHeroPanel(profile.getInterfaceSize()));
			if(p == null){
				hadToOpen = true;
				keyType(KeyEvent.VK_H);
				delay(fadeDelay);
				detec.takeScreen();
				p = detec.find(KeyPointBase.getHeroPanel(profile.getInterfaceSize()));
				if(p == null){
					return;
				}
			}
			Point bto = OffsetBase.getBuildTabOffset(profile.getInterfaceSize());
			robot.mouseMove(p.x + bto.x, p.y + bto.y);
			click();
			delay(defaultDelay * 2);
			int slot = 0;
			for(int skill : profile.getAllTraitlinePos()){
				if(skill != -1){
					Point slotOffset = OffsetBase.getTraitlineIconOffset(profile.getInterfaceSize(), slot);
					Point fp = new Point(p.x + slotOffset.x, p.y + slotOffset.y);
					robot.mouseMove(fp.x, fp.y);
					click();
					delay();
					Point skillOffset = OffsetBase.getTraitlineOffset(profile.getInterfaceSize(), skill);
					Point t = new Point(skillOffset.x + fp.x, skillOffset.y + fp.y);
					robot.mouseMove(t.x, t.y);
					click();
					
					robot.mouseMove(fp.x, fp.y);
					click();
					delay();
					skillOffset = OffsetBase.getSecondaryTraitlineOffset(profile.getInterfaceSize(), skill);
					t = new Point(skillOffset.x + fp.x, skillOffset.y + fp.y);
					robot.mouseMove(t.x, t.y);
					click();
					
					slot++;
				}
			}
			int[] traitPos = profile.getAllTraitPos();
			int traitGroup = 0;
			int line = 0;
			for (int trait = 0; trait < traitPos.length ; trait++) {
				if(traitPos[trait] != -1){
					Point slotOffset = OffsetBase.getTraitlineIconOffset(profile.getInterfaceSize(), line);
					Point traitOffset = OffsetBase.getTraitOffset(profile.getInterfaceSize(), traitPos[trait] + traitGroup * 3);
					Point fpn = new Point(p.x + slotOffset.x + traitOffset.x, p.y + slotOffset.y + traitOffset.y);
					robot.mouseMove(fpn.x, fpn.y);
					click();
					delay();
					traitGroup++;
					if((trait + 1) % 3 == 0){
						traitGroup = 0;
						line++;
					}
				}
			}
			if(hadToOpen){
				keyType(KeyEvent.VK_H);
			}
		}
		boolean hasSpells = false;
		for(int skill : profile.getAllSkillPos()){
			if(skill != -1){
				hasSpells = true;
			}
		}
		if(hasSpells){
			delay();
			Point p = detec.find(KeyPointBase.getSkillBar(profile.getInterfaceSize()));
			if(p == null){
				System.out.println("nofound");
				return;
			}
			int slot = 0;
			for(int skill : profile.getAllSkillPos()){
				if(skill != -1){
					Point slotOffset = OffsetBase.getSkillBarOffset(profile.getInterfaceSize(), slot);
					Point fp = new Point(p.x + slotOffset.x, p.y + slotOffset.y);
					robot.mouseMove(fp.x, fp.y);
					rightClick();
					delay();
					Point skillOffset = OffsetBase.getSkillOffset(profile.getInterfaceSize(), skill);
					fp.translate(skillOffset.x, skillOffset.y);
					robot.mouseMove(fp.x, fp.y);
					click();
				}
				slot++;
			}
		}
		
		//apply traitlines
		//get hero panel
		
	}
	
	private void keyType(int keycode){
		robot.keyPress(keycode);
		robot.keyRelease(keycode);
	}
	
	private void rightClick(){
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);
	}
	
	private void click(){
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	private void delay(){
		try {
			Thread.currentThread().sleep(defaultDelay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void delay(int time){
		try {
			Thread.currentThread().sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().sleep(3000);
//		Profile p = new Profile();
//		p.setInterfaceSize(InterfaceSize.Larger);
//		ArrayList<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(1);
//		p.setSkillPos(list);
//		new ClickBot().apply(p);
		ClickBot b = new ClickBot();
		b.rightClick();

		
		
		//p.setSkillPos(skillPos);
	}

}
