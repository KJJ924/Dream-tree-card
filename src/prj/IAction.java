package prj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	
	public ActionForward execute(HttpServletResponse response, HttpServletRequest request)throws Exception;
}
