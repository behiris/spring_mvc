package hms_controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hms_spring.MedicineDao;

@Controller
public class test {
	private MedicineDao medicineDao;
	
	public void setMedicineDao(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}

	@RequestMapping("/hms/test")
	public String list_Ori(Model model) {
		list(model);
		
		return "hms/test";
	}
	
	//환자 검색기능
	@RequestMapping(value="/hms/test2", method=RequestMethod.GET)
	public String infoMedicine(HttpServletRequest request, Model model) {
		MedicineCommand mc = medicineDao.selectMedicine(Long.parseLong(request.getParameter("num")));
		model.addAttribute("test", mc);
		
		return "hms/test2";
	}
	
	private List<MedicineCommand> list(Model model) {
		List<MedicineCommand> medicines = medicineDao.selectAll();
		model.addAttribute("medicines", medicines);
		
		return medicines;
	}
}