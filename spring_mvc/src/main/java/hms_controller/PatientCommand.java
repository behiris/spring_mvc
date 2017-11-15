package hms_controller;

public class PatientCommand {
	private int num;
	private String ssn;
	private String name;
	private int gender;
	private String phone;
	private String zipcode;
	private String address1;
	private String address2;
	
	public PatientCommand(){
		
	}
	
	public PatientCommand(int num, String ssn, String name, int gender, String phone, String zipcode, String address1,
			String address2) {
		super();
		this.num = num;
		this.ssn = ssn;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
}
