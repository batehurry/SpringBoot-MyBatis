package com.shawn.model.entity;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
public class BookStoreWithBooks extends BookStore {

    private static final long serialVersionUID = -740463675258248874L;

    private List<Book> books;

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
