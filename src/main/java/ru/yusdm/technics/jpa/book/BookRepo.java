package ru.yusdm.technics.jpa.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
