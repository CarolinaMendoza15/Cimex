package com.cimexstock.modelo.src.main.java.com.cimexstock.controller;

import com.cimexstock.modelo.src.main.java.com.cimexstock.db.ProveedorDb;
import com.cimexstock.modelo.src.main.java.com.cimexstock.modelo.Producto;
import com.cimexstock.modelo.src.main.java.com.cimexstock.modelo.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class CimexController {
    public CimexController() {
    }

    public void printItem() {
        System.out.println("1_Consultar Productos Stock ");
        System.out.println("2_Agregar Producto");
        System.out.println("3_Editar Producto");
        System.out.println("4_Borrar Producto");
        System.out.println("5_Agregar Usuario");
        System.out.println("6_Editar Usuario");
        System.out.println("7_Borrar Usuario");
        System.out.println("8_Listar Usuario");
        System.out.println("9_Consultar Productos con Alerta de Stock ");
        System.out.println("10_Listar Proveedor");
        System.out.println("11_SALIR");
    }

    public void printItem1() throws SQLException {
        ProductoController controller = new ProductoController();
        System.out.println("ID | NOMBRE | CODIGO| PRECIO | STOCK | STOCK MINIMO | STOC RECOMENDADO |PROVEEDOR ");
        System.out.println(controller.listartarProducto());

    }

    public void printItem2() throws SQLException {
        ProductoController controller = new ProductoController();
        Scanner scan = new Scanner(System.in);
        Producto producto = new Producto();
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

    public void printItem3Edi(Producto producto) throws SQLException {
        ProductoController controller = new ProductoController();
        Scanner scan = new Scanner(System.in);
        String edit;
        Integer mod = null;
        System.out.println("Editar Producto ");
        System.out.println("Editar Nombre " + producto.getNombre());
        edit = scan.nextLine();
        if (edit != "")
            producto.setNombre(edit);
        System.out.println("Editar Codigo " + producto.getCodigo());
        edit = scan.nextLine();
        if (edit != "")
            producto.setCodigo(edit);
        System.out.println("Editar Stock " + producto.getStock());
        mod = scan.nextInt();
        if (mod != null)
            producto.setStock(mod);
        scan.nextLine();
        System.out.println("Editar Stock Minimo " + producto.getStockMinimo());
        mod = scan.nextInt();
        if (mod != null)
            producto.setStockMinimo(mod);
        scan.nextLine();
        System.out.println("Editar Stock Recomendado " + producto.getStockRecomendado());
        mod = scan.nextInt();
        if (mod != null)
            producto.setStockRecomendado(mod);
        scan.nextLine();
        System.out.println("Editar $ Precio " + producto.getValorUnitario());
        Double modD = scan.nextDouble();
        if (mod != null)
            producto.setValorUnitario(mod);
        scan.nextLine();
        //pendiente agregar Proveedor controller
        producto.setProveedor(ProveedorDb.getProveedor(1));
        controller.modificarProducto(producto);

    }

    public void printItem3(Boolean editar) throws SQLException {
        ProductoController controller = new ProductoController();
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione Producto:");
        System.out.println(controller.listartarProducto());
        System.out.println("ID= ");
        if (editar) {
            Integer numero = scan.nextInt();
            Producto producto = controller.consultarProducto(numero);
            printItem3Edi(producto);
        } else {
            Integer numero = scan.nextInt();
            controller.eliminarProducto(numero);
        }
        Integer numero = scan.nextInt();
        controller.eliminarProducto(numero);

    }

    public void printItem4() throws SQLException {
        UsuarioController userController = new UsuarioController();
        Scanner scan = new Scanner(System.in);
        Usuario usuario = new Usuario();
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

    public void printItem5(Usuario usuario) throws SQLException {
        UsuarioController userController = new UsuarioController();
        String str;
        Integer varint = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Editar Usuario");
        System.out.println("Nombre " + usuario.getNombre());
        str = scan.nextLine();
        if (str != "")
            usuario.setNombre(str);
        System.out.println("Direccion " + usuario.getDireccion());
        str = scan.nextLine();
        if (str != "")
            usuario.setDireccion(str);
        System.out.println("telefono " + usuario.getTelefono());
        varint = scan.nextInt();
        if (varint != null)
            usuario.setTelefono(varint);
        scan.nextLine();
        System.out.println("Usuario " + usuario.getUsser());
        str = scan.nextLine();
        if (str != "")
            usuario.setUsser(str);
        System.out.println("Contracenia " + usuario.getPassware());
        str = scan.nextLine();
        if (str != "")
            usuario.setPassware(str);
        userController.modificarUsuario(usuario);

    }

    public void printItem5(boolean editar) throws SQLException {
        UsuarioController usuarioController = new UsuarioController();
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione usuario :");
        System.out.println(usuarioController.listartarUsuario());
        System.out.println("ID= ");
        if (editar) {
            Integer numero = scan.nextInt();
            Usuario usu = usuarioController.consultarUsuario(numero);
            printItem5(usu);
        } else {
            Integer numero = scan.nextInt();
            usuarioController.eliminarUsuario(numero);
        }


    }

    public void printItem7() throws SQLException {
        UsuarioController usuarioController = new UsuarioController();
        System.out.println(usuarioController.listartarUsuario());
    }

    public void exit() throws SQLException {
        LoguinController servlet = new LoguinController();
        servlet.Loguin();
    }

    public void Menu() throws SQLException {
        UsuarioController usuarioServlet = new UsuarioController();
        LoguinController loguinController = new LoguinController();
        String numero = "";

        ProductoController controller = new ProductoController();
        int cont = controller.listartarProductoAlertaStock().size();
        if (cont > 0)
            System.out.println("!!!!!!!!!!!POSEE  " + cont + " PRODUCTOS BAJOS DE STOCK!!!!!!!!!!");
        boolean seguir = true;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("****************CIMEX***************\n");
            System.out.println("****************MENU***************\n");
            printItem();
            System.out.println("ITEM = ");
            numero = scan.next();
            switch (numero) {
                case "1":
                    printItem1();
                    break;
                case "2":
                    printItem2();
                    break;
                case "3":
                    printItem3(true);
                    break;
                case "4":
                    ;
                    printItem3(false);
                    break;
                case "5":
                    printItem4();
                    break;
                case "6":
                    printItem5(true);
                    break;
                case "7":
                    printItem5(false);
                    break;
                case "8":
                    printItem7();
                    break;
                case "9":
                    printItem8();
                    break;
                case "10":
                    printItem9();
                    break;
                case "11":
                    seguir = false;
                    break;
                default:
                    System.out.println("ERROR! Seleccione un item");
            }
        } while (seguir);
        exit();
    }

    private void printItem8() throws SQLException {
        ProductoController controller = new ProductoController();
        System.out.println("ID | NOMBRE | CODIGO| PRECIO | STOCK | STOCK MINIMO | STOC RECOMENDADO |PROVEEDOR ");
        System.out.println(controller.listartarProductoAlertaStock());
    }

    private void printItem9() throws SQLException {
        ProveedorController controller = new ProveedorController();
        System.out.println(controller.listartarProveedor());
    }
}