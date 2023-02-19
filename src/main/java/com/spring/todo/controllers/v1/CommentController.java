package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.response.CommentResponse;
import com.spring.todo.model.inputs.CommentInput;
import com.spring.todo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/comment")
public class CommentController extends BaseController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public ResponseEntity<CommentResponse> getComment(@RequestParam("id") String id) {
        return null;
    }

    @GetMapping("/commentByTask")
    public ResponseEntity<List<CommentResponse>> getCommentByTask(
            @RequestParam("task") String task,
            @RequestParam("skip") Integer skip,
            @RequestParam("limit") Integer limit) {
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<CommentResponse> createComment(@RequestBody CommentInput commentInput) {
        return null;
    }

    @PutMapping("/")
    public ResponseEntity<CommentResponse> updateComment(
            @RequestParam("id") String id,
            @RequestBody CommentInput commentInput) {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<CommentResponse> deleteComment(@RequestParam("id") String id) {
        return null;
    }
}
