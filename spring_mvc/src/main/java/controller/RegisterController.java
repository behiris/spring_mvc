package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	private MemberRegisterService memberRegisterService;
	
	@RequestMapping(value="/register/step1", method=RequestMethod.GET)//웹 APP 개발은 두가지 코드를 작성하는 것. 1. Client로부터 특정 요청 URL 처리 코드 작성, 2. 요청을 처리한 결과를 웹 브라우저에서 해석할 수 있는 방식(HTML 등)으로 응답하는 코드 작성. 첫번째는 @Controller 어노테이션 적용하여 컨트롤러 클래스이용하여 구현, 이때 컨트롤러는 메서드에 @RequestMapping 어노테이션 지정하여 요청 경로 지정 
	public String handleStep1() {
		return "register/step1";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String handleStep2(@RequestParam(value="agree", defaultValue="false")Boolean agree, Model model) {
		if(!agree) {
			return "register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());
		return "register/step2";
	}
		
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String handleStep2() {
		return "redirect:/register/step1";
	}
	
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq, Errors errors) {
		/*new RegisterControllerValidator().validate(regReq, errors);//유효한 조건으로 변경해야함
		if(errors.hasErrors()) {
			return "register/step2";
		}*/
		try {
			memberRegisterService.regist(regReq);
			return "/register/step3";
		}
		catch(AlreadyExistingMemberException e) {
			errors.rejectValue("email", "duplicate");
			return "/register/step2";
		}
	}
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
}