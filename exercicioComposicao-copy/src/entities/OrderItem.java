package entities;

public class OrderItem {
    private Integer quantity;
    private Double price; /*O atributo price está presente tanto na Classe OrdemItem como na Product,
     pois caso o produto mude de preço no futuro, no historico do pedido irá ter o preço pelo qual foi comprado e não o preço atual do produto.*/
    private Product product;

    public OrderItem(){}

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal(){
        return price * quantity;
    }


    @Override
    public String toString(){
        return getProduct().getName()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity
                +", SubTotal: $"
                +String.format("%.2f",subTotal());
    }

}
