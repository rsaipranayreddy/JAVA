import java.util.Scanner;
import java.lang.Math;

abstract class shape{
    int a,b;
    shape (int a,int b){
        this.a=a;
        this.b=b;
    }
    shape (int a){
        this.a=a;
    }
    abstract void printArea();
}

class rectangle extends shape{

    rectangle(int a,int b){
        super(a,b);
    }
    void printArea(){
        System.out.println("Area of Rectangle : "+(a*b));
    }
}
class triangle extends shape{
    triangle(int a,int b){
        super(a,b);
    }
    void printArea(){
        System.out.println("Area of Triangle : "+(0.5*a*b));
    }
}
class circle extends shape{
    circle(int a){
        super(a);
    }
    void printArea(){
        System.out.println("Area of circle : "+(Math.PI*a*a));
    }
}

class printArea{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        System.out.println("1.rectangle\n2.triangle\n3.circle");
        System.out.print("Enter the shape:");
        int choice=obj.nextInt();
        int a,b;
        if (choice==1){
            System.out.print("Enter length and bredth of rectangle:");
            a=obj.nextInt();
            b=obj.nextInt();
            
            rectangle r=new rectangle(a,b);
            r.printArea();
        }
        else if (choice==2){
            System.out.print("Enter bredth and height of triangle:");
            a=obj.nextInt();
            b=obj.nextInt();
            
            triangle t=new triangle(a,b);
            t.printArea();
        }
        else if (choice==3){
            System.out.print("Enter radius of cicle:");
            a=obj.nextInt();
            circle c=new circle(a);
            c.printArea();
        }
        else{
            System.out.println("Invalid Choice!");
        }
    }
}