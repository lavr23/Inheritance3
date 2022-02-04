package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book item1 = new Book("В. Пикуль");
    private Book item2 = new Book("А. С. Пушкин");
    private Book item3 = new Book("М. Жванецкий");
    private Book item4 = new Book("Arthur Hailey");
    private Smartphone item5 = new Smartphone("Samsung");
    private Smartphone item6 = new Smartphone("Xiaomi");
    private Smartphone item7 = new Smartphone("Honor");
    private Smartphone item8 = new Smartphone("Huawei");


    @Test
    void shouldSaveOneItem() {
        repository.save(item2);
        Product[] expected = new Product[]{item2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveSomeItems() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item8);
        Product[] expected = new Product[]{item1, item2, item8};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldEmptyBasket() {
        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}