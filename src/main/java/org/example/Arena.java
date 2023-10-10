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

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(new Position(0, 0)); // Initialize hero at position (0, 0)
    }

    public void processKey(KeyStroke key) {
        // You can implement the key processing logic here
        // For example, updating the hero's position based on the key
    }

    public void draw(Screen screen) throws IOException {
        screen.clear();
        // Draw the arena and hero on the screen
        // You can add your drawing logic here
        // For example, screen.drawArena(this);
        // and screen.drawHero(hero);
        screen.refresh();
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position) {
        // Check if the new position is inside the Arena boundaries
        return position.getX() >= 0 && position.getX() < width &&
                position.getY() >= 0 && position.getY() < height;
    }
}
