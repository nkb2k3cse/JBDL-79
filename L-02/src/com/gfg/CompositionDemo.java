package com.gfg;

public class CompositionDemo {

    public static void main(String[] args) {
        Ubuntu os = new Ubuntu();
        os.ubuntuSpecificMethod();
        Keyboard keyboard = new DellKeyboard();

        Laptop laptop1 = new Laptop(os, keyboard);


        Laptop laptop2 = new Laptop(new Windows(), keyboard);
    }
}
