package co.yedam.emp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.emp.service.EmpService;
import co.yedam.emp.service.EmpServiceImpl;
import co.yedam.emp.service.EmpServiceMybatis;

public class EmpRemoveControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		// 삭제처리: EmpService -> EmpServiceImpl -> EmpDAO
		EmpService service = new EmpServiceMybatis();
		int r = service.removeEmp(Integer.parseInt(id));

		if (r > 0) { // 정상처리 되면 목록이동.
			try {
				resp.sendRedirect("empList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("errorPage.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
