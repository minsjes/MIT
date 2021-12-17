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
import com.mit.domain.InfoVO;
import com.mit.service.InfoService;

@Controller
@RequestMapping("/info")
public class InfoController {

	private static final Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	@Inject
	private InfoService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list...");

		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(InfoVO vo, Model model) throws Exception {
		logger.info("register get...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(InfoVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		
		service.register(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/info/list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("infoNo") int infoNo, Model model) throws Exception {
		logger.info("info read...");

		model.addAttribute(service.read(infoNo));
		model.addAttribute("infoFileVO", service.fileList(infoNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("infoNo") int infoNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		InfoVO info = service.read(infoNo);

		if (member.getMemberNo() == info.getMemberNo()) {
			model.addAttribute(info);
			model.addAttribute("infoFileVO", service.fileList(infoNo));

			return "/info/modify";
		} else {
			rttr.addAttribute("infoNo", infoNo);
			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/info/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(InfoVO vo, RedirectAttributes rttr) throws Exception {
		service.modify(vo);
		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/info/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("infoNo") int infoNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		InfoVO info = service.read(infoNo);

		if (member.getMemberNo() == info.getMemberNo() || member.getMemberNo() == 12345678) {
			service.remove(infoNo);
			rttr.addFlashAttribute("msg", "REMOVE");

			return "redirect:/info/list";
		} else {
			rttr.addAttribute("infoNo", infoNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");

			return "redirect:/info/list";
		}
	}
}
