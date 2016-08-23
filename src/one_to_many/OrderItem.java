package one_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	private String itemName;
	private int quantity;

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderItem() {

	}

	public OrderItem(String itemName, int quantity) {
		this.itemName = itemName;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", itemName=" + itemName + ", quantity=" + quantity + "]";
	}

}
