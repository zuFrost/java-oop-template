package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository {
    private SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(Book book) {
        SchoolBook[] tempSchoolBooks = new SchoolBook[schoolBooks.length + 1];
        for (int i = 0; i < schoolBooks.length; i++) {
            tempSchoolBooks[i] = schoolBooks[i];
        }
        tempSchoolBooks[tempSchoolBooks.length - 1] = (SchoolBook) book;
        schoolBooks = tempSchoolBooks;
        return true;
    }

    @Override
    public Book[] findByName(String name) {
        //сколько книг с названием name в массиве schoolBooks?
        // создаю переменную bookCount = 0
        int bookCount = 0;
        // прохожу в цикле по массиву schoolBooks в поисках книги с совпадающим названием, при совпадении названия, увеличиваю переменную bookCount
        for (Book element : schoolBooks) {
            if (element.getName().equals(name)) {
                bookCount++;
            }
        }
        //создаю массив типа SchoolBook[] foundSchoolBooks размером bookCount
        SchoolBook[] foundSchoolBooks = new SchoolBook[bookCount];
        // прохожу по массиву schoolBooks повторно, и книги с совпадающими именами копирую в foundSchoolBooks
        // переменная newArrayCounter следит за наполнением нового массива
        int newArrayCounter = 0;
        for (SchoolBook element : schoolBooks) {
            if (element.getName().equals(name)) {
                foundSchoolBooks[newArrayCounter] = element;
                newArrayCounter++;
            }
        }
        // возможны ли разные книги с совпадающими именами?? если нет, то можно упростить последнее действие
        // возвращаю массив foundSchoolBooks
        return foundSchoolBooks;
    }

    @Override
    public boolean removeByName(String name) {
        //сколько книг с названием name в массиве schoolBooks?
        int bookCounter = 0; // счетчик количества книг с названием name в массиве.
        for (int i = 0; i < schoolBooks.length; i++) {
            if (schoolBooks[i].getName().equals(name)) { //имя книги совпадает с name
                bookCounter++;
            }
        }
        if (bookCounter > 0) { // книги есть в количестве bookCounter
            //создаю массив размером schoolBooks - bookCounter
            SchoolBook[] smallSchoolBooks = new SchoolBook[schoolBooks.length - bookCounter];
            int smallSchoolBooksArrayCounter = 0;
            for (int i = 0; i < schoolBooks.length; i++) {// нахожу в массиве элементы совпадающие с name и пропускаю их при копировании массивов
                if (schoolBooks[i].getName().equals(name)) {
                    continue;
                } else {
                    smallSchoolBooks[smallSchoolBooksArrayCounter] = schoolBooks[i];
                    smallSchoolBooksArrayCounter++;
                }

            }
            schoolBooks = smallSchoolBooks;
            return true;
        } else { // в массиве нет книги с названием name
            return false;
        }
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
