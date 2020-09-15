package com.pluralsight.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Kid;


public class BookDAO extends DAO{

	private static BookDAO instance;

	private BookDAO() {
	}

	public static synchronized BookDAO getInstance() {
		if (instance == null) {
			instance = new BookDAO();
		}

		return instance;
	}

	public List<Kid> getAllKids() throws SQLException {

		this.getCon().setAutoCommit(false);
		System.out.println("Tukaaaaaaaaaaaaaaaaaaaaaaaaaa");

		PreparedStatement ps = null;
		try {
			ps = this.getCon().prepareStatement("SELECT * FROM house_kids");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet result = ps.executeQuery();

		List<Kid> kids = new ArrayList<Kid>();

		if (!result.next()){
			System.out.println("prazen sym");
		}
		while (result.next()){

			long id = result.getInt("id");
			String firstName = result.getString("first_name");
			String family = result.getString("family");
			String house = result.getString("house");
			int level = result.getInt("level");
			System.out.println("id: "+id);
			System.out.println("firstName: "+firstName);
			System.out.println("family: "+family);
			System.out.println("house: "+house);
			System.out.println("level: "+level);

			kids.add(new Kid(id, firstName, family, level));
		}

		return kids;
	}


//
//	public Book getBook(long bookId) throws SQLException, UnexistingException, ValidationException {
//		PreparedStatement ps = this.getCon().prepareStatement("SELECT * FROM books WHERE book_id = ?");
//		ps.setLong(1, bookId);
//		ResultSet result = ps.executeQuery();
//
//		if (!result.next()) {
//			throw new UnexistingException("Book with id: " + bookId + " doesn't exists");
//		}
//
//		long id = result.getInt("book_id");
//		String title = result.getString("title");
//		Author author = AuthorDAO.getInstance().getAuthor(result.getLong("authors_author_id"));
//		String description = result.getString("description");
//		String publisher = result.getString("publisher");
//		int year = result.getInt("year");
//		String photo = result.getString("photo");
//		double price = result.getDouble("price");
//		String category = CategoryDAO.getInstance().getCategory(result.getLong("categories_category_id"));
//		List<Comment> comments = CommentDAO.getInstance().getAllComments(id);
//
//		return new Book(id, title, author, description, year, publisher, price, category, comments, photo);
//	}

}
