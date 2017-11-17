package hms_controller;

import java.sql.Timestamp;

public class PrescriptionCommand {
	private long num;
	private String department;
	private String disease;
	private String desc;
	private String medicine;
	private int patient;
	private String doctor;
	private Timestamp regdate;
	private int check;

	public PrescriptionCommand(long num, String department, String disease, String desc, String medicine, int patient,
			String doctor, Timestamp regdate, int check) {
		super();
		this.num = num;
		this.department = department;
		this.disease = disease;
		this.desc = desc;
		this.medicine = medicine;
		this.patient = patient;
		this.doctor = doctor;
		this.regdate = regdate;
		this.check = check;

	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisaease(String disease) {
		this.disease = disease;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getPatient() {
		return patient;
	}

	public void setPatient(int patient) {
		this.patient = patient;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

}
