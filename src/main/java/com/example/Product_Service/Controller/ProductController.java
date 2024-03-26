package com.example.Product_Service.Controller;

import com.example.Product_Service.model.ImageModel;
import com.example.Product_Service.model.Product;
import com.example.Product_Service.model.ThumbnailIModel;
import com.example.Product_Service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@Validated
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @PostMapping("/addNewProduct")
//    public Product addNewProduct(@RequestBody Product product)
//    { return productService.addNewProduct(product);  }

    @PostMapping(value={"/addNewProduct"},consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("thumbnail") MultipartFile[] thumbnail,
                                 @RequestPart("imageFile") MultipartFile[] file){
        try{
            Set<ThumbnailIModel> image=uploadImage(thumbnail);
            product.setProductThumbnail(image);
            Set<ImageModel> images=uploadImages(file);
            product.setProductImages(images);
            return productService.addNewProduct(product);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Set<ImageModel> uploadImages(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels=new HashSet<>();

        for(MultipartFile file:multipartFiles){
            ImageModel imageModel=new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);

        }
        return imageModels;
    }

    public Set<ThumbnailIModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ThumbnailIModel> imageModels=new HashSet<>();

        for(MultipartFile file:multipartFiles){
            ThumbnailIModel imageModel=new ThumbnailIModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);

        }
        return imageModels;
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    @DeleteMapping("/deleteProduct/{product_id}")
    public void deleteProduct(@PathVariable("product_id") Long product_id){
        productService.deleteProduct(product_id);
    }

    @GetMapping("/getProductsBySubCategory/{category}/{subcategory1}/{subcategory2}")
    public List<Product> getProductsByCategoryAndSubcategory1AndSubcategory2(@PathVariable String category, @PathVariable String subcategory1, @PathVariable String subcategory2) {
        return productService.getProductsByCategoryAndSubcategory1AndSubcategory2(category, subcategory1, subcategory2);
    }
}
