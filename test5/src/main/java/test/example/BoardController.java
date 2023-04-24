package test.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	
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
	public String insert(HttpServletRequest request,BoardVO V ,BindingResult bindingResult) throws Exception {	
		 
		/*벨리데이션 작업*/
		beanValidator.validate(V, bindingResult);
		
		Map<String,String> M=new HashMap<String,String>();
		ObjectMapper O=new ObjectMapper();
		
		
		/*벨리데이션 체크에 따라 인설트 ox*/
		if(!bindingResult.hasErrors()) {
			
			boardService.insertUser(V);
			M.put("data","SucessInsert");	
		
		}else {
			M.put("data","severValidateFail");	
		}
			
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
	
	@RequestMapping(value="/validator.do")
	public String validator(HttpServletRequest request,BoardVO V) throws Exception {	
        System.out.println(">>>>벨리데이션 체크해주는 JSP컨트롤러<<<<");
		
		return "cmmn/validator";
	}
	
}
