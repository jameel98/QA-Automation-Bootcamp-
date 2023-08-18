package apiTest.logic.entities;

import lombok.Data;

@Data
public class Card {
    private String code;
    private String image;
    private Img images;
    private String value;
    private String suit;

}
