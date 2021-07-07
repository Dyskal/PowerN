package view;

import javax.swing.JFrame;

/**
 * Current management of a frame
 */
public class SimpleFrame extends JFrame {

    public SimpleFrame() {
        this.setSize(400,400);
        this.setLocation(200,200);
        // quitte l'application quand on ferme la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Makes the frame visible.
     */
    public void showIt(){
        this.setVisible(true);
    }

    /**
     * Makes the frame visible and sets the title text.
     *
     * @param title the title of th frame
     */
    public void showIt(String title){
        this.setTitle(title);
        this.setVisible(true);
    }

    /**
     * Makes the frame visible and sets the title text
     * and the position of the window.
     *
     * @param title title of the frame
     * @param x x position of the origin
     * @param y y position of the origin
     */
    public void showIt(String title,int x, int y){
        this.setTitle(title);
        this.setLocation(x,y);
        this.setVisible(true);
    }

    /**
     * Makes the frame invisible.
     */
    public void hideIt(){
        this.setVisible(false);
    }
}
