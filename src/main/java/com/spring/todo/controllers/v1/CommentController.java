package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.CommentEntity;
import com.spring.todo.model.inputs.CommentInput;
import com.spring.todo.model.response.CommentResponse;
import com.spring.todo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/comment")
public class CommentController extends BaseController<CommentEntity, CommentResponse> {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public ResponseEntity<CommentResponse> getComment(Authentication authentication, @RequestParam("id") String id) throws Exception {
        CommentEntity commentEntity = commentService.getComment(authentication.getName(), id);
        return success(commentEntity);
    }

    @GetMapping("/commentByTask")
    public ResponseEntity<List<CommentResponse>> getCommentByTask(
            Authentication authentication,
            @RequestParam("task") String task,
            @RequestParam("sort") String sort,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) throws Exception {
        List<CommentEntity> commentEntityList = commentService.getCommentByTask(authentication.getName(), task, sort, skip, limit);
        return success(commentEntityList);
    }

    @PostMapping("/")
    public ResponseEntity<CommentResponse> createComment(Authentication authentication, @RequestBody CommentInput commentInput) throws Exception {
        CommentEntity commentEntity = commentService.createComment(authentication.getName(), commentInput);
        return success(commentEntity);
    }

    @PutMapping("/")
    public ResponseEntity<CommentResponse> updateComment(
            Authentication authentication,
            @RequestParam("id") String id,
            @RequestBody CommentInput commentInput) throws Exception {
        CommentEntity commentEntity = commentService.updateComment(authentication.getName(), id, commentInput);
        return success(commentEntity);
    }

    @DeleteMapping("/")
    public ResponseEntity<CommentResponse> deleteComment(Authentication authentication, @RequestParam("id") String id) throws Exception {
        CommentEntity commentEntity = commentService.deleteComment(authentication.getName(), id);
        return success(commentEntity);
    }
}
