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

	      // �봽濡쒓렇�옩 �궡�슜
	      model.addAttribute(service.read(freeNo));

	      // �뾽濡쒕뱶�븳 �뙆�씪 由ъ뒪�듃
	      model.addAttribute("freeFileVO", service.fileList(freeNo));
	      
	}

	// 2-1) 자유게시판 : 게시물 수정 GET
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("freeNo") int freeNo, HttpSession session, Model model,
			RedirectAttributes rttr) throws Exception {

		logger.info("자유게시판 수정페이지 GET 실행");
		
		// 2-1-1) session에 저장된 로그인 정보 가져온 뒤 member 객체에 저장
		MemberVO member = (MemberVO) session.getAttribute("login");
		
		// 2-1-2) FreeService의 read 메소드를 호출하여 return 값 free 객체에 저장
		FreeVO free = service.read(freeNo);

		System.out.println("login : " + member.getMemberNo() + "==" + " free : " + free.getMemberNo());
		
		// 2-1-3)
		// if : 로그인한 memberNo와 FREE 테이블의 memberNo가 같다면 if문 수행
		// else : 로그인한 memberNo와 FREE 테이블의 memberNo가 다르다면 else문 수행
		if (member.getMemberNo() == free.getMemberNo()) {
			
			// 2-1-3-1) free/modify.jsp로 이동하면서 free 객체에 저장된 정보 전달
			model.addAttribute(free);
			
			// 2-1-3-2) FreeService의 fileList 메소드 호출하여 return 받은 값을 "freeFileVO"에 담아서 free/modify.jsp에 전달
			model.addAttribute("freeFileVO", service.fileList(freeNo));
			System.out.println("(if)FreeNo : " + freeNo);
			
			logger.info("자유게시판 수정페이지 GET 실행 완료");
			// 2-1-3-3) free/modify.jsp로 페이지 이동
			return "/free/modify";
			
		} else {
			
			// 2-1-3-1)rttr을 사용하여 redirect로 이동하는 페이지에 "freeNo"에 freeNo를 담아서 전송
			rttr.addAttribute("freeNo", freeNo);
			System.out.println("(else)FreeNo : " + freeNo);

			// 2-1-3-2)rttr을 사용하여 redirect로 이동하는 페이지에 "msg"에 "CANNOT" 문자열을 담아서 전송
			rttr.addFlashAttribute("msg", "CANNOT");

			logger.info("자유게시판 수정페이지 GET 실행 완료");
			// 2-1-3-3)free/list.jsp로 페이지 이동하면서 정보삭제 
			return "redirect:/free/list";
		}
	}

	// 2-2) 자유게시판 : 게시물 수정 POST
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(FreeVO vo, RedirectAttributes rttr)
			throws Exception {
		
		logger.info("자유게시판 수정페이지 POST 실행");
		
		// 2-2-1) FreeService의 update 메소드 호출
		service.update(vo);
		
		// 2-2-2) rttr을 사용하여 redirect로 이동하는 페이지에 "msg"에 "MODIFY" 문자열을 담아서 전송
		rttr.addFlashAttribute("msg", "MODIFY");

		logger.info("자유게시판 수정페이지 POST 실행 완료");
		// 2-2-3) free/list.jsp로 페이지 이동하면서 정보삭제 
		return "redirect:/free/list";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public void registerGET(FreeVO vo, Model model) throws Exception {

		logger.info("register get......");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public String registerPOST(FreeVO vo, RedirectAttributes rttr) throws Exception {

	 System.out.println(vo);
		service.create(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/free/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("freeNo") int freeNo, HttpSession session, RedirectAttributes rttr) throws Exception {
		// 1) 濡쒓렇�씤 �젙蹂� 媛��졇�삤湲�
		MemberVO member = (MemberVO)session.getAttribute("login");
				
		// 2) 寃뚯떆湲��쓽 �옉�꽦�옄 id�� 濡쒓렇�씤 �젙蹂� id瑜� 鍮꾧탳
		// 2-1) 寃뚯떆湲� �젙蹂� 媛��졇�삤湲�
		FreeVO free = service.read(freeNo);
				
		// 2-2) 寃뚯떆湲� �옉�꽦�옄 id�� 濡쒓렇�씤 �젙蹂� id 鍮꾧탳
		if(member.getMemberNo() == free.getMemberNo() || member.getMemberNo() == 12345678) {
			//�옉�꽦�옄�� 濡쒓렇�씤 �젙蹂� 媛숈쓬-> 寃뚯떆湲� �궘�젣
			service.delete(freeNo);
			
			rttr.addFlashAttribute("msg", "REMOVE");
			
			return "redirect:/free/list";
					
		} else {
			// 濡쒓렇�씤 �젙蹂댁� 寃뚯떆湲� �옉�꽦�옄媛� �씪移� �븯吏� �븡�� 寃쎌슦 -> �궘�젣 �븯吏� �븡怨� 媛뺤젣�씠�룞
			rttr.addAttribute("freeNo", freeNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");
					
			return "redirect:/free/list";
		}
	}
}