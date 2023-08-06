import java.util.*;
import java.io.*;
class ctelsolutions{
    int x;
    Scanner in; // Scanner class object is Created. 
    public static void main(String args[]){
        int c; //Variable for storing the data or lines fetch from the file is declared.Note this variable is declared int type because the data stored in the start.txt is symbol and that symbols are stored using number. 
        String username, password; //Two variable with String datatype is declared to get the input from user.
        String fileusername, filepassword; //lTwo variable with String datatype is declared to get the input from Files.
        ctelsolutions obj=new ctelsolutions();// object the class.
     
    try {
        Scanner in =new Scanner(System.in);
        FileInputStream starttemplate=new FileInputStream("start.txt");//Created object for Start.txt file
        FileReader validation =new FileReader("login.txt");
        BufferedReader valid=new BufferedReader(validation);
        while(true){//while(true) loop is used because this loop iterates for n times. until we break it
            c=starttemplate.read();
            System.out.println(c);
            if(c==-1){//after comp
                System.out.println(c);
                break;
            }
            System.out.print((char)c);// Converting Variable c from integer to character. 
        }
    } catch (Exception e) {
        System.out.print(e);
    }
}
}