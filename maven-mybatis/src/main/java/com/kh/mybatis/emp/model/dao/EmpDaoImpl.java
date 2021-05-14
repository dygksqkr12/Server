package com.kh.mybatis.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Map<String, Object>> selectAllEmp(SqlSession session) {
		return session.selectList("emp.selectAllEmp");
	}

	@Override
	public List<Map<String, Object>> search1(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.search1", param);
	}

	@Override
	public List<Map<String, Object>> search2(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.search2", param);
	}

	@Override
	public List<Map<String, String>> selectJobList(SqlSession session) {
		return session.selectList("emp.selectJobList");
	}

	@Override
	public List<Map<String, Object>> search3(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.search3", param);
	}

	@Override
	public List<Map<String, String>> selectDeptList(SqlSession session) {
		return session.selectList("emp.selectDeptList");
	}

	@Override
	public Map<String, Object> selectOneEmp(SqlSession session, String empId) {
		System.out.println("쿼리 : "+session.getConfiguration().getMappedStatement("emp.selectOneEmp").getBoundSql(empId).getSql());
		return session.selectOne("emp.selectOneEmp", empId);
	}
	
	@Override
	public int updateEmp(SqlSession session, Map<String, String> param) {
		return session.update("emp.updateEmp", param);
	}

//	@Override
//	public int update(SqlSession session, Map<String, String> map) {
//		return session.update("emp.update", map);
//	}

}