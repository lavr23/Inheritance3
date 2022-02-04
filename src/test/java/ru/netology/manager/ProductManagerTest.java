package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book item1 = new Book(1, "book1", 200, "author1");
    Book item2 = new Book(2, "book2", 200, "author1");
    Book item3 = new Book(3, "book3", 500, "author3");
    Book item4 = new Book(4, "book4", 690, "author4");
    Smartphone item5 = new Smartphone(5, "device1", 35000, "manufacture1");
    Smartphone item6 = new Smartphone(6, "device2", 24000, "manufacture2");
    Smartphone item7 = new Smartphone(7, "device3", 5600, "manufacture3");
    Smartphone item8 = new Smartphone(8, "device4", 10300, "manufacture4");


    @BeforeEach
    void manageAdd() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
    }


    @Test
    void searchByBookName() {
        Product[] expected = new Product[]{item4};
        Product[] actual = manager.searchBy("book4");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookAuthor() {
        Product[] expected = new Product[]{item3};
        Product[] actual = manager.searchBy("book3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookNotValidAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("author");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{item8};
        Product[] actual = manager.searchBy("device4");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{item5};
        Product[] actual = manager.searchBy("manufacture1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneNotValidManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("manufacture");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAddSomeItems() {
        Product[] expected = new Product[]{item1, item2};
        Product[] actual = manager.searchBy("author1");
        assertArrayEquals(expected, actual);
    }
}