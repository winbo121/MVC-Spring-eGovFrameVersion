package test.example;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;






@Service
public class BoardServiceImple implements BoardService {

	@Resource
	private BoardMapper boardMapper;


	public List<BoardVO> selectUser(BoardVO v) throws Exception {		
		return boardMapper.selectUser(v);
	}

	public void insertUser(BoardVO v) throws Exception {
		boardMapper.insertUser(v);		
	}


	public void deleteUser(BoardVO v) throws Exception {
		String[] realName = v.getDeleteNames().split(",", -1);
		if (realName.length > 0) {
			for (String name : realName) {
				v.setName(name);
				boardMapper.deleteUser(v);
			}
		}
	}

}
