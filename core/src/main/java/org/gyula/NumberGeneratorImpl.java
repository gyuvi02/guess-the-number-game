package org.gyula;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    private final Random random = new Random();

    @Getter
    private final int maxNumber;
    @Getter
    private final int minNumber;

    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return random.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }
}
