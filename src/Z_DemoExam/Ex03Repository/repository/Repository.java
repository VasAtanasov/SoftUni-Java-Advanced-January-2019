package Z_DemoExam.Ex03Repository.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private int id = 0;
    private Map<Integer, Person> data;

    public Repository() {
        this.data = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Person person) {
        this.data.put(id, person);
        id += 1;
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (! this.data.containsKey(id)) {
            return false;
        }
        this.data.put(id, newPerson);
        return true;
    }

    public boolean delete(int id) {
        if (! this.data.containsKey(id)) {
            return false;
        }
        this.data.remove(id);
        return true;
    }
}