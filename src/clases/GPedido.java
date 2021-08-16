package clases;

public class GPedido {
    private String codp;
    private String fechar;
    private String fechae;
    private String estado;
    private String dni;

    public GPedido() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechae() {
        return fechae;
    }

    public void setFechae(String fechae) {
        this.fechae = fechae;
    }

    public String getFechar() {
        return fechar;
    }

    public void setFechar(String fechar) {
        this.fechar = fechar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodp() {
        return codp;
    }

    public void setCodp(String codp) {
        this.codp = codp;
    }
    
}
