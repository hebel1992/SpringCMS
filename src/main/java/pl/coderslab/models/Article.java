package pl.coderslab.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.ArticleValidationGroup;
import pl.coderslab.DraftValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @Size(max = 200, groups = {Default.class, DraftValidationGroup.class})
    @Column(name = "title", length = 200)
    private String title;

    @Size(min = 500, message = "Treść artykułu to conajmniej 500 znaków", groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @Column(name = "content", length = 100000)
    private String content;

    private boolean draft;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Size(min = 1,groups = {ArticleValidationGroup.class},message = "Artykuł musi zawierać conajmniej jedną kategorię")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "articles_categories", joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }
}
