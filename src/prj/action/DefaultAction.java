package prj.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj.ActionForward;
import prj.IAction;

public class DefaultAction implements IAction {

	@Override
	public ActionForward execute(HttpServletResponse response, HttpServletRequest request) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setPath("/WEB-INF/view/index.jsp");
		
		return forward;
	}

}
