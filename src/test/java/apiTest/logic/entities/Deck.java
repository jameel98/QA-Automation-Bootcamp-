package apiTest.logic.entities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
import java.util.Map;

@Data
public class Deck {
    private boolean success;
    @SerializedName("deck_id")
    private String deckId;
    private int remaining;
    private boolean shuffled;
    private List<Card> cards;
    private Map<String, Pile> piles;

}