package hms_controller;

public class PatientCommand {
	private int num;
	private int ssn;
	private String name;
	private String gender;
	private int phone;
	private String zipcode;
	private String address1;
	private String address2;
	
	public PatientCommand(
			int num, int ssn, String name, String gender, int phone, 
			String zipcode, String address1, String address2) {
		super();
		
		this.setNum(num);
		this.setSsn(ssn);
		this.setName(name);
		this.setGender(gender);
		this.setPhone(phone);
		this.setZipcode(zipcode);
		this.setAddress1(address1);
		this.setAddress2(address2);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

}
