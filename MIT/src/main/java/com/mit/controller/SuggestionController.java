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

import com.mit.domain.MemberVO;
import com.mit.domain.SuggestionVO;
import com.mit.service.SuggestionService;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {
	
	private static final Logger logger = LoggerFactory.getLogger(SuggestionController.class);
	
	@Inject
	private SuggestionService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list...");

		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(SuggestionVO vo, Model model) throws Exception {
		logger.info("register get...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(SuggestionVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		
		service.register(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/suggestion/list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("suggestionNo") int suggestionNo, Model model) throws Exception {
		logger.info("suggestion read...");

		model.addAttribute(service.read(suggestionNo));
		model.addAttribute("SuggestionFileVO", service.fileList(suggestionNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("suggestionNo") int suggestionNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		SuggestionVO suggestion = service.read(suggestionNo);

		if (member.getMemberNo() == suggestion.getMemberNo()) {
			model.addAttribute(suggestion);
			model.addAttribute("SuggestionFileVO", service.fileList(suggestionNo));

			return "/suggestion/modify";
		} else {
			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/suggestion/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(SuggestionVO vo, RedirectAttributes rttr) throws Exception {
		service.modify(vo);
		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/suggestion/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("suggestionNo") int suggestionNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		SuggestionVO suggestion = service.read(suggestionNo);
		
		if(member.getMemberNo() == suggestion.getMemberNo() || member.getMemberNo() == 12345678) { 
			service.remove(suggestionNo);
			rttr.addFlashAttribute("msg", "REMOVE");
			
			return "redirect:/suggestion/list";
		} else {
			rttr.addAttribute("suggestionNo", suggestionNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");
			
			return "redirect:/suggestion/list";
		}
	}
}
