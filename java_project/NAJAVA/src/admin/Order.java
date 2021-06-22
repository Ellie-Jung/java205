package admin;

public class Order {

	private int ordercode;
	private int icode;
	private int idx ;
	private String orderdate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getIcode() {
		return icode;
	}
	public void setIcode(int icode) {
		this.icode = icode;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(int ordercode) {
		this.ordercode = ordercode;
	}
	
	
	
	
	public Order(int ordercode, int icode, int idx, String orderdate) {
		this.ordercode = ordercode;
		this.icode = icode;
		this.idx = idx;
		this.orderdate = orderdate;
	}
	@Override
	public String toString() {
		return "Order [ordercode=" + ordercode + ", icode=" + icode + ", idx=" + idx + ", orderdate=" + orderdate + "]";
	}
	
	
	
	
	
}
