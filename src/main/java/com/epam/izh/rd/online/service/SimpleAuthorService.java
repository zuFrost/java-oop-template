package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.AuthorRepository;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;

public class SimpleAuthorService implements AuthorService {
    private AuthorRepository authorRepository;

    public SimpleAuthorService() {
    }

    public SimpleAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean save(Author author) {
        /**
         * Метод должен сохранять автора.
         * По факту, он просто обращается к репозиторию с авторами и вызывает аналогичный метод, псоле чего возвращает результат.
         */
        SimpleAuthorRepository simpleAuthorRepository = new SimpleAuthorRepository();
        simpleAuthorRepository.save(author);
        return true;
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
        return 0;
    }

}
