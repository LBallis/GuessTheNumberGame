package gr.ballis;

public interface Game {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    int getGuessCount();

    void reset();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

    void check();
}
