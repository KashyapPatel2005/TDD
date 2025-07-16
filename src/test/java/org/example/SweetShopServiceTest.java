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

}
