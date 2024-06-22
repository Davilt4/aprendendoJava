package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        //Cliente
        System.out.println("Digite os dados do cliente:");

        System.out.print("Nome: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Data de nascimento(dd/mm/aaaa): ");
        Date birthDate = dateFormat.parse(sc.next());

        Client client = new Client(name,email,birthDate);
        System.out.println();

        //Pedido
        System.out.println("Digite os dados do pedido:");

        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Date orderDate = new Date();

        Order order = new Order(orderDate,status,client);

        System.out.print("Quantos itens tem esse pedido: ");
        int N = sc.nextInt();


        for (int i = 0;i<N;i++){
            System.out.println();
            System.out.println("Digite os dados do pedido "+(i+1));

            System.out.print("Nome: ");
            sc.nextLine();
            String productName = sc.nextLine();

            System.out.print("Preço: ");
            double productPrice = sc.nextDouble();

            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName,productPrice);

            OrderItem item = new OrderItem(quantity, productPrice,product);
            order.addItem(item);
        }

        System.out.println();
        System.out.println(order.toString());

        sc.close();

    }
}
