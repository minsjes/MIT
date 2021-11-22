package com.mit.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mit.domain.HistoryVO;
import com.mit.domain.MemberVO;
import com.mit.domain.PageMaker;
import com.mit.domain.SearchCriteria;
import com.mit.service.HistoryService;

@Controller
@RequestMapping("/history/*")
public class HistoryController {

	@Inject
	HistoryService service;

	private static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

		model.addAttribute("list", service.listSearch(cri));
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("historyNo") int HistoryNo, Model model) throws Exception {

		model.addAttribute(service.read(HistoryNo));

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(int historyNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {

		MemberVO member = (MemberVO) session.getAttribute("login");

		HistoryVO History = service.read(historyNo);

		if (member.getMemberNo() == History.getMemberNo()) {

			model.addAttribute(History);

			return "/history/modify";
		} else {

			rttr.addAttribute("historyNo", historyNo);

			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/history/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(HistoryVO vo, RedirectAttributes rttr) throws Exception {

		service.update(vo);

		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/history/list";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public void registerGET(HistoryVO vo, Model model) throws Exception {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public String registerPOST(HistoryVO vo, RedirectAttributes rttr) throws Exception {

		service.create(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/history/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("historyNo") int historyNo, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		MemberVO member = (MemberVO) session.getAttribute("login");

		HistoryVO history = service.read(historyNo);

		if (member.getMemberNo() == history.getMemberNo()) {

			service.delete(historyNo);

			rttr.addFlashAttribute("msg", "REMOVE");

			return "redirect:/history/list";

		} else {

			rttr.addAttribute("historyNo", historyNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");

			return "redirect:/history/list";

		}
	}

}
