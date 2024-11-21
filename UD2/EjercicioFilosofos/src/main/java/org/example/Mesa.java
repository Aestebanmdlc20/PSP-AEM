package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private List<Object> tenedores;

    public Mesa() {
        tenedores = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tenedores.add(new Object());
        }
    }

    public Object getTenedor(int index) {
        return tenedores.get(index);
    }
}