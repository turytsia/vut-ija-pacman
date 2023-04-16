package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import exceptions.HeaderNotFoundException;
import exceptions.InvalidRowException;
import game.objects.Maze;
import game.view.MazeView;



public class MazeConfigure {
    private int cols;
    private int rows;
    private Maze maze;

    public MazeConfigure(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);

            if (processHeader(reader.nextLine())) {
                reader.close();
                throw new HeaderNotFoundException("Header is not valid");
            }

            maze = new Maze(cols, rows);

            while (reader.hasNextLine()) {
                processLine(reader.nextLine());
            }

            reader.close();
        } catch (HeaderNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Maze getMaze(){
        return this.maze;
    }

    private void processLine(String line) {
        try {
            if (line.length() != cols)
                throw new InvalidRowException("Row has too much columns");

            maze.parseLine(line);
        } catch (InvalidRowException e) {
            e.printStackTrace();
        }

    }
    
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
