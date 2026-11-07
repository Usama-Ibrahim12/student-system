package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final List<T> items = new ArrayList<>();

    public void  add(T item) {
        items.add(item);
    }
    public List<T> findAll() {
        return List.copyOf(items);
    }

    public int size() {
        return items.size();
    }
}
