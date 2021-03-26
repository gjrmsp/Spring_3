package com.google.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.google.s3.member.MemberDTO;

@Controller
@RequestMapping("/account/**")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("accountInsert")
	public String setInsert(AccountDTO accountDTO, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		accountDTO.setId(memberDTO.getId());
		int result = accountService.setInsert(accountDTO);
		return "redirect:./accountList";
	}

	@RequestMapping("accountList")
	public void getList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(memberDTO.getId());
		List<AccountDTO> ar = accountService.getList(accountDTO);
		model.addAttribute("list", ar);
	}
}
