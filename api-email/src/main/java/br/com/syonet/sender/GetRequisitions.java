package br.com.syonet.sender;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.syonet.newsletter.model.Newsletter;

public class GetRequisitions {

	Connection conn;
	static String querySelect = "SELECT * from newsletter where processada is null";

	public GetRequisitions(Connection conn) {
		super();
		this.conn = conn;
	}

	public ArrayList<Newsletter> returnNews(){

		ArrayList<Newsletter> arrayNews = new ArrayList<Newsletter>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySelect);
			while(rs.next()) {
				Newsletter tempNews = new Newsletter();
				tempNews.setTitle(rs.getString("title"));
				tempNews.setDescription(rs.getString("description"));
				tempNews.setLink(rs.getString("link"));
				arrayNews.add(tempNews);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arrayNews;
		
	}
	
	
	

}
