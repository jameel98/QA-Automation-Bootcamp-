package createAndDestroyObjects.java;

import java.util.List;
import java.util.Random;

public class NameGenerator {
        private List<String> nameDictionary;
        private Random random;

        public NameGenerator(List<String> nameDictionary) {
            this.nameDictionary = nameDictionary;
            this.random = new Random();
        }

        public String generateRandomName() {
            int index = random.nextInt(nameDictionary.size());
            return nameDictionary.get(index);
        }

}
