package hms_controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MedicineStockCommand {
	private long num;//약재 번호
	private String name;//약재 이름
	private int stock;//약재 발주수량
	@DateTimeFormat(pattern="yyyyMMddHH")
	private Date regdate;
	
	public MedicineStockCommand(long num, String name, int stock, Date regdate) {
	
		super();
		this.num = num;
		this.name = name;
		this.stock = stock;
		this.regdate = regdate;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}