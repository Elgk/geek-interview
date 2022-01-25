package ru.geekbrains.algorithm;

import java.util.Iterator;
import java.util.Random;

public class IterableExsample {

    static class RandomIterable implements Iterable<Integer>{
        private int count;

        public RandomIterable(int count) {
            this.count = count;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int current = 0;
                Random random = new Random();
                @Override
                public boolean hasNext() {
                    return current < count;
                }

                @Override
                public Integer next() {
                    current ++;
                    return random.nextInt();
                }
            };
        }
    }
}
