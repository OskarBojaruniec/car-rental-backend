package com.bojaruniec.carrental.cars.specifications;


import com.bojaruniec.carrental.images.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class SpecificationService {

    private final SpecificationRepository specificationRepository;
    private final ImageService imageService;


    // cache
    public Optional<SpecificationOfCar> getSpecification(long id) {
        return specificationRepository.findById(id);
    }

    public SpecificationOfCar addSpecification(SpecificationOfCar specification) {
        return specificationRepository.save(specification);
    }

    // cache
    public List<SpecificationOfCar> getListOfSpecification() {
        return specificationRepository.findAll();
    }

    public SpecificationOfCar updateSpecification(SpecificationDto specificationDto) throws DataFormatException, IOException {
        SpecificationOfCar specificationToAdd = getSpecification(specificationDto.getSpecificationId()).orElseThrow();
        specificationToAdd.setImage(imageService.getImage(specificationDto.getImageId()));
        return specificationRepository.save(specificationToAdd);
    }

    public void deleteSpecification(long id) {
        specificationRepository.deleteById(id);
    }
}
