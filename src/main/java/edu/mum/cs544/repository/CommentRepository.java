package edu.mum.cs544.repository;

import edu.mum.cs544.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByPostId(int postId);
    Comment findById(int id);

}
