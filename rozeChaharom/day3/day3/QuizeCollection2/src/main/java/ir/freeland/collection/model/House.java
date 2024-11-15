package ir.freeland.collection.model;

public class House {
	/*
		in class example quize collection →
		 	farz konid yek class house daram → 
		 	yeseri property dare ykish addresss e → 
			address khudesh yek class
	 */
	//private ezafe mikonim 
	private String name;
	private Address address;
	private int area;
	private int room;
	private int price;
	
	@Override
	public String toString() {
		return "House [name=" + name + ", address=" + address + ", area=" + area + ", room=" + room + ", price=" + price
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public House( String name, Address address, int area,  int room, int price) {
		super();
		this.name = name;
		this.address = address;
		this.area = area;
		this.room = room;
		this.price = price;
	} 
	
	
	
}
