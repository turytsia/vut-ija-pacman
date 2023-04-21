package gui.views;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import gui.Game;
import gui.components.Background;
import gui.components.Button;

public class MainView extends View {

    public MainView(Game game) {
        super(game);
        LayoutManager gridLayout = new GridLayout(4, 1);
        JPanel buttonContainer = new JPanel(gridLayout);
        buttonContainer.setBounds(config.getWidth() - 20 - 200 - 16, 20, 200, 4 * 50);
        buttonContainer.setOpaque(false);

        Button buttonStart = new Button("Start");
        Button buttonLoad = new Button("Load");
        Button buttonSettings = new Button("Settings");
        Button buttonExit = new Button("Exit");

        buttonStart.addActionListener(e -> {
            game.pushView(new StartGameView(game));
        });

        buttonLoad.addActionListener(e -> {
            game.pushView(new LoadGameView(game));
        });

        buttons.add(buttonStart);
        buttons.add(buttonLoad);
        buttons.add(buttonSettings);
        buttons.add(buttonExit);

        for (Button button : buttons) {
            buttonContainer.add(button);
        }

        buttons.get(activeButton).setSelect(true);

        add(buttonContainer);
        add(new Background("data/assets/sprites/menu/bg-menu.jpg"));
    }

    @Override
    protected void KeyArrowLeft() {
    }

    @Override
    protected void KeyArrowUp() {
        selectPrevButton();
        game.update();
    }

    @Override
    protected void KeyArrowRight() {
    }

    @Override
    protected void KeyArrowDown() {
        selectNextButton();
        game.update();
    }

    @Override
    protected void KeyEscape() {
    }

    @Override
    protected void KeyEnter() {
        buttons.get(activeButton).doClick();
    }

    @Override
    protected void AnyKey(){}
}
