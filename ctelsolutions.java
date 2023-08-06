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
            
            if(c==-1){//when hole file gets printed on the screen the value which come from the file will -1 as file is empty nothing to print.
                break;
            }
            System.out.print((char)c);// Converting Variable c from integer to character. 
        }
        fileusername=valid.readLine();
        filepassword=valid.readLine();
        // System.out.println(fileusername);
        // System.out.println(filepassword);
        System.out.println();
        for(int i=1; i<=3; i++){
            if(i==2){
                System.out.println("Its your 2nd attempt");
            }//if
            else if(i==3){
                System.out.println("Its your Last Attempt");
            }//elseif
            System.out.println("Please Enter your Credentails....");
            System.out.println("Enter your Username: ");
            username=in.next(); 
            System.out.println("Enter your Password: ");
            password=in.next();
            if(username.equals(fileusername) && password.equals(filepassword)){
                System.out.print("Welcome  "+username);
                break;
            }
        
        }
    }//Try
    catch (IOException e) {
        System.out.print(e);
    }//catch
}//main
}//Class