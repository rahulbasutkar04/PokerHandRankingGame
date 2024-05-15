# Poker Hand Evaluation

## Initial Design Analysis

### HandController
- `receiveHandCards()`: This method receives the hand of cards.

### HandRankController
- `getHandRank()`: This method calls the outer service to get the hand rank.

### OuterService

#### CardService
- `boolean getCards(List<String> cards)`:
    - Performs structural validations and checks the count of cards.
    - Passes the validated cards to the inner service for further validation.
    - If valid, sends the cards back to the outer service to be stored in the repository.

- `String getHandRanking()`:
    - Calls the inner service to get the hand rank.

### Domain

#### Model
- `Rank`: Enum representing the rank of a card.
- `Suit`: Enum representing the suit of a card.
- `Card`: Class representing a card with a rank and suit.

### InnerService

- `UserHand(List<String> cards)`:
    - Stores the five cards in the card repository.
    - Calls the validator class before storing.

- `boolean cardParser(String card)`: Parses individual cards for validation.

- `String getHandRank(List<String> cards)`: Returns the hand rank. (Implemented as an interface)

### Repository

- `HandRepository`: Repository where the five cards are stored.

## Usage
- The `HandController` is responsible for receiving the hand of cards.
- The `HandRankController` interacts with the `OuterService` to get the hand rank.
- The `OuterService` performs initial validations and interacts with the `InnerService`.
- The `InnerService` handles detailed validation, parsing, and storing of the cards.
- The `Domain` models the structure of cards, ranks, and suits.
- The `Repository` is used for storing the validated hand of cards.

