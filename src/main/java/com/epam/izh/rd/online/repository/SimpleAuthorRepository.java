package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[0];

    @Override
    public boolean save(Author author) {
        //проверка на то, что пришедший в метод author уже есть в массиве. метод проверки findByFullName
        //еще не реализована

        if (findByFullName(author.getName(), author.getLastName()) != null) {
            //автор уже есть в базе
            return false;
        } else {
            //автора нет в базе - добавляем
            //увеличение массива на 1 и добавление автора
            Author[] tempAuthors = new Author[authors.length + 1];
            for (int i = 0; i < authors.length; i++) {
                tempAuthors[i] = authors[i];
            }
            tempAuthors[tempAuthors.length - 1] = author;
            authors = tempAuthors;
            return true;
        }
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getLastName().equals(lastname) && authors[i].getName().equals(name)) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        String tempAuthorName = author.getName();
        String tempAuthorLastName = author.getLastName();
        if (findByFullName(author.getName(), author.getLastName()) != null) {
            //автор есть в массиве авторов
            //создаю временный массив на 1 элемент меньше чем authors
            Author[] tempSmallAuthors = new Author[authors.length - 1];
            int tempSmallAuthorsArrayCounter = 0;
            for (int i = 0; i < authors.length; i++) {
                if (authors[i].equals(author)) {
                    //пропускаю элемент массива при копировании
                } else {
                    //копирую элементы массива
                    tempSmallAuthors[tempSmallAuthorsArrayCounter] = authors[i];
                    tempSmallAuthorsArrayCounter++;
                }
            }
            //меняю ссылку на новый массив
            authors = tempSmallAuthors;
            return true;
        } else {
            //автора нет в массиве
            return false;
        }
    }

    @Override
    public int count() {
        return authors.length;
    }
}
