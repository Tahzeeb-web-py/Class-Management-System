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
            System.out.print("Enter your Username: ");
            username=in.next(); 
            System.out.print("Enter your Password: ");
            password=in.next();
            if(username.equals(fileusername) && password.equals(filepassword)){
                System.out.println("--------------------  Welcome  "+username+"  --------------------");
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
        System.out.println("\nEnter your Choice");
        System.out.println();
        System.out.println("_____________________________________________________________");
        System.out.println("||    |                      |     |                       ||");
        System.out.println("|| 1. |  Add Student         | 8.  |  Delete Falculty      ||");
        System.out.println("|| 2. |  Add Facualty        | 9.  |  Delete Course        ||");
        System.out.println("|| 3. |  Add Course          | 10. |  Report               ||");
        System.out.println("|| 4. |  Update Student      | 11. |  View Courses         ||");
        System.out.println("|| 5. |  Update Faculty      | 12. |  View Students        ||");
        System.out.println("|| 6. |  Update Course       | 13. |  View Faculties       ||");
        System.out.println("|| 7. |  Delete Student      | 14. |  Exit                 ||");
        System.out.println("||____|______________________|_____|_______________________||");
        choice=in.nextInt();
        switch(choice){
            case 1:
                add_student();
            break;
            case 2:
                add_faculty();
            break;
            case 3:
                add_course();
            break;
            case 4:
                add_student();
            break;
            case 5:
                add_student();
            break;
            case 6:
                add_student();
            break;
            case 7:
                delete_student();
            break;
            case 8:
                add_student();
            break;
            case 9:
                Delete_course();
            break;
            case 10:
                add_student();
            break;
             case 11:
                view_course();
            break;
            case 12:
                view_student();
            break;
            case 13:
                view_faculty();
            break;
            case 14:
            break;
            default:
            System.out.println(" Invalid choice ");
        }
    System.out.println("\n\nDo you want to Continue ? --> YES or NO");
		char c1=in.next().charAt(0);
	if(c1!='y'){
        in.close();
	    break;
    }else{
        continue;
    }
        // while loop-------
    }
}
void add_student(){
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
            System.out.print("Enter Address: ");
            address=in.next();
            System.out.print("Enter Course Id: ");
            course=in.next();
            System.out.print("Enter Fees: ");
            fees=in.next();
            System.out.print("Enter Fees Type: ");
            feestype=in.next();
            data=receiptno+"@"+date+"#"+name+"$"+mobile+"%"+gender+"^"+address+"&"+course+"*"+fees+"!"+feestype+"\r\n";
            System.out.println(data);
            studfile.write(data.getBytes());
            System.out.print("Enter all Details ? y/n");
            c=in.next().charAt(0);
        }while(c=='y');
            studfile.close();//do
    }//try
    catch(IOException e){
        System.out.println(e);
    }//catch
}//add_student
void add_faculty(){
    String name, mobile, salary, subject, date,data;
    char c;
    try{
        RandomAccessFile faculty_File=new RandomAccessFile("faculty.txt", "rw");
        faculty_File.seek(faculty_File.length());
        do{
            System.out.println("Enter data to add New Faculty......");
            System.out.print("Enter Name: ");
            name=in.next();
            System.out.print("Enter Mobile No: ");
            mobile=in.next();
            System.out.print("Enter Joining Date: ");
            date=in.next(); 
            System.out.print("Enter Salary: ");
            salary=in.next();
            System.out.print("Enter Subject: ");
            subject=in.next();
            data=name+"!"+salary+"@"+date+"#"+mobile+"$"+subject+"\r\n";
            faculty_File.write(data.getBytes());
            System.out.print("Do you want to another Faculty? Y/N");
            c=in.next().charAt(0);
        }while(c=='y');
            faculty_File.close();
        
    }//try block
    catch(IOException e){
        System.out.println(e);
    }//catch
}//add_faculty
void add_course(){
    String id, name, fees, duration, data;
    char c;
    try{
        RandomAccessFile coursefile=new RandomAccessFile("course.txt", "rw");
        coursefile.seek(coursefile.length());
        do{
        System.out.println("Enter data to add new Course......");
        System.out.println("Enter Name of Subject: ");
        name=in.next();
        System.out.print("Enter New ID: ");
        id=in.next();
        System.out.print("Enter Fees: ");
        fees=in.next();
        System.out.print("Enter Duration: ");
        duration=in.next();
        data="\r\n"+name+"!"+id+"@"+fees+"#"+duration;
        System.out.print(data);
        coursefile.write(data.getBytes());
        System.out.println("Do you want to another Faculty? Y/N");
        c=in.next().charAt(0);

    }while(c=='y');{
        coursefile.close();
    }//do

    }//try
    catch(IOException e){
        System.out.println(e);
    }
}//add course
void view_student(){
        String name, course, fees, feestype, receiptno, mobile, data;
        int q,w,e,r,y,u,i,t;
        try{
            FileReader rd=new FileReader("student.txt");
            BufferedReader brd=new BufferedReader(rd);
            System.out.println("--------------------------------.C-SOLUTIONS, NGP.-----------------------------------");
            System.out.println("...................................Student List......................................");
            System.out.println("_____________________________________________________________________________________");
            System.out.println("|Receipt No | Name          | Course                | Fees    | Type    | Contact    |");
            while(true){
                data=brd.readLine();
                if(data==null){
                    break;
                }//receiptno+"@"+date+"#"+name+"$"+mobile+"%"+gender+"^"+address+"&"+course+"*"+fees+"!"+feestype+
                else{
                    q=data.indexOf('@');
                    w=data.indexOf('#');
                    e=data.indexOf('$');
                    r=data.indexOf('%');
                    t=data.indexOf('^');
                    y=data.indexOf('&');
                    u=data.indexOf('*');
                    i=data.indexOf('!');
                    receiptno=data.substring(0, q);
                    name=data.substring(w+1, e);
                    course=data.substring(y+1,u);
                    fees=data.substring(u+1,i);
                    feestype=data.substring(i+1);
                    mobile=data.substring(e+1,r);
                    System.out.printf("\n|    %-4s   |%-15s| %-21s |  %-5s  | %-7s | %-10s |", receiptno,name, course, fees, feestype, mobile);
                }
            System.out.println("\n|           |               |                       |         |         |            |");
            }
                        System.out.println("_____________________________________________________________________________________");

        }catch(IOException ob){
            System.out.println(ob);
        }


}//view_student
void view_course(){
//id, name, fees, duration, data;
    String id, name, fees, duration, data;
    int q,w,r;
    try {
        FileReader vc=new FileReader("course.txt");
        BufferedReader bvc=new BufferedReader(vc);
        System.out.println("---------------------.C-SOLUTIONS, NGP.-----------------------");
        System.out.println("...........................Course List........................");
        System.out.println("|Course ID | Course Name          | Duration(Months)| Fees    |");
        while(true){
            data=bvc.readLine();
            if(data==null){
                break;
            }else{
                q=data.indexOf('!');
                w=data.indexOf('@');
                r=data.indexOf('#');
                //name+"!"+id+"@"+fees+"#"+duration;
                id=data.substring(q+1,w);
                name=data.substring(0, q);
                duration=data.substring(r+1);
                fees=data.substring(w+1,r);
                System.out.printf("\n| %-8s | %-20s | %-15s | %-7s |",name, id, duration, fees );

            }
        }

    }//try 
    catch (Exception e) {
        System.out.print(e);
    }//catch
}//View_course
void view_faculty(){
    String name, mobile, salary, subject, date,data; 
    int q,w,r,t;
    try {
        FileReader vf = new FileReader("faculty.txt");
        BufferedReader bvf=new BufferedReader(vf);
        System.out.println(".................................C-TEL SOLUTIONS, NGP................................");
        System.out.println("\n                              All Faculties Available                              ");
        System.out.println(" ");
        System.out.println("______________________________________________________________________________________");
        System.out.println("|      Name      |    Contact    |          Subject          | Joining Data | Salary |");
        System.out.println("|                |               |                           |              |        |");
        while(true){
            data=bvf.readLine();
            if(data==null){
                break;
            }else{//name+"!"+salary+"@"+date+"#"+mobile+"$"+subject+
                q=data.indexOf("!");
                w=data.indexOf("@");
                r=data.indexOf("#");
                t=data.indexOf("$");

                name=data.substring(0, q);
                salary=data.substring(q+1, w);
                date=data.substring(w+1, r);
                mobile=data.substring(r+1, t);
                subject=data.substring(t+1);
                System.out.printf("\n|%-16s|%-15s|%-27s|%-14s|%-8s|", name, mobile, subject, date, salary);

            }

        } 
        System.out.print("\n|________________|_______________|___________________________|______________|________|");

    } catch (Exception e) {
        System.out.println(e);
    }
}//view faculties method
void delete_student(){
    String name, date, course, fees, feestype, inputreceiptno,filereceiptno, mobile, gender, address, data, alldata;
    int q,w,r,t,y,u,i,o, tag=0;
    System.out.println("\n Enter Receipt Nos: ");
    inputreceiptno=in.next();
    try {
        FileReader rd=new FileReader("student.txt");
        BufferedReader re=new BufferedReader(rd);
        FileWriter wr=new FileWriter("temp.txt");
        BufferedWriter ww=new BufferedWriter(wr);
        while(true){
            data=re.readLine();
            if(data==null)
                break;
            else 
                q=data.indexOf('@'); 
                w=data.indexOf('#');
                o=data.indexOf('$');
                r=data.indexOf('%');
                t=data.indexOf('^');
                y=data.indexOf('&');
                u=data.indexOf('*');
                i=data.indexOf('!');
                filereceiptno=data.substring(0, q);
                name=data.substring(w+1, o);
                course=data.substring(y+1,u);
                fees=data.substring(u+1,i);
                date=data.substring(q+1,w);
                gender=data.substring(r+1, t);
                address=data.substring(t+1,y);
                feestype=data.substring(i+1);
                mobile=data.substring(o+1,r);
                alldata=filereceiptno+"@"+date+"#"+name+"$"+mobile+"%"+gender+"^"+address+"&"+course+"*"+fees+"!"+feestype+"\r\n";
                System.out.print("bahar"+alldata);
                if(inputreceiptno.equals(filereceiptno)){
                    tag++;
                }//if
                else{
                    ww.write(alldata);
                }
        }//while
        re.close();
        ww.close();
        rd.close();
        wr.close();
        if(tag==1){
            FileReader rd1=new FileReader("temp.txt");
            BufferedReader re1=new BufferedReader(rd1);
            FileWriter wr1=new FileWriter("student.txt");
            BufferedWriter ww1=new BufferedWriter(wr1);
            while(true){
                data=re1.readLine();
                System.out.println(data);
                    if(data==null)
                    break;
                ww1.write(data+"\r\n");
            }//while
            re1.close();
            ww1.close();
            rd1.close();
            wr1.close();
            System.out.println(inputreceiptno+" is Deleted.....");
        }
    } catch (Exception e) {
        System.out.println(e);
    }

}//Delete_Student
void Delete_course(){
    String id, name, fees, duration, data, inputid, alldata;
    int q,w,r, tag=0;
    System.out.println("Enter ID of Couse you want to delete: ");
    inputid=in.next();
    try {
        FileReader fc=new FileReader("course.txt");
        BufferedReader bfc=new BufferedReader(fc);
        FileWriter ft=new FileWriter("temp.txt");
        BufferedWriter bft=new BufferedWriter(ft);
        while(true){
            data=bfc.readLine();
            if (data==null) {
              break;  
            }//if
            else 
                q=data.indexOf('!');
                w=data.indexOf('@');
                r=data.indexOf('#');
                //name+"!"+id+"@"+fees+"#"+duration;
                id=data.substring(q+1,w);
                name=data.substring(0, q);
                duration=data.substring(r+1);
                fees=data.substring(w+1,r);
                alldata=name+"!"+id+"@"+fees+"#"+duration+"\r\n";
                if(inputid.equals(id)){
                    tag++;
                }//if
                else{
                    bft.write(alldata);
                }
        }//while
        bfc.close();
        bft.close();
        fc.close();
        ft.close();
        if(tag==1){
            FileReader fc1=new FileReader("temp.txt");
            BufferedReader bfc1=new BufferedReader(fc1);
            FileWriter fw1=new FileWriter("course.txt");
            BufferedWriter bfw1=new BufferedWriter(fw1);
            while(true){
                data=bfc1.readLine();
                if(data==null){
                    break;
                }
                System.out.println(data);
                bfw1.write(data+"\r\n");

            }//while
            bfc1.close();
            bfw1.close();
            fc1.close();
            fw1.close();
            System.out.println("Course is Deleted.......");
        }//if
    }//try
    catch (Exception e) {
        System.out.print(e);
    }//catch
} //Delete Course
}//Class