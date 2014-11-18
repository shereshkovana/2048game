package logic;
import decorator.View;

import javax.swing.*;
import java.util.Random;

public class Randoming {
    public static void randAppear() {
        int ind1_1 = randInt(Grid.SIZE);       //random indexes of row, col
        int ind1_2 = randInt(Grid.SIZE);
        int randArr1 = randInt(2);

        int ind2_1 = randInt(Grid.SIZE);       //random indexes of row, col
        int ind2_2 = randInt(Grid.SIZE);
        int randArr2 = randInt(10);

        while ((ind1_1 == ind2_1)&&(ind1_2 == ind2_2)){
            ind2_1 = randInt(Grid.SIZE);
            ind2_2 = randInt(Grid.SIZE);
            randArr2 = randInt(10);
        }

        for (int i=0; i< Grid.SIZE; i++) {                      //2 random points in cells
            for (int j=0; j< Grid.SIZE; j++) {
                if ((i == ind1_1)&&(j == ind1_2)) {
                    Grid.cells[ind1_1][ind1_2] = Grid.values[randArr1];
                }
                else if ((i == ind2_1)&&(j == ind2_2)) {
                    Grid.cells[ind2_1][ind2_2] = Grid.values[randArr2];
                }
            }
        }
    }

    public static void randAppear1() {

        int randArr1 = randInt(10);


        boolean flag = false;
        while (!flag) {
            int ind1_1 = randInt(Grid.SIZE);
            int ind1_2 = randInt(Grid.SIZE);
            if (Grid.cells[ind1_1][ind1_2] == 0) {
                flag = true;
                Grid.cells[ind1_1][ind1_2] = Grid.values[randArr1];
            }
        }
    }

    public static int randInt(int num){
        Random randomGen = new Random();
        return randomGen.nextInt(num);
    }
}
