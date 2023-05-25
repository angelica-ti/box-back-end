package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.BoxRequestDTO;
import com.saper.boxbackend.dto.BoxResponseDTO;
import com.saper.boxbackend.model.Box;
import com.saper.boxbackend.repository.BoxRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    BoxRepository boxRepository;
    public Object getAll() {

        return boxRepository.findAll().stream().map((box -> new BoxResponseDTO(box)));
    }

    @Transactional
    public Object save(BoxRequestDTO boxRequestDTO) {
        Box box = new Box(boxRequestDTO);

        box = boxRepository.save(box);

        BoxResponseDTO boxResponseDTO = new BoxResponseDTO(box);

        return boxResponseDTO;

    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Box> boxOptional =  boxRepository.findById(id);

        if(boxOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrada!");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(boxOptional.get());
        }
    }

    @Transactional
    public Object update(Long id, BoxRequestDTO boxRequestDTO) {
        Optional<Box> boxOptional = boxRepository.findById(id);

        if(boxOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado");
        }else{
            Box box = boxOptional.get();

            if(boxRequestDTO.capacity != null){
                box.setCapacity(boxRequestDTO.capacity);
            }
            if(boxRequestDTO.name != null){
                box.setName(boxRequestDTO.name);
            }
            return ResponseEntity.status(HttpStatus.OK).body(new BoxResponseDTO(boxRepository.save(box)));
        }
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<Box> boxOptional = boxRepository.findById(id);

        if(boxOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado");
        }else{
            boxRepository.delete(boxOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(String.format("Box %d deletado com sucesso!", id));
        }
    }
}
