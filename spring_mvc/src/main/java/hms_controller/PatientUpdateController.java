package hms_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	public String updatePatient(@ModelAttribute("cmd")PatientCommand patientCommand, Model model) {
		patientDao.updatePatient(patientCommand);
		return "hms/patientList";
	}
}
