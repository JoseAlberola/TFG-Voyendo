package voyendo.controller;

import voyendo.authentication.ManagerUserSession;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CompanyService companyService;

    @Autowired
    ManagerUserSession managerUserSession;

}
