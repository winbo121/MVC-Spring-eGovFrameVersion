package test.example;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("boardMapper")
public interface BoardMapper {
	public List<BoardVO> selectUser(BoardVO v) throws Exception;
	public void insertUser(BoardVO v) throws Exception;
	public void deleteUser(BoardVO v) throws Exception;
}
