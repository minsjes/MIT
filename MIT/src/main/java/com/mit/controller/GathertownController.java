package com.mit.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mit.domain.GathertownVO;
import com.mit.domain.MemberVO;
import com.mit.service.GathertownService;

@Controller
@RequestMapping("/gathertown")
public class GathertownController {
	
	private static final Logger logger = LoggerFactory.getLogger(GathertownController.class);
	
	@Inject
	private GathertownService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(GathertownVO vo, Model model) throws Exception {
		logger.info("register get...");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(GathertownVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		
		service.register(vo);
		
		return "redirect:/gathertown/success";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("gathertownNo") int gathertownNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		GathertownVO vo = service.read(gathertownNo);

		if (member.getMemberNo() == vo.getMemberNo()) {
			model.addAttribute(vo);

			return "/gathertown/modify";
		} else {
			return "redirect:/WEB-INF/views/401.jsp";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(GathertownVO vo, RedirectAttributes rttr) throws Exception {
		service.modify(vo);
		rttr.addFlashAttribute("msg", "MODIFY");
		
		int gathertownNo = vo.getGathertownNo();
		return "redirect:/gathertown/modify?gathertownNo=" + gathertownNo + "";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("gathertownNo") int gathertownNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		GathertownVO vo = service.read(gathertownNo);
		
		if (member.getMemberNo() == vo.getMemberNo()) {
			service.remove(gathertownNo);
			rttr.addFlashAttribute("msg", "REMOVE");
			
			return "redirect:/gathertown/success";
		} else {
			return "redirect:/WEB-INF/views/401.jsp";
		}
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public void registerGET( ) throws Exception {
		logger.info("success...");
	}
}
