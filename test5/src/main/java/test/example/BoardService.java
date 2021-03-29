package test.example;

import java.util.List;





public interface BoardService {
	public List<BoardVO> selectUser(BoardVO v) throws Exception;
	public void insertUser(BoardVO v) throws Exception;
	public void deleteUser(BoardVO v) throws Exception;
}
