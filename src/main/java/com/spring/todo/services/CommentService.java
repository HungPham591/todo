package com.spring.todo.services;

import com.spring.todo.model.response.CommentResponse;
import com.spring.todo.model.entities.CommentEntity;
import com.spring.todo.model.inputs.CommentInput;
import com.spring.todo.repositories.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService extends BaseService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CommentResponse getComment(String id) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        return commentEntity.get().toReponse();
    }

    public List<CommentResponse> getCommentByTask(String task, Integer skip, Integer limit) {
        return null;
    }

    public CommentResponse createComment(CommentInput commentInput) {
        CommentEntity commentEntity = new CommentEntity();
        modelMapper.map(commentEntity, commentInput);
        commentEntity = commentRepository.save(commentEntity);
        return commentEntity.toReponse();
    }

    public CommentResponse updateComment(String id, CommentInput commentInput) {
        CommentEntity commentEntity = new CommentEntity();
        modelMapper.map(commentEntity, commentInput);
        commentEntity.setId(id);
        commentEntity = commentRepository.save(commentEntity);
        return commentEntity.toReponse();
    }

    public CommentResponse deleteComment(String id) {
        commentRepository.deleteById(id);
        return new CommentResponse();
    }
}
