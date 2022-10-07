package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

//Tabla trabajada!
@Entity
@Table(name = "clientes", schema = "getit")
public class ClientesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_cliente", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "primer_nombre", nullable = false, length = 50)
    private String primerNombre;
    @Basic
    @Column(name = "primer_apellido", nullable = false, length = 50)
    private String primerApellido;
    @Basic
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Basic
    @Column(name = "fecha_nac", nullable = false)
    private Date fechaNac;
    @Basic
    @Column(name = "domicilio", nullable = false, length = 100)
    private String domicilio;

    //Relacion entre los clientes y la tabla general de usuarios
    @OneToMany(mappedBy = "clientesEntity")
    private Collection<UsuariosEntity> usuariosByIdCliente;

    //Relacion entre lso clientes y los pagos en los que esta involucrado el mismo
    @OneToMany(mappedBy = "clientesByIdCliente")
    private Collection<PagosEntity> pagosByIdCliente;

    //Relacion entre el cliente y la tabla de quejas que el mismo ha efectuado
    @OneToMany(mappedBy = "clientesByIdIdUsuario")
    private Collection<QuejasEntity> quejasByIdCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientesEntity that = (ClientesEntity) o;

        if (idCliente != that.idCliente) return false;
        if (primerNombre != null ? !primerNombre.equals(that.primerNombre) : that.primerNombre != null) return false;
        if (primerApellido != null ? !primerApellido.equals(that.primerApellido) : that.primerApellido != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fechaNac != null ? !fechaNac.equals(that.fechaNac) : that.fechaNac != null) return false;
        if (domicilio != null ? !domicilio.equals(that.domicilio) : that.domicilio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (primerNombre != null ? primerNombre.hashCode() : 0);
        result = 31 * result + (primerApellido != null ? primerApellido.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fechaNac != null ? fechaNac.hashCode() : 0);
        result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
        return result;
    }

    public Collection<UsuariosEntity> getUsuariosByIdCliente() {
        return usuariosByIdCliente;
    }

    public void setUsuariosByIdCliente(Collection<UsuariosEntity> usuariosByIdCliente) {
        this.usuariosByIdCliente = usuariosByIdCliente;
    }

    public Collection<PagosEntity> getPagosByIdCliente() {
        return pagosByIdCliente;
    }

    public void setPagosByIdCliente(Collection<PagosEntity> pagosByIdCliente) {
        this.pagosByIdCliente = pagosByIdCliente;
    }

    public Collection<QuejasEntity> getQuejasByIdCliente() {
        return quejasByIdCliente;
    }

    public void setQuejasByIdCliente(Collection<QuejasEntity> quejasByIdCliente) {
        this.quejasByIdCliente = quejasByIdCliente;
    }
}
