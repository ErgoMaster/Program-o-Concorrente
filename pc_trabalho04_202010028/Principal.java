import Model.Variavel;
import Model.Thread1;
import Model.Thread2;

public class Principal {
    public static void main(String[] args) {
        Variavel.setX(1);
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
        
        try { 
            t1.join();
            t2.join(); 
        } 
        catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(Variavel.getX());
    }
}