package co.yedam.emp.command;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.emp.service.EmpService;
import co.yedam.emp.service.EmpServiceImpl;
import co.yedam.emp.service.EmpServiceMybatis;

public class EmpForm implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		EmpService service = new EmpServiceImpl();
		Map<String, String> jobList = service.jobList();

		for (Entry<String, String> ent : jobList.entrySet()) {
			System.out.println(ent.getKey() + "," + ent.getValue());
		}

		req.setAttribute("jobList", jobList);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/emp.jsp");
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
