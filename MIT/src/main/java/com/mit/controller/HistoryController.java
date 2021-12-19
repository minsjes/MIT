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

import com.mit.domain.HistoryVO;
import com.mit.domain.MemberVO;
import com.mit.service.HistoryService;

@Controller
@RequestMapping("/history")
public class HistoryController {

	private static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

	@Inject
	private HistoryService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list...");
		
		model.addAttribute("list", service.list());
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(HistoryVO vo, Model model) throws Exception {
		logger.info("register get...");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(HistoryVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		
		service.register(vo);
		
		return "redirect:/history/success";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("historyNo") int historyNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		HistoryVO vo = service.read(historyNo);
		
		if (member.getMemberNo() == vo.getMemberNo()) {
			model.addAttribute(vo);

			return "/history/modify";
		} else {
			return "redirect:/WEB-INF/views/401.jsp";
		}
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(HistoryVO vo, RedirectAttributes rttr) throws Exception {
		service.modify(vo);
		rttr.addFlashAttribute("msg", "MODIFY");
		
		int historyNo = vo.getHistoryNo();
		return "redirect:/history/modify?historyNo=" + historyNo + "";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("historyNo") int historyNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		HistoryVO vo = service.read(historyNo);
		
		if (member.getMemberNo() == vo.getMemberNo()) {
			service.remove(historyNo);

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
