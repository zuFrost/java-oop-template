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
        // Если сохранение прошло успешно, метод должен вернуть true
        return true;
    }

    @Override
    public Book[] findByName(String name) {
        /**
         * Метод должен находить в массиве schoolBooks все книги по имени.
         * <p>
         * Если книги найдены - метод должен их вернуть.
         * Если найденных по имени книг нет, должен вернуться пустой массив.
         */
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
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
