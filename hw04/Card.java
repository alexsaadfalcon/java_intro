public class Card {

    private final int cardNumber;
    private String cardName;
    private final String cardOwner;
    private final boolean isCredit;
    private double balance;

    // Constructors
    public Card(int cardNumber, String cardName,
        String cardOwner, boolean isCredit, double balance) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardOwner = cardOwner;
        this.isCredit = isCredit;
        if (validBalance(balance)) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    // Getter methods
    public int getCardNumber() {
        return cardNumber;
    }
    public String getCardName() {
        return cardName;
    }
    public String getCardOwner() {
        return cardOwner;
    }
    public boolean isCardCredit() {
        return isCredit;
    }
    public double getBalance() {
        return balance;
    }

    // Other public methods
    public boolean updateBalance(double spent) {
        if (validBalance(balance - spent)) {
            balance -= spent;
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        if (isCredit) {
            return String.format("Card Type - Credit; Card Name - " + cardName
                + "; Owner - " + cardOwner + "; Balance - $%.2f", balance);
        } else {
            return String.format("Card Type - Debit; Card Name - " + cardName
                + "; Owner - " + cardOwner + "; Balance - $%.2f", balance);
        }
    }

    // Private helper methods
    private boolean validBalance(double possibleNewBalance) {
        if (isCredit) {
            return possibleNewBalance <= 0;
        } else {
            return possibleNewBalance >= 0;
        }
    }
}