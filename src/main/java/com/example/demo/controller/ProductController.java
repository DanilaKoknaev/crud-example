package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/{userId}/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable Long userId,
            @PathVariable Long productId
    ) {
        return ResponseEntity.ok(productService.findById(userId, productId));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @PathVariable Long userId,
            @Valid @RequestBody ProductRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.create(userId, request));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long userId,
            @PathVariable Long productId,
            @Valid @RequestBody ProductRequest request
    ) {
        return ResponseEntity.ok(
                productService.update(userId, productId, request)
        );
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId,
            @PathVariable Long productId
    ) {
        productService.delete(userId, productId);
        return ResponseEntity.noContent().build();
    }
}
