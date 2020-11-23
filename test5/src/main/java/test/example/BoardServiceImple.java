package test.example;



import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Service
public class BoardServiceImple extends EgovAbstractServiceImpl implements BoardService {

	@Resource
	private BoardDAO boardDAO;


	public List<BoardVO> selectUser(BoardVO v) throws Exception {		
		return boardDAO.selectUser(v);
	}

	public void insert(BoardVO v) throws Exception {
		boardDAO.insert(v);		
	}


	public void delete(BoardVO v) throws Exception {
		String[] realName = v.getDeleteNames().split(",", -1);
		if (realName.length > 0) {
			for (String name : realName) {
				v.setName(name);
				boardDAO.delete(v);
			}
		}
	}

}
