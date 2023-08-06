import java.util.*;
import java.io.*;
class ctelsolutions{
    int x;
    Scanner in=new Scanner(System.in); // Scanner class object is Created. 
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
                System.out.println("Welcome  "+username);
                obj.menu();
                break;
            }
            else{
                System.out.println("Wrong Credentials");
                if(i==3){
                    System.out.println("3 Wrong Attempts...................");
                }
            }
    
        }
    }//Try
    catch (IOException e) {
        System.out.print(e);
    }//catch
}//main
void menu(){
    int choice;
    in=new Scanner(System.in);
    while(true){
        System.out.println("Enter your Choice");
        System.out.println();
        System.out.println("_____________________________");
        System.out.println("| 1. |  Add Student         |");
        System.out.println("| 2. |  Add Facualty        |");
        System.out.println("| 3. |  Add Course          |");
        System.out.println("| 4. |  Update Student      |");
        System.out.println("| 5. |  Update Faculty      |");
        System.out.println("| 6. |  Update Course       |");
        System.out.println("| 7. |  Delete Student      |");
        System.out.println("| 8. |  Delete Falculty     |");
        System.out.println("| 9. |  Delete Course       |");
        System.out.println("| 10 |  Report              |");
        System.out.println("|____|______________________|");
        choice=in.nextInt();
        switch(choice){
            case 1:
                add();
            break;
            case 2:
                add();
            break;
            case 3:
                add();
            break;
            case 4:
                add();
            break;
            case 5:
                add();
            break;
            case 6:
                add();
            break;
            case 7:
                add();
            break;
            case 8:
                add();
            break;
            case 9:
                add();
            break;
            case 10:
                add();
            break;
            default:
            System.out.println(" Invalid choice ");
        }
    System.out.println("Do you want to Continue ? y-yes n-no");
		char c1=in.next().charAt(0);
	if(c1!='y')
	    break;
        // while loop-------
    }
}
void add(){
    String name, date, course, fees, feestype, receiptno, mobile, gender, address, data;
    char c;
    try{
        RandomAccessFile studfile=new RandomAccessFile("student.txt","rw");
        studfile.seek(studfile.length()); 
        do
        {
            System.out.print("Enter Receipt No: ");
            receiptno=in.next();
            System.out.print("Enter Admission Date: ");
            date=in.next();
            System.out.print("Enter Student Name: ");
            name=in.next();
            System.out.print("Enter Mobile No: ");
            mobile=in.next();
            System.out.print("Enter Gender: ");
            gender=in.next();
            System.out.print("Enter Address");
            address=in.next();
            System.out.print("Enter Course Id: ");
            course=in.next();
            System.out.print("Enter Fees: ");
            fees=in.next();
            System.out.print("Enter Fees Type: ");
            feestype=in.next();
            data=receiptno+"@"+date+"#"+name+"$"+mobile+"%"+gender+"^"+address+"&"+course+"*"+fees+"!"+feestype+"\r\n";
            System.out.println(data);
            System.out.print("Enter all Details ? y/n");
            c=in.next().charAt(0);
        }while(c=='y');
            studfile.close();//do
    }//try
    catch(IOException e){
        System.out.println(e);
    }//catch
}//add
}//Class