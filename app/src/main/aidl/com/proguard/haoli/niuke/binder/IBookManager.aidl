package com.proguard.haoli.niuke.binder;

import com.proguard.haoli.niuke.binder.Book;

interface IBookManager {

    List<Book> getBookList();

    void addBook(in Book book);

}
