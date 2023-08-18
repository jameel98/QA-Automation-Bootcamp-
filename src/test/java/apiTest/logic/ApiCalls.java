package apiTest.logic;


import apiTest.infra.HttpRequest;
import apiTest.infra.HttpResponse;
import apiTest.logic.entities.Card;
import apiTest.logic.entities.Deck;
import apiTest.logic.entities.Pile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static apiTest.infra.HttpRequest.get;

public  class ApiCalls {

    private static final String BASE_URL = "https://deckofcardsapi.com/api/deck/";

    public ApiCalls() {
    }

    // API call to create a new deck
    public HttpResponse<Deck> createNewDeck() throws IOException {
        String url = BASE_URL + "new/";
        HttpResponse<Deck> res;
        try {
            res =  HttpRequest.get(url, getDefaultHeaders(), null,Deck.class);
        } catch (IOException e) {
            throw new IOException("Failed to create new deck");
        }
        return res;
    }

    //API call to draw two cards from the deck by deck_id
    public HttpResponse<Deck> drawCardsFromDeckById(String deck_id, int numberOfCardsToDraw) throws IOException {
        String url = BASE_URL + deck_id + "/draw/";
        Map<String, String> param = new HashMap<>();
        param.put("count", String.valueOf(numberOfCardsToDraw));

        return HttpRequest.get(url,null , param,Deck.class);
    }

    // API call to create new pile and to add cards to a pile
    public HttpResponse<Deck> addCardsToPile(String deckId, String pileName, ArrayList<Card> cardsList) throws IOException {
        String url = BASE_URL  + deckId + "/pile/" + pileName + "/add/";
        HttpResponse<Deck> res;

        StringBuilder cards = new StringBuilder();

        for (Card card : cardsList) {
            cards.append(card.getCode());
            cards.append(",");
        }
        Map<String,String> param = new HashMap<>();
        param.put("cards", String.valueOf(cards));
        ///add/?cards=AS,BS
        try {
            res = HttpRequest.get(url, null, param,Deck.class);
        } catch (IOException e) {
            throw new IOException("Failed to put cards in pile !");
        }
        return res;
    }

    // API call to check if cards are added to a pile
    public HttpResponse<Pile> checkCardsInPile(String deckId, String pileName) throws IOException {
        String url = BASE_URL +  deckId + "/pile/" + pileName + "/list/";
        HttpResponse<Pile> res;

        try {
            res = get(url, getDefaultHeaders(), null,Pile.class);
        } catch (IOException e) {
            throw new IOException("Failed to get cards in pile");
        }

        return res;
    }

    // API call to check if cards are removed from a deck
    public HttpResponse<Deck> checkCardsRemovedFromDeck(String deckId, int count) throws IOException {
        String url = BASE_URL +  deckId + "/draw/?count=" + count;
        HttpResponse<Deck> res;
        try {
            res = get(url, getDefaultHeaders(), null,Deck.class);
        } catch (IOException e) {
            throw new IOException("Failed to check if cards removed from deck");
        }
        return res;
    }

    // API call to return cards from a pile to the deck
    public HttpResponse<Pile> returnCardsFromPileToDeck(String deckId, String pileName, String cards) throws IOException {
        String url = BASE_URL +  deckId + "/pile/" + pileName + "/return";
        HttpResponse<Pile> res;

        try{
            res = HttpRequest.post(url, getDefaultHeaders(), cards);
        }catch (IOException e){
            throw new IOException("Failed to return cards");
        }
        return res;
    }

    private Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }


}
