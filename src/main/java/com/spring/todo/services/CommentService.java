package com.spring.todo.services;

import com.spring.todo.model.entities.CommentEntity;
import com.spring.todo.model.inputs.CommentInput;
import com.spring.todo.repositories.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService extends BaseService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CommentEntity getComment(String user, String id) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        return commentEntity.get();
    }

    public List<CommentEntity> getCommentByTask(String user, String task, String sort, Integer skip, Integer limit) {
        Pageable page = PageRequest.of(skip, limit, Sort.by(sort));
        Page<CommentEntity> listComment = commentRepository.findByTask(task, page);
        return listComment.get().collect(Collectors.toList());
    }

    public CommentEntity createComment(String user, CommentInput commentInput) {
        CommentEntity commentEntity = new CommentEntity();
        modelMapper.map(commentEntity, commentInput);
        commentEntity = commentRepository.save(commentEntity);
        return commentEntity;
    }

    public CommentEntity updateComment(String user, String id, CommentInput commentInput) {
        CommentEntity commentEntity = new CommentEntity();
        modelMapper.map(commentEntity, commentInput);
        commentEntity.setId(id);
        commentEntity = commentRepository.save(commentEntity);
        return commentEntity;
    }

    public CommentEntity deleteComment(String user, String id) {
        commentRepository.deleteById(id);
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(id);
        return commentEntity;
    }
}
