package com.ilp.entity;

public class Services {
	private String serviceCode;
	private String serviceName;
	private double serviceRate;
	public Services(String serviceCode, String serviceName, double serviceRate) {
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.serviceRate = serviceRate;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public double getRate() {
		return serviceRate;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public void setRate(double serviceRate) {
		this.serviceRate = serviceRate;
	}

	

}
