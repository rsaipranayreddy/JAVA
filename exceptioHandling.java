import java.util.Scanner;


class Father {
    int fatherAge;
    Father(int fatherAge){
        this.fatherAge=fatherAge;
        try {
            if(fatherAge<0){
                throw new IllegalArgumentException("wrongAge"+" :Father Age cannot be less than 0");
            }
            System.out.println("Father Age: "+fatherAge);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }       
    }
}

class Son extends Father{
    int sonAge;
    Son(int fatherAge,int sonAge){
        super(fatherAge);
        this.sonAge=sonAge;
        try {
            if (sonAge>=fatherAge){
                throw new IllegalArgumentException("wrongAge"+" :Son Age cannot Exceed Father Age");
            }
            System.out.println("Son Age: "+sonAge);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class exceptioHandling {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int fatherAge,sonAge;
        System.out.println("Enter Father and Son Age: ");
        fatherAge=obj.nextInt();
        sonAge=obj.nextInt();
        // Father f=new Father(fatherAge);
        Son s=new Son(fatherAge, sonAge);
        obj.close();
    }
}
