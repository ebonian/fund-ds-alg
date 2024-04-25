package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;

	public UnitDeck(String deckName) {
		cardsInDeck = new ArrayList<CardCounter>();
		setDeckName(deckName);
	}

	public void addCard(UnitCard newCard, int count) {
		if (count <= 0) {
			return;
		}
		
		if (existsInDeck(newCard)) {
			for (CardCounter c : cardsInDeck) {
				if (newCard.equals(c.getCard())) {
					c.setCount(c.getCount() + count);
					return;
				}
			}
		} else {
			CardCounter newCardCounter = new CardCounter(newCard, count);
			cardsInDeck.add(newCardCounter);
		}

	}
	
	public void removeCard(UnitCard toRemove, int count) {
		if (count <= 0) {
			return;
		} 
		
		if (existsInDeck(toRemove)) {
			for (CardCounter c : cardsInDeck) {
				if (toRemove.equals(c.getCard())) {
					c.setCount(c.getCount() - count);
					if (c.getCount() <= 0) {
						cardsInDeck.remove(c);
					}
					
					return;
				}

			}
		} else {
			return;
		}
	}

	public int cardCount() {
		int totalCard = 0;
		for (CardCounter card : cardsInDeck) {
			System.out.println(card);
			totalCard += card.getCount();
		}
		return totalCard;
	}

	public boolean existsInDeck(UnitCard card) {
		for (CardCounter c : cardsInDeck) {
			if (c.getCount() >= 1 && c.getCard().getName().equals(card.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean equals(UnitDeck other) {
		return this.deckName.equals(other.getDeckName());
	}

	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}

	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		if (deckName.isBlank()) {
			this.deckName = "Untitled Deck";
			return;
		}
		this.deckName = deckName;
	}
}
