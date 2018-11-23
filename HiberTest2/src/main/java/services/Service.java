package services;

import dao.Dao;
import models.Model;

public class Service {

    private Dao dao = new Dao();

    public void save(Model model) {
        dao.save(model);
    }

    public void delete(Model model) { dao.delete(model); }

    public void update(Model model) { dao.update(model); }

}
