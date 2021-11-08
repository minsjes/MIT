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
import com.mit.domain.NoticeVO;
import com.mit.service.NoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Inject
	NoticeService service;

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(Model model) throws Exception {
		logger.info("notice list...");

		model.addAttribute("list", service.listSearch());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("noticeNo") int noticeNo, Model model) throws Exception {
		logger.info("notice read...");
		
		model.addAttribute(service.read(noticeNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(int noticeNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("notice modify...");
		
		MemberVO member = (MemberVO) session.getAttribute("login");

		NoticeVO notice = service.read(noticeNo);
		
		if (member.getMemberNo() == notice.getMemberNo()) { // 작성자와 로그인 정보 같음
			model.addAttribute(notice);
			// 수정 페이지로 이동
			return "/notice/modify";
		} else { // 로그인 정보와 게시글 작성자가 일치 하지 않은 경우 -> 강제이동
			rttr.addAttribute("noticeNo", noticeNo);

			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/notice/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(NoticeVO vo, RedirectAttributes rttr) throws Exception {
		service.update(vo);
		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/notice/list";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(NoticeVO vo, Model model) throws Exception {
		logger.info("notice register...");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(NoticeVO vo, RedirectAttributes rttr) throws Exception {
		service.create(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/notice/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("noticeNo") int noticeNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		// 1) 로그인 정보 가져오기
		MemberVO member = (MemberVO)session.getAttribute("login");
		
		// 2) 게시글의 작성자 id와 로그인 정보 id를 비교
		// 2-1) 게시글 정보 가져오기
		NoticeVO notice = service.read(noticeNo);
				
		// 2-2) 게시글 작성자 id와 로그인 정보 id 비교
		if(member.getMemberNo() == notice.getMemberNo()) {
			//작성자와 로그인 정보 같음-> 게시글 삭제
			service.delete(noticeNo);
			rttr.addFlashAttribute("msg", "REMOVE");
			
			return "redirect:/notice/list";
		} else {
			// 로그인 정보와 게시글 작성자가 일치 하지 않은 경우 -> 삭제 하지 않고 강제이동
			rttr.addAttribute("noticeNo", noticeNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");
			
			return "redirect:/notice/list";
		}
	}
}
