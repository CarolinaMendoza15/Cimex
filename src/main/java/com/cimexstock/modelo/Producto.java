package com.cimexstock.modelo;

public class Producto {
    private int id;
    private String nombre;
    private double valorUnitario;
    private int Stock;
    private  int StockMinimo;
    private  int StockRecomendado;
    private  Proveedor proveedor;

    public Producto(int id, String nombre, double valorUnitario, int stock, int stockMinimo, int stockRecomendado, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        Stock = stock;
        StockMinimo = stockMinimo;
        StockRecomendado = stockRecomendado;
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", Stock=" + Stock +
                ", StockMinimo=" + StockMinimo +
                ", StockRecomendado=" + StockRecomendado +
                ", proveedor=" + proveedor +
                '}';
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
