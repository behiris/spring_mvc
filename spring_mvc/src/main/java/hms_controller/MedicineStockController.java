package hms_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import hms_spring.MedicineStockDao;

@Controller
public class MedicineStockController {
	private MedicineStockDao medicineStockDao;


	public MedicineStockDao getMedicineStockDao() {
		return medicineStockDao;
	}

	public void setMedicineStockDao(MedicineStockDao medicineStockDao) {
		this.medicineStockDao = medicineStockDao;
	}

	@RequestMapping("/hms/medicineStockList")
	public String list(Model model) {
		List<MedicineStockCommand> medicineStocks = medicineStockDao.selectAll();
		model.addAttribute("medicineStocks", medicineStocks);
		return "hms/medicineStockList";
	}
}
