package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Author esenin = new Author();
        LocalDate date = LocalDate.of(1895, 10, 03);
        esenin.setBirthdate(date);
        esenin.setCountry("Russia");
        esenin.setName("Sergey");
        esenin.setLastName("Esenin");
        SimpleAuthorRepository simpleAuthorRepository = new SimpleAuthorRepository();
        simpleAuthorRepository.save(esenin);
        System.out.println(simpleAuthorRepository.count());

        Author esenin_s = new Author();
        LocalDate date_s = LocalDate.of(1895, 10, 03);
        esenin_s.setBirthdate(date_s);
        esenin_s.setCountry("Russia");
        esenin_s.setName("Sergey_s");
        esenin_s.setLastName("Esenin");
        simpleAuthorRepository.save(esenin_s);
        System.out.println(simpleAuthorRepository.count());


    }

}
