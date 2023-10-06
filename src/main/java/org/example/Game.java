package org.example;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {
    Terminal terminal;
    Hero hero;
    Screen screen;
    TerminalSize terminalSize ;
    public Game() throws IOException {
        hero = new Hero(10,10);
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminal = terminalFactory.createTerminal();
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary

    }
    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }
    public void run() throws IOException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }
    private void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.EOF) {
            return;
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }

        if (key.getKeyType() == KeyType.ArrowUp) {
            hero.moveUp();
        } else if (key.getKeyType() == KeyType.ArrowDown) {
            hero.moveDown();
        } else if (key.getKeyType() == KeyType.ArrowLeft) {
            hero.moveLeft();
        } else if (key.getKeyType() == KeyType.ArrowRight) {
            hero.moveRight();
        }
    }
}