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
	//@RequestMapping("/hms/test2")
	/*@RequestMapping(value="/hms/test2", method=RequestMethod.POST)
	public String searchPatient(@ModelAttribute("cmd")PatientCommand patientCommand, Model model) {
		PatientCommand pc = patientDao.selectPatient(patientCommand.getNum());
		model.addAttribute("test", pc);
		
		return "hms/test2";
	}*/
	
	@RequestMapping(value="/hms/test2", method=RequestMethod.GET)
	public String AddMedicineStockList(HttpServletRequest request, Model model, HttpSession session) {
		List<MedicineCommand> add_medicines = new ArrayList<MedicineCommand>();
		if(session.getAttribute("add_medicines") != null) {
			add_medicines = (List<MedicineCommand>)session.getAttribute("add_medicines");
		}
		
		boolean isOverlap = false;
		for(int i=0; i<add_medicines.size(); i++) {
			MedicineCommand tmp = add_medicines.get(i);
			if(tmp.getNum() == Integer.parseInt(request.getParameter("num"))) {
				isOverlap = true;
			}
		}
		
		if(!isOverlap) {
			MedicineCommand mc = medicineDao.selectMedicine(Integer.parseInt(request.getParameter("num")));
			add_medicines.add(mc);
		}
		session.setAttribute("add_medicines", add_medicines);
		
		list(model);
		
		//model.addAttribute("test", pc);
		return "hms/test";
	}
	
	private List<MedicineCommand> list(Model model) {
		List<MedicineCommand> medicines = medicineDao.selectAll();
		model.addAttribute("medicines", medicines);
		
		return medicines;
	}
	
	@RequestMapping("/hms/test3")
	public String searchPatient(Model model, HttpSession session) {
		List<MedicineCommand> add_medicines = new ArrayList<MedicineCommand>();
		if(session.getAttribute("add_medicines") != null) {
			add_medicines = (List<MedicineCommand>)session.getAttribute("add_medicines");
		}
		
		for(int i=0; i<add_medicines.size(); i++) {
			medicineDao.orderMedicine(add_medicines.get(i), 1);
			medicineDao.update(add_medicines.get(i), 1);
		}
		session.invalidate();
		
		list(model);
		
		return "hms/test";
	}
}