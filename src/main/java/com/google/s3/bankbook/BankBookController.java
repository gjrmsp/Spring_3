package com.google.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/**")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("bankbookUpdate")
	public void setUpdate(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}

	@RequestMapping(value = "bankbookUpdate", method = RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setUpdate(bankBookDTO);
		return "redirect:./bankbookList";
	}
	
	@RequestMapping("bankbookDelete")
	public String setDelete(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setDelete(bankBookDTO);		
		return "redirect:./bankbookList";
	}

	@RequestMapping("bankbookList")
	public void getList(Model model) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
	}

	@RequestMapping(value = "bankbookSelect")
	public ModelAndView getSelect(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/bankbookSelect");
		return mv;
	}
}