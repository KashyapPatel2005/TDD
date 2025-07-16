package org.example;

public class Sweet {
    private int id; //Unique identifier for each sweet
    private String name;
    private String category;
    private double price;
    private int quantity;


    // Creates new Sweet Object
    public Sweet(int id,String name,String category,double price,int quantity){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }


    //Getter Methods
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }



    //Setter methods
    public void setId(int id){
        this.id = id;;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }



}
