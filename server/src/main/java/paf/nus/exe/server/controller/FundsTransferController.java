package paf.nus.exe.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.JsonArray;
import paf.nus.exe.server.exception.FundsException;
import paf.nus.exe.server.models.Accounts;
import paf.nus.exe.server.models.TransferAccount;
import paf.nus.exe.server.service.FundsTransferService;

@Controller
@CrossOrigin(origins = "*")
public class FundsTransferController {

    @Autowired
    private FundsTransferService service;

    @GetMapping(path = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public ResponseEntity<String> getAccounts(){

        List<Accounts> acc = service.getAccounts();
        JsonArray arr = Accounts.toJson(acc);
        return ResponseEntity.status(HttpStatus.OK).body(arr.toString());
    }    

    @PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> placeTransfer(@RequestBody String payload) throws FundsException{

        System.out.println(">>>>> transfering" + payload);
        TransferAccount ta = TransferAccount.toTransAcc(payload);
        System.out.println(ta);
        ResponseEntity<String> id = service.placeFundTransfer(ta);
        return ResponseEntity.status(HttpStatus.OK).body(id.toString());
    }
    
}
