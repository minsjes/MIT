
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

import com.mit.domain.InfoVO;
import com.mit.domain.MemberVO;
import com.mit.domain.PageMaker;
import com.mit.domain.SearchCriteria;
import com.mit.service.InfoService;

@Controller
@RequestMapping("/info/*")
public class InfoController {

	@Inject
	InfoService service;

	private static final Logger logger = LoggerFactory.getLogger(InfoController.class);

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
	public void read(@RequestParam("infoNo") int infoNo, Model model) throws Exception {

		logger.info("read.........");

		// �봽濡쒓렇�옩 �궡�슜
		model.addAttribute(service.read(infoNo));
		model.addAttribute("infoFileVO", service.fileList(infoNo));

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(int infoNo, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {

		MemberVO member = (MemberVO) session.getAttribute("login");

		InfoVO info = service.read(infoNo);

		if (member.getMemberNo() == info.getMemberNo()) {
			// 占쎌삂占쎄쉐占쎌쁽占쏙옙 嚥≪뮄�젃占쎌뵥 占쎌젟癰귨옙 揶쏆늿�벉
			model.addAttribute(info);

			model.addAttribute("infoFileVO", service.fileList(infoNo));

			return "/info/modify";
		} else {
			// 嚥≪뮄�젃占쎌뵥 占쎌젟癰귣똻占� 野껊슣�뻻疫뀐옙 占쎌삂占쎄쉐占쎌쁽揶쏉옙 占쎌뵬燁삼옙 占쎈릭筌욑옙 占쎈륫占쏙옙 野껋럩�뒭 ->
			// 揶쏅벡�젫占쎌뵠占쎈짗
			rttr.addAttribute("infoNo", infoNo);

			rttr.addFlashAttribute("msg", "CANNOT");

			return "redirect:/info/list";
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(InfoVO vo, RedirectAttributes rttr) throws Exception {

		service.update(vo);

		rttr.addFlashAttribute("msg", "MODIFY");

		return "redirect:/info/list";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public void registerGET(InfoVO vo, Model model) throws Exception {

		logger.info("register get......");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public String registerPOST(InfoVO vo, RedirectAttributes rttr) throws Exception {

		service.create(vo);
		rttr.addFlashAttribute("msg", "REGISTER");

		return "redirect:/info/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("infoNo") int infoNo, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		MemberVO member = (MemberVO) session.getAttribute("login");

		InfoVO info = service.read(infoNo);

		if (member.getMemberNo() == info.getMemberNo()) {

			service.delete(infoNo);

			rttr.addFlashAttribute("msg", "REMOVE");

			return "redirect:/info/list";

		} else {

			rttr.addAttribute("infoNo", infoNo);
			rttr.addFlashAttribute("msg", "CANTDELETE");

			return "redirect:/info/list";

		}
	}

}