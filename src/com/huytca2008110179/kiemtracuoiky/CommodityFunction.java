package com.huytca2008110179.kiemtracuoiky;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Date;
import java.util.Calendar;


public class CommodityFunction {
    Commodity commodity = new Commodity();
    Scanner sc = new Scanner(System.in);
    ArrayList<Commodity> list = new ArrayList<>();

    public void readyList(){
        list.add(new Commodity("A01", 15, "Dien thoai", "Dien may", 3650000, commodity.setNSX(2018, 8, 9)));
        list.add(new Commodity("A02", 20, "Thit bo hop", "Thuc pham", 50000, commodity.setNSX(2021, 11, 20)));
        list.add(new Commodity("A03", 35, "Chen", "Sanh su", 30000, commodity.setNSX(2019, 3, 5)));
        list.add(new Commodity("A04", 5, "Tu lanh", "Dien may", 7200000, commodity.setNSX(2017, 8, 12)));
        list.add(new Commodity("A05", 10, "Laptop", "Dien may", 20800000, commodity.setNSX(2020, 7, 25)));
        list.add(new Commodity("B01", 5, "Binh hoa", "Sanh su", 32000, commodity.setNSX(2008, 2, 3)));
        list.add(new Commodity("B02", 36, "Ca rot", "Thuc pham", 4000, commodity.setNSX(2021, 10, 9)));
        list.add(new Commodity("B03", 15, "Rau xa lach", "Thuc pham", 3000, commodity.setNSX(2021, 11, 18)));
        list.add(new Commodity("B04", 30, "Ly thuy tinh", "Sanh su", 245000, commodity.setNSX(2019, 7, 25)));
        list.add(new Commodity("B05", 5, "Ruou vang", "Thuc pham", 195000, commodity.setNSX(2020, 4, 6)));
        list.add(new Commodity("C01", 10, "Ipad Pro 11", "Dien may", 25900000, commodity.setNSX(2018, 6, 12)));
        list.add(new Commodity("C02", 35, "Thit heo hop", "Thuc pham", 35000, commodity.setNSX(2021, 10, 25)));
        list.add(new Commodity("C03", 15, "Smart Watch", "Dien may", 268000, commodity.setNSX(2019, 12, 8)));
        list.add(new Commodity("C04", 25, "Ca hop", "Thuc pham", 25000, commodity.setNSX(2021, 8, 27)));
        list.add(new Commodity("C05", 30, "Mi goi", "Thuc pham", 4000, commodity.setNSX(2021, 9, 3)));
        list.add(new Commodity("D01", 6, "May lanh", "Dien may", 5870000, commodity.setNSX(2009, 1, 30)));
        list.add(new Commodity("D02", 3, "Ti-vi", "Dien may", 39580000, commodity.setNSX(2015, 5, 31)));
        list.add(new Commodity("D03", 30, "Dia thuy tinh", "Sanh su", 50000, commodity.setNSX(2019, 11, 21)));
        list.add(new Commodity("D04", 10, "Sugar", "Thuc pham", 32000, commodity.setNSX(2021, 5, 28)));
        list.add(new Commodity("D05", 15, "Muong thuy tinh", "Sanh su", 25800, commodity.setNSX(2020, 12, 13)));
    }                      
    
    public void xuatDS(){
        System.out.println("==============================================DANH S??CH H??NG H??A===============================================");
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
        System.out.println();
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
        System.out.println();

        for (Commodity commodity : list){
            commodity.inTT();
        }

        System.out.println("===============================================================================================================");        
    }

    public void sortType(){
        //String n = list.toString();
        Comparator comparatorType = new Comparator<Commodity>() {
            @Override
            public int compare(Commodity o1, Commodity o2) {
                
                return o1.getType().compareTo(o2.getType());
            }
        };
        list.sort(comparatorType);

        for (Commodity commodity : list) {
            System.out.println(commodity.getType());
        }
    }

    public void sortAsc(){
        Comparator comparator = new Comparator<Commodity>(){
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return Double.compare(o1.price, o2.price);
            }
        };
        /*if(commodity.getPrice() == commodity.getPrice()){
            sortType();
        }*/
        
