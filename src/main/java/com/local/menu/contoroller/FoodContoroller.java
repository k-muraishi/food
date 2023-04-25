package com.local.menu.contoroller;

import com.local.menu.food.Food;
import com.local.menu.food.FoodRepository;
import com.local.menu.food.FoodRequestDTO;
import com.local.menu.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodContoroller {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodlist = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodlist;
    }
}
