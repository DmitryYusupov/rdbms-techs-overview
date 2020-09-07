package ru.yusdm.technics.e.book;

import javax.persistence.*;

@Entity
public class BookDescription {

    @Id
    private Long id;

    @Column
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
