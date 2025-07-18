package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SweetShopService {

    private List<Sweet> sweets = new ArrayList<>();

    public void addSweet(Sweet sweet) {    // adds new sweet to inventory
        sweets.add(sweet);
    }

    public List<Sweet> getAllSweets() {   // View all sweets in inventory
        return sweets;
    }

    public void deleteSweet(int id) {     // delete sweet by id
        Sweet found = sweets.stream().filter(s -> s.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Sweet not found"));
        sweets.remove(found);
    }


    public List<Sweet> searchByName(String name){   // returns list of sweets search by name
        return sweets.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Sweet> searchByPriceRange(double min, double max) {
        return sweets.stream()
                .filter(s -> s.getPrice() >= min && s.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public List<Sweet> searchByCategory(String category) {
        return sweets.stream()
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }



    public void purchaseSweet(int id) {
        Sweet sweet = sweets.stream().filter(s -> s.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Sweet not found")); // throws an error if sweet not found
        if (sweet.getQuantity() <= 0) throw new RuntimeException("Insufficient stock"); // Check for stock
        sweet.setQuantity(sweet.getQuantity() - 1);
    }

    public void restockSweet(int id, int qty) {
        Sweet sweet = sweets.stream().filter(s -> s.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Sweet not found"));  // throws an error if sweet not found
        sweet.setQuantity(sweet.getQuantity() + qty);
    }


}
