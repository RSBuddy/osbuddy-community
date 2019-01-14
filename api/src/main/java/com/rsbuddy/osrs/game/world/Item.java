package com.rsbuddy.osrs.game.world;

import java.util.Objects;

public class Item {
    private final int id;
    private final String name;
    private final int stack;
    private final int price;

    public Item(int id, String name, int stack, int price) {
        this.id = id;
        this.name = name;
        this.stack = stack;
        this.price = price;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public int stack() {
        return stack;
    }

    public int price() {
        return price;
    }

    public int value() {
        return stack * price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                stack == item.stack &&
                price == item.price &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stack, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stack=" + stack +
                ", price=" + price +
                '}';
    }
}
