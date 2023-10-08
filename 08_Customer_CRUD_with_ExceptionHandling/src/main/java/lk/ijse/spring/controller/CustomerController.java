package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
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
    public ResponseUtil getAllCustomers() {
        List<Customer> all = repo.findAll();
        ArrayList<CustomerDTO> customerDTOS = mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
        return new ResponseUtil("Ok", "Successfully Loaded", customerDTOS);
    }

    // find
    @GetMapping(params = {"id"})
    public ResponseUtil findCustomer(String id) {
        if (!repo.existsById(id)) throw new RuntimeException("Id not exists !");

        CustomerDTO map = mapper.map(repo.findById(id).get(), CustomerDTO.class);
        return new ResponseUtil("Ok", "Successfully Searched", map);
    }

    // add
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto) {
        if (repo.existsById(dto.getId())) throw new RuntimeException("Error, Already added!");

        repo.save(mapper.map(dto, Customer.class));
        return new ResponseUtil("Ok", "Successfully Added", dto);
    }

    // update
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) throw new RuntimeException("Id not exists !");

        repo.save(mapper.map(dto, Customer.class));
        return new ResponseUtil("Ok", "Successfully Updated", dto);
    }

    // delete
    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteCustomer(String id) {
        if (!repo.existsById(id)) throw new RuntimeException("Id not exists !");

        repo.deleteById(id);
        return new ResponseUtil("Ok", "Successfully Deleted", id);
    }
}
