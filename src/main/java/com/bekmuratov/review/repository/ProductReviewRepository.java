package com.bekmuratov.review.repository;

import com.bekmuratov.review.domain.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
    Optional<ProductReview> findById(Long id);
    Optional<ProductReview> findByProductId(String productId);

    Integer save(ProductReview input);
}
