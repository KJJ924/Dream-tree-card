package prj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import prj.ActionForward;
import prj.IAction;
import prj.dao.DreamTreeDAO;

public class SelectRegionAction implements IAction {

	@Override
	public ActionForward execute(HttpServletResponse response, HttpServletRequest request) throws Exception {
			
		String region =request.getParameter("region");
		String result= null;
		DreamTreeDAO dao = new DreamTreeDAO();
		
		List<String> list_ID =dao.selectRegion(region);
		
		
		
		Gson gson = new Gson();
		
		result =gson.toJson(list_ID);
		System.out.println("json(처리전):"+list_ID);
		System.out.println("json(처리후):"+result);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("output", result);
		forward.setPath("/WEB-INF/view/json.jsp");
				
		return forward;
	}

}
