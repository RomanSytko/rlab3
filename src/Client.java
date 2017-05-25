/**
 * Created by Ольга on 27.03.2017.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    private Client() {}
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
// Получаем стаб регистратора с хоста, определенного в командной строке
// если в командной строке хост не указывается, то он считается как localhost
            Registry registry = LocateRegistry.getRegistry(host);
// получаем стаб удаленного объекта от регистратора сервера
            Year stub = (Year) registry.lookup("year");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter year: ");
            int year = Integer.parseInt(br.readLine());
            String response = stub.whatYear(year);
            System.out.println("year: " + response);
        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

