package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import game.objects.Maze;
import gui.Game;

public class Reviewer {
    private final List<String> instructions = new ArrayList<>();

    private Maze maze;

    public Reviewer(Game game, File reviewFile) {
        try {
            Scanner scanner = new Scanner(reviewFile);
            List<File> maps = game.getMapFiles();
            String filename = scanner.nextLine();
            Optional<File> mapResult = maps.stream().filter(map -> map.getName().equals(filename)).findFirst();

            

            if (!mapResult.isPresent()) {
                scanner.close();
                throw new FileNotFoundException("Unknown map name");
            }


            MazeConfigure cfg = new MazeConfigure(mapResult.get());
            this.maze = cfg.getMaze();

            scanner.forEachRemaining(instructions::add);
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        
    }

    public List<String> getInstructions() {
        return new ArrayList<>(this.instructions);
    }

    public Maze getMaze() {
        return this.maze;
    }
}
