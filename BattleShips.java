import java.util.Scanner;

public class BattleShips {

static Scanner input = new Scanner(System.in);
static String[][] map1 = new String[10][10];
static String[][] map2 = new String[10][10];
public static void main(String[] args){
    System.out.println("**** Welcome to Battle Ships game ****\n");
    System.out.println("Right now, the ocean is empty.");
    map(map1);
    for (int i=0; i<10;i++){
        int x = (int)(Math.random()*10);
        int y= (int) (Math.random()*10);
        if(i==5){
            System.out.println("\nComputer is deploying ships:\n ");
        }
        if(i<5){
            System.out.print("Enter X coordinate for your ship: ");
            x =input.nextInt();
            System.out.print("Enter Y coordinate for your ship: ");
            y= input.nextInt();
        }


        if ((x<0 || x>=10) || (y<0 || y>=10) || map1[x][y]!=null || map2[x][y]!=null){
            System.out.println("Please enter different coordinates");
            i--;
        }
        else if(i<5){
            map1[x][y]="@";
            }

        else{
            map2[x][y]="@";
            System.out.println("Computer deployed");

        }
        if(i==4) {
            map(map1);
        }

    }
    System.out.println(battle(map1,map2));
}

public static void map(String[][] s){
    System.out.println("  0123456789");
    for(int i= 0;i<10;i++){
        System.out.print(i+"|");
        for (int j = 0; j < 10; j++) {
                if (s[i][j]==null){
            System.out.print(" ");}
                else {
                    System.out.print(s[i][j]);
                }
        }
        System.out.println("|"+i);}


    System.out.println("  0123456789");
}

public static String battle(String[][] map1, String[][] map2){
    String r="" ;
    int count1 = 5;
    int count2 = 5;
    while(count1!=0 || count2 !=0) {
        int x=0;
        int y=0;
        for (int i = 0; i < 10;i++) {
            if(i%2==0){
            System.out.println("\nYOUR TURN\n");
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter y coordinate: ");
            y = input.nextInt();
            if (x>=0 && x<10 && y>=0 && y<10 ){
                if (map1[x][y]!="@" && map2[x][y]!="@"){
                    System.out.println("you Missed");
                    map2[x][y]="x";
                    map1[x][y]="x";
                }
                else if (map1[x][y]=="@"){
                    map1[x][y]="!";
                    count1--;
                    System.out.println("Hit own ship");
                }
                else {
                    map2[x][y]="!";
                    count2--;
                    System.out.println("Boom!  Hit the enemy ship");
                    map1[x][y]="!";
                }}
            else {
                System.out.println("Please enter different coordinates");
                i--;
            }
            }
            else {

                System.out.println("\nComputer's turn\n ");
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                System.out.println("X= " + x);
                System.out.println("Y= " + y);

                if (x>=0 && x<10 && y>=0 && y<10) {
                    if (map1[x][y] != "@" && map2[x][y] != "@") {
                        System.out.println(" Missed");
                        map2[x][y] = "x";
                        map1[x][y] = "x";
                    } else if (map2[x][y] == "@") {
                        map2[x][y] = "!";
                        map1[x][y] = "!";
                        count2--;
                        System.out.println("Hit own ship");
                    } else {
                        map1[x][y] = "!";
                        count1--;
                        System.out.println("Boom!  Hit the enemy ship");
                    }
                }
                else {
                    System.out.println("Please enter different coordinates");
                    i--;
                }
            }
        }
        map(map1);
        System.out.println(" Your Ships: "+count1+ " Computer Ships: "+count2);
    }
    if(count1==0){
        r= "Computer Win!!!";
    }
    if (count2==0){
        r="You Win!!!";
    }
    return r;
}
}