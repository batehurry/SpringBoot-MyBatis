package com.shawn.model.entity;

/**
 * @author Xiaoyue Xiao
 */
public class BookWithBookStore extends Book {

    private static final long serialVersionUID = -4858710159989616286L;

    private BookStore bookStore;

	/**
	 * @return the bookStore
	 */
	public BookStore getBookStore() {
		return bookStore;
	}

	/**
	 * @param bookStore the bookStore to set
	 */
	public void setBookStore(BookStore bookStore) {
		this.bookStore = bookStore;
	}

}
