package hms_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hms_spring.MedicineDao;

@Controller
public class MedicineController {
	private MedicineDao medicineDao;
	
	public void setMedicineDao(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}

	@RequestMapping("/hms/medicineList")
	public String list(Model model) {
		List<MedicineCommand> medicines = medicineDao.selectAll();
		model.addAttribute("medicines", medicines);
		
		return "hms/medicineList";
	}
	
	public void testtest(){
		System.out.println("a");
	}
}
