package hms_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hms_spring.PatientDao;

@Controller
public class PatientUpdateController {
	private PatientDao patientDao;
	
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@RequestMapping("/hms/patientUpdate")
	public String list(Model model) {
		model.addAttribute("cmd", new PatientCommand());
		return "hms/patientUpdate";
	}
	
	@RequestMapping(value="/hms/patientInfo", method=RequestMethod.GET)
	public String infoPatient(@ModelAttribute("cmd")PatientCommand patientCommand, HttpServletRequest request, Model model) {
		PatientCommand pc = patientDao.selectPatient(Long.parseLong(request.getParameter("num")));
		model.addAttribute("patient", pc);
		System.out.println(pc.getNum());
		return "hms/patientUpdate";
	}
	
	@RequestMapping(value="/hms/patientUpdate", method=RequestMethod.POST)
	public String updatePatient(@ModelAttribute("cmd")PatientCommand patientCommand, Model model) {
		System.out.println(patientCommand.getNum());
		patientDao.updatePatient(patientCommand);
		return "hms/patientList";
	}
}
