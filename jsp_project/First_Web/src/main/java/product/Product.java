package product;

import java.util.Arrays;

// beans 형식의 클래스로 정의 : 상품 정보를 저장
public class Product {
	
	// 상품 목록 : 배열
	private String[] productList = {"item1","item2","item3","item4","item5"}; //명시적으로 값을 초기화
	
	//변수 : el 테스트용
	private int price = 100;
	private int amount = 1000;
	
	
	public String[] getProductList() {
		return productList;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	
	//${product.display}  -> 하면 이 메서드 호출 (변수의 유무와 상관없이 el에서 호출해서 결과 출력)
	public String getDisplay() {
		
		return "price : " + this.price + ", amount : " + this.amount;
	}
	
	
	@Override
	public String toString() {
		return "Product [pList=" + Arrays.toString(productList) + ", price=" + price + ", amount=" + amount + "]";
	} 
	
	
	
	
}
