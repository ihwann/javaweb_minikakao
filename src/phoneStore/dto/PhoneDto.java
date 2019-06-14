package phoneStore.dto;

import java.io.Serializable;

public class PhoneDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String phone_model_id ;
	String phone_name ;
	String phone_lease_price ;
	
	public PhoneDto() {
		
	}
	
	
	public PhoneDto(String phone_model_id, String phone_name, String phone_lease_price) {
		super();
		this.phone_model_id = phone_model_id;
		this.phone_name = phone_name;
		this.phone_lease_price = phone_lease_price;
	}
	
	public String getPhone_model_id() {
		return phone_model_id;
	}
	public void setPhone_model_id(String phone_model_id) {
		this.phone_model_id = phone_model_id;
	}
	public String getPhone_name() {
		return phone_name;
	}
	public void setPhone_name(String phone_name) {
		this.phone_name = phone_name;
	}
	public String getPhone_lease_price() {
		return phone_lease_price;
	}
	public void setPhone_lease_price(String phone_lease_price) {
		this.phone_lease_price = phone_lease_price;
	}
	
	
	

}
