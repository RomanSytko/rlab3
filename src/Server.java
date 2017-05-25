/**
 * Created by Ольга on 27.03.2017.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Year {

    public Server() {}
 @Override
    public String whatYear(int year) throws Exception{
        String response = "";

     if ((year % 4) == 0 )
     {
         if (year <400 && year!=100 && year != 200 && year !=300)

             response = "Високосный";
         else
         if ((year % 100) != 0 || (year% 400) == 0)

             response = "Високосный";
         else
         if ((year % 100) == 0 && !(((year % 400)) == 0))

             response = "Невисокосный";
     }

     else response = "Невисокосный";


     return response;
 }
    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(1099);
            System.err.println("java RMI registry created");
        } catch (RemoteException e) {
            System.err.println("java RMI registry already exists");
        }
        try {
// создаем и экспортируем удаленный объект
            Server obj = new Server();
            Year stub = (Year) UnicastRemoteObject.exportObject(obj, 0);
// Регистрируем удаленный объект в RMI-регистраторе под именем
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("year", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
