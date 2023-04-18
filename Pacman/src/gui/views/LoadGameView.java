package gui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import gui.Game;
import gui.components.Button;
import gui.components.Label;

public class LoadGameView extends View {

    private int pageIndex;
    private JPanel asidePanel = new JPanel();

    JPanel gameList;

    public LoadGameView(Game game) {
        super("Load game", game);

        setBackground(Color.BLACK);

        JPanel listFooter = new JPanel();
        gameList = new JPanel(new GridLayout(8, 1));

        gameList.setOpaque(false);
        listFooter.setOpaque(false);

        container.add(gameList);
        add(listFooter, BorderLayout.SOUTH);

        List<File> files = config.getFiles("data/replays");

        //meta data
        // asidePanel.setPreferredSize(new Dimension(config.getWidth() / 4, container.getHeight()));

        // add(asidePanel, BorderLayout.EAST);

        try {

            for (File file : files) {

                BasicFileAttributes attr = Files.readAttributes(Path.of(file.getPath()), BasicFileAttributes.class);

                Button fileInfoButton = new Button(file.getName());
                Label dateText = new Label(attr.creationTime().toString());
                Label scoreText = new Label("Score: 0");
                Label isWinnerText = new Label("Winner: No");
                
            
                fileInfoButton.setLayout(new BorderLayout(10, 10));
                System.out.println(container.getX());
                fileInfoButton.setPreferredSize(new Dimension( 200, 50));
                fileInfoButton.setOpaque(false);



                // scoreText.setPreferredSize(new Dimension(20, 20));


                // fileInfoButton.add(new Label("Map01.txt"), BorderLayout.NORTH);
                // fileInfoButton.add(dateText, BorderLayout.WEST);
                // fileInfoButton.add(scoreText, BorderLayout.CENTER);
                // fileInfoButton.add(isWinnerText, BorderLayout.EAST);

                gameList.add(fileInfoButton);
                buttons.add(fileInfoButton);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttons.get(activeButton).setSelect(true);

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
        game.popView();
    }

    @Override
    protected void KeyEnter() {
    }

    @Override
    protected void AnyKey() {
    }

}
