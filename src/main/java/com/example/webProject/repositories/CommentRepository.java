package com.example.webProject.repositories;

import com.example.webProject.models.Comment;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
Comment[] findCommentsByPost_Id(Long postId);
}

