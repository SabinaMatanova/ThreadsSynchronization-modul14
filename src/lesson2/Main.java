package lesson2;

public class Main {


    public static void main(String[] args) throws InterruptedException {
/*
Make class Typer which will type it's Message
symbol by symbol every 500ms
*/

/* This code has to print
Message first. Message second.
in 15 seconds
*/
        new Typer("Message first. ").start();
        new Typer("Message second.").start();


    }

}
