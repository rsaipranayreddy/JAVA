import java.util.Scanner;
public class quad{
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        double a,b,c,r1,r2,rp,ip;
        System.out.print("Enter 1st Coeficient:");
        a=obj.nextDouble();
        System.out.print("Enter 2nd Coeficient:");
        b=obj.nextDouble();
        System.out.print("Enter 3rd Coeficient:");
        c=obj.nextDouble();
        double d=(b*b)-(4*a*c);
        if (a==0)
            System.out.println("This is not a quadratic equation");
        else if(d==0){
            r1 = -(b/(2*a));
            System.out.println("Roots are equal and is "+r1);
        }
        else if(d>0){
            r1=-(b/(2*a));
            r2=(Math.sqrt(d))/(2*a);
            System.out.println("Roots are real and are \nRoot 1="+(r1+r2)+"\nRoot 2="+(r1-r2));
        }
        else{
            rp=-(b/(2*a));
            ip= ((4*a*c)-(b*b))/(2*a);
            System.out.println("Roots are imaginary and are \nRoot 1= "+rp+"+i"+ip+"\nRoot 2 ="+rp+"-i"+ip);
        }
    }
}
