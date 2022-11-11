package com.cimexstock.controller;

import com.cimexstock.db.ProveedorDb;
import com.cimexstock.modelo.Producto;
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
        System.out.println("5_Editar Usuario");
        System.out.println("6_Borrar Usuario");
        System.out.println("7_Listar Usuario");
        System.out.println("8_Consultar Productos con Alerta de Stock ");
        System.out.println("9_Listar Proveedor");
        System.out.println("10_SALIR");
    }
    public  void  printItem1() throws SQLException {
        ProductoController controller= new ProductoController();
        System.out.println("ID | NOMBRE | CODIGO| PRECIO | STOCK | STOCK MINIMO | STOC RECOMENDADO |PROVEEDOR ");
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
    public  void  printItem5(Usuario usuario) throws SQLException {
        UsuarioController userController= new UsuarioController();
        String str;
        Integer varint=null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Editar Usuario");
        System.out.println("Nombre "+ usuario.getNombre() );
        str=scan.nextLine();
        if (str != "" )
            usuario.setNombre(str);
        System.out.println("Direccion " + usuario.getDireccion());
        str=scan.nextLine();
        if (str != "")
            usuario.setDireccion(str);
        System.out.println("telefono "+ usuario.getTelefono());
        varint=scan.nextInt();
        if (varint != null)
            usuario.setTelefono(varint);
        scan.nextLine();
        System.out.println("Usuario " + usuario.getUsser());
        str=scan.nextLine();
        if (str != "")
            usuario.setUsser(str);
        System.out.println("Contracenia " + usuario.getPassware());
        str=scan.nextLine();
        if (str != "")
            usuario.setPassware(str);
        userController.modificarUsuario(usuario);

    }
    public  void  printItem5(boolean editar) throws SQLException {
        UsuarioController usuarioController= new UsuarioController();
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione usuario :");
        System.out.println(usuarioController.listartarUsuario());
        System.out.println("ID= ");
        if (editar){
            Integer numero = scan.nextInt();
            Usuario usu = usuarioController.consultarUsuario(numero);
            printItem5(usu);
        }else{
            Integer numero = scan.nextInt();
            usuarioController.eliminarUsuario(numero);
        }


    }
    public  void printItem7() throws SQLException {
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

        ProductoController controller= new ProductoController();
        int cont =controller.listartarProductoAlertaStock().size();
        if (cont >0)
            System.out.println("!!!!!!!!!!!POSEE  " + cont + " PRODUCTOS BAJOS DE STOCK!!!!!!!!!!");
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
                case "5":printItem5(true);
                    break;
                case "6": printItem5(false);
                    break;
                case "7": printItem7();
                    break;
                case "8": printItem8();
                    break;
                case "9": printItem9();
                    break;
                case "10":
                    seguir=false;
                    break;
                default:System.out.println("ERROR! Seleccione un item");
            }
        } while (seguir);
        exit();
    }

    private void printItem8() throws SQLException {
        ProductoController controller= new ProductoController();
        System.out.println("ID | NOMBRE | CODIGO| PRECIO | STOCK | STOCK MINIMO | STOC RECOMENDADO |PROVEEDOR ");
        System.out.println(controller.listartarProductoAlertaStock());
    }

    private void printItem9() throws SQLException {
        ProveedorController controller= new ProveedorController();
        System.out.println(controller.listartarProveedor());
    }
}