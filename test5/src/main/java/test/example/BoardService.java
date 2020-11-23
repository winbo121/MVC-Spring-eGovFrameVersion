package test.example;

import java.util.List;

import org.springframework.stereotype.Service;



public interface BoardService {
	public List<BoardVO> selectUser(BoardVO v) throws Exception;
	public void insert(BoardVO v) throws Exception;
	public void delete(BoardVO v) throws Exception;
}
