package edu.mum.cs544.controller;

import edu.mum.cs544.exception.CommentNotFoundException;
import edu.mum.cs544.exception.PostNotFoundException;
import edu.mum.cs544.domain.Comment;
import edu.mum.cs544.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/comments")
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAll(){
        return commentService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment add(@RequestBody Comment comment) throws PostNotFoundException {
        return commentService.add(comment);
    }

    @PutMapping(value= "/{id}", consumes = "application/json")
    public Comment update(@RequestBody Comment comment,@PathVariable Integer id) throws CommentNotFoundException,PostNotFoundException {
        return commentService.update(comment,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) throws CommentNotFoundException,PostNotFoundException{
        commentService.delete(id);
    }


    @GetMapping(value="/post/{postid}", produces="application/json")
    public List<Comment> getAllCommentsOfPost(@PathVariable("postid") int postid) {
        return commentService.getAllByPostId(postid);
    }




}
