package test.example;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;

	
	@RequestMapping(value="/start.do")
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
		
		boardService.insert(V);
		
		Map<String,String> M=new HashMap<String,String>();
		
		M.put("data","SucessInsert");
		
		return O.writeValueAsString(M);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete.do")
	public String delete(HttpServletRequest request,BoardVO V) throws Exception {	
		 
		ObjectMapper O=new ObjectMapper();
		
		boardService.delete(V);
		
		Map<String,String> M=new HashMap<String,String>();
		
		M.put("data","SucessDelete");
		
		return O.writeValueAsString(M);
	}

	
	
}
