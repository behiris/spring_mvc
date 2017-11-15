package hms_controller;

public class MedicineCommand {
	private long num;//약재 번호
	private String name;//약재 이름
	private int stock;//약재 재고
	
	public MedicineCommand(long num, String name, int stock) {
		super();
		this.num = num;
		this.name = name;
		this.stock = stock;
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
	public void test2(int test2) {
		System.out.println("테스트2");
	}
}
