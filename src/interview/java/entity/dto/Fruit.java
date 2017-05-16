package interview.java.entity.dto;

public class Fruit implements Comparable<Fruit> {
	private String name;
	private int price;

	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(Fruit fruit) {
		
		int comparePrice = fruit.getPrice();
		
		//ascending order
		System.out.println(this.price);
		System.out.println(" " + fruit.getPrice());
		return comparePrice - this.price;
		
		//descending order
		//return comparePrice - this.price;
	}

}
