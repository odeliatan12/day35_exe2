package paf.nus.exe.server.models;

import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

public class Accounts {

    private String account_id;
    private String name;
    private Double balance;
    public String getAccount_id() {
        return account_id;
    }
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public static JsonArray toJson(List<Accounts> acc){
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Accounts a : acc){
            JsonObject o = Json.createObjectBuilder()
                .add("account_id", a.getAccount_id())
                .add("name", a.getName())
                .add("balance", a.getBalance())
                .build();
            builder.add(o);
        }
        JsonArray arrBuilder = builder.build();
        return arrBuilder;
    }
    
}
