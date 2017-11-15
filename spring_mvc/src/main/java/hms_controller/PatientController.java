package hms_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//환자 검색기능
	@RequestMapping("/hms/patientList")
	public String searchPatient(@ModelAttribute("cmd")PatientCommand PatientCommand, 
			Model model) {
			if(PatientCommand.getName() != null){
			List<PatientCommand> patients = patientDao.searchPatient();
			PatientCommand.getName();
			model.addAttribute("patients", patients);
			}
		return "hms/patientList";
	}
	
}
