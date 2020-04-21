package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository {
    private SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(Book book) {
        SchoolBook[] tempSchoolBooks = new SchoolBook[schoolBooks.length+1];
        for (int i = 0; i <schoolBooks.length ; i++) {
            tempSchoolBooks[i] = schoolBooks[i];
        }
        tempSchoolBooks[tempSchoolBooks.length-1] = (SchoolBook) book;
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
        //return new Book[0];
        return foundSchoolBooks;
    }

    @Override
    public boolean removeByName(String name) {
        /**
         * Метод должен удалять книги из массива schoolBooks по названию.
         * Если книг с одинаковым названием в массиве несколько, метод должен удалить их все.
         * <p>
         * Важно: при удалении книги из массива размер массива должен уменьшиться!
         * То есть, если мы сохранили 2 разные книги и вызвали count() (метод ниже), то он должен вернуть 2.
         * Если после этого мы удалили 1 книгу, метод count() должен вернуть 1.
         * <p>
         * Если хотя бы одна книга была найдена и удалена, метод должен вернуть true, в противном случае,
         * если книга не была найдена, метод должен вернуть false.
         */

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
            for (int i = 0; i < schoolBooks.l; i++) {// недописаная строка

            }

            return true;
        } else { // в массиве нет книги с названием name
            return false;
        }
    }

    @Override
    public int count() {
        /**
         * Метод возвращает количество сохраненных сущностей в массиве schoolBooks.
         */
//        System.out.println(schoolBooks.toString());
//        System.out.println(schoolBooks.length);
        return schoolBooks.length;
    }
}