        list.sort(comparator);
    }

    public void sortDec(){
        Comparator comparator = new Comparator<Commodity>(){
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return Double.compare(o2.price, o1.price);
            }
        };
        /*if(commodity.getPrice() == commodity.getPrice()){
            sortType();
        }*/
        
        list.sort(comparator);
    }

    public void sortDateFunctionASC(){
        Comparator comparatorDate = new Comparator<Commodity>(){
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        };
        
        list.sort(comparatorDate);
    }

    public void sortDateFunctionDEC(){
        Comparator comparatorDate = new Comparator<Commodity>(){
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        };
        
        list.sort(comparatorDate);
    }

    public int findID(){
        System.out.print("Nh???p m?? h??ng c???n x??a: ");
        String timID = sc.nextLine();

        int x = -1;

        for (Commodity commodityRemove : list) {
            if(timID.equalsIgnoreCase(commodityRemove.id)){
                x = list.indexOf(commodityRemove);
            }
        }
        return x;
    }

    public Date setNSX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        commodity.date = calendar.getTime();
        return commodity.date;
    }

    public Double sum(){
        double sum = 0;
        System.out.println("============================================TH???NG K?? GI?? TR??? H??NG H??A==========================================");
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
        System.out.println();
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
        System.out.println();
        for (Commodity commoditySumm : list) {
            sum = commoditySumm.price*commoditySumm.number;
            commoditySumm.inTTsum();
        }
        System.out.println("===============================================================================================================");
        return sum;
    }
    

    /****************************************************--------------------******************************************************/


    //Th??m SP
    public void add(){
        System.out.print("S??? l?????ng h??ng c???n th??m: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++){
            commodity.nhapTT();
            list.add(new Commodity(commodity.id, commodity.number, commodity.name, commodity.type, commodity.price, commodity.date));
        }
        System.out.println("???? th??m h??ng h??a v??o cu???i danh s??ch");
        //sc.nextLine();
    }

    //X??a SP
    public void remove(){
        int x = findID();
        if(x != -1){
            list.remove(x);
            System.out.println("???? x??a h??ng h??a");
        }
        else{
            System.out.println("Kh??ng c?? m?? h??ng n??y n??y!!");
        }
    }

    //S???a SP
    public void Update(){
        //System.out.println("??ang ph??t tri???n");
        System.out.print("Nh???p m?? h??ng c???n s???a: ");
        String timType = sc.nextLine();

        int x = -1;

        for (Commodity commodityFix : list) {
            if(timType.equalsIgnoreCase(commodityFix.id)){
                x = list.indexOf(commodityFix);
            }
        }
        //sc.nextLine();

        for (int j=0; j<list.size(); j++){
            if(j == x){
                System.out.println("M?? h??ng: "+timType);
                System.out.print("T??n h??ng s???a: ");
                String name = sc.nextLine();
                System.out.print("Lo???i h??ng s???a: ");
                String type = sc.nextLine();
                System.out.print("Gi?? b??n s???a: ");
                double price = sc.nextDouble();
                sc.nextLine();
                System.out.print("S??? l?????ng s???a: ");
                int number = sc.nextInt();
                sc.nextLine();
                System.out.print("N??m, th??ng, ng??y nh???p h??ng s???a (t??ch nhau b???ng d???u c??ch): ");
                Date date = commodity.setNSX(sc.nextInt(), sc.nextInt(), sc.nextInt());
                
                list.get(j).setID(timType);
                list.get(j).setName(name);
                list.get(j).setType(type);
                list.get(j).setPrice(price);
                list.get(j).setNumber(number);
                list.get(j).setDate(date);
             }
        }
        System.out.println("???? s???a th??ng tin h??ng h??a "+timType);
        sc.nextLine();
    }

    //T??m SP theo lo???i
    public void findType(){
        System.out.print("Nh???p lo???i h??ng c???n t??m: ");
        String timLoai = sc.nextLine();
        System.out.println("Lo???i SP c???n t??m: "+timLoai);
        System.out.println("===========================================DANH S??CH H??NG H??A c???N T??M==========================================");
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
        System.out.println();
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
        System.out.println();
              
        boolean kq=false;

        for (Commodity commodityTimLoai : list) {
            if(timLoai.equalsIgnoreCase(commodityTimLoai.type)){
                commodityTimLoai.inTT();
                kq = true;
            }
        }

        System.out.println("===============================================================================================================");

        if(kq == false){
            System.out.println();
            System.out.println("Kh??ng t??m th???y h??ng c??ng lo???i !!");
        }
    }

    //T??m SP theo gi?? ti???n
    public void findPrice(){
        System.out.print("Nh???p gi?? t???i thi???u: ");
        Double timGia = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nh???p gi?? t???i ??a: ");
        double timGia2 = sc.nextDouble();
        sc.nextLine();

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strGia = numberFormat.format(timGia);
        String strGia2 = numberFormat.format(timGia2);

        System.out.println();
        System.out.println("Lo???i SP c???n t??m c?? gi?? kho???ng t??? "+strGia+" ?????n "+strGia2+": ");
        System.out.println("===========================================DANH S??CH H??NG H??A c???N T??M==========================================");
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
        System.out.println();
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
        System.out.println();
              
        boolean kq=false;

        sortAsc();

        for (Commodity commodityTimGia : list) {
            if(timGia <= commodityTimGia.price && timGia2 >= commodityTimGia.price){
                commodityTimGia.inTT();
                kq = true;
            }
        }
        System.out.println("===============================================================================================================");

        if(kq == false){
            System.out.println();
            System.out.println("Kh??ng t??m th???y h??ng c??ng lo???i !!");
        }
        System.out.println();
    }

    //T??m SP theo ng??y
    public void findDate(){
        System.out.print("N??m, th??ng, ng??y b???t ?????u (t??ch nhau b???ng d???u c??ch): ");
        Date date = setNSX(sc.nextInt(), sc.nextInt(), sc.nextInt()-1);
        
        System.out.print("N??m, th??ng, ng??y k???t th??c (t??ch nhau b???ng d???u c??ch): ");
        Date date2 = setNSX(sc.nextInt(), sc.nextInt(), sc.nextInt());

        sortDateFunctionASC();

        boolean kq=false;

        System.out.println("===========================================DANH S??CH H??NG H??A c???N T??M==========================================");
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
        System.out.println();
        System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
        System.out.println();
        for (Commodity commodityTimNgay : list) {
            if(date.before(commodityTimNgay.date) && date2.after(commodityTimNgay.date)){
                commodityTimNgay.inTT();
                kq = true;
            }
         }       
        System.out.println("===============================================================================================================");
        System.out.println();
        
        if(kq == false){
            System.out.println("Kh??ng t??m th???y!!");
        }
    }
   
    //S???p x???p theo gi??
    public void sortPrice(){
        int menu, chose;
        System.out.println("   -> 1. Theo lo???i h??ng \"Dien may\"");
        System.out.println("   -> 2. Theo lo???i h??ng \"Sanh su\"");
        System.out.println("   -> 3. Theo lo???i h??ng \"Thuc pham\"");
        System.out.println("   -> 4. Theo danh s??ch ban ?????u");
        System.out.print("Ch???n m???c c???n s???p x???p: ");
        menu = sc.nextInt();
        System.out.println("   -> Ch???n 1 ????? s???p x???p t??ng d???n ");
        System.out.println("   -> Ch???n 2 ????? s???p x???p gi???m d???n ");
        System.out.print("Ch???n c??ch s???p x???p: ");
        chose = sc.nextInt();
        if(chose == 1){
        switch (menu){
            case 1:
                sortAsc();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Dien May\"==============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("dien may")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();
                break;
            case 2:
                sortAsc();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Sanh su\"===============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("sanh su")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();

                break;
            case 3:
                sortAsc();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Thuc pham\"=============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("thuc pham")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();

                break;
            case 4:
                //sortType();
                sortAsc();
                System.out.println("===================================DANH S??CH H??NG H??A ???????C S???P X???P THEO NG??Y===================================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for(Commodity commoditySortDate : list){
                    commoditySortDate.inTT();
                }  
                System.out.println("===============================================================================================================");
                System.out.println();
                break;
            default:
                System.out.println("Kh??ng c?? ch???c n??ng n??y!!");
        }
        sc.nextLine();
    }
        if(chose == 2){
        switch (menu){
            case 1:
                sortDec();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Dien May\"==============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("dien may")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();
                break;
            case 2:
                sortDec();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Sanh su\"===============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("sanh su")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();

                break;
            case 3:
                sortDec();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Thuc pham\"=============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("thuc pham")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();

                break;
            case 4:
                //sortType();
                sortDec();
                System.out.println("===================================DANH S??CH H??NG H??A ???????C S???P X???P THEO NG??Y===================================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for(Commodity commoditySortDate : list){
                    commoditySortDate.inTT();
                }  
                System.out.println("===============================================================================================================");
                System.out.println();
                break;
            default:
                System.out.println("Kh??ng c?? ch???c n??ng n??y!!");
            }
            sc.nextLine();
        }
        else{
            System.out.println("Kh??ng c?? ch???c n??ng n??y!!");
        }
    } 

    //S???p x???p SP theo ng??y
    public void sortDate(){
        int menu, chose;
        System.out.println("   -> 1. Theo lo???i h??ng \"Dien may\"");
        System.out.println("   -> 2. Theo lo???i h??ng \"Sanh su\"");
        System.out.println("   -> 3. Theo lo???i h??ng \"Thuc pham\"");
        System.out.println("   -> 4. Theo danh s??ch ban ?????u");
        System.out.print("Ch???n m???c c???n s???p x???p: ");
        menu = sc.nextInt();
        System.out.println("   -> Ch???n 1 ????? s???p x???p t??ng d???n ");
        System.out.println("   -> Ch???n 2 ????? s???p x???p gi???m d???n ");
        System.out.print("Ch???n c??ch s???p x???p: ");
        chose = sc.nextInt();
        if(chose == 1){
        switch (menu){
            case 1:
                sortDateFunctionASC();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Dien May\"==============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("dien may")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();
                break;
            case 2:
                sortDateFunctionASC();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Sanh su\"===============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("sanh su")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();

                break;
            case 3:
                sortDateFunctionASC();
                System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Thuc pham\"=============================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("thuc pham")){
                        commodityTimLoai.inTT();
                    }
                }
                System.out.println("===============================================================================================================");
                System.out.println();

                break;
            case 4:
                //sortType();
                sortDateFunctionASC();
                System.out.println("===================================DANH S??CH H??NG H??A ???????C S???P X???P THEO NG??Y===================================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();
                for(Commodity commoditySortDate : list){
                    commoditySortDate.inTT();
                }  
                System.out.println("===============================================================================================================");
                System.out.println();
                break;
            default: 
                System.out.println("Kh??ng c?? ch???c n??ng n??y!!");
                break;
        }
        sc.nextLine();
    }
        if(chose == 2){
            switch (menu){
                case 1:
                    sortDateFunctionDEC();
                    System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Dien May\"==============================");
                    System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                    System.out.println();
                    System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                    System.out.println();
                    for (Commodity commodityTimLoai : list) {
                        if(commodityTimLoai.type.equalsIgnoreCase("dien may")){
                            commodityTimLoai.inTT();
                        }
                    }
                    System.out.println("===============================================================================================================");
                    System.out.println();
                    break;
                case 2:
                    sortDateFunctionDEC();
                    System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Sanh su\"===============================");
                    System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                    System.out.println();
                    System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                    System.out.println();
                    for (Commodity commodityTimLoai : list) {
                        if(commodityTimLoai.type.equalsIgnoreCase("sanh su")){
                            commodityTimLoai.inTT();
                        }
                    }
                    System.out.println("===============================================================================================================");
                    System.out.println();
    
                    break;
                case 3:
                    sortDateFunctionASC();
                    System.out.println("==================================DANH S??CH H??NG H??A ???????C S???P X???P THEO \"Thuc pham\"=============================");
                    System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n SP","Lo???i SP","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                    System.out.println();
                    System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","------","-------","-------------","--------","-------------");
                    System.out.println();
                    for (Commodity commodityTimLoai : list) {
                        if(commodityTimLoai.type.equalsIgnoreCase("thuc pham")){
                            commodityTimLoai.inTT();
                        }
                    }
                    System.out.println("===============================================================================================================");
                    System.out.println();
    
                    break;
                case 4:
                    //sortType();
                    sortDateFunctionDEC();
                    System.out.println("===================================DANH S??CH H??NG H??A ???????C S???P X???P THEO NG??Y===================================");
                    System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                    System.out.println();
                    System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                    System.out.println();
                    for(Commodity commoditySortDate : list){
                        commoditySortDate.inTT();
                    }  
                    System.out.println("===============================================================================================================");
                    System.out.println();
                    break;
                default: 
                    System.out.println("Kh??ng c?? ch???c n??ng n??y!!");
                    break;
            }
            sc.nextLine();
        }
    }

    //Th???ng k?? s??? l?????ng h??ng
    public void totalCommodity(){
        xuatDS();
        System.out.println("T???ng s??? l?????ng h??ng h??a l??: "+list.size());
        System.out.println();
    }

    //Th???ng k?? gi?? tr??? h??ng h??a
    public void sumPrice(){
        
        double sum = sum();
        for (Commodity commoditySum : list) {
            sum+= commoditySum.sumPrice;
        }

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strSum = numberFormat.format(sum);

        System.out.printf("%-12s %-22s %-20s %-11s %-10s %-10s","T???ng ti???n t???t c??? h??ng h??a l??: ","","","","",strSum);
        System.out.println();

    }
    
    //Th???ng k?? theo t???ng lo???i
    public void totalType(){
        int menu ;
        System.out.println("   -> 1. Theo lo???i h??ng \"Dien may\"");
        System.out.println("   -> 2. Theo lo???i h??ng \"Thuc pham\"");
        System.out.println("   -> 3. Theo lo???i h??ng \"Sanh su\"");
        System.out.print("Ch???n lo???i h??ng c???n th???ng k??: ");
        menu = sc.nextInt();
        
        switch(menu){
            case 1:
                System.out.println("Lo???i h??ng c???n t??m: \"dien may\"");
                System.out.println("===========================================DANH S??CH H??NG H??A c???N T??M==========================================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();

                int sizeType = 0;

                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("dien may")){
                        commodityTimLoai.inTT();
                        sizeType++;
                    }
                }

                System.out.println("===============================================================================================================");
                System.out.println("T???ng s??? l?????ng h??ng h??a \"dien may\" l??: "+sizeType);
                break;

            case 2:
                System.out.println("Lo???i h??ng c???n t??m: \"thuc pham\"");
                System.out.println("===========================================DANH S??CH H??NG H??A c???N T??M==========================================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();

                int sizeType2 = 0;

                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("thuc pham")){
                        commodityTimLoai.inTT();
                        sizeType2++;
                    }
                }

                System.out.println("===============================================================================================================");
                System.out.println("T???ng s??? l?????ng h??ng h??a \"thuc pham\" l??: "+sizeType2);

                break;

            case 3:
                System.out.println("Lo???i h??ng c???n t??m: \"sanh su\"");
                System.out.println("===========================================DANH S??CH H??NG H??A c???N T??M==========================================");
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","M?? h??ng","T??n h??ng","Lo???i h??ng","Gi?? b??n(/1sp)","S??? l?????ng","Ng??y nh???p kho");
                System.out.println();
                System.out.printf("%-12s %-22s %-20s %-20s %-19s %-20s","-------","--------","---------","-------------","--------","-------------");
                System.out.println();

                int sizeType3 = 0;

                for (Commodity commodityTimLoai : list) {
                    if(commodityTimLoai.type.equalsIgnoreCase("sanh su")){
                        commodityTimLoai.inTT();
                        sizeType3++;
                    }
                }

                System.out.println("===============================================================================================================");
                System.out.println("T???ng s??? l?????ng h??ng h??a \"sanh su\" l??: "+sizeType3);

                break;

            default:
                System.out.println("Kh??ng c?? lo???i h??ng n??y!!");   

                break;
        }
        System.out.println();
    }
}
