package test.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;

	
	@RequestMapping(value="/start5.do")
	public String start(HttpServletRequest request,BoardVO V, Model M) throws Exception {	
		
		return "NewFile";
	}

	@ResponseBody
	@RequestMapping(value="/list.do")
	public String list(HttpServletRequest request,BoardVO V) throws Exception {	
		
		ObjectMapper O=new ObjectMapper();
		
		List<BoardVO> L=boardService.selectUser(V);
		
		Map<String,Object> M=new HashMap<String,Object>();
		
		M.put("data",L);
		
		
		return O.writeValueAsString(M);
	}
	
	@ResponseBody
	@RequestMapping(value="/insert.do")
	public String insert(HttpServletRequest request,BoardVO V) throws Exception {	
		 
		ObjectMapper O=new ObjectMapper();
		
		boardService.insertUser(V);
		
		Map<String,String> M=new HashMap<String,String>();
		
		M.put("data","SucessInsert");
		
		return O.writeValueAsString(M);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete.do")
	public String delete(HttpServletRequest request,BoardVO V) throws Exception {	
		 
		ObjectMapper O=new ObjectMapper();
		
		boardService.deleteUser(V);
		
		Map<String,String> M=new HashMap<String,String>();
		
		M.put("data","SucessDelete");
		
		return O.writeValueAsString(M);
	}

	
	
}
