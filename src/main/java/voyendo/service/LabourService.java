package voyendo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voyendo.model.CategoryRepository;
import voyendo.model.CompanyRepository;

@Service
public class LabourService {

    Logger logger = LoggerFactory.getLogger(LabourService.class);

    private CompanyRepository companyRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    public LabourService(CompanyRepository companyRepository, CategoryRepository categoryRepository) {
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
    }


}
