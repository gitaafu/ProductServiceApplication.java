package com.example.Product_Service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="thumbnail_model")
public class ThumbnailIModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;
    private String name;
    private String type;
    @Column(length=50000000)
    private byte[] picByte;

    public ThumbnailIModel(String name, String type, byte[] picByte) {
        this.name=name;
        this.type=type;
        this.picByte=picByte;
    }
}
