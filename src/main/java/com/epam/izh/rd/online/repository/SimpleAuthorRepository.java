package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository{
    private Author[] authors = new Author[0];

    @Override
    public boolean save(Author author) {
        /**
         * Метод должен сохранять автора в массив authors.
         * Массив при каждом сохранении должен увеличиваться в размере ровно на 1.
         * То есть он ровно того размера, сколько сущностей мы в него сохранили.
         * <p>
         * Если на вход для сохранения приходит автор, который уже есть в массиве (сохранен), то автор не сохраняется и
         * метод возвращает false.
         * <p>
         * Можно сравнивать только по полному имени (имя и фамилия), считаем, что двух авторов
         * с одинаковыми именем и фамилией быть не может.
         * Подсказка - можно использовать для проверки метод findByFullName.
         * <p>
         * Если сохранение прошло успешно, метод должен вернуть true.
         */
        //1 - проверка на отсутствие автора в массиве authors автора author методом findByFullName
        //true автор отсутствует - увеличение размера массива и добавление автора. return true.
        //false автор присутствует - return false

        boolean noAuthorInArray = true; //Флаг проверки. Автора нет в массиве.
        for (Author element: authors) {
            if (findByFullName(author.getName(), author.getLastName()).equals(findByFullName(element.getName(), element.getLastName()))) {

                noAuthorInArray = false;
            }
        }
        if(noAuthorInArray ) {  //реализация проверки на отсутствие author в массиве authors методом findByFullName
            //увеличение размера массива
            //создаю массив tempAuthors типа Author[] размером authors.length + 1
            Author[] tempAuthors = new Author[authors.length + 1];
            // копирую authors[] в tempAuthors[]
            System.arraycopy(authors,0, tempAuthors, 0, authors.length);
            // добавление автора в tempAuthors[tempAuthors.length-1]
            tempAuthors[tempAuthors.length-1] = author;
            //присвоение authors = tempAuthors
            authors = tempAuthors;
            // return true.
            return true;
        } else {
            return false;
        }

        /*Author[] tempAuthors = new Author[1];
        System.arraycopy(authors,0, tempAuthors, 0, authors.length);
        tempAuthors[tempAuthors.length-1] = author;
        authors = tempAuthors;
        return true;*/
    }

    @Override
    public Author findByFullName(String name, String lastname) {

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
