import java.sql.*;
import java.util.Scanner;
public class OTP
{
    String a="8219534067";
    String x,y;
    int b;
    public void rotp()
    {
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connect= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
        Statement s=connect.createStatement();
        ResultSet set=s.executeQuery("Select otp from rajan");
        while(set.next()) 
        {
            x=set.getString(1);
        }
        b=Integer.parseInt(x);
        if(b>=10000 || b<1000)
        {
            int r=1000;
            r=r+27;
            String g=String.valueOf(r);
            s.executeUpdate("update rajan set otp ="+g+" where no =1");
            s.executeUpdate("commit");
            
        }
        
        int first,second,third,fourth;
        fourth=b%10;
        third=(b/10)%10;
        second=(b/100)%10;
        first=(b/1000)%100;
        String str="";
        for (int i=0;i<4;i++)
        {
            
          if(i==0)
          {
              str=str+a.charAt(first);
          } 
          if(i==1)
          {
              str=str+a.charAt(second);  
          }
          if(i==2)
          {
            str=str+a.charAt(third);
          }
          if(i==3)
          {
            str=str+a.charAt(fourth);
          }
        }
        System.out.print("Your otp is ");
        System.out.println(str);
        int c=b+102;
        String z=String.valueOf(c);
        s.executeUpdate("update rajan set otp ="+z+" where no =1");
        s.executeUpdate("commit");
        connect.close();
        }catch(Exception ee)
        {
            System.out.println(ee);
        }

    }
    public void check()
    {
      try
      {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connect= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
        Statement s=connect.createStatement();
        ResultSet set=s.executeQuery("Select otp from rajan");
        while(set.next()) 
        {
            y=set.getString(1);
        }
        //int m=Integer.parseInt(y);
        Scanner sc=new Scanner(System.in);
        System.out.println("\n"+"Varify your number here ");
        System.out.print("Enter your otp ");
        String num=sc.next();
        char u=num.charAt(3);
        char v=num.charAt(2);
        char w=num.charAt(1);
        char f=num.charAt(0);

        String str="";

        for (int i=0;i<4;i++)
        {

            
          if(i==0)
          {
              str=str+a.indexOf(f);
          } 
          if(i==1)
          {
              str=str+a.indexOf(w); 
          }
          if(i==2)
          {
            str=str+a.indexOf(v);
          }
          if(i==3)
          {
            str=str+a.indexOf(u);
          }
         
        }
        
        int q=Integer.parseInt(str);
        str=String.valueOf(q+102);
        int j=Integer.parseInt(str);
        int k=Integer.parseInt(y);
        if(j==k)
        {
            System.out.println("WELCOME");
        }
        else
        {
            System.out.println("Sorry Wrong OTP");
        }
      }catch(Exception ee)
      {
          System.out.println(ee);
      }
    }

    public static void main(String []args)
    {
        Rotp2 o=new Rotp2();
        o.rotp();
        o.check();
    }
}