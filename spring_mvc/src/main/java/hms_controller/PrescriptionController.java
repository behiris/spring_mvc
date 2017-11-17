package hms_controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import controller.ChangePwdCommand;
import hms_spring.PrescriptionDao;


@Controller
public class PrescriptionController {
	private PrescriptionDao prescriptionDao;
	
	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
	}
 
	@RequestMapping("/hms/prescriptionList")
	public String list(Model model) {
		List<PrescriptionCommand> prescriptions = prescriptionDao.selectAll();
		model.addAttribute("prescriptions", prescriptions);
		
		return "hms/prescriptionList";
	}
	
	@RequestMapping("/hms/prescriptionUpdate")
	public String form(HttpServletRequest request) {
		System.out.println(request.getAttribute("num"));
		
		//prescriptionDao.update(prescription);
		return "hms/prescriptionList";
	}
}
