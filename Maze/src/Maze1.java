import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze1 {

    private int rows;
    private int columns;
    private char[][] maze;

    private char treasure = 'E';
    private char wall_1 = '+';
    private char wall_2 = '-';
    private char wall_3 = '|';

    public Maze1() {

    }
    
    

    public int getRows() {
		return rows;
	}



	public int getColumns() {
		return columns;
	}



	public char[][] getMaze() {
		return maze;
	}



	public void setRows(int rows) {
		this.rows = rows;
	}



	public void setColumns(int columns) {
		this.columns = columns;
	}



	public void setMaze(char[][] maze) {
		this.maze = maze;
	}



	public char getTreasure() {
		return treasure;
	}



	public char getWall_1() {
		return wall_1;
	}



	public char getWall_2() {
		return wall_2;
	}



	public char getWall_3() {
		return wall_3;
	}



	public void setTreasure(char treasure) {
		this.treasure = treasure;
	}



	public void setWall_1(char wall_1) {
		this.wall_1 = wall_1;
	}



	public void setWall_2(char wall_2) {
		this.wall_2 = wall_2;
	}



	public void setWall_3(char wall_3) {
		this.wall_3 = wall_3;
	}



	public char[][] buildMaze(String fileName) {
      //  fileName = "C:\\Users\\user\\Downloads\\maze1.txt";
        try (Scanner scan = new Scanner(new File(fileName))) {
            List<char[]> charList = new ArrayList<>();

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                charList.add(line.toCharArray());
                columns = line.length();
                rows++;
            }
            this.maze = new char[rows][columns];

            for (int i = 0; i < rows; i++) {
                maze[i] = charList.get(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions
        }
        
        return this.maze;
    }

    public void printMaze() {
        if (maze == null || maze.length == 0) {
            System.out.println("Maze not initialized properly.");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return rows * columns;
    }
}
