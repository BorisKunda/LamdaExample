package com.happytrees.lamdaexample;

public class LambdaDemo {

    interface Printer {
        void print(String val);
    }
    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

}
