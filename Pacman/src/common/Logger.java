package common;

import game.common.CommonField;
import game.objects.GhostObject;
import game.objects.Maze;
import game.objects.MazeObject;
import game.objects.PacmanObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private MazeObject obj;
    private Maze maze;
    private static boolean isFileHeader = false;
    private static boolean isFileLogs = false;
    private static List<String> logs = new ArrayList<>();

    public Logger(MazeObject obj) {
        this.obj = obj;
        this.maze = obj.getField().getMaze();
    }

    public void log(CommonField.Direction dir) {

        if (this.obj instanceof PacmanObject) {
            logs.add("PACMAN " + dir);
        } else if (this.obj instanceof GhostObject) {
            logs.add("GHOST" + obj.getId() + " " + dir);
        }
    }

    public void print_logs(String fileName) {
        if (!isFileLogs) {
            
            logs.add(0, fileName);
            isFileHeader = true;

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("-yyyy-MM-dd-HH-mm-ss-");
            String formattedDateTime = now.format(formatter);

            File file = new File("data/replays/replay" + formattedDateTime + this.maze.getMazeFile().getName());
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (String str : logs) {
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logs_clear() {
        isFileLogs = false;
        isFileHeader = false;
        logs.clear();
    }
}
