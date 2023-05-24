package com.saper.boxbackend.dto;

import com.saper.boxbackend.model.Box;

public class BoxResponseDTO {
    public long id;
    public String name;
    public String created_by;
    public Integer capacity;

    public  BoxResponseDTO(Box box){
        this.id = box.getId();
        this.name = box.getName();
        this.created_by = box.getCreated_by();
        this.capacity = box.getCapacity();
    }
}
