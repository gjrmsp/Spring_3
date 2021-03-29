package com.google.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		//List<NoticeDTO> ar = noticeService.getList(curPage);
		//mv.addObject("list", ar);
		//mv.setViewName("notice/noticeList");
		return mv;
	}

	@RequestMapping("noticeSelect")
	public ModelAndView getSelect(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		noticeDTO = noticeService.getSelect(noticeDTO);

		mv.addObject("dto", noticeDTO);
		mv.setViewName("notice/noticeSelect");
		return mv;
	}

	@RequestMapping("noticeInsert")
	public void setInsert() throws Exception {}

	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String setInsert(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.setInsert(noticeDTO);
		return "redirect:../";
	}

	@RequestMapping("noticeUpdate")
	public void setUpdate(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}

	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:../";
	}
	
	@RequestMapping("noticeDelete")
	public String setDelete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.setDelete(noticeDTO);
		return "redirect:../";
	}
}	