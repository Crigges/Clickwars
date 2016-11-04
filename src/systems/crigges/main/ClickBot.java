package systems.crigges.main;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ClickBot {
	private static final int defaultDelay = 25;
	private static final int fadeDelay = 350;
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
		//apply traitlines
		p = detec.find(KeyPointBase.getHeroPanel(profile.getInterfaceSize()));
		if(p == null){
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
		delay();
		slot = 0;
		for(int skill : profile.getAllTraitlinePos()){
			Point slotOffset = OffsetBase.getTraitlineIconOffset(profile.getInterfaceSize(), slot);
			Point fp = new Point(p.x + slotOffset.x, p.y + slotOffset.y);
			robot.mouseMove(fp.x, fp.y);
			click();
			delay();
			Point skillOffset = OffsetBase.getTraitlineOffset(profile.getInterfaceSize(), skill);
			fp.translate(skillOffset.x, skillOffset.y);
			robot.mouseMove(fp.x, fp.y);
			click();
			slot++;
		}
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
