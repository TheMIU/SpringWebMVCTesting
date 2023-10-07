package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepo repo;

    public CustomerController() {
        System.out.println("CustomerController");
    }

    @PostMapping
    public void saveCustomer(@ModelAttribute CustomerDTO dto) {
        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress());
        repo.save(customer);
    }
}
