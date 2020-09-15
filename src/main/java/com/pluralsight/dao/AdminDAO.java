package com.pluralsight.dao;


public class AdminDAO extends DAO {

	private static AdminDAO instance;

	private AdminDAO() {
	}

	public static synchronized AdminDAO getInstance() {
		if (instance == null) {
			instance = new AdminDAO();
		}

		return instance;
	}

}
