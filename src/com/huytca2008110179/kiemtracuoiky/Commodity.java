package com.huytca2008110179.kiemtracuoiky;

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Commodity {

    int number;
    String id, type, name;
    double price, sumPrice;
    Date date;

    //SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
    Scanner sc = new Scanner(System.in);
    
    public Commodity(){}

    public Commodity(String id, int number, String name){
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Commodity(String id, int number,String name, String type, double price, Date date){
        this.id = id;
        this.number = number;
        this.name = name;
        this.type = type;
        this.price = price;
        this.date = date;
    }

    public Commodity(String id, int number,String name, String type, double price, double sumPrice){
        this.id = id;
        this.number = number;
        this.name = name;
        this.type = type;
        this.price = price;
        this.sumPrice = sumPrice;
    }

    public String getID() {
        return id;
    }
 
    public void setID(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }
 
    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    public Date getDate() {
        return date;
    }
    
    

    public void setDate(Date date) {
        this.date = date;
    }

    public Date setNSX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.date = calendar.getTime();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        return date;
    }
    
    public boolean kiemTraMaHang(boolean k) {
        if (this.id == "" || this.id.trim().isEmpty()) {
            System.out.println("Mã hàng không được để trống !!");
        } else {
            k = false;
        }
        return k;
    }

    public boolean kiemTraTenHang(boolean k) {
        if (this.name == "" || this.name.trim().isEmpty()) {
            System.out.println("Tên hàng không được để trống !!");
        } else {
            k = false;
        }
        return k;
    }

    public boolean kiemTraLoaiHang(boolean k) {
        if (this.type == "" || this.type.trim().isEmpty()) {
            System.out.println("Loại hàng không được để trống !!");
        } else {
            k = false;
        }
        return k;
    }
    
    public void nhapTT(){
        boolean ktMH = true;
        boolean ktTH = true;
        boolean ktLH = true;

        do{

            System.out.print("Mã hàng: ");
            setID(sc.nextLine());

        }while (kiemTraMaHang(ktMH));

        do{

            System.out.print("Tên hàng: ");
            setName(sc.nextLine());

        }while (kiemTraTenHang(ktTH));

        do{

            System.out.print("Loại hàng: ");
            setType(sc.nextLine());

        }while (kiemTraLoaiHang(ktLH));

        System.out.print("Giá bán: ");
        price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Số lượng: ");
        number = sc.nextInt();
        sc.nextLine();
        System.out.print("Năm, tháng, ngày nhập hàng (tách nhau bằng dấu cách): ");
        setNSX(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

    public void inTT(){
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String str = numberFormat.format(price);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String str1 = simpleDateFormat.format(date);
        
        System.out.printf("%-12s %-22s %-20s %-23s %-19.2s %-26s",id,name,type,str,number,str1);
        System.out.println();
    }

    public void inTTsum(){
        sumPrice = price*number;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String str = numberFormat.format(price);
        String str1 = numberFormat.format(sumPrice);

        System.out.printf("%-12s %-22s %-20s %-23s %-16.5s %-20s",id,name,type,str,number,str1);
        System.out.println();
    }

    public void Type(){

    }
}
