package com.uttt.autosparepart;


import com.uttt.autosparepart.entities.ClientDO;
import com.uttt.autosparepart.entities.ResponseTO;
import com.uttt.autosparepart.sevices.ClientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins="*")
@RestController
@RequestMapping("/client")
public class ClientRest {

    @Autowired
    ClientServiceI clientService;

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClientDO> login(String email, String password) {
     return new ResponseEntity<>(clientService.login(email, password), HttpStatus.OK) ;
    }

    @PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClientDO> guardar(@RequestBody ClientDO clientDO) {
        return new ResponseEntity<>(clientService.save(clientDO), HttpStatus.OK) ;
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClientDO> update(@RequestBody ClientDO clientDO) {
        return new ResponseEntity<>(clientService.save(clientDO), HttpStatus.OK) ;
    }

    @GetMapping(value = "/sendCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseTO> sendCode(String email) {
        return new ResponseEntity<>(clientService.sendCode(email), HttpStatus.OK) ;
    }

    @GetMapping(value = "/verifyCode", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseTO> verifyCode(String email) {
        return new ResponseEntity<>(clientService.verifyCode(email), HttpStatus.OK) ;
    }
    @PostMapping(value = "/restorePassword", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseTO> restorePassword(@RequestBody ClientDO clientDO) {
        return new ResponseEntity<>(clientService.restorePassword(clientDO), HttpStatus.OK) ;
    }

}

