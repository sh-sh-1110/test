package com.internousdev.template.action;

public class BuyItemAction extends ActionSupport implements SessionAware{
	private int stock;
	private String pay;
	private Map<String, Object>session;
	private String result;

	public String execute(){
		result = SUCCESS;

		session.put("stock",stock);
		int intStock = Integer.parseInt(session.get("stock").toString();
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
	}
}


