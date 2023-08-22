package learn.poker;

import learn.cards.Card;

public class TwoCardHand implements Comparable<TwoCardHand> {

    private final Card one;
    private final Card two;

    public TwoCardHand(Card one, Card two) {
        this.one = one;
        this.two = two;
    }

    public Card getOne() {
        return one;
    }

    public Card getTwo() {
        return two;
    }

    @Override
    public int compareTo(TwoCardHand hand) {
        // 1. Complete the compareTo method.
        // If the current TwoCardHand(`this`) has a lower score than the TwoCardHand parameter, compareTo returns
        // an int less than 0.
        // If `this` has a higher score than the TwoCardHand parameter, compareTo returns an int greater than 0.
        // If `this` and the TwoCardHand parameter have the same score, compareTo returns 0.
        // See Exercise04.md for scoring rules.

        boolean weHavePair = one.getRank() == two.getRank();
        boolean theyHavePair = hand.getOne().getRank() == hand.getTwo().getRank();


        if (weHavePair && theyHavePair) {
            return one.getRank().compareTo(hand.getOne().getRank());
        } else if (weHavePair && !theyHavePair) {
            return 1;
        } else if (!weHavePair && theyHavePair) {
            return -1;
        }

        Card usHighCard;
        Card usLowCard;
        if ((one.getRank().compareTo(two.getRank()) < 0)) {
            usHighCard = two;
            usLowCard = one;
        } else {
            usHighCard = one;
            usLowCard = two;
        }
        Card themHighCard;
        Card themLowCard;
        if ((hand.getOne().getRank().compareTo(hand.getTwo().getRank()) < 0)) {
            themHighCard = hand.getTwo();
            themLowCard = hand.getOne();
        } else {
            themHighCard = hand.getOne();
            themLowCard = hand.getTwo();
        }

        int rankCompare = usHighCard.getRank().compareTo(themHighCard.getRank());
        if (rankCompare > 0) {
            return 1;
        } else if (rankCompare < 0) {
            return -1;
        } else {
            return usLowCard.getRank().compareTo(themLowCard.getRank());
        }
    }
}
