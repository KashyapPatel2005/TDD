package org.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sweets")
@CrossOrigin(origins = "*")
public class SweetController {

    private final SweetShopService service = new SweetShopService();

    @GetMapping
    public List<Sweet> getAllSweets() {
        return service.getAllSweets();
    }

    @PostMapping
    public Sweet addSweet(@RequestBody Sweet sweet) {
        service.addSweet(sweet);
        return sweet;
    }

    @DeleteMapping("/{id}")
    public void deleteSweet(@PathVariable int id) {
        service.deleteSweet(id);
    }

    @PutMapping("/purchase/{id}")
    public Sweet purchase(@PathVariable int id) {
        service.purchaseSweet(id);
        return service.getAllSweets().stream()
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }

    @PutMapping("/restock/{id}")
    public Sweet restock(@PathVariable int id, @RequestParam int qty) {
        service.restockSweet(id, qty);
        return service.getAllSweets().stream()
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }

    @GetMapping("/search")
    public List<Sweet> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max) {

        if (name != null) return service.searchByName(name);
        if (category != null) return service.searchByCategory(category);
        if (min != null && max != null) return service.searchByPriceRange(min, max);

        return service.getAllSweets();
    }
}
