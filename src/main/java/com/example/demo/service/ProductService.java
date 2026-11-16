package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;

    public Page<ProductResponse> findByUser(
            Long userId,
            Pageable pageable
    ) {
        findUserById(userId);

        return productRepository.findByUserId(userId, pageable)
                .map(productMapper::toResponse);
    }

    public ProductResponse findById(Long userId, Long productId) {
        return productMapper.toResponse(findProductById(userId, productId));
    }

    public ProductResponse create(
            Long userId,
            ProductRequest request
    ) {
        User user = findUserById(userId);
        Product product = productMapper.toEntity(request, user);

        return productMapper.toResponse(productRepository.save(product));
    }

    public ProductResponse update(
            Long userId,
            Long productId,
            ProductRequest request
    ) {
        Product product = findProductById(userId, productId);
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());

        return productMapper.toResponse(productRepository.save(product));
    }

    public void delete(Long userId, Long productId) {
        productRepository.delete(findProductById(userId, productId));
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User", userId)
                );
    }

    private Product findProductById(Long userId, Long productId) {
        return productRepository.findByIdAndUserId(productId, userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product", productId)
                );
    }
}
