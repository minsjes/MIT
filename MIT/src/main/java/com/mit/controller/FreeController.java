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

import com.mit.domain.FreeVO;
import com.mit.domain.MemberVO;
import com.mit.service.FreeService;

@Controller
@RequestMapping("/free")
public class FreeController {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeController.class);
	
	@Inject
	private FreeService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		logger.info("list...");

		model.addAttribute("list", service.list());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(FreeVO vo, Model model) throws Exception {
		logger.info("register get...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(FreeVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		
		service.register(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/free/list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("freeNo") int freeNo, Model model) throws Exception {
		logger.info("free read...");

	    model.addAttribute(service.read(freeNo));
	    model.addAttribute("freeFileVO", service.fileList(freeNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("freeNo") int freeNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		FreeVO free = service.read(freeNo);

		if (member.getMemberNo() == free.getMemberNo()) {
			model.addAttribute(free);
			model.addAttribute("freeFileVO", service.fileList(freeNo));

			return "/free/modify";	
		} else {
			rttr.addAttribute("freeNo", freeNo);
			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/free/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(FreeVO vo, RedirectAttributes rttr) throws Exception {
		service.modify(vo);
		rttr.addFlashAttribute("msg", "MODIFY");
		
		return "redirect:/free/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("freeNo") int freeNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO)session.getAttribute("login");
		FreeVO free = service.read(freeNo);
				
		if(member.getMemberNo() == free.getMemberNo() || member.getMemberNo() == 12345678) {
			service.remove(freeNo);
			rttr.addFlashAttribute("msg", "REMOVE");
			
			return "redirect:/free/list";	
		} else {
			rttr.addAttribute("freeNo", freeNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");
					
			return "redirect:/free/list";
		}
	}
}
