package quizdate.model;

import java.util.List;

public interface DAO<T> {

    List<T> getAll();

    int getRandomId();

    T get(int id);

    boolean save(T t);

    boolean update(int id, T t);

    boolean remove(int id);



}
