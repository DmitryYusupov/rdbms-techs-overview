package ru.yusdm.technics.e.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private BookService bs;

    @Override
    public void run(String... args) {
        bs.save(createBookWithDescription());
        bs.save(createBookWithDescription());
        bs.save(createBookWithDescription());
        System.out.println("-------------------------");


        bs.getAll().forEach(b -> System.out.println(b.getId() + " " + b.getName()));
        System.out.println("-------------------------");


        bs.findById(1L);
    }

    private Book createBookWithDescription() {
        Book book = new Book();
        book.setName("BOOK NAME");
        BookDescription bookDescription = new BookDescription();
        bookDescription.setDescription("BOOK DESCRIPTION");
        bookDescription.setBook(book);
        book.setBookDescription(bookDescription);

        return book;
    }
}
