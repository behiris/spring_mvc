package hms_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hms_spring.PatientDao;

@Controller
public class PatientInsertController {
	private PatientDao patientDao;
	
	public void setMedicineDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@RequestMapping("/hms/PatientInsert")
	public String list(Model model) {
		List<PatientCommand> patients = patientDao.selectAll();
		model.addAttribute("patientss", patients);
		
		return "hms/patientInsert";
	}
}
