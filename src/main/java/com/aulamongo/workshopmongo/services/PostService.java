package com.aulamongo.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulamongo.workshopmongo.domain.Post;
import com.aulamongo.workshopmongo.repository.PostRepository;
import com.aulamongo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;
    
    public Post findById(String id) {
    	Optional<Post> post = repo.findById(id);
    	if(post.isEmpty()) {
    		throw new ObjectNotFoundException("Objeto nao encontrado");
    	}
    	return post.get();
    }  
}