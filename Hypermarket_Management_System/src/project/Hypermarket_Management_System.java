package project;
import java.util.*;
class product
{
    String product_code, product_name;
    int product_quantity;
    float product_rate;
    public void add_product(int order)
    {
         String code;
         Scanner sc=new Scanner(System.in);
         if (product_name.length() > 4) 
         {
            code = product_name.substring(0, 4);
         } 
         else
         {
            code = product_name;
         }
         code=code.toUpperCase();
         if(order<10)
         {
             product_code=code+"00"+order;
         }
         else
         {
             product_code=code+"0"+order;
         }
         
         System.out.println("\nProduct code : "+product_code);
         System.out.println("\nEnter rate of Product :");
         product_rate=sc.nextFloat();
         System.out.println("Enter quantity of Product :");
         product_quantity=sc.nextInt();
    }
    public void change_rate()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\nPrevious rate : "+product_rate);
        System.out.println("\nEnter new rate : ");
        product_rate=sc.nextFloat();
        System.out.println("Rate updated");
    }
    public void issue_product()
    {
        int issue=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("\nHow many "+product_name+"  are to be issued??");
        issue=sc.nextInt();
        if(issue>product_quantity)
            System.out.println("Only "+product_quantity+" available in stock.");
        else
            product_quantity=product_quantity-issue;
    }
    public void recieve_product()
    {
        int recieve=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("\nHow many "+product_name+"  are to be recieved??");
        recieve=sc.nextInt();
        product_quantity=product_quantity+recieve;
    }
    
    public void display()
    {
        System.out.println(product_code+"\t\t\t"+product_name+"\t\t\t"+product_quantity+"\t\t\t"+product_rate);   
    }
   
  
}

