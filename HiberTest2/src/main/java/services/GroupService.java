package services;

import dao.GroupDao;
import models.Group;

import java.util.List;

public class GroupService extends Service {

    private GroupDao groupDao = new GroupDao();

    public GroupService() {
    }

    public Group findGroup(int id) {
        return groupDao.findById(id);
    }

    public List<Group> findAllGroups() {
        return groupDao.findAll();
    }

}
