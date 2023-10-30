package models;

import lombok.Data;

@Data
public class CardInfoModel {
    private String nameOnCard;
    private String cardNumber;
    private String cvc;
    private String expMonth;
    private String expYear;
}
