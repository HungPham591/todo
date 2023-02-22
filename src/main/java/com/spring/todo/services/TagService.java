package com.spring.todo.services;

import com.spring.todo.model.entities.TagEntity;
import com.spring.todo.model.inputs.TagInput;
import com.spring.todo.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService extends BaseService {

    @Autowired
    private TagRepository tagRepository;

    public TagEntity getTag(String id) {
        Optional<TagEntity> tagEntity = tagRepository.findById(id);
        return tagEntity.get();
    }

    public List<TagEntity> getTags(String name, Integer skip, Integer limit) {
        name += "%" + name + "%";
        List<TagEntity> listTag = tagRepository.findAllByName(name);
        return listTag;
    }

    public List<TagEntity> getMyTag(Authentication authentication, String name) {
        name += "%" + name + "%";
        String userId = authentication.getName();
        List<TagEntity> listTag = tagRepository.findAllByOwner(name, userId);
        return listTag;
    }

    public TagEntity createTag(String user, TagInput tagInput) {
        TagEntity tagEntity = tagRepository.save(tagInput.toEntity());
        return tagEntity;
    }

    public TagEntity updateTag(String user, String id, TagInput tagInput) {
        TagEntity tagEntity = tagInput.toEntity();
        tagEntity.setId(id);
        tagEntity = tagRepository.save(tagEntity);
        return tagEntity;
    }

    public TagEntity deleteTag(String user, String id) {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setId(id);
        tagRepository.deleteById(id);
        return tagEntity;
    }
}
