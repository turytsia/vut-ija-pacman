package gui.views;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import gui.Game;
import gui.components.Background;
import gui.components.Button;

/**
 * This class represents default view for the
 * game when it first launched (menu interface)
 * 
 * @autor Oleksandr Turytsia (xturyt00)
 * @version %I%, %G%
 */
public class MainView extends View {

    /* PANELS */
    private final LayoutManager gridLayout = new GridLayout(3, 1);
    private final JPanel buttonContainer = new JPanel(gridLayout);

    /* BUTTONS */
    private final Button buttonStart = new Button("Start game");
    private final Button buttonLoad = new Button("Load replay");
    private final Button buttonExit = new Button("Exit");

    public MainView(Game game) {
        super(game);

        buttonContainer.setBounds(config.getWidth() - 20 - 200 - 16, 20, 200, 3 * 50);
        buttonContainer.setOpaque(false);

        buttonStart.addActionListener(e -> {
            game.pushView(new StartGameView(game));
        });

        buttonLoad.addActionListener(e -> {
            game.pushView(new LoadGameView(game));
        });

        buttonExit.addActionListener(e -> {
            game.dispose();
        });

        buttons.add(buttonStart);
        buttons.add(buttonLoad);
        buttons.add(buttonExit);

        for (Button button : buttons) {
            buttonContainer.add(button);
        }

        selectButton(activeButton);

        add(buttonContainer);
        add(new Background("lib/assets/sprites/menu/bg-menu.jpg"));
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
    protected void AnyKey() {
    }
}
