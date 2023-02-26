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
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService extends BaseService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CommentEntity getComment(String user, String id) throws Exception {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        if (commentEntity.isEmpty()) {
            throw new Exception();
        }
        return commentEntity.get();
    }

    public List<CommentEntity> getCommentByTask(String user, String task, String sort, Integer skip, Integer limit) throws Exception {
        Pageable page = PageRequest.of(skip, limit, Sort.by(sort));
        Page<CommentEntity> listComment = commentRepository.findByTask(user, task, page);
        if (listComment.isEmpty()) {
            throw new Exception();
        }
        return listComment.get().collect(Collectors.toList());
    }

    public CommentEntity createComment(String user, CommentInput commentInput) throws Exception {
        CommentEntity commentEntity = new CommentEntity();
        modelMapper.map(commentEntity, commentInput);
        commentEntity = commentRepository.save(commentEntity);
        if (ObjectUtils.isEmpty(commentEntity)) {
            throw new Exception();
        }
        return commentEntity;
    }

    public CommentEntity updateComment(String user, String id, CommentInput commentInput) throws Exception {
        CommentEntity comment = this.getComment(user, id);
        this.ensureOwnerShip(user, comment.getOwner().getId());
        CommentEntity commentEntity = commentInput.toEntity();
        commentEntity.setId(id);
        commentEntity = commentRepository.save(commentEntity);
        if (ObjectUtils.isEmpty(commentEntity)) {
            throw new Exception();
        }
        return commentEntity;
    }

    public CommentEntity deleteComment(String user, String id) throws Exception {
        CommentEntity comment = this.getComment(user, id);
        this.ensureOwnerShip(user, comment.getOwner().getId());
        commentRepository.deleteById(id);
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(id);
        return commentEntity;
    }
}
