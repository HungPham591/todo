package com.spring.todo.repositories.custom;

import com.spring.todo.model.entities.TaskEntity;
import com.spring.todo.model.inputs.TaskInput;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TaskRepositoryCustomImpl extends BaseRepositoryCustom<TaskEntity> implements TaskRepositoryCustom {

    @Override
    public Map<String, Object> aggregateTaskByUser(String user) {
        Session session = this.getSession();
//        Query query = session.createQuery("SELECT task FROM Task task WHERE ");
        return null;
    }

    @Override
    public List<TaskEntity> getTasksByFilter(Map<String, Object> filter) {
        Session session = this.getSession();
        String sql = " SELECT * FROM Task ";

        String assignee = null;
        String assigner = null;
        String group = null;
        Date start = null;
        Date end = null;
        int skip = 0;
        int limit = 10;

        if (!ObjectUtils.isEmpty(filter.get("assignee"))) {
            assignee = filter.get("assignee").toString();
            sql += " assignee = :assignee ";
        }
        if (!ObjectUtils.isEmpty(filter.get("assigner"))) {
            assigner = filter.get("assigner").toString();
            sql += " assigner = :assigner ";
        }
        if (!ObjectUtils.isEmpty(filter.get("group"))) {
            group = filter.get("group").toString();
            sql += " group = :group ";
        }
        if (!ObjectUtils.isEmpty(filter.get("start")) && filter.get("start").getClass().equals(Date.class)) {
            start = (Date) filter.get("start");
            sql += " start >= :start ";
        }
        if (!ObjectUtils.isEmpty(filter.get("end")) && filter.get("end").getClass().equals(Date.class)) {
            end = (Date) filter.get("end");
            sql += " end <= :end ";
        }
        if (!ObjectUtils.isEmpty(filter.get("skip")) && filter.get("skip").getClass().equals(int.class)) {
            skip = (Integer) filter.get("skip");
        }
        if (!ObjectUtils.isEmpty(filter.get("limit")) && filter.get("limit").getClass().equals(int.class)) {
            limit = (Integer) filter.get("limit");
        }

        sql += " LIMIT :skip, :limit";

        Query query = session.createNativeQuery(sql);

        if (assignee != null) {
            query.setParameter("assignee", assignee);
        }
        if (assigner != null) {
            query.setParameter("assigner", assigner);
        }
        if (group != null) {
            query.setParameter("group", group);
        }
        if (start != null) {
            query.setParameter("start", start);
        }
        if (end != null) {
            query.setParameter("end", end);
        }
        query.setParameter("skip", skip);
        query.setParameter("limit", limit);

        List<TaskEntity> listTask = query.list();

        return listTask;
    }

    @Override
    public void updateTask(Map<String, Object> filter, TaskInput taskInput) {
        Session session = this.getSession();
        String sql = " UPDATE Task ";

        String content = null;
        String group = null;
        String img = null;
        String title = null;
        Boolean done = null;

        String assignerFilter = null;
        String assigneeFilter = null;
        String groupFilter = null;
        Date startFilter = null;
        Date endFilter = null;
        Boolean doneFilter = null;
        String id = null;

        sql += " SET ";

        if (taskInput.getContent() != null) {
            sql += " content = :content ";
            content = taskInput.getContent();
        }
        if (taskInput.getGroup() != null) {
            sql += " group = :group ";
            group = taskInput.getGroup();
        }
        if (taskInput.getImg() != null) {
            sql += " img = :img ";
            img = taskInput.getImg();
        }
        if (taskInput.getTitle() != null) {
            sql += " title = :title ";
            title = taskInput.getTitle();
        }

        sql += " WHERE ";

        if (filter.containsKey("id")) {
            sql += " id = :id ";
            id = filter.get("id").toString();
        }
        if (filter.containsKey("start")) {
            sql += " createAt >= :startFilter ";
            startFilter = (Date) filter.get("start");
        }
        if (filter.containsKey("end")) {
            sql += " createAt <= :endFilter ";
            endFilter = (Date) filter.get("end");
        }
        if (filter.containsKey("done")) {
            sql += " done = :doneFilter ";
            doneFilter = (boolean) filter.get("done");
        }
        if (filter.containsKey("group")) {
            sql += " group = :groupFilter ";
            groupFilter = filter.get("group").toString();
        }
        if (filter.containsKey("assigner")) {
            sql += " assigner = :assignerFilter ";
            groupFilter = filter.get("assigner").toString();
        }
        if (filter.containsKey("assignee")) {
            sql += " assignee = :assigneeFilter ";
            groupFilter = filter.get("assignee").toString();
        }

        Query query = session.createNativeQuery(sql);

        if (id != null) {
            query.setParameter("id", id);
        }
        if (doneFilter != null) {
            query.setParameter("doneFilter", doneFilter);
        }
        if (startFilter != null) {
            query.setParameter("startFilter", startFilter);
        }
        if (endFilter != null) {
            query.setParameter("endFilter", endFilter);
        }
        if (groupFilter != null) {
            query.setParameter("groupFilter", groupFilter);
        }
        if (assignerFilter != null) {
            query.setParameter("assignerFilter", assignerFilter);
        }
        if (assigneeFilter != null) {
            query.setParameter("assigneeFilter", assigneeFilter);
        }
        if (content != null) {
            query.setParameter("content", content);
        }
        if (group != null) {
            query.setParameter("group", group);
        }
        if (img != null) {
            query.setParameter("img", img);
        }
        if (title != null) {
            query.setParameter("title", title);
        }
        if (done != null) {
            query.setParameter("done", done);
        }

        int affectedRows = query.executeUpdate();
    }

    @Override
    public void deleteTask(Map<String, Object> filter) {
        Session session = this.getSession();
        Query query = session.createQuery("DELETE Task task WHERE task.id in :ids");

        if (filter.containsKey("ids")) {
            return;
        }

        List<String> listId = (List<String>) filter.get("ids");

        query.setParameter("ids", listId);
        int affectedRow = query.executeUpdate();
    }
}
