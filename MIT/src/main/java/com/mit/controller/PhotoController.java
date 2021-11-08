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

import com.mit.domain.MemberVO;
import com.mit.domain.PageMaker;
import com.mit.domain.PhotoVO;
import com.mit.domain.SearchCriteria;
import com.mit.service.PhotoService;

@Controller
@RequestMapping("/photo/*")
public class PhotoController {

	@Inject
	PhotoService service;

	private static final Logger logger = LoggerFactory.getLogger(PhotoController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info(cri.toString());

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		logger.info("pageMaker " + pageMaker);

		model.addAttribute("pageMaker", pageMaker);

		model.addAttribute("list", service.listSearch(cri));
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(@RequestParam("photoNo") int photoNo,  @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		logger.info("read.........");

		// �봽濡쒓렇�옩 �궡�슜
		model.addAttribute(service.read(photoNo));

		// �뾽濡쒕뱶�븳 �뙆�씪 由ъ뒪�듃
		model.addAttribute("photoFileVO", service.fileList(photoNo));
		
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("photoNo") int photoNo, HttpSession session, Model model,
			RedirectAttributes rttr) throws Exception {

		MemberVO member = (MemberVO) session.getAttribute("login");

		PhotoVO photo = service.read(photoNo);

		if (member.getMemberNo() == photo.getMemberNo()) {
			
			model.addAttribute(photo);
			model.addAttribute("photoFileVO", service.fileList(photoNo));
			
			return "/photo/modify";
		} else {
			
			rttr.addAttribute("photoNo", photoNo);
		
			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/photo/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(PhotoVO vo, RedirectAttributes rttr)
			throws Exception {

		service.update(vo);
	
		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/photo/list";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public void registerGET(PhotoVO vo, Model model) throws Exception {

		logger.info("register get......");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public String registerPOST(PhotoVO vo, RedirectAttributes rttr) throws Exception {

		service.create(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/photo/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("photoNo") int photoNo, HttpSession session,
			RedirectAttributes rttr) throws Exception {

	
				MemberVO member = (MemberVO)session.getAttribute("login");
				
				PhotoVO photo = service.read(photoNo);
				
				
				if(member.getMemberNo() == photo.getMemberNo()) {
					
					service.delete(photoNo);
				
					rttr.addFlashAttribute("msg", "REMOVE");
					
					return "redirect:/photo/list";
					
				} else {
				
					rttr.addAttribute("photoNo", photoNo);
					rttr.addFlashAttribute("msg", "CANTDELETE");
					
					return "redirect:/photo/list";
				
				}
			}

	}
