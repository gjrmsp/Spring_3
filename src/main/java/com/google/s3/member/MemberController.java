package com.google.s3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("memberJoin")
	public String memberJoin() {
		return "redirect:./memberJoin";
	}
	
	@RequestMapping(value = "/member/memberJoin", method = RequestMethod.POST)
	public void memberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberService.memberJoin(memberDTO);
	}
	
	public ModelAndView memberLogin(MemberDTO memberDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		memberDTO = memberService.memberLogin(memberDTO);
		
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("member/memberPage");
		return modelAndView;
	}
}
