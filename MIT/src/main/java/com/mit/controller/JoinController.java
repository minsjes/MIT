package com.mit.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mit.domain.JoinVO;
import com.mit.domain.PageMaker;
import com.mit.domain.SearchCriteria;
import com.mit.service.JoinService;

@Controller
@RequestMapping("/join")
public class JoinController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private JoinService service;
	
	@RequestMapping(value="/memberRegister", method=RequestMethod.GET) 
	public void memberRegisterGET(JoinVO join, Model model) throws Exception {
		logger.info("register get......");
		
	}
	
	@RequestMapping(value="/memberRegister", method=RequestMethod.POST) 
	public String memberRegisterPOST(JoinVO join, @RequestParam("joinNo") int joinNo, RedirectAttributes rttr) throws Exception {
		logger.info("register post.......");
		logger.info(join.toString());
		
		int result = service.idChk(joinNo);
		try {
			if(result >= 1) {
				rttr.addFlashAttribute("warning", "사용할 수 없는 정보입니다.");
				return "redirect:/join/memberRegister";
			} else if(result == 0) {
				service.create(join);
			}
		} catch(Exception e) {
			throw new RuntimeException();
		}
		rttr.addFlashAttribute("result", "JOIN");
		return "redirect:/";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("join list...");
	
		model.addAttribute("list", service.listSearch());
			
	}
	
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void readPage(@RequestParam("joinNo") int joinNo, Model model) throws Exception{
		logger.info("join read...");
		
		model.addAttribute(service.read(joinNo));
	}
	
	@RequestMapping(value="/modifyA", method = RequestMethod.POST)
	public String modifyA(JoinVO join, RedirectAttributes rttr) throws Exception{
		// 가입신청(JOIN) 테이블에서 승인 상태(1)로 바꾸고, 회원목록(MEMBER) 테이블에 가입정보 추가하기
		join.setAllowStatus("1");
		
		service.update(join);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/join/list";
	}
	
	@RequestMapping(value="/modifyB", method = RequestMethod.POST) //실제 게시글 데이터베이스 수정
	public String modifyB(JoinVO join, RedirectAttributes rttr) throws Exception{
		join.setAllowStatus("2");
		
		service.update(join);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/join/list";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String removePage(JoinVO join, RedirectAttributes rttr) throws Exception{
		
		service.delete(join);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/join/list";
	}
}
