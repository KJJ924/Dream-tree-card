package prj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import prj.ActionForward;
import prj.IAction;
import prj.dao.DreamTreeDAO;

public class Search implements IAction {

	@Override
	public ActionForward execute(HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		String result=null;
		String title =request.getParameter("title");
		System.out.println(title);
		DreamTreeDAO dao = new DreamTreeDAO();
		
		List<String>list_id = dao.search(title);
		
		Gson gson = new Gson();
		
		result = gson.toJson(list_id);
		
		ActionForward forward =new ActionForward();
		
		request.setAttribute("output", result);
		forward.setPath("/WEB-INF/view/json.jsp");
		
	
		return forward;
	}

}
