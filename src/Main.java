import decorator.View;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new View();
                }
            });
    }
}