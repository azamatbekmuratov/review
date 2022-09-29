package com.bekmuratov.review;

import com.bekmuratov.review.domain.dto.ProductReviewDto;
import com.bekmuratov.review.repository.ProductReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReviewApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class ReviewControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private ProductReviewRepository repository;

    @Test
    public void givenReviewWhenReviewGet_thenStatus200() throws Exception {
        mockMvc.perform(get("/api/reviews/v1/review/product/{productId}", "M20324")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("productId", is("M20324")));
    }

    @Test
    public void givenReviewWhenReviewCreate_thenStatus200() throws Exception {
        ProductReviewDto review = new ProductReviewDto();
        review.setProductId("ABC123");
        review.setNumberOfReviews(2);
        review.setAverageReviewScore(3);

        mockMvc.perform(post("/api/reviews/v1/review")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(review))
                        .header("Authorization", "Basic YWRtaW46YXphbWF0"))
                .andExpect(status().isOk());
    }
}
