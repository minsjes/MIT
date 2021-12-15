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
import com.mit.domain.StudyVO;
import com.mit.service.StudyService;

@Controller
@RequestMapping("/study")
public class StudyController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudyController.class);
	
	@Inject
	private StudyService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list...");

		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(StudyVO vo, Model model) throws Exception {
		logger.info("register get...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(StudyVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		
		service.register(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/study/list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("studyNo") int studyNo, Model model) throws Exception {
		logger.info("study read...");
		
		model.addAttribute(service.read(studyNo));
		model.addAttribute("studyFileVO", service.fileList(studyNo));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("studyNo") int studyNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		StudyVO study = service.read(studyNo);

		if (member.getMemberNo() == study.getMemberNo()) {
			model.addAttribute(study);
			model.addAttribute("studyFileVO", service.fileList(studyNo));

			return "/study/modify";
		} else {
			rttr.addAttribute("studyNo", studyNo);
			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/study/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(StudyVO vo, RedirectAttributes rttr) throws Exception {
		service.modify(vo);
		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/study/list";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("studyNo") int studyNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		StudyVO study = service.read(studyNo);
		
		if (member.getMemberNo() == study.getMemberNo() || member.getMemberNo() == 12345678) {
			service.remove(studyNo);
			rttr.addFlashAttribute("msg", "REMOVE");
			
			return "redirect:/study/list";
		} else {
			rttr.addAttribute("studyNo", studyNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");
			
			return "redirect:/study/list";
		}
	}
}
