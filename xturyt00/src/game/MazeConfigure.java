package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import exceptions.HeaderNotFoundException;
import exceptions.InvalidRowException;
import game.objects.Maze;

/**
 * A class that can build up a maze out of the file.
 * It contains method in order to parse map file.
 * 
 * @author Turtysia Oleksandr (xturyt00)
 * @version %I%, %G%
 */
public class MazeConfigure {
    private int cols;
    private int rows;
    private Maze maze;

    public MazeConfigure(File file, boolean isReview) {
        try {
            Scanner reader = new Scanner(file);

            if (processHeader(reader.nextLine())) {
                reader.close();
                throw new HeaderNotFoundException("Header is not valid");
            }

            maze = new Maze(cols, rows, file, isReview);

            while (reader.hasNextLine()) {
                processLine(reader.nextLine());
            }

            reader.close();
        } catch (HeaderNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns resulting maze
     * 
     * @return maze
     */
    public Maze getMaze() {
        return this.maze;
    }

    /**
     * Process one of the lines in maze file
     * 
     * @param line line from the maze file
     */
    private void processLine(String line) {
        try {
            if (line.length() != cols)
                throw new InvalidRowException("Row has too much columns");

            maze.parseLine(line);
        } catch (InvalidRowException e) {
            e.printStackTrace();
        }

    }

    /**
     * Processes very first line of the maze file
     * 
     * @param line very first line of the maze file
     * @return true if it parsed well, otherwise false
     */
    private boolean processHeader(String line) {
        Pattern headerPattern = Pattern.compile("^\\d.*\\d$");

        boolean isHeader = headerPattern.matcher(line).find();

        if (!isHeader) {
            return true;
        }

        String[] lineArray = line.split("\s");

        rows = Integer.parseInt(lineArray[0]);
        cols = Integer.parseInt(lineArray[1]);

        return false;
    }
}
