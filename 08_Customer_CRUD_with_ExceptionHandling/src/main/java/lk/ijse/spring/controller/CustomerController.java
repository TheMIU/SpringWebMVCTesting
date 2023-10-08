package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin // Enable Cross-Origin Resource Sharing (CORS) for this controller
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper mapper;

    public CustomerController() {
        System.out.println("CustomerController");
    }

    // get all
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        ArrayList<CustomerDTO> customerDTOS= mapper.map(all,new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
        return customerDTOS;
    }

    // find
    @GetMapping(params = {"id"})
    public CustomerDTO findCustomer(String id) {
        Customer c = repo.findById(id).get();
        CustomerDTO map = mapper.map(c, CustomerDTO.class);
        return map;
    }

    // add
    @PostMapping
    public void saveCustomer(@ModelAttribute CustomerDTO dto) {
        Customer map = mapper.map(dto, Customer.class);
        repo.save(map);
    }

    // update
    @PutMapping
    public void updateCustomer(@RequestBody CustomerDTO dto) {
        if (repo.findById(dto.getId()).isPresent()) { // check if customer exists
            Customer map = mapper.map(dto, Customer.class);
            repo.save(map);
        }
    }

    // delete
    @DeleteMapping(params = {"id"})
    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }
}
