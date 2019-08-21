package com.internousdev.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

//LoginDTO型を最後に呼び出し元に渡すための、LoginDTOを戻り値にしたメソッド
//Actionクラスの値を引数として受け取る
public class LoginDAO {
	public LoginDTO select(String name,String password)throws SQLException{
		LoginDTO dto = new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

//最初の?がActionから送られたname,次の?がActionから送られたpass
		String sql = "select * from user where user_name=? and password=?";

//ResultSet~Query();によって、戻り値がResultSetに。
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();

//select文でDBから取得した情報をString型に変換しDTOに格納
//(setterを利用)
	if(rs.next()){
		dto.setName(rs.getString("user_name"));
		dto.setPassword(rs.getString("password"));
	}
//catch～Trace();はSQLエラーが出たときに実行する処理
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		con.close();
	}
//dtoに入った値を、呼び出し元のActionクラスに渡す
	return dto;
	}

}


//DAOクラス
//DBConnectorのインスタンス化
//getConnectionの呼び出し
//sql文。値は使いまわせるように？を入れる
//PreparedStatement(DBまで運んでくれる箱)に代入
//sql文の?に入れる値のset
//executeQuery()←Select文はこっち/executeUpdate()で実行
//結果の処理(selectで取得→DTOに格納)
//con.close()で接続終了