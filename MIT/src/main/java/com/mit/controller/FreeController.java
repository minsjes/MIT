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

import com.mit.domain.FreeVO;
import com.mit.domain.MemberVO;
import com.mit.domain.PageMaker;
import com.mit.domain.SearchCriteria;
import com.mit.service.FreeService;

@Controller
@RequestMapping("/free/*")
public class FreeController {

	@Inject
	FreeService service;

	private static final Logger logger = LoggerFactory.getLogger(FreeController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

		model.addAttribute("list", service.listSearch(cri));
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("freeNo") int freeNo, Model model)
			throws Exception {
		logger.info("read.........");

	      // 프로그램 내용
	      model.addAttribute(service.read(freeNo));

	      // 업로드한 파일 리스트
	      model.addAttribute("freeFileVO", service.fileList(freeNo));
	      
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("freeNo") int freeNo, HttpSession session, Model model,
			RedirectAttributes rttr) throws Exception {

		MemberVO member = (MemberVO) session.getAttribute("login");

		FreeVO free = service.read(freeNo);

		if (member.getMemberNo() == free.getMemberNo()) {
			// 작성자와 로그인 정보 같음
			model.addAttribute(free);
			model.addAttribute("freeFileVO", service.fileList(freeNo));
			// 수정 페이지로 이동
			return "/free/modify";
		} else {
			// 로그인 정보와 게시글 작성자가 일치 하지 않은 경우 -> 강제이동
			rttr.addAttribute("freeNo", freeNo);

			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/free/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(FreeVO vo, RedirectAttributes rttr)
			throws Exception {

		service.update(vo);
		
		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/free/list";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public void registerGET(FreeVO vo, Model model) throws Exception {

		logger.info("register get......");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public String registerPOST(FreeVO vo, RedirectAttributes rttr) throws Exception {

		service.create(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/free/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("freeNo") int freeNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		// 1) 로그인 정보 가져오기
		MemberVO member = (MemberVO)session.getAttribute("login");
				
		// 2) 게시글의 작성자 id와 로그인 정보 id를 비교
		// 2-1) 게시글 정보 가져오기
		FreeVO free = service.read(freeNo);
				
		// 2-2) 게시글 작성자 id와 로그인 정보 id 비교
		if(member.getMemberNo() == free.getMemberNo()) {
			//작성자와 로그인 정보 같음-> 게시글 삭제
			service.delete(freeNo);
			
			rttr.addFlashAttribute("msg", "REMOVE");
			
			return "redirect:/free/list";
					
		} else {
			// 로그인 정보와 게시글 작성자가 일치 하지 않은 경우 -> 삭제 하지 않고 강제이동
			rttr.addAttribute("freeNo", freeNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");
					
			return "redirect:/free/list";
		}
	}
}