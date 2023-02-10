package co.yedam.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.common.DataSource;
import co.yedam.emp.vo.EmpVO;

// EmpServiceImpl : jdbc
// EmpServiceMybatis : mybatis
public class EmpServiceMybatis implements EmpService {

	SqlSessionFactory sessionFactory = DataSource.getInstance();
	SqlSession session = sessionFactory.openSession(true); // 자동커밋.

	@Override
	public List<EmpVO> empList() {
		return session.selectList("co.yedam.emp.mapper.EmpMapper.empList");
	}

	@Override
	public int addEmp(EmpVO emp) {
		// A -> B 송금.
//		session.commit();
		int r = session.insert("co.yedam.emp.mapper.EmpMapper.addEmp", emp);
		if (r > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		return r;
	}

	@Override
	public EmpVO getEmp(int empId) {
		return session.selectOne("co.yedam.emp.mapper.EmpMapper.getEmp", empId);
	}

	@Override
	public Map<String, String> jobList() {
		// TODO Auto-generated method stub
		Map<String, Object> map = session.selectMap("co.yedam.emp.mapper.EmpMapper.jobList", "jobId");
		Set<String> set = map.keySet();
		Map<String, String> resultMap = new HashMap<>();
		for (String key : set) {
			String valStr = (String) map.get(key);
			System.out.println(key + ", " + valStr.substring(valStr.indexOf("jobTitle="), 0));
//			resultMap.put(key, (String) map.get(key));
		}

//		for (Entry<String, Object> ent : map) {
//			System.out.println(ent.getKey() + "," + ent.getValue());
//		}
		return resultMap;// session.selectmap("co.yedam.emp.mapper.EmpMapper.jobList");
	}

	@Override
	public int modEmp(EmpVO emp) {
		return session.update("co.yedam.emp.mapper.EmpMapper.modEmp", emp);
	}

	@Override
	public int removeEmp(int id) {
		return session.delete("co.yedam.emp.mapper.EmpMapper.removeEmp", id);
	}

}
