package pe.edu.upeu.claseinterna;

public class claseExterna {
    int a,b;


    class interna1{
        double r;

        double sumar(){
            r =a+b;
            return r;
        }
    }


    class interna2{
        double r;

        double restar(){
            r= a-b;
            return r;
        }

    }

}




class externa2{
    public static void main(String[] args) {
        claseExterna ce =new claseExterna();
        ce.a=10;
        ce.b=25;

        claseExterna.interna1 ci1 = ce.new interna1();
        System.out.println(ci1.sumar());
        claseExterna.interna2 ci2 = ce.new interna2();
        ci2.restar();
        System.out.println(ci2.r);
    }
}
