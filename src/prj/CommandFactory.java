package prj;

import prj.action.DefaultAction;
import prj.action.Search;

import prj.action.SelectRegionAction;
import prj.action.SelectThemeAction;

public class CommandFactory {
	
	//싱글톤패턴
	private static CommandFactory  instance ;
	private CommandFactory() {}

	public static CommandFactory getInstance() {
		if(instance==null) {
			instance= new CommandFactory();
		}
			return instance;
	}
	
	public IAction getAction(String command) {
		IAction action =null;
		
		switch (command) {
		case "Search":
			action = new Search();
			break;
		case "SelectRegion":
			action = new SelectRegionAction();
			break;
		case "SelectTheme":
			action = new SelectThemeAction();
			break;
		//Command가 기본 값일 경우
		case "DefaultAction":
		default:
			action= new DefaultAction();
			break;
		}
		
		
		
		return action;
	}
}
