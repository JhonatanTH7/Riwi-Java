package Works.MockExam1.model;

import Works.MockExam1.database.CRUD;

import java.util.List;

public class PhysicianModel implements CRUD {
    @Override
    public Object insert(Object object) {
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }
}
