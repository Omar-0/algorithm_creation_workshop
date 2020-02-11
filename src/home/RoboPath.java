package home;


import javafx.util.Pair;

import java.util.Stack;

public class RoboPath {

    static Stack<Pair<Integer, Integer>> path = new Stack<>();
    static int goalX;
    static int goalY;
    static Character[][] grid;

    public void step( int x, int y){



        if( x != goalX && y != goalY){

            boolean openX = false;
            boolean openY = false;

            if(grid[x+1][ y] != 'T' ){
                path.push(new Pair<>(x+1, y));
                step(x+1, y);
                step(x, y+1);
                openX = true;
            }

            if(grid[x][y+1] != 'T' ){
                path.push(new Pair<>(x, y+1));
                step(x, y+1);
                step(x+1, y);
                openY = true;
            }

            if(!(openX && openY)) return;
        }else return;
    }


    public static void main(String... args){

        grid = new Character[][]{
                {'S', 'o', 'o'},
                {'o', 'T', 'o'},
                {'o', 'o', 'G'}
        };

        goalX = 2;
        goalY = 2;

        new RoboPath().step(0,0);
        System.out.println(path);
    }

}
