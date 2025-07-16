package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

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


    public List<Sweet> searchByName(String name){
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


}
