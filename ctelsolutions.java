import java.util.*;

import javax.annotation.processing.Filer;

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
                update_student();
            break;
            case 5:
                add_student();
            break;
            case 6:
                update_faculty();
            break;
            case 7:
                delete_student();
            break;
            case 8:
                Delete_faculty();
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
        data=name+"!"+id+"@"+fees+"#"+duration+"\r\n";
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
                System.out.printf("\n| %-8s | %-20s | %-15s | %-7s |",id, name, duration, fees );

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
                alldata=filereceiptno+"@"+date+"#"+name+"$"+mobile+"%"+gender+"^"+address+"&"+course+"*"+fees+"!"+feestype;
                if(inputreceiptno.equals(filereceiptno)){
                    tag++;
                }//if
                else{
                    ww.write(alldata+"\r\n");
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
                ww1.write(data+"\n");
            }//while
            re1.close();
            ww1.close();
            rd1.close();
            wr1.close();
            System.out.println(inputreceiptno+" is Deleted.....");
        }//if
        else{
            System.out.println("No Recipt no. found.....Please check again.");
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
                alldata=name+"!"+id+"@"+fees+"#"+duration;
                if(inputid.equals(id)){
                    tag++;
                }//if
                else{
                    bft.write(alldata+"\r\n");
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
                bfw1.write(data+"\n");

            }//while
            bfc1.close();
            bfw1.close();
            fc1.close();
            fw1.close();
            System.out.println("Course is Deleted.......");
        }//if
        else{
            System.out.print("No Course with id "+inputid+" found.....Please Check the ID again");
        }
    }//try
    catch (Exception e) {
        System.out.print(e);
    }//catch
} //Delete Course
void Delete_faculty(){
    String name, mobile, salary, subject, date,data, inputname,alldata; 
    int q,w,r,t, tag=0;
    try {
        FileReader ff=new FileReader("faculty.txt");
        BufferedReader bff=new BufferedReader(ff);
        FileWriter fw=new FileWriter("temp.txt");
        BufferedWriter bfw=new BufferedWriter(fw);
        System.out.println("Enter Name of Faculty you want to Delete: ");
        inputname=in.next();
        while(true){
            data=bff.readLine();
            if(data==null){
                break;
            }
            else{
                q=data.indexOf("!");
                w=data.indexOf("@");
                r=data.indexOf("#");
                t=data.indexOf("$");

                name=data.substring(0, q);
                salary=data.substring(q+1, w);
                date=data.substring(w+1, r);
                mobile=data.substring(r+1, t);
                subject=data.substring(t+1);
                alldata=name+"!"+salary+"@"+date+"#"+mobile+"$"+subject;
                if(inputname.equals(name)){
                    tag++;
                }
                else{
                    bfw.write(alldata+"\r\n");
                }
            }
        }//while
        bff.close();
        bfw.close();
        ff.close();
        fw.close();
        if(tag==1){
            FileReader fr1=new FileReader("temp.txt");
            BufferedReader br1=new BufferedReader(fr1);
            FileWriter fw1=new FileWriter("faculty.txt");
            BufferedWriter bw1=new BufferedWriter(fw1);
            while(true){data=br1.readLine();
            if(data==null){
                break;
            }//if
            else{
                bw1.write(data+"\n");
            }//else
        }//while
        br1.close();
        bw1.close();
        fr1.close();
        fw1.close();
        System.out.print("Faculty Deleted.");
        }//if
        else{
            System.out.println("No Data Found, Please Check the Name...");
        }
    }//try
    catch (Exception e) {
        System.out.println(e);
    }//catch
}//Delete Faculty
void update_student(){
    String name, date, course, fees, feestype, receiptno, mobile, gender, address, data, alldata,filereceiptno,inputreceiptno;
    int q,w,r,t,y,u,i,o, tag=0;
    System.out.println("Enter Recipt no: ");
    inputreceiptno=in.next();
    try{
    FileReader studfile=new FileReader("student.txt");
    FileWriter temp=new FileWriter("temp.txt");
    RandomAccessFile update=new RandomAccessFile("update.txt", "rw");
    BufferedReader bufferstudfile=new BufferedReader(studfile);
    BufferedWriter buffertemp=new BufferedWriter(temp);    
        while(true){
            data=bufferstudfile.readLine();
            if(data==null){
                break;
            }//if
            else{
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
                if(inputreceiptno.equals(filereceiptno)){
                    update.write(alldata.getBytes());
                    tag++;
                }//if
                else{
                    buffertemp.write(alldata);
                }//else
            }//else
        }//while
        bufferstudfile.close();
        buffertemp.close();
        temp.close();
        update.close();
        studfile.close();
        if(tag>=1){
            String olddata,data1, variable_name_alter, variable_course_alter, variable_fees_alter, variable_feestype_alter, variable_receiptno_alter, variable_mobile_alter,variable_address_alter, variable_gender_alter, variable_date_alter;
            String name_alter, course_alter, fees_alter, feestype_alter, mobile_alter, date_alter, address_alter, gender_alter;
            int q_alter,w_alter,e_alter,r_alter,y_alter,u_alter,i_alter,t_alter;
            try {
                RandomAccessFile update_alter=new RandomAccessFile("update.txt", "rw");
                RandomAccessFile temp_alter=new RandomAccessFile("temp.txt","rw");
                temp_alter.seek(temp_alter.length());
                olddata=update_alter.readLine();
                q_alter=olddata.indexOf('@');
                w_alter=olddata.indexOf('#');
                e_alter=olddata.indexOf('$');
                r_alter=olddata.indexOf('%');
                t_alter=olddata.indexOf('^');
                y_alter=olddata.indexOf('&');
                u_alter=olddata.indexOf('*');
                i_alter=olddata.indexOf('!');
                variable_receiptno_alter=olddata.substring(0, q_alter);
                variable_date_alter=olddata.substring(q_alter+1, w_alter);
                variable_name_alter=olddata.substring(w_alter+1,e_alter);
                variable_mobile_alter=olddata.substring(e_alter+1,r_alter);
                variable_gender_alter=olddata.substring(r_alter+1, t_alter);
                variable_address_alter=olddata.substring(t_alter+1,y_alter);
                variable_course_alter=olddata.substring(y_alter+1, u_alter);
                variable_fees_alter=olddata.substring(u_alter+1, i_alter);
                variable_feestype_alter=olddata.substring(i_alter+1);
                data1=variable_receiptno_alter+variable_date_alter+variable_name_alter+variable_fees_alter+variable_course_alter+variable_feestype_alter+variable_gender_alter+variable_address_alter+variable_mobile_alter;
                System.out.println("-----------------------------------------------------.C-SOLUTIONS, NGP.------------------------------------------------------");
                System.out.println("........................................................Student List.........................................................");
                System.out.println("_____________________________________________________________________________________________________________________________");
                System.out.println("|Receipt No|    Date    | Name          | Gender | Course                | Fees    | Type    | Contact    |     Address     |");
                System.out.println("|----------|------------|---------------|--------|-----------------------|---------|---------|------------|-----------------|");
                System.out.printf("|   %-4s   |%-12s|%-15s| %-6s | %-21s |  %-5s  | %-7s | %-10s |%-17s| \n", variable_receiptno_alter,variable_date_alter,variable_name_alter, variable_gender_alter,variable_course_alter, variable_fees_alter, variable_feestype_alter, variable_mobile_alter, variable_address_alter);
                System.out.println("|__________|____________|_______________|________|_______________________|_________|_________|____________|_________________|");
                System.out.println("\n\n");
                System.out.println("Changing data for Student ID: "+variable_receiptno_alter);
                System.out.println("Enter Name: ");
                name_alter=in.next();
                if(name_alter.equals(".") || name_alter.equals("/")){
                    name_alter=variable_name_alter;
                }
                System.out.println("Enter Admission Date: ");
                date_alter=in.next();
                if(date_alter.equals(".") || date_alter.equals("/")){
                    date_alter=variable_date_alter;
                }
                System.out.println("Enter Gender: ");
                gender_alter=in.next();
                if(gender_alter.equals(".") || gender_alter.equals("/")){
                    gender_alter=variable_gender_alter;
                }
                System.out.println("Enter Course: ");
                course_alter=in.next();
                if(course_alter.equals(".") || course_alter.equals("/")){
                    course_alter=variable_course_alter;
                }
                System.out.println("Enter Fees: ");
                fees_alter=in.next();
                if(fees_alter.equals(".") || fees_alter.equals("/")){
                    fees_alter=variable_fees_alter;
                }
                System.out.println("Enter FeesType: ");
                feestype_alter=in.next();
                if(feestype_alter.equals(".") || fees_alter.equals("/")){
                    feestype_alter=variable_feestype_alter;
                }
                System.out.println("Enter Contact: ");
                mobile_alter=in.next();
                if(mobile_alter.equals(".") || mobile_alter.equals("/")){
                    mobile_alter=variable_mobile_alter;
                }
                System.out.println("Enter Address: ");
                address_alter=in.next();
                if(address_alter.equals(".") || address_alter.equals("/")){
                    address_alter=variable_address_alter;
                }
                System.out.println("\n\nUpdated Details"); 
                System.out.println("_____________________________________________________________________________________________________________________________");
                System.out.println("|Receipt No|    Date    | Name          | Gender | Course                | Fees    | Type    | Contact    |     Address     |");
                System.out.println("|----------|------------|---------------|--------|-----------------------|---------|---------|------------|-----------------|");
                System.out.printf("|   %-4s   |%-12s|%-15s| %-6s | %-21s |  %-5s  | %-7s | %-10s |%-17s| \n", variable_receiptno_alter,date_alter,name_alter, gender_alter,course_alter, fees_alter, feestype_alter, mobile_alter, address_alter);
                System.out.println("|__________|____________|_______________|________|_______________________|_________|_________|____________|_________________|");
                data1=variable_receiptno_alter+"@"+date_alter+"#"+name_alter+"$"+mobile_alter+"%"+gender_alter+"^"+address_alter+"&"+course_alter+"*"+fees_alter+"!"+feestype_alter+"\r\n";
                temp_alter.write(data1.getBytes());
                temp_alter.close();
                update_alter.close();
            }//try
            catch (Exception e) {
                System.out.println(e);
            }//catch
        }//if
        try{
            FileReader fr1=new FileReader("temp.txt");
            BufferedReader br1=new BufferedReader(fr1);
            FileWriter fw1=new FileWriter("student.txt");
            BufferedWriter bw1=new BufferedWriter(fw1);
            while(true){data=br1.readLine();
            if(data==null){
                break;
            }//if
            else{
                bw1.write(data+"\n");
            }//else
        }//while
        br1.close();
        bw1.close();
        fr1.close();
        fw1.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }//Try
    catch(IOException e){
        System.out.println("Please Check, Some Error Occured Due to Files. Please Contact the Develops teams.");
        System.out.println(e);
    }//catch
}//update_student
void update_faculty(){
    String id, name, fees, duration, data, inputid, alldata;
    int q,w,r, tag=0;
    System.out.println("Enter the id of Course: ");
    inputid=in.next(); 
    try {
        RandomAccessFile course_access=new RandomAccessFile("course.txt", "rw");
        FileWriter temp=new FileWriter("temp.txt");
        FileWriter update=new FileWriter("update.txt");
        BufferedWriter buff_temp=new BufferedWriter(temp);
        BufferedWriter buff_update=new BufferedWriter(update);
        while(true){ 
            data=course_access.readLine();
            if(data==null){
                break;
            }//if
            else{
                q=data.indexOf('!');
                w=data.indexOf('@');
                r=data.indexOf('#');
                name=data.substring(0, q);
                id=data.substring(q+1, w);
                //DBMS!03@4300##4
                fees=data.substring(w+1,r); 
                duration=data.substring(r);
                alldata=id+"!"+name+"@"+fees+"#"+duration+"\r\n";
                System.out.println(id );
                if(id.equals(inputid)){
                    tag++;
                    buff_update.write(alldata);
                }//ifv 
                else{
                    buff_temp.write(alldata);
                }//else 
            }//else
            
        }//while
        buff_temp.close();
        buff_update.close();
        temp.close();
        update.close();
        course_access.close();
        if(tag>=1){
            String id1, name1, duration1, fees1, alldata1;
            FileWriter temp1=new FileWriter("temp.txt");
            BufferedWriter buff_temp1=new BufferedWriter(temp1);
            FileReader update1=new FileReader("update.txt");
            BufferedReader buff_update1=new BufferedReader(update1);
            data=buff_update1.readLine();
            q=data.indexOf('!');
            w=data.indexOf('@');
            r=data.indexOf('#');
            name=data.substring(0, q);
            id=data.substring(q+1, w);
            //DBMS!03@4300##4
            fees=data.substring(w+1,r); 
            duration=data.substring(r);
            alldata=id+"!"+name+"@"+fees+"#"+duration+"\r\n";
            System.out.println("---------------------.C-SOLUTIONS, NGP.-----------------------");
            System.out.println("...........................Course List........................");
            System.out.println("|Course ID | Course Name          | Duration(Months)| Fees    |");
            System.out.printf("\n| %-8s | %-20s | %-15s | %-7s |",id, name, duration, fees );
            System.out.println();
            System.out.println("Change data for Course ID: "+id);
            System.out.println();
            System.out.print("Enter Name: ");
            name1=in.next();
            if(name1.equals(".")){
                name1=name;
            }
            System.out.print("Enter Duration of Course: ");
            duration1=in.next();
            if(duration1.equals(".")){
                duration1=duration;
            }
            System.out.print("Enter Fees of the Course: ");
            fees1=in.next();
            if(fees1.equals(".")){
                fees1=fees;
            }
            alldata1=name1+"!"+id+"@"+fees1+"#"+duration1+"\r\n";
            System.out.println(alldata1);
            buff_temp1.write(alldata1);

        }
    } catch (Exception e) {
        System.out.println(e);
        // TODO: handle exception
    }
}
}//Class