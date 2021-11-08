package com.mit.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.mit.domain.MemberVO;
import com.mit.domain.PageMaker;
import com.mit.domain.SearchCriteria;
import com.mit.dto.LoginDTO;
import com.mit.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		logger.info("member login...");

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPost(LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("member loginPost....");

		MemberVO vo = service.login(dto);

		if (vo == null) {// 로그인 정보가 없는 경우
			return;
		}

		// 로그인 정보가 있는 경우, session 객체에 정보 담기 -> Interceptor에게 이관
		// model 객체에 정보 담기
		model.addAttribute("memberVO", vo);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session, RedirectAttributes rttr)
			throws Exception {

		Object obj = session.getAttribute("login");

		if (obj != null) {
			logger.info("logout: session.invalidate() ");

			session.removeAttribute("login");
			session.invalidate();
		}
		rttr.addFlashAttribute("msg", "LOGOUT");
		return "redirect:/";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(Model model) throws Exception {

		logger.info("listPage...");

		// 1) cri에 맞는 게시글 정보 담아서 화면으로 전달
		model.addAttribute("list", service.listSearch());

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("memberNo") int memberNo, Model model)
			throws Exception {
		logger.info("member read...");

		model.addAttribute(service.read(memberNo));
	}
	
	@RequestMapping(value = "/myreadPage", method = RequestMethod.GET)
	public void myreadPage(@RequestParam("memberNo") int memberNo, Model model)
			throws Exception {
		logger.info("member myreadPage...");

		model.addAttribute(service.read(memberNo));
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET) // 수정 화면으로 이동
	public void modifyPageGET(int memberNo,Model model) throws Exception {
	

		model.addAttribute(service.read(memberNo));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST) // 실제 게시글 데이터베이스 수정
	public String modifyPagePOST(MemberVO member,RedirectAttributes rttr)
			throws Exception {

		service.modify(member);
		
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/myModifyPage", method = RequestMethod.GET) // 수정 화면으로 이동
	public void myModifyPageGET(int memberNo,Model model) throws Exception {

		model.addAttribute(service.read(memberNo));

	}

	@RequestMapping(value = "/myModifyPage", method = RequestMethod.POST) // 실제 게시글 데이터베이스 수정
	public String myModifyPagePOST(MemberVO member, RedirectAttributes rttr)
			throws Exception {
		
		int memberNo = member.getMemberNo();

		service.modify(member);

		rttr.addAttribute("memberNo", memberNo);
		
		rttr.addFlashAttribute("msg", "수정되었습니다.");

		return "redirect:/member/myreadPage";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String removePage(@RequestParam("memberNo") int memberNo, 
			RedirectAttributes rttr) throws Exception {

		service.remove(memberNo);

		rttr.addFlashAttribute("msg", "REMOVE");

		return "redirect:/member/list";

	}

}
