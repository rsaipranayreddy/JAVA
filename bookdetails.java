import java.util.Scanner;

class book{
    String name;
    String author;
    double price;
    int num_pages;

    public book(String name,String author,double price,int num_pages){
        this.name=name;
        this.author=author;
        this.price=price;
        this.num_pages=num_pages;
    }

    public String toString() {
        return "Book Name: " + name + "\nAuthor: " + author + "\nPrice: Rs " + price + "\nPages: " + num_pages;
    }

}


public class bookdetails {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter number of books:");
        int n = obj.nextInt();
        
        book[] books = new book[n];
        
        for (int i=0;i<n;i++){
            obj.nextLine();
            System.out.println("Enter details for book:"+(i+1));
            System.out.print("Name: ");
            String name = obj.nextLine();
            
            System.out.print("Author: ");
            String author = obj.nextLine();

            System.out.print("Price: ");
            double price = obj.nextDouble();

            System.out.print("Number of Pages: ");
            int num_pages = obj.nextInt();

            books[i] = new book(name, author, price, num_pages);
        }

        System.out.println("\nBook Details:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nBook " + (i + 1) + ":\n" + books[i].toString());
        }

        obj.close();
    }
}