package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
public class E_CustomerController {
    //add (POST)
    //delete (DELETE)
    //update (PUT)
    //search (GET)
    //get_all (GET)

    //every response should return a json object including state,message and data
    //return

    //get_all (GET)
    @GetMapping
    public ResponseUtil getAllCustomer() {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        allCustomers.add(new CustomerDTO("C001", "John", "Galle", 5000, "0771234567", null));
        allCustomers.add(new CustomerDTO("C002", "Tommy", "Matara", 1000, "0777654321", null));
        return new ResponseUtil("OK", "Success", allCustomers);
    }

    //add (POST)
    @PostMapping
    public ResponseUtil addCustomer(@RequestBody CustomerDTO dto){
        return new ResponseUtil("OK", "Success", "Json Data : "+dto.toString());
    }

    //update (PUT)
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        return new ResponseUtil("OK", "Success", dto.toString());
    }

    //delete (DELETE)
    @DeleteMapping
    public ResponseUtil deleteCustomer(String id) {
        return new ResponseUtil("OK", "Success", id);
    }
}
