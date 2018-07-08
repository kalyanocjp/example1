package com.example.example1.bootStrap;

import com.example.example1.model.Author;
import com.example.example1.model.Book;
import com.example.example1.repository.AuthorRepository;
import com.example.example1.repository.BookRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Author kalyan = new Author("kalyan","Kanakatla");
        Book javaKalyan = new Book("javaKalyan", "1234",  "Worker");
        kalyan.getBooks().add(javaKalyan);
        javaKalyan.getAuthors().add(kalyan);

        authorRepository.save(kalyan);
        bookRepository.save(javaKalyan);

        Author gomu = new Author("gomu","Kanakatla");
        Book javagomu = new Book("javagomu", "2345",  "Workergomu");
        gomu.getBooks().add(javagomu);
        javagomu.getAuthors().add(gomu);

        authorRepository.save(gomu);
        bookRepository.save(javagomu);

    }
}
