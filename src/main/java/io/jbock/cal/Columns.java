package io.jbock.cal;

import java.util.List;

class Columns {

    static void print(List<String> words) {
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            String word = words.get((i * 8 + (i / 3)) % 24);
            System.out.print(word + "  ");
            count++;
            if (count % 3 == 0) {
                System.out.println();
            }
        }
        System.out.flush();
    }
}
