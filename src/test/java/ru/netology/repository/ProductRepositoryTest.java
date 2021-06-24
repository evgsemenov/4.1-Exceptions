package ru.netology.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private Product item = new Product(4, "Product for remove", 500);

    @Test
    public void shouldRemoveByIdIfExist() {
        repository.save(item);
        repository.save(coreJava);
        repository.removeById(4);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldShowNotFoundExceptionIfRemoveByIdNotExist() {
        repository.save(item);
        repository.save(coreJava);
        repository.removeById(20);
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(15);
        });
    }
}

