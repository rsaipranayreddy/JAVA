import java.util.Scanner;
class student{
    String usn,name;
    int n;
    int[] credits;
    int[] marks;
    Scanner obj=new Scanner(System.in);
    void acceptdetails(){
        System.out.println("Enter name of student:");
        name=obj.nextLine();
        System.out.println("Enter USN of student:");
        usn=obj.nextLine();
        System.out.print("Enter the number of subjects:");
        n=obj.nextInt();

        credits=new int[n];
        marks=new int[n];
        for (int i=0;i<n;i++){
            System.out.println("Enter credits and marks for subject "+(i+1));
            credits[i]=obj.nextInt();
            marks[i]=obj.nextInt();
        }
    }
    double calcsgpa(){
        int totalcredits=0;
        int totalpoints=0;

        for(int i=0;i<n;i++){
            int gradepoint=getGradepoints(marks[i]);
            totalpoints=totalpoints+gradepoint*credits[i];
            totalcredits=totalcredits+credits[i];
        }
        if (totalcredits==0) {
            return 0.0;
        }
        else {
            return (double) totalpoints/totalcredits;
        }
    }
    int getGradepoints(int marks){
            if (marks>=90) return 10;
            else if(marks>=80) return 9;
            else if(marks>=70) return 8;
            else if(marks>=60) return 7;
            else if(marks>=50) return 6;
            else if(marks>=40) return 5;
            else return 0;
    }
    void displaydetails(){
        System.out.println("Name:"+name);
        System.out.println("usn:"+usn);

        for (int i=0;i<n;i++){
            System.out.println("subject:"+(i+1)+" credits:"+credits[i]+" marks:"+marks[i]+" gradepoints:"+getGradepoints(marks[i]));
        }
        double sgpa = calcsgpa();
        System.out.println("SGPA:"+sgpa);
    }
}


public class studentSGPAcalc {
    public static void main(String[] args){
        student s=new student();
        s.acceptdetails();
        s.displaydetails();
    }
    
}
