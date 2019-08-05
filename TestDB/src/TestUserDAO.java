//DAOはDBConnectorからインスタンス化、getConnectionの呼び出し、
//mysqlにログイン、sql文作成、PreparedStatementでデータを入れて、
//Queryで実行し、con.closeで接続解除。

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUserDAO {
	String name = "";
	String password = "";
	public void select(String name,String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table where user_name = ? and password = ?";

//PreparedStatementはDBまで運んでくれる箱のこと

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

//rs.nextによって一行下から始まる。
//最初から始まると、username/passwordの組み合わせから始まってしまうので
//一行下にして実際のデータから読み込んでもらうようにしている。

			if(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e){
			  e.printStackTrace();
		}

//con.closeによってデータ接続を終える。

		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void selectAll(){
		DBConnector db =new DBConnector();
		Connection con = db.getConnection();

		String sql ="select * from test_table";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		  }

		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void selectByName(String name){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table where user_name = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void selectByPassword(String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from test_table where password = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void updateUserNameByUserName(String oldName,String newName){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "update test_table set user_name = ? where user_name = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, oldName);

	//executeUpdateはデータ（数値）を返しているので変数（int）となる。

			int i = ps.executeUpdate();
			if(i > 0){
				System.out.println(i + "件更新されました");
			} else{
				System.out.println("該当するデータはありませんでした");
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void insert(int user_id,String name,String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into test_table values(?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, user_id);
		ps.setString(2, name);
		ps.setString(3, password);
		int i = ps.executeUpdate();
		if(i > 0){
			System.out.println(i + "件登録されました");
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void delete(String name){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from test_table where user_name = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		int i = ps.executeUpdate();
		if(i > 0){
			System.out.println(i + "件削除されました");
		}
		} catch(SQLException e){
		e.printStackTrace();
		}

		try{
			con.close();
		} catch(SQLException e){
			e.printStackTrace();
	  }
	}

}