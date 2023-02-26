package com.spring.todo.services;

import com.spring.todo.model.entities.TagEntity;
import com.spring.todo.model.inputs.TagInput;
import com.spring.todo.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TagService extends BaseService {

    @Autowired
    private TagRepository tagRepository;

    public TagEntity getTag(String id) throws Exception {
        Optional<TagEntity> tagEntity = tagRepository.findById(id);
        if (tagEntity.isEmpty()) {
            throw new Exception();
        }
        return tagEntity.get();
    }

    public List<TagEntity> getTags(String name, Integer skip, Integer limit) throws Exception {
        name += "%" + name + "%";
        List<TagEntity> listTag = tagRepository.findAllByName(name);
        if (listTag.isEmpty()) {
            throw new Exception();
        }
        return listTag;
    }

    public List<TagEntity> getMyTag(Authentication authentication, String name) throws Exception {
        name += "%" + name + "%";
        String userId = authentication.getName();
        List<TagEntity> listTag = tagRepository.findAllByOwner(name, userId);
        if (listTag.isEmpty()) {
            throw new Exception();
        }
        return listTag;
    }

    public TagEntity createTag(String user, TagInput tagInput) throws Exception {
        TagEntity tagEntity = tagRepository.save(tagInput.toEntity());
        if (ObjectUtils.isEmpty(tagEntity)) {
            throw new Exception();
        }
        return tagEntity;
    }

    public TagEntity updateTag(String user, String id, TagInput tagInput) throws Exception {
        TagEntity tag = this.getTag(id);
        this.ensureOwnerShip(user, tag.getOwner().getId());
        TagEntity tagEntity = tagInput.toEntity();
        tagEntity.setId(id);
        tagEntity = tagRepository.save(tagEntity);
        return tagEntity;
    }

    public TagEntity deleteTag(String user, String id) throws Exception {
        TagEntity tag = this.getTag(id);
        this.ensureOwnerShip(user, tag.getOwner().getId());
        TagEntity tagEntity = new TagEntity();
        tagEntity.setId(id);
        tagRepository.deleteById(id);
        return tagEntity;
    }
}
