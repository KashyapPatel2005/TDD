package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class SweetShopServiceTest {

    private SweetShopService service;

    @BeforeEach
    void setup(){
        service  = new SweetShopService();

    }

    @Test
    void AddSweetTest() {
        SweetShopService service = new SweetShopService();
        Sweet sweet = new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 10);
        service.addSweet(sweet);

        List<Sweet> result = service.getAllSweets();
        assertEquals(1, result.size());
        assertEquals("Kaju Katli", result.get(0).getName());
    }


    @Test
    void ViewAllSweetsTest() {
        service.addSweet(new Sweet(1, "Gulab Jamun", "Milk-Based", 10.0, 30));
        service.addSweet(new Sweet(2, "Candy", "Candy", 5.0, 100));

        List<Sweet> sweets = service.getAllSweets();
        assertEquals(2, sweets.size());
    }

    @Test
    void DeleteSweetByIdTest() {
        Sweet sweet = new Sweet(1, "Rasgulla", "Milk-Based", 15.0, 50);
        service.addSweet(sweet);
        service.deleteSweet(1);

        assertTrue(service.getAllSweets().isEmpty());
    }


    @Test
    void testSearchByName() {
        service.addSweet(new Sweet(1, "Kaju Katli", "Nut", 50, 10));
        service.addSweet(new Sweet(2, "Gulab Jamun", "Milk", 10, 20));

        List<Sweet> results = service.searchByName("Kaju");
        assertEquals(1, results.size());
        assertEquals("Kaju Katli", results.get(0).getName());
    }

    @Test
    void testSearchByPriceRange() {
        service.addSweet(new Sweet(1, "Gulab Jamun", "Milk", 10, 40));
        service.addSweet(new Sweet(2, "Pastry", "Cake", 25, 10));
        service.addSweet(new Sweet(3, "Chocolate", "Candy", 5, 100));

        List<Sweet> results = service.searchByPriceRange(6, 20);
        assertEquals(1, results.size());
        assertEquals("Gulab Jamun", results.get(0).getName());
    }


    @Test
    void testSearchByCategory() {
        service.addSweet(new Sweet(1, "Kaju Katli", "Nut", 50, 10));
        service.addSweet(new Sweet(2, "Peda", "Milk", 15, 30));

        List<Sweet> results = service.searchByCategory("Milk");
        assertEquals(1, results.size());
        assertEquals("Peda", results.get(0).getName());
    }

}
