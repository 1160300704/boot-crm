package com.zhouhao.controller;

import com.zhouhao.po.BaseDict;
import com.zhouhao.po.Customer;
import com.zhouhao.service.BaseDictService;
import com.zhouhao.service.CustomerService;
import com.zhouhao.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;

    @Value("${customer.from.type}")
    private String SOURCE_TYPE;
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    @RequestMapping("/list")
    public String list(@RequestParam(name = "page", defaultValue = "1") Integer page,
                       @RequestParam(name = "rows", defaultValue = "10") Integer rows,
                       String custName , String custSource , String custlndustry,
                       String custLevel, Model model){
        Customer customer = new Customer();
        customer.setCust_name(custName);
        customer.setCust_source(custSource);
        customer.setCust_industry(custlndustry);
        customer.setCust_level(custLevel);

        Page<Customer> customers = customerService.findCustomerList(page, rows, customer);
        model.addAttribute("page", customers);
        List<BaseDict> sourceType = baseDictService.findBaseDictByTypeCode(SOURCE_TYPE);
        List<BaseDict> industryType = baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);
        List<BaseDict> levelType = baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);

        model.addAttribute("fromType", sourceType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName", customer.getCust_name());
        model.addAttribute("custSource", customer.getCust_source());
        model.addAttribute("custIndustry", customer.getCust_industry());
        model.addAttribute("custLevel", customer.getCust_level());
        return "customer";
    }

    @RequestMapping("/create")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session){


        return "OK";
    }
}
