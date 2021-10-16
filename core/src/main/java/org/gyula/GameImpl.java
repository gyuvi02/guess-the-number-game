package org.gyula;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game{

    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;
    private final int guessCount;
    private int number;

    @Setter
    private int guess;

    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean isValidNumberRange = true;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    //    @Autowired
//    public GameImpl(NumberGenerator numberGenerator, int guessCount, int number, int guess, int smallest, int biggest, int remainingGuesses, boolean isValidNumberRange) {
//        this.numberGenerator = numberGenerator;
//        this.guessCount = guessCount;
//        this.number = number;
//        this.guess = guess;
//        this.smallest = smallest;
//        this.biggest = biggest;
//        this.remainingGuesses = remainingGuesses;
//        this.isValidNumberRange = isValidNumberRange;
//    }

    // init
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        log.debug("the number is = {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy");
    }

    //public methods
//    public void setNumberGenerator(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

    //at the beginning of the game we call this to have the number and other stuff


    @Override
    public void check() {
        checkValidNumberRange();

        if (isValidNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;

    }


    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        isValidNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
