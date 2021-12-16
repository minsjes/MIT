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
import com.mit.domain.QnaVO;
import com.mit.service.QnaService;

@Controller
@RequestMapping("/qna")
public class QnaController {

	@Inject
	private QnaService service;

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {

		logger.info("list...");

		model.addAttribute("list", service.list());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("qnaNo") int qnaNo, Model model) throws Exception {
		logger.info("qna read........");

		model.addAttribute(service.read(qnaNo));
		
		model.addAttribute("qnaFileVO", service.fileList(qnaNo));

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("qnaNo") int qnaNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		MemberVO member = (MemberVO) session.getAttribute("login");
		QnaVO qna = service.read(qnaNo);

		if (member.getMemberNo() == qna.getMemberNo()) {
			model.addAttribute(qna);
			model.addAttribute("qnaFileVO", service.fileList(qnaNo));

			return "/qna/modify";
		} else {
			rttr.addAttribute("qnaNo", qnaNo);
			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/qna/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(QnaVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("modify post...");
		
		service.modify(vo);
		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/qna/list";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public void registerGET(QnaVO vo, Model model) throws Exception {

		logger.info("register get......");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(QnaVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		
		service.register(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/qna/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("qnaNo") int qnaNo, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		
		
		MemberVO member = (MemberVO)session.getAttribute("login");
		
		
		QnaVO qna = service.read(qnaNo);
		
		
		if(member.getMemberNo() == qna.getMemberNo() || member.getMemberNo() == 12345678) { 
			
			service.remove(qnaNo);

			rttr.addFlashAttribute("msg", "REMOVE");
			
			return "redirect:/qna/list";
			
		} else {
			
			rttr.addAttribute("qnaNo", qnaNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");
			
			return "redirect:/qna/list";
			
		}

		
	}

}
