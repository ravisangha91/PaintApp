package paintapp;

public class PaintApp {

    public static void main(String[] args) {
        PaintSplash ps = new PaintSplash();
        ps.iterate();
        PaintWindow pw = new PaintWindow();
        ps.dispose();
    }
}
