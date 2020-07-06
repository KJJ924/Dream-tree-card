package prj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prj.ActionForward;
import prj.IAction;
import prj.dao.DreamTreeDAO;
import prj.dto.DreamTreeInfo;

public class SelectPointAction implements IAction {

	@Override
	public ActionForward execute(HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		int select_id= Integer.parseInt(request.getParameter("cam_id"));
	
		
		DreamTreeDAO dao = new DreamTreeDAO();
		
		DreamTreeInfo info = dao.selectPoint(select_id);
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("info", info);
		forward.setPath("WEB-INF/view/informationWindow.jsp");
		
		return forward;
	}

}
