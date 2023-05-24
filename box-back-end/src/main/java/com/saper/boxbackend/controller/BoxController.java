package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.BoxRequestDTO;
import com.saper.boxbackend.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/box")
public class BoxController {

    @Autowired
    BoxService boxService;
    @GetMapping
    public Object getAll(){
        return boxService.getAll();
    }

    @PostMapping
    public Object save(@RequestBody BoxRequestDTO boxRequestDTO){

        return boxService.save(boxRequestDTO);
    }
}