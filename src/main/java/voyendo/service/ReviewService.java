package voyendo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voyendo.controller.Data.CrearAppointmentData;
import voyendo.controller.Data.CrearReviewData;
import voyendo.controller.Data.LabourData;
import voyendo.controller.ReservaCalendario;
import voyendo.model.*;
import voyendo.service.exception.LabourServiceException;
import voyendo.service.exception.ReviewServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    Logger logger = LoggerFactory.getLogger(ReviewService.class);

    private CompanyRepository companyRepository;
    private ReviewRepository reviewRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public ReviewService(CompanyRepository companyRepository, ReviewRepository reviewRepository,
                         CustomerRepository customerRepository) {
        this.companyRepository = companyRepository;
        this.reviewRepository = reviewRepository;
        this.customerRepository = customerRepository;
    }

    public Page<Review> findPaginated(Long idCompany, Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Review> list;
        List<Review> reviews = reviewRepository.reviewsDeEmpresa(idCompany);

        if (reviews.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, reviews.size());
            list = reviews.subList(startItem, toIndex);
        }

        Page<Review> reviewPage
                = new PageImpl<Review>(list, PageRequest.of(currentPage, pageSize), reviews.size());

        return reviewPage;
    }

    @Transactional(readOnly = true)
    public Review findById(Long reviewId) {
        logger.debug("Buscando review " + reviewId);
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Transactional
    public boolean crearReview(Company company, Customer customer, CrearReviewData crearReviewData) {
        logger.debug("Creando review para la empresa " + company.getId() + " el cliente " + customer.getId());

        Review review = new Review(crearReviewData.getComentario(), crearReviewData.getValuation(),
                company, customer);
        reviewRepository.save(review);
        return true;
    }

    @Transactional
    public boolean modificarReview(CrearReviewData crearReviewData) {
        Long idReview = crearReviewData.getIdreview();
        logger.debug("Modificando review " + idReview);

        Review review = reviewRepository.findById(idReview).orElse(null);
        if (review == null) {
            throw new ReviewServiceException("No existe review con id " + idReview);
        }
        review.setText(crearReviewData.getComentario());
        review.setValuation(crearReviewData.getValuation());
        reviewRepository.save(review);
        return true;
    }

    @Transactional
    public boolean eliminarReview(Long idReview) {
        logger.debug("Eliminando review " + idReview);
        Review review = reviewRepository.findById(idReview).orElse(null);
        if (review == null) {
            throw new ReviewServiceException("No existe review con id " + idReview);
        }
        reviewRepository.delete(review);
        return true;
    }

}
