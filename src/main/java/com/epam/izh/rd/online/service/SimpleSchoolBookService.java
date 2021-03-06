package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService {
    private BookRepository<SchoolBook> schoolBookBookRepository; //это репозиторий книг к которому вы будете обращаться в методах
    private AuthorService authorService; // это сервис для работы с авторами к которому  вы будете обращаться в методах

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    @Override
    public boolean save(Book book) {
        SchoolBook tempBook = new SchoolBook();
        tempBook = (SchoolBook) book;
        if (authorService.findByFullName(tempBook.getAuthorName(), tempBook.getAuthorLastName()) != null) {
            schoolBookBookRepository.save((SchoolBook) book);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book[] findByName(String name) {
        return new Book[0];
    }

    @Override
    public int getNumberOfBooksByName(String name) {
        return schoolBookBookRepository.findByName(name).length;
    }

    @Override
    public boolean removeByName(String name) {
        return schoolBookBookRepository.removeByName(name);
    }

    @Override
    public int count() {
        return schoolBookBookRepository.count();
    }

    @Override
    public Author findAuthorByBookName(String name) {
        // name - название книги
        // найти книгу по названию в репозитории книг
        String tempAuthorlastName = schoolBookBookRepository.findByName(name)[0].getAuthorLastName();
        String tempAuthorName = schoolBookBookRepository.findByName(name)[0].getAuthorName();
        // найти автора по имени и фамилии
        return authorService.findByFullName(tempAuthorName, tempAuthorlastName);
    }
}
