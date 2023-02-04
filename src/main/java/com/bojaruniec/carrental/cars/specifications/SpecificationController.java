package com.bojaruniec.carrental.cars.specifications;

import com.bojaruniec.carrental.images.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SpecificationController {

    private final SpecificationService specificationService;
    private final ImageService imageService;

    @GetMapping("/specifications")
    public List<SpecificationOfCar> getListOfSpecifications() {
        return specificationService.getListOfSpecification();
    }

    @GetMapping("/specifications/{id}")
    public SpecificationOfCar getSpecificationById(@PathVariable long id) {
        return specificationService.getSpecification(id).orElseThrow();
    }
    @PostMapping("/specifications")
    public SpecificationOfCar addSpecification(@RequestBody SpecificationOfCar specification) {
        return specificationService.addSpecification(specification);
    }
    @PutMapping("/specifications")
    public SpecificationOfCar updateSpecification(@RequestBody SpecificationDto specificationDto) throws DataFormatException, IOException {
        return specificationService.updateSpecification(specificationDto);
    }
    @DeleteMapping("/specifications/{id}")
    public void deleteSpecification(@PathVariable long id){
        specificationService.deleteSpecification(id);
    }
}
