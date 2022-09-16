package com.bekmuratov.review.service.impl;

import com.bekmuratov.review.domain.dto.Operation;
import com.bekmuratov.review.domain.dto.ProductReviewDto;
import com.bekmuratov.review.domain.dto.SuccessCreateResponse;
import com.bekmuratov.review.domain.dto.SuccessOperation;
import com.bekmuratov.review.domain.model.ProductReview;
import com.bekmuratov.review.exception.DatabaseOperationException;
import com.bekmuratov.review.exception.ReviewByProductIdNotFoundException;
import com.bekmuratov.review.exception.ReviewNotFoundException;
import com.bekmuratov.review.repository.ProductReviewRepository;
import com.bekmuratov.review.service.api.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    ProductReviewRepository reviewRepository;

    @Override
    public ProductReviewDto findReviewByProductId(String productId) {
        Optional<ProductReview> productReview = reviewRepository.findByProductId(productId);
        return productReview.map(this::mapModelToDto).orElseThrow(() -> new ReviewByProductIdNotFoundException(productId));
    }

    @Override
    public SuccessCreateResponse save(ProductReviewDto input) {
        try {
            ProductReview entity = reviewRepository.save(mapDtoToModel(input));
            if (entity.getId() != null) {
                return new SuccessCreateResponse("201", Operation.SUCCESS.toString(), entity.getId());
            }
        } catch (DatabaseOperationException ex) {
            throw new DatabaseOperationException(ex);
        }
        return null;
    }

    @Override
    public SuccessOperation update(ProductReviewDto input) {
        if (input.getId() == null) {
            throw new ReviewNotFoundException(input.getId());
        }
        Optional<ProductReview> entity = reviewRepository.findById(input.getId());
        if (entity.isPresent()) {
            reviewRepository.save(mapDtoToModel(input));
        } else {
            throw new ReviewNotFoundException(input.getId());
        }
        return new SuccessOperation("200", Operation.SUCCESS.toString());
    }

    @Override
    public SuccessOperation delete(Long id) {
        Optional<ProductReview> entity = reviewRepository.findById(id);
        if (entity.isPresent()) {
            reviewRepository.delete(entity.get());
        } else {
            throw new ReviewNotFoundException(id);
        }
        return new SuccessOperation("200", Operation.SUCCESS.toString());
    }

    ProductReviewDto mapModelToDto(ProductReview model){
        if (model == null) {
            return null;
        }
        ProductReviewDto result = new ProductReviewDto();

        result.setId(model.getId());
        result.setAverageReviewScore(model.getAverageReviewScore());
        result.setNumberOfReviews(model.getNumberOfReviews());
        result.setProductId(model.getProductId());
        return result;
    }

    ProductReview mapDtoToModel(ProductReviewDto dto){
        if (dto == null) {
            return null;
        }
        ProductReview model = new ProductReview();
        model.setId(dto.getId());
        model.setProductId(dto.getProductId());
        model.setNumberOfReviews(dto.getNumberOfReviews());
        model.setAverageReviewScore(dto.getAverageReviewScore());

        return model;
    }
}
