package org.example;
import java.util.List;
import java.util.ArrayList;

public class SweetShopService {

    private List<Sweet> sweets = new ArrayList<>();

    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public List<Sweet> getAllSweets() {
        return sweets;
    }

    public void deleteSweet(int id) {
        Sweet found = sweets.stream().filter(s -> s.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Sweet not found"));
        sweets.remove(found);
    }


}
