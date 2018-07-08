package com.example.example1.bootStrap;

import com.example.example1.model.Author;
import com.example.example1.model.Book;
import com.example.example1.model.Publisher;
import com.example.example1.repository.AuthorRepository;
import com.example.example1.repository.BookRepository;
import com.example.example1.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Author kalyan = new Author("kalyan","Kanakatla");
        Publisher publisherOne = new Publisher("ReeTech Publishers", "Pond Street1");
        Book javaKalyan = new Book("javaKalyan", "1234",  publisherOne);

        kalyan.getBooks().add(javaKalyan);
        javaKalyan.getAuthors().add(kalyan);

        publisherRepository.save(publisherOne);
        authorRepository.save(kalyan);
        bookRepository.save(javaKalyan);

        Author gomu = new Author("gomu","Kanakatla");
        Publisher publisherTwo = new Publisher("MyTech Publishers", "Pond Street1");
        Book javagomu = new Book("javagomu", "2345",  publisherTwo);

        gomu.getBooks().add(javagomu);
        javagomu.getAuthors().add(gomu);

        publisherRepository.save(publisherTwo);
        authorRepository.save(gomu);
        bookRepository.save(javagomu);

    }
}
