import java.util.*;

class Product{
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    public static int totalProducts=0;
    public static Set<String> categories=new HashSet<>();

    public Product(String productId, String productName, double price, String category, int stockQuantity){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        this.category=category;
        this.stockQuantity=stockQuantity;
        totalProducts++;
        categories.add(category);
    }

    public String getProductId(){ return productId; }
    public String getProductName(){ return productName; }
    public double getPrice(){ return price; }
    public String getCategory(){ return category; }
    public int getStockQuantity(){ return stockQuantity; }

    public void reduceStock(int qty){ stockQuantity-=qty; }
    public void increaseStock(int qty){ stockQuantity+=qty; }

    public void displayProduct(){
        System.out.println(productId+" | "+productName+" | $"+price+" | "+category+" | Stock: "+stockQuantity);
    }

    public static Product findProductById(Product[] products, String productId){
        for(Product p : products){
            if(p.getProductId().equals(productId))  return p;
        }
        return null;
    }

    public static void getProductsByCategory(Product[] products, String category){
        System.out.println("\nProducts in Category: "+category);
        for(Product p : products){
            if(p.getCategory().equalsIgnoreCase(category)){
                p.displayProduct();
            }
        }
    }
}

class ShoppingCart{
    private String cartId;
    private String customerName;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;
    private double cartTotal;

    public ShoppingCart(String cartId, String customerName){
        this.cartId=cartId;
        this.customerName=customerName;
        this.products=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.cartTotal=0.0;
    }

    public void addProduct(Product product, int quantity){
        if(product.getStockQuantity()>=quantity){
            products.add(product);
            quantities.add(quantity);
            product.reduceStock(quantity);
            calculateTotal();
            System.out.println(quantity+" x "+product.getProductName()+" added to cart");
        }
        else{
            System.out.println("Not enough stock available for "+product.getProductName());
        }
    }

    public void removeProduct(String productId){
        for(int i=0; i<products.size(); i++){
            if(products.get(i).getProductId().equals(productId)){
                Product p=products.get(i);
                int qty=quantities.get(i);
                p.increaseStock(qty);
                products.remove(i);
                quantities.remove(i);
                calculateTotal();
                System.out.println("Removed "+p.getProductName()+" from cart");
                return;
            }
        }
        System.out.println("Product not found in cart");
    }

    public void calculateTotal(){
        cartTotal=0;
        for(int i=0; i<products.size(); i++){
            cartTotal+=products.get(i).getPrice()*quantities.get(i);
        }
    }

    public void displayCart(){
        System.out.println("\n====== Shopping Cart (" + customerName + ") ======");
        if(products.isEmpty()){
            System.out.println("Cart is empty");
            return;
        }
        for(int i=0; i < products.size(); i++){
            System.out.println(products.get(i).getProductName()+" x "+quantities.get(i)+" = $"+(products.get(i).getPrice()*quantities.get(i)));
        }
        System.out.println("Cart Total: $"+cartTotal);
    }

    public void checkout(){
        if(products.isEmpty()){
            System.out.println("Cart is empty, nothing to checkout");
            return;
        }
        System.out.println("\nCheckout successful for "+customerName+"!");
        System.out.println("Final Total: $"+cartTotal);
        products.clear();
        quantities.clear();
        cartTotal=0;
    }
}

public class ShoppingCartSystem{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        Product[] products={
                new Product("P001","Laptop",800,"Electronics",10),
                new Product("P002","Smartphone",500,"Electronics",15),
                new Product("P003","Headphones",50,"Electronics",20),
                new Product("P004","Jeans",40,"Clothing",30),
                new Product("P005","T-Shirt",20,"Clothing",50),
                new Product("P006","Shoes",60,"Clothing",25),
                new Product("P007","Refrigerator",700,"Appliances",5),
                new Product("P008","Microwave",150,"Appliances",8),
                new Product("P009","Novel Book",15,"Books",40),
                new Product("P010","Textbook",60,"Books",12)
        };

        ShoppingCart cart=new ShoppingCart("C001", "Alice");

        int choice;
        do{
            System.out.println("\n====== Online Shopping Cart Menu ======");
            System.out.println("1. View All Products");
            System.out.println("2. View Products by Category");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice=input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                    System.out.println("\nAvailable Products:");
                    for(Product p : products)  p.displayProduct();
                    break;
                case 2:
                    System.out.println("Available categories: "+Product.categories);
                    System.out.print("Enter category: ");
                    String cat=input.nextLine();
                    Product.getProductsByCategory(products,cat);
                    break;
                case 3:
                    System.out.print("Enter Product ID to add: ");
                    String addId=input.nextLine();
                    Product addProd=Product.findProductById(products,addId);
                    if(addProd!=null){
                        System.out.print("Enter quantity: ");
                        int qty=input.nextInt();
                        cart.addProduct(addProd,qty);
                    }
                    else{
                        System.out.println("Product not found");
                    }
                    break;
                case 4:
                    System.out.print("Enter Product ID to remove: ");
                    String remId=input.nextLine();
                    cart.removeProduct(remId);
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    cart.checkout();
                    break;
                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=7);
        input.close();
    }
}
