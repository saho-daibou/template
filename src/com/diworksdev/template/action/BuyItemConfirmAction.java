package com.diworksdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	
	public String execute() throws SQLException {
		
		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
		
		buyItemCompleteDAO.buyItemInfo(
			    Integer.parseInt(session.get("id").toString()),
			    Integer.parseInt(session.get("login_user_id").toString()),
			    Integer.parseInt(session.get("buyItem_price").toString()),
			    Integer.parseInt(session.get("stock").toString()),
			    session.get("pay").toString()
			);
			
		String result = SUCCESS;
		return result;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
