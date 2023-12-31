package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class E_Query_Sting_Parameters_Controller {
    //?id=C001&name=Kasun&address=Galle
    @GetMapping(params = {"id", "name", "address"})
    public String getMapping1(@RequestParam String id, String name, String address) {
        return "Get Mapping Invoked 1 " + id + " " + name + " " + address;
    }

    // @RequestParam - not required (nathuwath wada)
}
