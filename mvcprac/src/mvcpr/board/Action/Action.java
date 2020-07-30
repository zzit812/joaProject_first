package mvcpr.board.Action;

import javax.servlet.http.*;

import mvcpr.board.DTO.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
