package com.spring.todo.controllers.v1;

import com.spring.todo.controllers.BaseController;
import com.spring.todo.model.entities.TagEntity;
import com.spring.todo.model.inputs.TagInput;
import com.spring.todo.model.response.TagResponse;
import com.spring.todo.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/tag", produces = MediaType.APPLICATION_JSON_VALUE)
public class TagController extends BaseController<TagEntity, TagResponse> {
    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public ResponseEntity<TagResponse> getTag(@RequestParam("id") String id) throws Exception {
        TagEntity tagEntity = tagService.getTag(id);
        return success(tagEntity);
    }

    @GetMapping("/tags")
    public ResponseEntity<List<TagResponse>> getTags(@RequestParam("name") String name, @RequestParam("skip") Integer skip, @RequestParam("limit") Integer limit) throws Exception {
        List<TagEntity> tagEntities = tagService.getTags(name, skip, limit);
        return success(tagEntities);
    }

    @GetMapping("/myTag")
    public ResponseEntity<List<TagResponse>> getMyTag(
            Authentication authentication,
            @RequestParam String group) throws Exception {
        List<TagEntity> tagEntities = tagService.getMyTag(authentication, group);
        return success(tagEntities);
    }

    @PostMapping("/")
    public ResponseEntity<TagResponse> createTag(Authentication authentication, @RequestBody TagInput tagInput) throws Exception {
        TagEntity tagEntity = tagService.createTag(authentication.getName(), tagInput);
        return success(tagEntity);
    }

    @PutMapping("/")
    public ResponseEntity<TagResponse> updateTag(
            Authentication authentication,
            @RequestParam("id") String id,
            @RequestBody TagInput tagInput) throws Exception {
        TagEntity tagEntity = tagService.updateTag(authentication.getName(), id, tagInput);
        return success(tagEntity);
    }

    @DeleteMapping("/")
    public ResponseEntity<TagResponse> deleteTag(Authentication authentication, @RequestParam("id") String id) throws Exception {
        TagEntity tagEntity = tagService.deleteTag(authentication.getName(), id);
        return success(tagEntity);
    }
}
