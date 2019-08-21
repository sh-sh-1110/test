package com.internousdev.login.action;

import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
//↑struts2の持ってるActionSupport

public class LoginAction extends ActionSupport{
	private String name;
	private String password;
//フィールド変数はJSPから受け取るのならJSPと同じ名前じゃないとだめ

//メソッド名：execute 戻り値retを定義し、初期値はERROR
	public String execute()throws SQLException{
		String ret = ERROR;

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

//JSPから送られてきたnameとpassを引数としてLoginDAOクラスのselectメソッド呼び出し
//その後、DAOで取得した結果をLoginDTOに代入
		dto = dao.select(name,password);

//ユーザーの入れたnameとpassが、DTOからもってきた値（get以下）とそれぞれ一致するか確認
//OKだったらretがSUCCESSに書き換えられる
		if(name.equals(dto.getName())){
			if(password.equals(dto.getPassword())){
				ret = SUCCESS;
			}
		}
		return ret;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
}

//setterの定義によりJSPでユーザーが入れた値がフィールドに格納される
//executeメソッドの定義
//条件分岐でSUCCESS？ERROR？
//executeメソッドの結果でSUCCESSかERRORかを返す