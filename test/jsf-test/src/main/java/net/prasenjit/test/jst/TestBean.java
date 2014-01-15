package net.prasenjit.test.jst;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TestBean {

	private Date popDate;
	
	public TestBean() {
		popDate = new Date();
	}

	public Date getPopDate() {
		return popDate;
	}

	public void setPopDate(Date popDate) {
		this.popDate = popDate;
	}
}
