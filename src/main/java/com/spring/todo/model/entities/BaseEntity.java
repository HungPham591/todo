package com.spring.todo.model.entities;

import com.spring.todo.model.response.BaseResponse;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@MappedSuperclass
@Data
public abstract class BaseEntity<E extends BaseEntity, D extends BaseResponse> implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, updatable = false)
    private String id;
    @CreationTimestamp
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;

    public String setCreateAtConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.format(createAt);
    }

    public String setUpdateAtConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.format(updateAt);
    }

    public String setDeleteAtConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.format(deleteAt);
    }

    private ModelMapper initModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    public abstract Object toReponse();

    protected D mapToResponse(E entity, D dto) {
        ModelMapper modelMapper = initModelMapper();
        modelMapper.map(entity, dto);
        return dto;
    }


//    public String toString() {
//        return null;
//    }
//
//    public boolean equals(final Object o) {
//        return false;
//    }
//
//    public int hashCode() {
//        return 0;
//    }
}
