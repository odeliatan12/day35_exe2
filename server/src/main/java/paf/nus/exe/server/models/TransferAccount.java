package paf.nus.exe.server.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class TransferAccount {

    private String id;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private String comments;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFromAccount() {
        return fromAccount;
    }
    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
    public String getToAccount() {
        return toAccount;
    }
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public static TransferAccount toTransAcc(String j){
        JsonReader reader = Json.createReader(new StringReader(j));
        return createTransAcc(reader.readObject());
    }

    public static TransferAccount createTransAcc(JsonObject obj){
        TransferAccount ta = new TransferAccount();
        ta.setFromAccount(obj.getString("fromAccount"));
        ta.setToAccount(obj.getString("toAccount"));
        ta.setComments(obj.getString("comments"));
        ta.setAmount(obj.getJsonNumber("amount").doubleValue());
        return ta;
    }
}
