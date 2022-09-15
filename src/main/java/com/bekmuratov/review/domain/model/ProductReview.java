package com.bekmuratov.review.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_review")
public class ProductReview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_review_seq")
    @SequenceGenerator(name = "product_review_seq", allocationSize = 1, sequenceName = "product_review_seq")
    private Long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "average_review_score")
    private Integer averageReviewScore;

    @Column(name = "number_of_reviews")
    private Integer numberOfReviews;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getAverageReviewScore() {
        return averageReviewScore;
    }

    public void setAverageReviewScore(Integer averageReviewScore) {
        this.averageReviewScore = averageReviewScore;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "id=" + id +
                ", productId=" + productId +
                ", averageReviewScore=" + averageReviewScore +
                ", numberOfReviews=" + numberOfReviews +
                '}';
    }
}
