package prj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import prj.ActionForward;
import prj.IAction;
import prj.dao.DreamTreeDAO;

public class SelectThemeAction implements IAction {

	@Override
	public ActionForward execute(HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		String result= null;
		String theme =request.getParameter("theme");
		
		DreamTreeDAO dao = new DreamTreeDAO();
	
		List<String>list_ID = dao.selectTheme(theme);
		
		Gson gson = new Gson();
		result =gson.toJson(list_ID);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("output", result);
		forward.setPath("/WEB-INF/view/json.jsp");
		
		return forward;
	}

}
