package hms_controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hms_spring.PatientDao;

@Controller
public class test {
	private PatientDao patientDao;
	
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	@RequestMapping("/hms/test")
	public String list(Model model) {
		List<PatientCommand> patients = patientDao.selectAll();
		model.addAttribute("patients", patients);
		model.addAttribute("cmd", new PatientCommand());
		
		return "hms/test";
	}
	
	//환자 검색기능
	//@RequestMapping("/hms/test2")
	/*@RequestMapping(value="/hms/test2", method=RequestMethod.POST)
	public String searchPatient(@ModelAttribute("cmd")PatientCommand patientCommand, Model model) {
		PatientCommand pc = patientDao.selectPatient(patientCommand.getNum());
		model.addAttribute("test", pc);
		
		return "hms/test2";
	}*/
	
	@RequestMapping(value="/hms/test2", method=RequestMethod.GET)
	public String updatePatient(HttpServletRequest request, Model model) {
		PatientCommand pc = patientDao.selectPatient(Integer.parseInt(request.getParameter("num")));
		model.addAttribute("test", pc);
		return "hms/test2";
	}
}