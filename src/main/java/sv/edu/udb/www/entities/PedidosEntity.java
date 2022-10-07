package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.sql.Date;

//Tabla trabajada!
@Entity
@Table(name = "pedidos", schema = "getit")
public class PedidosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_pedido", nullable = false)
    private int idPedido;
    @Basic
    @Column(name = "Id_pago", nullable = false)
    private int idPago;
    @Basic
    @Column(name = "Id_motorista", nullable = false)
    private int idMotorista;
    @Basic
    @Column(name = "Id_unidadTransporte", nullable = false)
    private int idUnidadTransporte;
    @Basic
    @Column(name = "Id_administrador", nullable = false)
    private int idAdministrador;
    @Basic
    @Column(name = "direccion_domicilio", nullable = false, length = 50)
    private String direccionDomicilio;
    @Basic
    @Column(name = "tiempo_tardado", nullable = false, length = 30)
    private String tiempoTardado;
    @Basic
    @Column(name = "estado_pedido", nullable = false)
    private int estadoPedido;
    @Basic
    @Column(name = "fecha_efectuacion", nullable = false)
    private Date fechaEfectuacion;

    //Es one to one porque un pago es para un pedido. Ademas el papel de many lo juega esta entidad (PedidosEntity)
    //ya que manda a llamar en sí con el JoinColumn su referencia, por lo cual es el predominante entre los dos
    @OneToOne
    @JoinColumn(name = "Id_pago", referencedColumnName = "Id_pago", nullable = false)
    private PagosEntity pagosByIdPago;

    @ManyToOne
    @JoinColumn(name = "Id_motorista", referencedColumnName = "Id_motorista", nullable = false)
    private MotoristaEntity motoristaByIdMotorista;

    @ManyToOne
    @JoinColumn(name = "Id_unidadTransporte", referencedColumnName = "Id_unidadTransporte", nullable = false)
    private UnidadesTransporteEntity unidadesTransporteEntity;

    @ManyToOne
    @JoinColumn(name = "Id_administrador", referencedColumnName = "Id_administrador_getit", nullable = false)
    private AdministradorGetitEntity administradorGetitByIdAdministrador;

    @ManyToOne
    @JoinColumn(name = "estado_pedido", referencedColumnName = "Id_estado", nullable = false)
    private EstadosPedidoEntity estadosPedidoByEstadoPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public int getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(int idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getTiempoTardado() {
        return tiempoTardado;
    }

    public void setTiempoTardado(String tiempoTardado) {
        this.tiempoTardado = tiempoTardado;
    }

    public int getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(int estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Date getFechaEfectuacion() {
        return fechaEfectuacion;
    }

    public void setFechaEfectuacion(Date fechaEfectuacion) {
        this.fechaEfectuacion = fechaEfectuacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidosEntity that = (PedidosEntity) o;

        if (idPedido != that.idPedido) return false;
        if (idPago != that.idPago) return false;
        if (idMotorista != that.idMotorista) return false;
        if (idUnidadTransporte != that.idUnidadTransporte) return false;
        if (idAdministrador != that.idAdministrador) return false;
        if (estadoPedido != that.estadoPedido) return false;
        if (direccionDomicilio != null ? !direccionDomicilio.equals(that.direccionDomicilio) : that.direccionDomicilio != null)
            return false;
        if (tiempoTardado != null ? !tiempoTardado.equals(that.tiempoTardado) : that.tiempoTardado != null)
            return false;
        if (fechaEfectuacion != null ? !fechaEfectuacion.equals(that.fechaEfectuacion) : that.fechaEfectuacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedido;
        result = 31 * result + idPago;
        result = 31 * result + idMotorista;
        result = 31 * result + idUnidadTransporte;
        result = 31 * result + idAdministrador;
        result = 31 * result + (direccionDomicilio != null ? direccionDomicilio.hashCode() : 0);
        result = 31 * result + (tiempoTardado != null ? tiempoTardado.hashCode() : 0);
        result = 31 * result + estadoPedido;
        result = 31 * result + (fechaEfectuacion != null ? fechaEfectuacion.hashCode() : 0);
        return result;
    }

    //Pago realizado para haber hecho el pedido

    public PagosEntity getPagosByIdPago() {
        return pagosByIdPago;
    }

    public void setPagosByIdPago(PagosEntity pagosByIdPago) {
        this.pagosByIdPago = pagosByIdPago;
    }

    //Motorista asignado para el pedido

    public MotoristaEntity getMotoristaByIdMotorista() {
        return motoristaByIdMotorista;
    }

    public void setMotoristaByIdMotorista(MotoristaEntity motoristaByIdMotorista) {
        this.motoristaByIdMotorista = motoristaByIdMotorista;
    }

    //Administrador de getit que atendió el pedido

    public AdministradorGetitEntity getAdministradorGetitByIdAdministrador() {
        return administradorGetitByIdAdministrador;
    }

    public void setAdministradorGetitByIdAdministrador(AdministradorGetitEntity administradorGetitByIdAdministrador) {
        this.administradorGetitByIdAdministrador = administradorGetitByIdAdministrador;
    }

    //Estados de Pedido

    public EstadosPedidoEntity getEstadosPedidoByEstadoPedido() {
        return estadosPedidoByEstadoPedido;
    }

    public void setEstadosPedidoByEstadoPedido(EstadosPedidoEntity estadosPedidoByEstadoPedido) {
        this.estadosPedidoByEstadoPedido = estadosPedidoByEstadoPedido;
    }

    //Unidad de transporte

    public UnidadesTransporteEntity getUnidadesTransporteEntity() {
        return unidadesTransporteEntity;
    }

    public void setUnidadesTransporteEntity(UnidadesTransporteEntity unidadesTransporteEntity) {
        this.unidadesTransporteEntity = unidadesTransporteEntity;
    }
}
