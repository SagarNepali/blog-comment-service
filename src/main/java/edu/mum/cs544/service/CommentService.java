package edu.mum.cs544.service;

import edu.mum.cs544.exception.CommentNotFoundException;
import edu.mum.cs544.domain.Comment;
import edu.mum.cs544.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public Comment add(Comment comment) {
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

//    public List<Comment> getAllByPostId(int postid) {
//        return commentRepository.findByPostId(postid);
//    }



}
