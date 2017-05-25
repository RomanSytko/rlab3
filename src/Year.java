/**
 * Created by Ольга on 27.03.2017.
 */
import java.rmi.Remote;

public interface Year extends Remote  {
    String whatYear(int year) throws  Exception;
}