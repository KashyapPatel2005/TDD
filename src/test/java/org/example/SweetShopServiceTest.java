package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SweetShopServiceTest {

    private SweetShopService service;

    @BeforeEach
    void setup(){
        service  = new SweetShopService();

    }

    @Test
    void AddSweetTest(){
        Sweet sweet = new Sweet(1001,"kaju katli","Nut-based",50.0,20);
        service.addSweet(sweet);

        List<Sweet> sweets = service.getAllSweets();
        assertEquals(1, sweets.size());
        assertEquals("Kaju Katli", sweets.get(0).getName());
    }
}