public class Hypermarket_Management_System
{
  	public static void main(String args[])
    {
        product prod[]=new product[100];
        for(int i=0;i<100;i++)
        {
            prod[i]=new product();
        }
        int ch, product_count=0;
        String PassRSM="HMManager";
        String PassREL="HEL";
        Scanner sc=new Scanner(System.in);
        char wish='y';
        int p_try=0,flag=0;
        String prod_code;
        int f=0;
        do
        {
            System.out.println("_______________________MENU______________________\n");
            System.out.println("1.Hypermarket Manager\n2.Hypermarket Employee Login\n");
            System.out.println("______________________________________________\n");
            System.out.println("Enter your choice");
            ch=sc.nextInt();
            sc.nextLine();
            p_try=0;
            switch(ch)
            {
                case 1:
                    do
                    {
                        String pass=new String();
                        System.out.println("Enter password :");
                        
                        pass=sc.nextLine();
                        if(pass.equals(PassRSM))
                        {
                           p_try=3;
                           char c='y';
                           do
                           {
                               int choice;
                               f=0;
                               flag=0;
                               System.out.println("______________________ Hypermarket Manager________________\n"); 
                               System.out.println("1. Register New Product\n");
                               System.out.println("2. Change Rate Of Product\n");
                               System.out.println("3. Issue Product\n");
                               System.out.println("4. Recieve Product\n");
                               System.out.println("5. Product Details\n");
                               System.out.println("6. Display All Product\n");
                               System.out.println("7. Display Product based on price\n");
                               System.out.println("_________________________________________________________________\n");
                               System.out.println("Enter your choice :");
                               choice=sc.nextInt();
                               sc.nextLine();
                               switch(choice)
                               {
                                   case 1:
                                      String prod_name;
                                     
                                      System.out.println("\nEnter name of product");
                                      prod_name=sc.nextLine();
                                      for(int j=0;j<product_count;j++)
                                      {

                                          String str1;
                                          str1=prod[j].product_name;
                                          if(prod_name.equalsIgnoreCase(str1))
                                          {    
                                              flag=1;
                                              break;
                                          }
                                      }
                                      if(flag==1)
                                      {
                                          System.out.println("Product already exists. Update quantity.\n");
                                      }
                                      else
                                      {
                                          prod[product_count].product_name=prod_name;
                                          prod[product_count].add_product(product_count);
                                          product_count++;
                                          for(int i=0;i<(product_count-1);i++)
                                          {
                                              for(int j=i+1;j<product_count;j++)
                                              {
                                                  if(prod[i].product_code.compareTo(prod[j].product_code)>0)   
                                                  {    
                                                        product temp = new product(); 
                                                        temp=prod[i];  
                                                        prod[i] = prod[j];  
                                                        prod[j] = temp;
                                                  }
                                              }
                                          }
                                      }
                                      break;
                                   case 2:
                                       System.out.println("Enter Product Code to rate :");
                                       prod_code=sc.nextLine();
                                       for(int i=0;i<product_count;i++)
                                       {
                                           if(prod_code.equals(prod[i].product_code))
                                           {
                                               prod[i].change_rate();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such product exists");
                                       break;
                                   case 3:
                                	   System.out.println("Enter Item Code to issue :");
                                       prod_code=sc.nextLine();
                                       for(int i=0;i<product_count;i++)
                                       {
                                           if(prod_code.equals(prod[i].product_code))
                                           {
                                               prod[i].issue_product();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 4:
                                	   System.out.println("Enter product Code to recieve :");
                                       prod_code=sc.nextLine();
                                       for(int i=0;i<product_count;i++)
                                       {
                                           if(prod_code.equals(prod[i].product_code))
                                           {
                                               prod[i].recieve_product();
                                               f=1;
                                               break;
                                           }
                                        
                                       }
                                       if(f!=1)
                                               System.out.println("No such product exists");
                                       break;
                                   case 5:
                                       System.out.println("Enter Product Code to Display  :");
                                       prod_code=sc.nextLine();
                                       for(int i=0;i<product_count;i++)
                                       {
                                           if(prod_code.equals(prod[i].product_code))
                                           {
                                               System.out.println("Product Code\t\tProduct Name\t\tQuantity\t\tRate");
                                               prod[i].display();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 6:
                                       System.out.println("Product Code\t\tProduct Name\t\tQuantity\t\tRate");
                                       for(int i=0;i<product_count;i++)
                                       {
                                           prod[i].display();
                                       }
                                       break;
                                   case 7:
                                	   float p;
                                	   System.out.println("Enter price:");
                                	   p=sc.nextFloat();
                                	   System.out.println("Product Code\t\tproduct Name\t\tQuantity\t\tRate");
                                       for(int i=0;i<product_count;i++)
                                       {
                                           if(prod[i].product_rate<p)
                                        	   prod[i].display();
                                       }
                                       break;
                                   default:
                                       System.out.println("Wrong choice!!");
                               }
                               System.out.println("Want to do more operations?(y/n) : ");
                               c=sc.next().charAt(0);
                               sc.nextLine();
                           }while(c=='y'||c=='Y');
                        }
                        else
                        {
                            p_try++;
                            System.out.println("Wrong password!!! "+(3-p_try)+" attempts left!!");
                        }
                    }while(p_try<3);
                    break;
                case 2 :
                    do
                    {
                        p_try=0;
                        String pass=new String();
                        System.out.println("Enter password :");
                        pass=sc.nextLine();
                        if(pass.equals(PassREL))
                        {
                           p_try=3;
                           char c='y';
                           do
                           {
                               int choice;
                               f=0;
                               flag=0;
                               System.out.println("________________Hpermarkert Employee Login_____________\n"); 
                               System.out.println("1. Issue Product\n");
                               System.out.println("2. Recieve Product\n");
                               System.out.println("3. Product Details\n");
                               System.out.println("4. Display All products\n");
                               System.out.println("_____________________________________________________\n");
                               System.out.println("Enter your choice :");
                               choice=sc.nextInt();
                               sc.nextLine();
                               switch(choice)
                               {
                                   case 1:
                                       System.out.println("Enter Item Code to issue :");
                                       prod_code=sc.nextLine();
                                       for(int i=0;i<product_count;i++)
                                       {
                                           if(prod_code.equals(prod[i].product_code))
                                           {
                                               prod[i].issue_product();
                                               f=1;
                                               break;
                                           }
                                           
                                       }
                                       if(f!=1)
                                               System.out.println("No such item exists");
                                       break;
                                   case 2:
                                       System.out.println("Enter product Code to recieve :");
                                       prod_code=sc.nextLine();
                                       for(int i=0;i<product_count;i++)
                                       {
                                           if(prod_code.equals(prod[i].product_code))
                                           {
                                               prod[i].recieve_product();
                                               f=1;
                                               break;
                                           }
                                        
                                       }
                                       if(f!=1)
                                               System.out.println("No such product exists");
                                       break;
                                   case 3:
                                       System.out.println("Enter product Code to Display :");
                                       prod_code=sc.nextLine();
                                       for(int i=0;i<product_count;i++)
                                       {
                                           if(prod_code.equals(prod[i].product_code))
                                           {
                                               System.out.println("Product Code\t\tProduct Name\t\tQuantity\t\tRate");
                                               prod[i].display();
                                               f=1;
                                               break;
                                           }
                                       }
                                       if(f!=1)
                                               System.out.println("No such product exists");
                                       break;
                                   case 4:
                                	   
                                	   System.out.println("Product Code\t\tproduct Name\t\tQuantity\tRate");
                                       for(int i=0;i<product_count;i++)
                                       {
                                           prod[i].display();
                                       }
                                      break;
                                   default:
                                       System.out.println("Wrong choice!!");
                               }
                               System.out.println("Want to do more operations?(y/n) : ");
                               c=sc.next().charAt(0);
                               sc.nextLine();
                           }while(c=='y'||c=='Y');
                        }
                        else
                        {
                            p_try++;
                            System.out.println("Wrong password!!! "+(3-p_try)+" attempts left!!");
                        }
                    }while(p_try<3);
                    break;
                default :
                    System.out.println("Wrong choice!!");
            }
            System.out.println("Want to go to Main Menu?(y/n) : ");
            wish=sc.next().charAt(0);
            sc.nextLine();
        }while(wish=='y'||wish=='Y');
    }
}