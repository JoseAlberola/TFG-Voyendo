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
import voyendo.controller.ReservaCalendario;
import voyendo.model.*;

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

}
