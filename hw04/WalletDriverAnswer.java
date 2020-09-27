import java.util.Scanner;

public class WalletDriver {
    public static void main(String[] args) {
        Scanner scandalous = new Scanner(System.in);
        Card[] cards = new Card[10];
        boolean isCredit = false;
        double balance = 0;
        Wallet wallet;
        int numCards = 0;

        System.out.print("Welcome to the virtual wallet! What is your name? ");
        String owner = scandalous.nextLine();
        System.out.print("Please set a password for your wallet. ");
        String password = scandalous.nextLine();
        System.out.println();

        boolean initialize = true;
        while (initialize) {
            int input;
            System.out.println("Does your wallet currently have anything "
                + "(else) in it?");
            System.out.println("1: Credit Cards");
            System.out.println("2: Debit Cards");
            System.out.println("3: No");
            input = Integer.parseInt(scandalous.nextLine());
            System.out.println();
            switch (input) {
            case 1:
                String quit = "";
                System.out.println("Please note that there is a "
                    + "maximum of 10 cards (debit and credit combined) "
                    + "per wallet.");
                while (!quit.equalsIgnoreCase("q")
                    && numCards < cards.length) {
                    System.out.println("Please enter the name of the owner"
                        + " of the next card or \"q\" to quit.");
                    String cardOwner = scandalous.nextLine();
                    if (!cardOwner.equalsIgnoreCase("q")) {
                        System.out.println("Please enter the card "
                            + "number.");
                        int cardNumber = Integer.parseInt(
                            scandalous.nextLine());
                        System.out.println("Would you like to give the "
                            + "card a name? (Press enter to skip)");
                        String cardName = scandalous.nextLine();
                        if (cardName.length() == 0) {
                            cardName = "" + cardNumber;
                        }
                        String bal = "1";
                        while (bal.length() != 0
                            && Double.parseDouble(bal) > 0) {
                            System.out.println("Would you like to give the"
                                + " credit card a balance? It cannot be a "
                                + "positive value."
                                + "(Press enter to skip)");
                            bal = scandalous.nextLine();
                        }
                        if (bal.length() == 0) {
                            cards[numCards] = new Card(cardNumber,
                                cardName, cardOwner, true, 0);
                        } else {
                            cards[numCards] = new Card(cardNumber,
                                cardName, cardOwner, true,
                                Double.parseDouble(bal));
                        }
                        numCards++;
                    } else {
                        quit = cardOwner;
                    }
                }
                break;
            case 2:
                quit = "";
                System.out.println("Please note that there is a "
                    + "maximum of 10 cards (debit and credit combined) "
                    + "allowed per wallet.");
                while (!quit.equalsIgnoreCase("q")
                    && numCards < cards.length) {
                    System.out.println("Please enter the name of the owner"
                        + " of the next card or \"q\" to quit.");
                    String cardOwner = scandalous.nextLine();
                    if (!cardOwner.equalsIgnoreCase("q")) {
                        System.out.println("Please enter the card "
                            + "number.");
                        int cardNumber = Integer.parseInt(
                            scandalous.nextLine());
                        System.out.println("Would you like to give the "
                            + "card a name? (Press enter to skip)");
                        String cardName = scandalous.nextLine();
                        if (cardName.length() == 0) {
                            cardName = "" + cardNumber;
                        }
                        String bal = "-1";
                        while (bal.length() != 0
                            && Double.parseDouble(bal) < 0) {
                            System.out.println("Would you like to give the"
                                + " debit card a balance? It cannot be a "
                                + "negative value.\n"
                                + "(Press enter to skip)");
                            bal = scandalous.nextLine();
                        }
                        if (bal.length() == 0) {
                            cards[numCards] = new Card(cardNumber,
                                cardName, cardOwner, false, 0);
                        } else {
                            cards[numCards] = new Card(cardNumber,
                                cardName, cardOwner, false,
                                Double.parseDouble(bal));
                        }
                        numCards++;
                    } else {
                        quit = cardOwner;
                    }
                }
                break;
            case 3:
                initialize = false;
                if (numCards != 0) {
                    for (int i = 0; i < cards.length && cards[i] != null;
                        i++) {
                        balance += cards[i].getBalance();
                    }
                }
                break;
            default:
                System.out.println("Incorrect input!");
            }
        }
        if (numCards == 0) {
            wallet = new Wallet(owner, password);
        } else {
            wallet = new Wallet(owner, password, cards);
        }

        cards = new Card[10];
        numCards = 0;

        System.out.println("\nYour wallet has been created!\n");

        boolean run = true;
        while (run) {
            System.out.println("What would you like to do?");
            System.out.println("1: Add Cards");
            System.out.println("2: Make a Purchase");
            System.out.println("3: Check Wallet");
            System.out.println("4: Quit");

            int input = Integer.parseInt(scandalous.nextLine());
            System.out.println();
            switch (input) {
            case 1:
                String quit = "";
                System.out.println("Please note that there is a "
                    + "maximum of 10 cards (debit and credit combined) "
                    + "allowed per wallet.");
                while (!quit.equalsIgnoreCase("q")
                    && numCards < cards.length) {
                    System.out.println("Please enter the name of the owner"
                        + " of the next card or \"q\" to quit.");
                    String cardOwner = scandalous.nextLine();
                    if (!cardOwner.equalsIgnoreCase("q")) {
                        System.out.println("Please enter the card "
                            + "number.");
                        int cardNumber = Integer.parseInt(
                            scandalous.nextLine());
                        System.out.println("Would you like to give the "
                            + "card a name? (Press enter to skip)");
                        String cardName = scandalous.nextLine();
                        if (cardName.length() == 0) {
                            cardName = "" + cardNumber;
                        }
                        boolean valid = false;
                        while (!valid) {
                            System.out.println("Is the card debit or "
                                + "credit?");
                            String cardType = scandalous.nextLine();
                            if (cardType.equalsIgnoreCase("debit")
                                || cardType.equalsIgnoreCase("credit")) {
                                isCredit = cardType.equalsIgnoreCase(
                                    "credit");
                                valid = true;
                            }
                        }
                        String bal;
                        if (isCredit) {
                            bal = "1";
                            while (bal.length() != 0
                                && Double.parseDouble(bal) > 0) {
                                System.out.println("Would you like to give"
                                    + " the credit card a balance? It can "
                                    + "not be a positive value. (Press "
                                    + "enter to skip)");
                                bal = scandalous.nextLine();
                            }
                        } else {
                            bal = "-1";
                            while (bal.length() != 0
                                && Double.parseDouble(bal) < 0) {
                                System.out.println("Would you like to give"
                                    + " the debit card a balance? It can "
                                    + "not be a negative value. (Press "
                                    + "enter to skip)");
                                bal = scandalous.nextLine();
                            }
                        }
                        if (bal.length() == 0) {
                            cards[numCards] = new Card(cardNumber,
                                cardName, cardOwner, isCredit, 0);
                        } else {
                            cards[numCards] = new Card(cardNumber,
                                cardName, cardOwner, isCredit,
                                Double.parseDouble(bal));
                        }
                        numCards++;
                    } else {
                        quit = cardOwner;
                        wallet.add(cards);
                        cards = new Card[10];
                        numCards = 0;
                    }
                }
                break;
            case 2:
                System.out.println("How much does your purchase cost?");
                double price = Double.parseDouble(scandalous.nextLine());
                if (price > 0) {
                    System.out.println("Which card would you like to "
                        + "pay with?");
                    String selectedCard = scandalous.nextLine();
                    wallet.buy(price, selectedCard);
                } else {
                    System.out.println("Sorry, the price must be "
                        + "positive.");
                }
                break;
            case 3:
                System.out.println(wallet.toString());
                break;
            case 4:
                run = false;
                break;
            default:
                System.out.println("Incorrect Input!");
            }
        }
    }
}