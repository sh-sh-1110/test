package com.internousdev.login.dto;

//DAOクラスで選ばれた値を格納するためのクラス
public class LoginDTO {

//フィールド変数の宣言
	private int id;
	private String name;
	private String password;

//フィールド変数に応じたgetterとsetter
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

//Actionクラスから呼び出され、nameフィールドの値をActionに渡す
	public String getName(){
		return name;
	}

//DAOクラスから呼び出され、引数として(pub~void)受け取ったテーブルの値を自身のnameフィールドに格納
	public void setName(String name){
		this.name = name;
	}

//Actionクラスから呼び出され、passフィールドの値をActionに渡す

	public String getPassword(){
		return password;
	}

//DAOクラスから引数として(pub~void)受け取ったテーブルの値を自身のpassに格納
	public void setPassword(String password){
		this.password = password;
	}
}
