package hms_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hms_spring.PatientDao;

@Controller
public class PatientInsertController {
	private PatientDao patientDao;
	
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@RequestMapping("/hms/patientInsert")
	public String list(Model model) {
		model.addAttribute("cmd", new PatientCommand());
		return "hms/patientInsert";
	}
	
	@RequestMapping("/hms/insertPatient")
	public String insertPatient(@ModelAttribute("cmd")PatientCommand patientCommand, Model model) {
		patientDao.insertPatient(patientCommand);
		return "hms/patientInsert";
	}
}
