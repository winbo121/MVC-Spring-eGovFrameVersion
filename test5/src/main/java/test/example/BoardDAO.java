package test.example;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class BoardDAO extends EgovAbstractMapper{


	public List<BoardVO> selectUser(BoardVO v) throws Exception {
		return selectList("User.selectUser",v);
	}


	public void insert(BoardVO v) throws Exception {
		 insert("User.insertUser",v);		
	}

	
	public void delete(BoardVO v) throws Exception {
		 delete("User.deleteUser", v);
	}





}
