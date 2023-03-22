package paf.nus.exe.server.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import paf.nus.exe.server.models.Accounts;
import paf.nus.exe.server.models.TransferAccount;

import static paf.nus.exe.server.repo.Queries.*;

@Repository
public class FundsTransferRepo {

    @Autowired
    private JdbcTemplate template;
    
    public List<Accounts> getAccounts(){
        return template.query(SQL_GETACCOUNTS, BeanPropertyRowMapper.newInstance(Accounts.class));
    }

    public Boolean insertTransfer(TransferAccount ta){

        Integer result = template.update(SQL_INSERTTRANSFER,
            ta.getId(), ta.getFromAccount(), ta.getToAccount(), ta.getAmount(), ta.getComments());
        System.out.println(result);
        return result > 0 ? true : false;

    }

    public Boolean updateTransfer(Double amount, String id){

        Integer result = template.update(SQL_UPDATEUSER, amount, id);
        return result > 0 ? true : false;

    }

    public Double getBalance(String id){

        Double balance = template.queryForObject(SQL_GETBALANCE, Double.class, id);
        System.out.println(balance);
        return balance;
    }


}
