package com.actdigital.challenges.mapping.services;

import com.actdigital.challenges.mapping.models.db.Article;
import com.actdigital.challenges.mapping.models.dto.ArticleDto;
import com.actdigital.challenges.mapping.repositories.ArticleRepository;
import com.actdigital.challenges.mapping.mappers.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    private final ArticleMapper mapper;

    @Autowired
    public ArticleService(ArticleRepository repository, ArticleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ArticleDto> list() {
        final List<Article> articles = repository.all();
        //TODO
        return new ArrayList<>();
    }

    public ArticleDto articleForId(Long id) {
        final Article article = repository.findBy(id);
        //TODO
        return new ArticleDto();
    }

    public ArticleDto create(ArticleDto articleDto) {
        final Article create = mapper.map(articleDto);
        repository.create(create);
        return mapper.map(create);
    }
}
