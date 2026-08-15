package com.ui.pojo;

public class AddressPOJO {

	private String company;
	private String addresLine1;
	private String addresLine2;
	private String city;
	private String postcode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String otherInformation;
	private String addressAlias;
	private String state;

	public AddressPOJO(String company, String addresLine1, String addresLine2, String city, String postcode,
			String homePhoneNumber, String mobileNumber, String otherInformation, String addressAlias, String state) {
		super();
		this.company = company;
		this.addresLine1 = addresLine1;
		this.addresLine2 = addresLine2;
		this.city = city;
		this.postcode = postcode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}

	public String getCompany() {
		return company;
	}

	public String getAddresLine1() {
		return addresLine1;
	}

	public String getAddresLine2() {
		return addresLine2;
	}

	public String getCity() {
		return city;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addresLine1=" + addresLine1 + ", addresLine2=" + addresLine2
				+ ", city=" + city + ", postcode=" + postcode + ", homePhoneNumber=" + homePhoneNumber
				+ ", mobileNumber=" + mobileNumber + ", otherInformation=" + otherInformation + ", addressAlias="
				+ addressAlias + ", state=" + state + "]";
	}

}
