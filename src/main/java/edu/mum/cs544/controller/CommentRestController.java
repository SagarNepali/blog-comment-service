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
    public Comment add(@RequestBody Comment comment) {
        return commentService.add(comment);
    }

    @PutMapping(value= "/{id}", consumes = "application/json")
    public Comment update(@RequestBody Comment comment,@PathVariable Integer id) throws CommentNotFoundException {
        return commentService.update(comment,id);
    }



    @GetMapping(value="/post/{postId}", produces="application/json")
    public List<Comment> getAllCommentsOfPost(@PathVariable("postId") int postId) {
        return commentService.getAllByPostId(postId);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer commentId) throws CommentNotFoundException{
        commentService.delete(commentId);
    }

    @DeleteMapping("/post/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllByPostId(@PathVariable Integer postId) throws CommentNotFoundException{
        commentService.deleteAllByPostId(postId);
    }

    @DeleteMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllByUserId(@PathVariable Integer userId) throws CommentNotFoundException{
         commentService.deleteAllByUserId(userId);
    }




}
