//package com.luxhouse.main.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class SecurityController {
//	@RequestMapping("/security/login/form")
//	public String loginForm(Model model) {
//		model.addAttribute("message","Vui Long Dang Nhap !");
//		return "client/security/login";
//	}
//	
//	@RequestMapping("/security/login/success")
//	public String loginSuccess(Model model) {
//		model.addAttribute("message", "Dang Nhap Thanh Cong !");
//		return "client/security/login";
//	}
//	
//	@RequestMapping("/security/login/error")
//	public String loginError(Model model) {
//		model.addAttribute("message", "Dang Nhap Khong Thanh Cong !");
//		return "redirect:/security/login/form";
//	}
//	
//	@RequestMapping("/security/unauthoried")
//	public String unauthoried(Model model) {
//		model.addAttribute("message", "Khong co quyen truy xuat !");
//		return "security/login";
//	}
//	
//	@RequestMapping("/security/logoff/success")
//	public String logoffSuccess(Model model) {
//		model.addAttribute("message","Dang Xuat Thanh Cong !");
//		return "security/login";
//	}
//	
//}
