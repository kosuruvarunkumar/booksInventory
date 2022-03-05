package com.example.booksInventory.dto;

import com.example.booksInventory.model.Author;

import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

public class BookDTO {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
