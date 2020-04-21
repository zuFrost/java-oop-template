package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{
    private Author[] authors = new Author[0];

    //6) Написать в классе SimpleAuthorRepository реализацию для всех методов (коллекции не используем, работаем только с массивами)
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
            tempAuthors[tempAuthors.length-1] = author;
            authors = tempAuthors;
            return true;
        }
    }

    @Override
    public Author findByFullName(String name, String lastname) {
//        Метод должен находить в массиве authors автора по имени и фамилии (считаем, что двух авторов
//        с одинаковыми именем и фамилией быть не может.)
//        <p>
//     * Если автор с таким именем и фамилией найден - возвращаем его, если же не найден, метод должен вернуть null.
        for (int i = 0; i < authors.length ; i++) {
            if (authors[i].getLastName().equals(lastname) && authors[i].getName().equals(name)) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        return false;
    }

    @Override
    public int count() {
        /**
         * Метод возвращает количество сохраненных сущностей в массиве authors.
         */
        return authors.length;
    }
}
