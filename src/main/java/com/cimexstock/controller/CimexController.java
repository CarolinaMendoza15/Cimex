package com.cimexstock.controller;

import com.cimexstock.db.ProveedorDb;
import com.cimexstock.modelo.Producto;
import com.cimexstock.modelo.Proveedor;
import com.cimexstock.modelo.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class CimexController {
    public CimexController() {
    }
    public  void  printItem(){
        System.out.println("1_Consultar Productos Stock ");
        System.out.println("2_Agregar Producto");
        System.out.println("3_Borrar Producto");
        System.out.println("4_Agregar Usuario");
        System.out.println("5_Borrar Usuario");
        System.out.println("6_Listar Usuario");
        System.out.println("7_Consultar Productos con Alerta de Stock ");
        System.out.println("8_SALIR");
    }
    public  void  printItem1() throws SQLException {
        ProductoController controller= new ProductoController();
        System.out.println(controller.listartarProducto());

    }
    public  void  printItem2() throws SQLException {
        ProductoController controller= new ProductoController();
        Scanner scan = new Scanner(System.in);
        Producto producto= new Producto();
        System.out.println("Nuevo Producto");
        System.out.println("Numero Identificador");
        producto.setId(scan.nextInt());
        scan.nextLine();
        System.out.println("Nombre");
        producto.setNombre(scan.nextLine());
        System.out.println("Codigo");
        producto.setCodigo(scan.nextLine());
        System.out.println("Stock");
        producto.setStock(scan.nextInt());
        scan.nextLine();
        System.out.println("Stock Minimo ");
        producto.setStockMinimo(scan.nextInt());
        scan.nextLine();
        System.out.println("Stock Recomendado");
        producto.setStockRecomendado(scan.nextInt());
        scan.nextLine();
        System.out.println("$ Precio");
        producto.setValorUnitario(scan.nextDouble());
        scan.nextLine();
        //pendiente agregar Proveedor controller
        producto.setProveedor(ProveedorDb.getProveedor(1));
        controller.addProducto(producto);

    }
    public  void  printItem3() throws SQLException {
        ProductoController controller= new ProductoController();
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione Producto a eliminar:");
        System.out.println(controller.listartarProducto());
        System.out.println("ID= ");
        Integer numero = scan.nextInt();
        controller.eliminarProducto(numero);

    }
    public  void  printItem4() throws SQLException {
        UsuarioController userController= new UsuarioController();
        Scanner scan = new Scanner(System.in);
        Usuario usuario= new Usuario();
        System.out.println("4_Nuevo Usuario");
        System.out.println("Nimero Identificador");
        usuario.setId(scan.nextInt());
        scan.nextLine();
        System.out.println("Nombre");
        usuario.setNombre(scan.nextLine());
        System.out.println("Direccion");
        usuario.setDireccion(scan.nextLine());
        System.out.println("telefono");
        usuario.setTelefono(scan.nextInt());
        scan.nextLine();
        System.out.println("Usuario");
        usuario.setUsser(scan.nextLine());
        System.out.println("Contracenia");
        usuario.setPassware(scan.nextLine());

        userController.addUsuario(usuario);

    }
    public  void  printItem5() throws SQLException {
        UsuarioController usuarioController= new UsuarioController();
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione usuario a eliminar:");
        System.out.println(usuarioController.listartarUsuario());
        System.out.println("ID= ");
        Integer numero = scan.nextInt();
        usuarioController.eliminarUsuario(numero);
    }
    public  void  printItem6() throws SQLException {
        UsuarioController usuarioController= new UsuarioController();
        System.out.println(usuarioController.listartarUsuario());
    }
    public  void exit() throws SQLException {
        LoguinController servlet = new LoguinController();
        servlet.Loguin();
    }
    public void Menu() throws SQLException {
        UsuarioController usuarioServlet=new UsuarioController();
        LoguinController loguinController=new LoguinController();
        String numero="";
        boolean seguir=true;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("****************CIMEX***************\n");
            System.out.println("****************MENU***************\n");
            printItem();
            System.out.println("ITEM = ");
            numero = scan.next();
            switch(numero){
                case "1": printItem1();
                    break;
                case "2": printItem2();
                    break;
                case "3": printItem3();
                    break;
                case "4":printItem4();
                    break;
                case "5": printItem5();
                    break;
                case "6": printItem6();
                    break;
                case "7": printItem7();
                    break;
                case "8":
                    seguir=false;
                    break;
                default:System.out.println("ERROR! Seleccione un item");
            }
        } while (seguir);
        exit();
    }

    private void printItem7() throws SQLException {
        ProductoController controller= new ProductoController();
        System.out.println(controller.listartarProductoAlertaStock());
    }
}
