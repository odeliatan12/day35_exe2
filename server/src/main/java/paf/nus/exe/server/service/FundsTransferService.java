package paf.nus.exe.server.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import paf.nus.exe.server.models.Accounts;
import paf.nus.exe.server.models.TransferAccount;
import paf.nus.exe.server.repo.FundsTransferRepo;

@Service
public class FundsTransferService {

    @Autowired
    private FundsTransferRepo repo;

    public List<Accounts> getAccounts(){
        return repo.getAccounts();
    }
    
    public ResponseEntity<String> placeFundTransfer(TransferAccount ta) {

        String transferId = UUID.randomUUID().toString().substring(0,8);

        System.out.println(transferId);
        ta.setId(transferId);

        System.out.println(ta.getFromAccount() + " " + ta.getToAccount());

        Boolean result = repo.insertTransfer(ta);
        System.out.println(result);
        Double fromAmount = repo.getBalance(ta.getFromAccount());
        Double balanceforFrom = fromAmount - ta.getAmount();
        System.out.println(balanceforFrom);
        Double toAmount = repo.getBalance(ta.getToAccount());
        Double balanceforTo = toAmount + ta.getAmount();
        System.out.println(balanceforTo);
        Boolean result2 = repo.updateTransfer(balanceforFrom, ta.getFromAccount());
        System.out.println(result2);
        Boolean result3 = repo.updateTransfer(balanceforTo, ta.getToAccount());
        System.out.println(result3);

        return ResponseEntity.status(HttpStatus.OK).body(transferId);
    }

    
}
