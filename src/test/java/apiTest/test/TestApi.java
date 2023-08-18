package apiTest.test;

import apiTest.infra.HttpResponse;
import apiTest.logic.ApiCalls;
import apiTest.logic.entities.Card;
import apiTest.logic.entities.Deck;
import apiTest.logic.entities.Pile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TestApi {
    private final ApiCalls apiCalls = new ApiCalls();
    private String deckId = "";
    private final String pileName = "test_pile";

    @BeforeEach
    public void setup() {
        HttpResponse<Deck> res;
        try {
            res = apiCalls.createNewDeck();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create new deck");
        }
        deckId = res.getData().getDeckId();
        System.out.println("deck id " + deckId);
    }

    @Test
    public void createNewDeck() throws IOException {
        HttpResponse<Deck> res = apiCalls.createNewDeck();
        System.out.println("Create new deck test started");
        //status test
        assertEquals(200, res.getStatus());
        assertNotNull(res.getData().getDeckId());
        //data test
        assertTrue(res.getData().isSuccess());
        assertFalse(res.getData().isShuffled());
        assertEquals(res.getData().getRemaining(), 52);
    }

    @Test
    void drawCardsFromDeck() {
        System.out.println("Draw cards from deck test started");
        HttpResponse<Deck> res;
        //act
        try {
            res = apiCalls.drawCardsFromDeckById(deckId, 2);
        } catch (IOException e) {
            throw new RuntimeException("Failed to draw cards!\n " + e);
        }

        //assert
        //status
        assertEquals(200, res.getStatus());

        //not null test
        assertNotNull(res.getData().getDeckId());
        assertNotNull(res.getData().getCards());
        //data test
        assertTrue(res.getData().isSuccess());
        assertEquals(50, res.getData().getRemaining());
        assertEquals(2, res.getData().getCards().size());

    }

    @Test
    public void testAddCardsToPile() throws IOException {
        //arrange
        HttpResponse<Deck> resDrawCards, resAddCards;

        try {
            resDrawCards = apiCalls.drawCardsFromDeckById(deckId, 2);
        } catch (IOException e) {
            throw new RuntimeException("Failed to draw cards!\n " + e);
        }

        Card firstCard = resDrawCards.getData().getCards().get(0);
        Card secondCard = resDrawCards.getData().getCards().get(1);

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(firstCard);
        cards.add(secondCard);
        //act
        try {
            resAddCards = apiCalls.addCardsToPile(deckId, pileName, cards);
        } catch (IOException e) {
            throw new RuntimeException("Failed to add cards to pile");
        }

        String pName = null;
        Pile pile = null;
        for (Map.Entry<String, Pile> entry : resAddCards.getData().getPiles().entrySet()) {
            if (entry.getKey().equals(pileName)) {
                pName = entry.getKey();
                pile = entry.getValue();
            }
        }

        //assert status
        assertEquals(200, resAddCards.getStatus());

        //assert pile data
        assertEquals(pileName, pName);
        assertNotNull(pile);
        assertEquals(2, pile.getRemaining());

        //not null validation
        assertNotNull(resAddCards.getData().getDeckId());
        assertNotNull(resAddCards.getData().getPiles());

        //data validation
        assertTrue(resAddCards.getData().isSuccess());
        assertEquals(resAddCards.getData().getRemaining(), 50);
        //assertFalse(d2.isShuffled());
        assertEquals(resAddCards.getData().getPiles().size(), 1);

    }

    @Test
    void testCardsInDeck() {
        HttpResponse<Deck> resDrawingCards, resCreatingNewPile;
        //draw 2 cards
        try {
            resDrawingCards = apiCalls.drawCardsFromDeckById(deckId, 2);
        } catch (IOException e) {
            throw new RuntimeException("Failed to draw cards!\n " + e);
        }
        Card firstCard = resDrawingCards.getData().getCards().get(0);
        Card secondCard = resDrawingCards.getData().getCards().get(1);

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(firstCard);
        cards.add(secondCard);

        //create new pile and add the 2 cards to it
        try {
            resCreatingNewPile = apiCalls.addCardsToPile(deckId, pileName, cards);
        } catch (IOException e) {
            throw new RuntimeException("Can't create new pile !\n " + e);
        }

        HttpResponse<Deck> res;
        //act
        try {
            res = apiCalls.drawCardsFromDeckById(deckId, resDrawingCards.getData().getRemaining());
        } catch (IOException e) {
            throw new RuntimeException("Can't draw cards from the deck !\n " + e);
        }

        //assert
        assertEquals(200, res.getStatus());

        //not null validation
        assertThat(res.getData().getDeckId(), notNullValue());
        assertThat(res.getData().isSuccess(), notNullValue());
        assertThat(res.getData().getCards(), notNullValue());


        //data validation
        assertTrue(res.getData().isSuccess());
    //    assertThat(res.getData().getCards(), not(hasItem(cards.get(0))));
   //     assertThat(res.getData().getCards(), not(hasItem(cards.get(1))));

    }
}
