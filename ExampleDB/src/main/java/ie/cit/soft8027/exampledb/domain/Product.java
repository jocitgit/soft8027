package ie.cit.soft8027.exampledb.domain;

public class Product {

	private int id;
	private String name;
	private double weight;
	private String description;
	private double unitCost;
	
	public Product(int id, String name, double weight, String description, double unitCost) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.description = description;
		this.unitCost = unitCost;
	}
	
	public Product() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", weight=" + weight + ", description=" + description
				+ ", unitCost=" + unitCost + "]";
	}
	
	
	
}
