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
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		logger.info("member loginPost...");

		MemberVO vo = service.login(dto);

		if (vo == null) {// 로그인 정보가 없는 경우
			return;
		}

		// 로그인 정보가 있는 경우, session 객체에 정보 담기 → Interceptor에게 이관
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
	public void list(Model model) throws Exception {
		logger.info("list...");
		
		model.addAttribute("list", service.listSearch());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(MemberVO vo, Model model) throws Exception {
		logger.info("register get...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(MemberVO vo, @RequestParam("memberNo") int memberNo, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		
		int result = service.idCheck(memberNo);
		
		try {
			if(result >= 1) {
				rttr.addFlashAttribute("msg", "FAIL");
				return "redirect:/member/register";
			} else if(result == 0) {
				service.register(vo);
				rttr.addFlashAttribute("msg", "REGISTER");
			}
		} catch(Exception e) {
			throw new RuntimeException();
		}
		
		return "redirect:/member/list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readGET(@RequestParam("memberNo") int memberNo, Model model) throws Exception {
		logger.info("member read...");
		
		model.addAttribute(service.read(memberNo));
	}
	
	@RequestMapping(value = "/readMyPage", method = RequestMethod.GET)
	public void readMyPageGET(@RequestParam("memberNo") int memberNo, Model model) throws Exception {
		logger.info("member readMyPage...");
		
		model.addAttribute(service.read(memberNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET) // 수정 화면으로 이동
	public void modifyGET(@RequestParam("memberNo") int memberNo, Model model) throws Exception {
		logger.info("modify get...");
		
		model.addAttribute(service.read(memberNo));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST) // 실제 데이터베이스 수정
	public String modifyPOST(MemberVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("modify post...");
		
		service.modifyAdmin(vo);
		
		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/modifyMyPage", method = RequestMethod.GET) // 수정 화면으로 이동
	public void modifyMyPageGET(@RequestParam("memberNo") int memberNo, Model model) throws Exception {
		logger.info("member modifyMyPage...");
		
		model.addAttribute(service.read(memberNo));
	}

	@RequestMapping(value = "/modifyMyPage", method = RequestMethod.POST) // 실제 데이터베이스 수정
	public String modifyMyPagePOST(MemberVO vo,RedirectAttributes rttr) throws Exception {
		
		int memberNo = vo.getMemberNo();

		service.modifyUser(vo);

		rttr.addAttribute("memberNo", memberNo);
		
		rttr.addFlashAttribute("msg", "수정되었습니다.");

		return "redirect:/member/readMyPage";
	}
}
