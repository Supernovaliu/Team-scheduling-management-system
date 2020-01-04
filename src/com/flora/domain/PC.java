/**
 * 
 */
package com.flora.domain;

/**@description
 * @author aiquanquanderen
 * @date2020年1月3日
 */
public class PC implements Equipment {
	private String model;// type of machine
	private String display;// name of monitor

	public PC() {

	}

	public PC(String model, String display) {
		this.model = model;
		this.display = display;
	}

	@Override
	public String getDescription() {
		return model + "(" + display + ")";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}
