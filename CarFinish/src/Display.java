import javax.swing.JFrame;

public class Display {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CarFinish");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.setUndecorated(true);
          frame.setSize(650,620);
          frame.setResizable(false);

        frame.add(new Main(frame));
        frame.setVisible(true);
    }

}