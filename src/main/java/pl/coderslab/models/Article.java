package pl.coderslab.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String title;

    @ManyToOne
    private Author author;

    @ManyToMany
    private List<Category> categories;

    private String content;

    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePersist(){
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updated = LocalDateTime.now();
    }
}
