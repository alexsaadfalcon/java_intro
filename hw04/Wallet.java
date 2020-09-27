import java.util.Scanner;

public class Wallet {

    private final String owner;
    private String password;
    private Card[] cards;
    private int numCards;
    private double balance;

    // Constructors
    public Wallet(String owner, String password, Card[] cards) {
        this.owner = owner;
        this.password = password;
        if (cards == null) {
            this.cards = new Card[10];
        } else {
            this.cards = new Card[10];
            int cardsCounter = 0;
            for (int i = 0; i < cards.length; i++) {
                if (cards[i] != null
                    && cards[i].getCardOwner().equals(this.owner)) {
                    this.cards[cardsCounter] = cards[i];
                    cardsCounter++;
                }
            }
        }
        numCards = 0;
        for (int i = 0; i < 10; i++) {
            if (this.cards[i] != null) {
                numCards++;
            }
        }
        updateBalance();
    }
    public Wallet(String owner, String password) {
        this(owner, password, null);
    }

    // Getter Methods
    public double getBalance() {
        return balance;
    }
    public String getOwner() {
        return owner;
    }

    // Other public methods
    public void add(Card[] newCards) {
        int newCardsIndex = 0;
        int currentCardsIndex = numCards;
        int notAddedIndex = 0;
        Card[] notAdded = new Card[10];
        while (newCardsIndex < newCards.length) {
            if (newCards[newCardsIndex] != null
                && newCards[newCardsIndex].getCardOwner().equals(this.owner)
                && currentCardsIndex < 10) {
                cards[currentCardsIndex] = newCards[newCardsIndex];
                currentCardsIndex++;
                newCardsIndex++;
            } else {
                notAdded[notAddedIndex] = newCards[newCardsIndex];
                newCardsIndex++;
                notAddedIndex++;
            }
        }
        System.out.println("The following cards could not be added:");
        for (int i = 0; i < 10; i++) {
            if (notAdded[i] != null) {
                System.out.println(notAdded[i]);
            }
        }
        numCards = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                numCards++;
            }
        }
        updateBalance();
    }
    public void buy(double price, String cardName) {
        if (validate()) {
            boolean cardExists = false;
            int cardIndex = -1;
            for (int i = 0; i < numCards; i++) {
                if (cards[i].getCardName().equals(cardName)) {
                    cardIndex = i;
                    cardExists = true;
                }
            }
            if (cardExists) {
                if (cards[cardIndex].updateBalance(price)) {
                    System.out.println("The purchase was made.");
                    updateBalance();
                } else {
                    System.out.println("The purchase could not be made.");
                }
            } else {
                System.out.println("I'm sorry, but that card isn't "
                    + "in the wallet.");
            }
        }
        System.out.printf("Your balance is: $%.2f\n", balance);
    }
    public String toString() {
        String out = "";
        if (cards[0] != null) {
            out = cards[0].toString();
            for (int i = 1; i < numCards; i++) {
                out = out + "\n" + cards[i].toString();
            }
        } else {
            out = "There are no cards in this wallet.";
        }
        return out;
    }

    // Private helper methods
    private void updateBalance() {
        balance = 0;
        for (int i = 0; i < numCards; i++) {
            balance += cards[i].getBalance();
        }
    }
    private boolean validate() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String entered = kb.nextLine();
        if (entered.equals(password)) {
            return true;
        } else {
            System.out.println("I'm sorry, but that is the wrong password.");
            return false;
        }
    }
}