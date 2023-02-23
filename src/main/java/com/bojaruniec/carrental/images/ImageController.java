package com.bojaruniec.carrental.images;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/images")
    public Image addImage(@RequestParam("imageFile") MultipartFile imageFile) {
        return imageService.addImage(imageFile);
    }

    @GetMapping("/images/{imageId}")
    public Image getImage(@PathVariable("id") long id) throws DataFormatException, IOException {
        return imageService.getImage(id);
    }
    @GetMapping("/images")
    public List<Image> getListOfImages() throws DataFormatException, IOException {
        return imageService.getListOfImages();
    }
}
