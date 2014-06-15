package problem54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hand implements Comparable<Hand> {

   private List<Card> cards = new ArrayList<Card>(5);
   private String handType;
   private int value;
   
   private static String[] handRanks = {
      "High Card",
      "One Pair",
      "Two Pairs",
      "Three of a Kind",
      "Straight",
      "Flush",
      "Full House",
      "Four of a Kind",
      "Straight Flush",
      "Royal Flush"
   };
   
   private static List<String> orderedHands = new ArrayList<String>(10); 
   
   static {
      for (String s: handRanks) {
         orderedHands.add(s);
      }
   }
   
   // PUBLIC METHODS 
   
   // creates the hand based on an array of strings representing individual cards,
   // establishing its hand type and value e.g. Type: Full House, Value: 3
   public Hand(String[] cardData) {
      for (int i = 0; i < 5; i++) {
         cards.add(new Card("" + cardData[i].charAt(0), "" + cardData[i].charAt(1)));
      }
      Collections.sort(cards);
      getHand();
   }

   // compares this hand to the given hand 'other' with better hands considered as "less."
   // If this returns a negative value, the current hand is better than the other one.
   public int compareTo(Hand other) {
      if (this.handType.equals(other.handType)) {
         if (other.value == this.value) {
            return compareHighCards(other);
         } else {
            return other.value - this.value;
         }
      } else {
         return orderedHands.indexOf(other.handType) - orderedHands.indexOf(this.handType);
      }
   }
   
   // PRIVATE METHODS
   
   // if all cards have equal suits, returns true (flush)
   private boolean isFlush() {
      boolean flag = true;
      for (int i = 1; i < 5; i++) {
         if (!cards.get(0).getSuit().equals(cards.get(i).getSuit())) {
            flag = false;
         }
      }
      return flag;
   }
   
   // if all cards are in order, returns true (straight)
   private boolean isStraight() {
      boolean flag = true;
      for (int i = 0; i < 4; i++) {
         if (cards.get(i).getValue() + 1 != cards.get(i + 1).getValue()) {
            flag = false;
            i = 4;
         }
      }
      return flag;
   }
   
   // sets the type of hand and its value
   private void getHand() {
      String[] pairings = getPairings();
      String pairType = pairings[0];
      int pairValue = Integer.parseInt(pairings[1]);
      boolean flush = isFlush();
      boolean straight = isStraight();
      
      if (flush && straight && cards.get(0).getValue() == 8) {
         handType = "Royal Flush";
      } else if (flush && straight) {
         handType = "Straight Flush";
         value = cards.get(4).getValue();
      } else if (pairType.equals("Four of a Kind")) {
         handType = pairType;
         value = pairValue;
      } else if (pairType.equals("Full House")) {
         handType = pairType;
         value = pairValue;
      } else if (flush) {
         handType = "Flush";
      } else if (straight) {
         handType = "Straight";
      } else {
         handType = pairType;
         value = pairValue;
      }
   }
   
   // Counts pairs, three of a kind, four of a kind, and full houses in a hand.
   // Returns the type of hand as well as its value e.g. {"Full House", 4}
   private String[] getPairings() {
      List<Integer> pairs = new LinkedList<Integer>();
      List<Integer> threes = new LinkedList<Integer>();
      List<Integer> fours = new LinkedList<Integer>();
      
      int count = 1;
      for (int i = 0; i < 4; i++) {
         // if the next card is the same as this one, increment count
         if (cards.get(i + 1).compareTo(cards.get(i)) == 0) {
            count++;
         } else {
            // when the "chain" is broken, adds the card value to its respective list
            if (count == 2) {
               pairs.add(cards.get(i).getValue());
            } else if (count == 3) {
               threes.add(cards.get(i).getValue());
            } else if (count == 4) {
               fours.add(cards.get(i).getValue());
            }
            count = 1;
         }
      }
      
      // fencepost case
      if (count == 2) {
         pairs.add(cards.get(4).getValue());
      } else if (count == 3) {
         threes.add(cards.get(4).getValue());
      } else if (count == 4) {
         fours.add(cards.get(4).getValue());
      }
      
      // returning the proper hand type and value
      if (fours.size() > 0) {
         return new String[] {"Four of a Kind", "" + fours.get(0)};
      } else if (threes.size() == 1 && pairs.size() == 1) {
         return new String[] {"Full House", "" + threes.get(0)};
      } else if (threes.size() == 1) {
         return new String[] {"Three of a Kind", "" + threes.get(0)};
      } else if (pairs.size() == 2) {
         return new String[] {"Two Pairs", "" + pairs.get(1)};
      } else if (pairs.size() == 1) {
         return new String[] {"One Pair", "" + pairs.get(0)};
      } else {
         return new String[] {"High Card", "" + cards.get(4).getValue()};
      }
   }
   
   // compares high cards in descending order
   private int compareHighCards(Hand other) {
      for (int i = 4; i >= 0; i--) {
         if (this.cards.get(i).getValue() != other.cards.get(i).getValue()) {
            return other.cards.get(i).getValue() - this.cards.get(i).getValue();
         }
      }
      return 0;
   }
}

// Each Hand is made up of 5 cards with a value (0-12) and a suit
class Card implements Comparable<Card> {

   private static final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
   private static List<String> orderedValues = new ArrayList<String>(13); 
   
   static {
      for (String s: values) {
         orderedValues.add(s);
      }
   }
   
   private String value;
   private String suit;
   
   // creates a card given a value and a suit
   public Card(String value, String suit) {
      this.value = value;
      this.suit = suit;
   }
   
   // gets the value of the given card (0-12)
   public int getValue() {
      return orderedValues.indexOf(value);
   }
   
   // gets the suit of the given card (H, C, S, D)
   public String getSuit() {
      return suit;
   }

   // orders cards from smallest to largest
   public int compareTo(Card c) {
      return this.getValue() - c.getValue();
   }
}