package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/response")
public class D_Response_Controller {
    //So how to send back data with JSON
    //In java EE we use Json Processing. in here.?

    //ResponseUtil
    //@ResponseStatus(HttpStatus.CREATED)

    @PutMapping
    public CustomerDTO receiveDataWithJson(@RequestBody CustomerDTO dto) {
        return dto;
    }

   /* @GetMapping
    public ArrayList<CustomerDTO> sendJsonData() {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        return allCustomers;
    }*/

   /* @GetMapping
    public ArrayList<CustomerDTO> sendJsonData(){
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        allCustomers.add(new CustomerDTO("C001","John","Galle",5000,"0771234567",null));
        allCustomers.add(new CustomerDTO("C002","Tommy","Matara",1000,"0777654321",null));
        return allCustomers;
    }*/

}
