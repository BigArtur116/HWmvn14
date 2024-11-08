package ru.netology.javaqa95.HWmvn14.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(1, "Книга", 400);
    Product product2 = new Product(12, "Рыба", 450);
    Product product3 = new Product(23, "Кофе", 1700);
    Product product4 = new Product(44, "Помидор", 150);
    Product product5 = new Product(101, "Ручка", 40);

    @Test
    void addEndRemoveTest() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        Assertions.assertArrayEquals(new Product[]{product1, product2, product3, product4, product5}, repo.findAll());

        repo.removeById(12);
        Assertions.assertArrayEquals(new Product[]{product1, product3, product4, product5}, repo.findAll());
    }

    @Test
    void shouldBeError() {
        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(1));
        repo.add(product1);
        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(-1));

        Product product6 = new Product(1, "Ручка красная", 42);
        Assertions.assertThrows(NotFoundException.class, () -> repo.add(product6)); // Добавление продукта с ID совпадающим с ID в массиве.
    }
}