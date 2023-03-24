/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sesi5;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author keziaaudi
 */
public class Session5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        double prc = 0;
        String itm, prc1;
        int chs;
        int qty = 0;
        int stc = 50, dsc = 0;
        double tot,cst = 0;
        DecimalFormat df = new DecimalFormat("#.##");
         
        //header
        System.out.println("ES Companies Portal - Cashier App 3");
        System.out.println("===================================");
        
        //no.1
        //user input item name
        do{
        System.out.print("Input Item's name [5..30 characters] : ");
        itm = input.nextLine();
        } 
        while ((itm.length() < 5)&&(itm.length() < 30));
        
        //user input item price
        do{
           System.out.print("Input item's price [use decimal numbers] 10.0-2000.0]: $"); 
           prc1= input.nextLine(); 
           try{
            prc = Double.parseDouble(prc1);
           }
           catch (NumberFormatException e){
               System.out.println("Input must be number!");
           }
        }
         while ((prc > 2000.0) || (prc < 10.0));
        
        //no.2
        //display menu
        boolean exit = false;
        while(!exit){
        System.out.println("\nWhat will you do?");
        System.out.println("=================");
        
        System.out.println("1. Sell item");
        System.out.println("2. Restock item");
        System.out.println("3. Exit");
        System.out.print("\nChoose : ");
        chs = input.nextInt();
        
        //menu 1
        if (chs == 1){
            qty = 0;
            dsc = 0;
            cst = 0;       
            if (stc < 1){
                System.out.println("Out of Stock!");
            }
            else{
                while((qty > stc) ||(qty < 1)){
                    if (qty > stc)
                        System.out.println("Out of stock!");
                System.out.print("Input item's quantity [1.."+stc+"] : ");
                    while (!input.hasNextInt()) {
                    System.out.println("Input must be a number!");
                    System.out.print("Input item's quantity [1.." + stc + "] : ");
                    input.next();
                    }
                    qty = input.nextInt();
                }
                
                while ((dsc > 50) || (dsc < 1)){
                    System.out.print("Input item's discount [0..50] : ");
                    while (!input.hasNextInt()) {
                        System.out.println("Input must be a number!");
                        System.out.print("Input item's discount [0..50] : ");
                        input.next();
            }
                    dsc = input.nextInt();
                }
                System.out.println("\nES Companies Portal - Invoice");
                System.out.println("=============================");
                System.out.println("Item's name     : "+itm);
                System.out.println("Item's price    : "+ df.format(prc));
                System.out.println("Item's quantity : "+qty);
                System.out.println("Item's discount : "+dsc+ "%");
                
                double pym;
                tot = (prc*qty*(100-dsc)/100);
                System.out.println("\nYou have to pay $"+ df.format(tot));
                while(cst < tot){
                    System.out.print("Input your money [use decimal numbers | min "+ df.format(tot)+"] : $");
                    while (!input.hasNextDouble()) { // check if input is a double
                    System.out.println("Input must be number");
                    System.out.print("Input your money [use decimal numbers | min "+ df.format(tot)+"] : $");
                    input.next();
                }
                    cst = input.nextDouble();
        }
                pym = (cst - tot);
                System.out.println("\nThanks for purchasing!");
                    System.out.println("Your change : $"+ df.format(pym));
                stc = stc-qty;
                Scanner enter = new Scanner (System.in);
                enter.nextLine();
                }
        }
        //menu 2
        else if (chs == 2){
                if(stc>99)
                    System.out.println("item stok full, please sell it");
                else{
                    int inptstc=stc;
                    int totstc = 100 - inptstc;
                    
                    do {
                        System.out.print("\nAdd stock [1.." + totstc + "]: ");
                        if (input.hasNextInt()) {
                            inptstc = input.nextInt();
                            if (inptstc >= 1 && inptstc <= totstc) {
                                stc += inptstc;
                                System.out.println("Success add stock!");
                                break;
                            } 
                            else {
                                System.out.println("Out of stock!");
                            }
                        } 
                            else {
                            System.out.println("Item must be a number!");
                            input.next();
                        }
                    } 
                    while (true);
                    Scanner enter = new Scanner (System.in);
                    enter.nextLine();
        }
    }
        //menu 3
        else{
            exit = true;
            System.out.println("Thanks for using this application :)");
            
            }
        }
    }
 }