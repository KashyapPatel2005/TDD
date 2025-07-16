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

}
