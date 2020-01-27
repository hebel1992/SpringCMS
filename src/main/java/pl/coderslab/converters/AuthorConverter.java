package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.models.Author;
import pl.coderslab.repository.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author convert(String id) {
        if ("".equals(id)) {
            return null;
        } else {
            return authorRepository.findById(Long.parseLong(id)).get();
        }
    }
}
