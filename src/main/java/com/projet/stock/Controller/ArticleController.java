package com.projet.stock.Controller;
import com.projet.stock.Model.Article;
import com.projet.stock.Repository.ArticleRepository;
import com.projet.stock.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        System.out.println("Get all articles ........");
        List<Article> articles=new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        return articles;
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable(value="id") long id) throws ResourceNotFoundException {
        Article article=articleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Article not found"));
        return ResponseEntity.ok().body(article);
    }

    @PostMapping("/article")
    public ResponseEntity<String> saveArticle(@Valid @RequestBody Article article) throws ResourceNotFoundException {
        articleRepository.save(article);
        return ResponseEntity.ok("is OK");
    }

    @DeleteMapping("/article/{id}")
    private Map<String, Boolean> deleteArticle(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
        Article article = articleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Impossible to delete Article cause is not found"));
        articleRepository.delete(article);
        Map<String,Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }

    @PutMapping("article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id ,@Valid @RequestBody Article article) throws ResourceNotFoundException {
        Optional<Article> article1 =articleRepository.findById(id);
        if(article1.isPresent()) {
            Article ancienArticle =article1.get();
            ancienArticle.setCode(article.getCode());
            ancienArticle.setPv(article.getPv());
            ancienArticle.setFodec(article.getFodec());
            ancienArticle.setLibelle(article.getLibelle());
            ancienArticle.setPa(article.getPa());
            ancienArticle.setStkinit(article.getStock());
            ancienArticle.setStock(article.getStock());
            ancienArticle.setTva(article.getTva());
            return new ResponseEntity<>(articleRepository.save(ancienArticle), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
