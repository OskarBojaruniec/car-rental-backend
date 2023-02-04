package com.bojaruniec.carrental.images;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public Image getImage(long id) throws IOException, DataFormatException {

        Optional<Image> retrievedImage = imageRepository.findById(id);

        if (retrievedImage.isPresent()) {
            return new Image(retrievedImage.get().getId(), retrievedImage.get().getName(),
                    decompressBytes(retrievedImage.get().getImageByte()));
        }
        else return null;
    }

    public Image addImage(MultipartFile imageFile)  {

        Image image;
        try {
            image = new Image(imageFile.getOriginalFilename(),
                    compressBytes(imageFile.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return imageRepository.save(image);
    }

    private byte[] compressBytes(byte[] data) throws IOException {

        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();

        return outputStream.toByteArray();
    }

    private byte[] decompressBytes(byte[] data) throws IOException, DataFormatException {

        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];

        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();

        return outputStream.toByteArray();
    }

    public List<Image> getListOfImages() throws DataFormatException, IOException {

        List<Image> listOfImages =  imageRepository.findAll();
        for (Image image: listOfImages) {
            image.setImageByte(decompressBytes(image.getImageByte()));
        }

        return listOfImages;
    }
}
