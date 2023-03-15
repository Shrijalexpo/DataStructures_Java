import java.util.Scanner;

class node{
    int data;
    node link;
    node(){
        data = 0;
        link = null;
    }
    void create(){
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first data: ");
        this.data = sc.nextInt();
        System.out.println("enter no. of nodes to be created: ");
        n = sc.nextInt();
        node temp;
        node ptr = this;
        for (int i = 0; i < n; i++) {
            temp = new node();
            System.out.println();
            temp.data = sc.nextInt();
            temp.link = null;
            ptr.link = temp;
            temp = null;
            ptr = ptr.link;
        }
    }

    void insertbeg(node start, int x){
        node temp = new node();
        temp.data = x;
        temp.link= null;
        temp.link = start;
        start = temp;
        temp = null;
    }

    void insertmid(node start, int x, int n){
        node temp = new node();
        temp.data = x;
        temp.link = null;
        node ptr = start;
        int count = 1;
        while (count < n){
            ptr = ptr.link;
            count++;
        }
        temp.link = ptr.link;
        ptr.link = temp;
    }

    void insertend(node start, int x){
        node temp = new node();
        temp.data  = x;
        temp.link = null;
        node ptr = start;
        while (ptr.link != null){
            ptr = ptr.link;
        }
        ptr.link = temp;
        temp = ptr = null;
    }

    void delete(node start, int n){
        node ptr = start;
        node ptr1 = ptr;
        int count = 1;
        while (count < n){
            ptr1 = ptr;
            ptr = ptr.link;
            count++;
        }
        ptr1.link = ptr.link;
        ptr.link = null;
        ptr = ptr1 = null;
    }
    void  display(){
        node ptr = this;
        while (ptr!= null){
            System.out.println(ptr.data);
            ptr = ptr.link;
        }
    }
}

class xyz{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        node first = new node();
        int ch,k,p;
        do {
            System.out.println("1.Create a linked list structure" +
                    "\n2.Insert a list in the biginning" +
                    "\n3.Insert a list at the end" +
                    "\n4.Insert a list at middle" +
                    "\n5.Delete a list" +
                    "\n6.Display the list" +
                    "\n7.Exit");
            System.out.println("Enter your Choice");
            ch = sc.nextInt();
            switch (ch){
                case 1:
                    first.create();
                    break;

                case 2:
                    System.out.println("enter data for new node");
                    k = sc.nextInt();
                    first.insertbeg(first,k);
                    break;
                case 3:
                    System.out.println("enter data for new node");
                    k = sc.nextInt();
                    first.insertend(first,k);
                    break;
                case 4:
                    System.out.println("enter data for new node");
                    k = sc.nextInt();
                    System.out.println("Enter node number after which node to be inserted");
                    p = sc.nextInt();
                    first.insertmid(first,k,p);
                    break;
                case 5:
                    System.out.println("Enter node to be deleted");
                    k = sc.nextInt();
                    first.delete(first,k);
                    break;
                case 6:
                    System.out.println("Data are:");
                    first.display();
            }
        }
        while (ch != 7);
    }
}