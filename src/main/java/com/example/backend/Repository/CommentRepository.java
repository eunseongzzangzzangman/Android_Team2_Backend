package com.example.backend.Repository;

import com.example.backend.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByUidAndRid(Long uid, Long rid);

    Comment findByUidAndRid(Long uid, Long rid);
}
