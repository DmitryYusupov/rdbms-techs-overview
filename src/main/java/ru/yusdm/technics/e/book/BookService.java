package ru.yusdm.technics.e.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Service
@Transactional
public class BookService {

    @Autowired
    private EntityManager em;

    @Autowired
    private BookRepo bookRepo;

    public void save(Book book) {
        em.persist(book);
    }

    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    public Book findById(Long id) {
        Book b = bookRepo.getOne(id);
        System.out.println(b.getName());
        System.out.println(b.getBookDescription().getDescription());

        return b;
    }
}
