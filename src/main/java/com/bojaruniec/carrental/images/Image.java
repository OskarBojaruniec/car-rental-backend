package com.bojaruniec.carrental.images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "image_bytea")
    private byte[] imageByte;

    public Image(String name, byte[] imageByte) {
        this.name = name;
        this.imageByte = imageByte;
    }
}
