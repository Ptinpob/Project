import java.util.Scanner;

public class Project_get_data {
    static String[][] table = new String[370][60];
    static int date = 0,date_pre = 0;
    static int month = 0;
    static int input = 0;
    static String work = "";
    static Boolean home = true;
    static Scanner sc = new Scanner(System.in);


    static void get_dm(){
        System.out.print("Date: ");
        date = sc.nextInt();
        System.out.print("Month: ");
        month = sc.nextInt();
    }

    static void edit(int ed){
        show_assign(ed);
        System.out.print("Your assignment that you want to edit : ");
        int idx = sc.nextInt();
        sc.nextLine();
        System.out.print("text edit: ");
        String text = sc.nextLine();
        table[ed][idx] = text;
    }

    static void get_date(){
        for(int i = 1;i<month;i++){
            if(i == 1 || i == 3 || i == 5 || i == 7||i==8||i==10){
                date += 31;
            }else if(i==2){
                date += 28;
            }else{
                date+=30;
            }
        }
    }
    public static void get_assign(String work){
        for(int i = 0;i<=59;i++){
            if(table[date][i] == null){
                table[date][i] = work;
                break;
            }
        }
    }

    public static void show_assign(int index){
        for(int i = 1;i<=59;i++){
            if(table[index][1] == null){
                System.out.println("You don't have assignment");
            }
            if(table[index][i] == null)
                break;
            else{
                System.out.println(i + "." + table[index][i]);
            }
        }
    }
    public static void main(String[] args) {
        while(home){
            for(int i = 1;i<=21;i++){
                if(i!=10)System.out.print("-");
                else System.out.print("Your schedule");
            }
            System.out.println("");
            System.out.println("Add assign press 1");
            System.out.println("Edit assign press 2");
            System.out.println("Show assign press 3");
            for(int i = 1;i<=33;i++){
                System.out.print("-");
            } 
            System.out.println("");
            System.out.print("Select: ");
            input = sc.nextInt();
            home = false;
            if(input == 1){
                while(true){
                    get_dm();
                    get_date();
                    while(true){
                        String ch = "end";
                        work = sc.nextLine();
                        if(work.equals(ch)!=true){
                            get_assign(work);
                        }else{
                            break;
                        }
                    }
                    show_assign(date);
                    String ans = "";
                    String che = "Yes";
                    System.out.println("You want to end this(Yes / No) : ");
                    ans = sc.nextLine();
                    if(ans.equals(che)==true){
                        home = true;
                        break;
                    } 
                }
            }else if(input == 2){
                while(true){
                    get_dm();
                    get_date();
                    edit(date);
                    sc.nextLine();
                    String ans = "";
                    String che = "Yes";
                    System.out.println("You want to end this(Yes / No) : ");
                    ans = sc.nextLine();
                    if(ans.equals(che)==true){
                        home = true;
                        break;
                    } 
                }
            }else if(input == 3){
                while(true){
                    get_dm();
                    get_date();
                    sc.nextLine();
                    show_assign(date);
                    String ans = "";
                    String che = "Yes";
                    System.out.println("You want to end this(Yes / No) : ");
                    ans = sc.nextLine();
                    if(ans.equals(che)==true){
                        home = true;
                        break;
                    } 
                }
            }else{
                return;
            }
        }
        sc.close();
    }
}
