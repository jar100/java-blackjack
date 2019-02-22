package javablackjack.blackjack.domain;

import javablackjack.blackjack.BaseTest;
import javablackjack.blackjack.domain.card.Card;
import javablackjack.blackjack.domain.card.CardDeck;
import javablackjack.blackjack.domain.card.CardDeckFactory;
import org.junit.Test;


public class CardTest extends BaseTest {
    @Test
    public void card_deck() {
        CardDeck cardDeck = CardDeckFactory.create();
        for (Card card : cardDeck.getCards()) {
            System.out.println(card);
        }
        softly.assertThat(cardDeck.getCards().size()).isEqualTo(52);
    }

    @Test
    public void card_num_vo_test() {
        Number num = Number.A;
        softly.assertThat(num.getNum()).isEqualTo(11);

        Number num1 = Number.K;
        softly.assertThat(num1.getNum()).isEqualTo(10);

    }

    @Test
    public void card_string_test() {
        Number num = Number.A;
        softly.assertThat(num.name()).isEqualTo("A");
    }
}