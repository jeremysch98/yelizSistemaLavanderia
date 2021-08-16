package clases;

public class DetallePedido {
    private int coda;
    private String descripcion;
    private int cantidad; 
    private double precio;
    private String codped;
    private double subtotal;

    public DetallePedido() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodped() {
        return codped;
    }

    public void setCodped(String codped) {
        this.codped = codped;
    }

    public int getCoda() {
        return coda;
    }

    public void setCoda(int coda) {
        this.coda = coda;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
}
