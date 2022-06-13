package edu.mum.cs544.service;

import edu.mum.cs544.exception.CommentNotFoundException;
import edu.mum.cs544.domain.Comment;
import edu.mum.cs544.exception.PostNotFoundException;
import edu.mum.cs544.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAll(){
        return commentRepository.findAll();
    }

    public Comment getById(int id) throws CommentNotFoundException {
        Comment c =  commentRepository.getById(id);
        if(c == null) throw new CommentNotFoundException("Comment not found");
        return c;
    }

    public List<Comment> getAllByPostId(int postId){
        List<Comment> commentList = commentRepository.findByPostId(postId);
        return commentList;
    }

    public Comment add(Comment comment) {
        Date date = new Date();
        comment.setDate(date);
        return commentRepository.save(comment);
    }

    public Comment update(Comment comment,Integer id) throws CommentNotFoundException{
        Comment c = commentRepository.getById(id);
        if(c != null){
            c.setMessage(comment.getMessage());
            c.setDate(c.getDate());
            return commentRepository.save(c);
        }
        throw new CommentNotFoundException("Comment not found.");
    }

    public void delete(Integer id) throws CommentNotFoundException{
        Comment c = getById(id);
        if(c == null) throw new CommentNotFoundException("Comment could not be deleted. Comment does not exist.");

        commentRepository.delete(c);
    }

    public void deleteAllByPostId(Integer postId) throws CommentNotFoundException{
        commentRepository.deleteAllByPostId(postId);
    }

    public void deleteAllByUserId(Integer userId) throws CommentNotFoundException{
        commentRepository.deleteAllByUserId(userId);
    }
//    public List<Comment> getAllByPostId(int postid) {
//        return commentRepository.findByPostId(postid);
//    }



}
