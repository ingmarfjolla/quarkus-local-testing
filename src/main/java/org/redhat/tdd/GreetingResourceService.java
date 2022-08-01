package org.redhat.tdd;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingResourceService {
    private final List<Item> items = List.of(new Item(1L, "Hello"));

    public List<Item> getAllItems() {
        return items;
    }

    public Optional<Item> getItem(Long id) {
        return items.stream()
                .filter(item -> id == item.getId())
                .findFirst();
    }
}