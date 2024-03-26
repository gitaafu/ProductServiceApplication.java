package com.example.Product_Service.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;



    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="product_thumbnail",
            joinColumns={
                    @JoinColumn(name="product_id")

            },
            inverseJoinColumns = {
                    @JoinColumn(name="thumbnail_id")
            }
    )
    private Set<ThumbnailIModel> productThumbnail;

    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="product_images",
            joinColumns={
                    @JoinColumn(name="product_id")

            },
            inverseJoinColumns = {
                    @JoinColumn(name="image_id")
            }
    )
    private Set<ImageModel> productImages;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String category;

    @Column(name = "sub_cat1")
    private String subcategory1;

    @Column(name = "sub_cat2")
    private String subcategory2;



    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;




}
