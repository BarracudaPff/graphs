import com.GraphControll;
import com.ReadControll;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ReadControll readControll = new ReadControll(new GraphControll());
        readControll.readData();
    }
}
