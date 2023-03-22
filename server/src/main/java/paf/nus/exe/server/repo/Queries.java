package paf.nus.exe.server.repo;

public class Queries {
    

    public static final String SQL_GETACCOUNTS = """
        select * from accounts;    
        """;

    public static final String SQL_INSERTTRANSFER = """
            insert into FundsTransfer(id, fromAccount, 
            toAccount, amount, comments) values 
            (?, ?, ?, ?, ?) 
        """;

    public static final String SQL_UPDATEUSER = """
            update accounts set balance = ? where account_id = ?;
        """;

    public static final String SQL_GETBALANCE = """
            select balance from accounts where account_id = ?
        """;
}
