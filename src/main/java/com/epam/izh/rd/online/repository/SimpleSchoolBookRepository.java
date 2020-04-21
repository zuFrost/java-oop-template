package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository {
    private SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(Book book) {
        // создаю временный массив +1 элемент
        SchoolBook[] tempSchoolBooksArray = new SchoolBook[schoolBooks.length + 1];
        // копирую в него существующий
        System.arraycopy(schoolBooks, 0, tempSchoolBooksArray, 0, schoolBooks.length);
        // кладу book в последний элемент нового массива
        tempSchoolBooksArray[schoolBooks.length] = (SchoolBook) book;
        // присваиваю ссылку на новый временный массив переменной schoolBooks
        schoolBooks = tempSchoolBooksArray;
        tempSchoolBooksArray = null;
        // Если сохранение прошло успешно, метод должен вернуть true
        return true;
    }

    @Override
    public Book[] findByName(String name) {
        return new Book[0];
    }

    @Override
    public boolean removeByName(String name) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
