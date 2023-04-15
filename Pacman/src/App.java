import menu.Menu;
import menu.Views.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        new Menu(new MainView()); //create menu
    }
}
