package com.example.Product_Service.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="image_model")
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;
    private String name;
    private String type;
    @Column(length=50000000)
    private byte[] picByte;


    public ImageModel(String name, String type, byte[] picByte) {
        this.name=name;
        this.type=type;
        this.picByte=picByte;
    }
}

