package hms_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hms_spring.PatientDao;

@Controller
public class PatientController {
	private PatientDao patientDao;
	
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@RequestMapping("/hms/patientList")
	public String list(Model model) {
		List<PatientCommand> patients = patientDao.selectAll();
		model.addAttribute("patients", patients);
		
		return "hms/patientList";
	}
	
}
