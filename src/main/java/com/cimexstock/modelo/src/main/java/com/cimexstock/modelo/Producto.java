package com.cimexstock.modelo.src.main.java.com.cimexstock.modelo;

public class Producto {
    private int id;
    private String nombre;
    private String codigo;
    private double valorUnitario;
    private int Stock;
    private int StockMinimo;
    private int StockRecomendado;
    private Proveedor proveedor;

    public Producto(int id, String nombre, String codigo, double valorUnitario, int stock, int stockMinimo, int stockRecomendado, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.valorUnitario = valorUnitario;
        this.Stock = stock;
        this.StockMinimo = stockMinimo;
        this.StockRecomendado = stockRecomendado;
        this.proveedor = proveedor;
    }

    public Producto() {
    }

    @Override
    public String toString() {
        String sep = " | ";
        return id + sep + nombre + sep + codigo + sep + valorUnitario +
                sep + Stock + sep + StockMinimo +
                sep + StockRecomendado +
                sep + proveedor.getNombre() + " \n ";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getStockMinimo() {
        return StockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        StockMinimo = stockMinimo;
    }

    public int getStockRecomendado() {
        return StockRecomendado;
    }

    public void setStockRecomendado(int stockRecomendado) {
        StockRecomendado = stockRecomendado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
