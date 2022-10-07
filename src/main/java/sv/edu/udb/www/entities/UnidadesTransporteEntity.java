package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;

//Tabla trabajada!
@Entity
@Table(name = "unidades_transporte", schema = "getit")
public class UnidadesTransporteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_unidadTransporte", nullable = false)
    private int idUnidadTransporte;
    @Basic
    @Column(name = "placa", nullable = false, length = 20)
    private String placa;
    @Basic
    @Column(name = "tipoVehiculo", nullable = false)
    private Object tipoVehiculo;
    @Basic
    @Column(name = "pesoVehiculo", nullable = false)
    private Object pesoVehiculo;
    @Basic
    @Column(name = "Id_administrador_transportista", nullable = false)
    private int idAdministradorTransportista;
    @Basic
    @Column(name = "estado_unidad", nullable = false)
    private int estadoUnidad;


    //Relacion entre la unidad de transporte y el transportista dueño
    @ManyToOne
    @JoinColumn(name = "Id_administrador_transportista", referencedColumnName = "Id_administrador_transportista", nullable = false)
    private AdministradorTransportistaEntity administradorTransportistaEntity;

    //Relacion entre la unidad y el estado actual en el que se encuetra
    @ManyToOne
    @JoinColumn(name = "estado_unidad", referencedColumnName = "Id_estado", nullable = false)
    private EstadosGeneralesEntity estadosGeneralesByEstadoUnidad;

    //Relacion entre pedidos y la unidad de transporte solicitada
    @OneToMany(mappedBy = "unidadesTransporteEntity")
    private Collection<PedidosEntity> pedidosByIdUnidadTransporte;


    public int getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(int idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Object getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Object tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Object getPesoVehiculo() {
        return pesoVehiculo;
    }

    public void setPesoVehiculo(Object pesoVehiculo) {
        this.pesoVehiculo = pesoVehiculo;
    }

    public int getIdAdministradorTransportista() {
        return idAdministradorTransportista;
    }

    public void setIdAdministradorTransportista(int idAdministradorTransportista) {
        this.idAdministradorTransportista = idAdministradorTransportista;
    }

    public int getEstadoUnidad() {
        return estadoUnidad;
    }

    public void setEstadoUnidad(int estadoUnidad) {
        this.estadoUnidad = estadoUnidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnidadesTransporteEntity that = (UnidadesTransporteEntity) o;

        if (idUnidadTransporte != that.idUnidadTransporte) return false;
        if (idAdministradorTransportista != that.idAdministradorTransportista) return false;
        if (estadoUnidad != that.estadoUnidad) return false;
        if (placa != null ? !placa.equals(that.placa) : that.placa != null) return false;
        if (tipoVehiculo != null ? !tipoVehiculo.equals(that.tipoVehiculo) : that.tipoVehiculo != null) return false;
        if (pesoVehiculo != null ? !pesoVehiculo.equals(that.pesoVehiculo) : that.pesoVehiculo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUnidadTransporte;
        result = 31 * result + (placa != null ? placa.hashCode() : 0);
        result = 31 * result + (tipoVehiculo != null ? tipoVehiculo.hashCode() : 0);
        result = 31 * result + (pesoVehiculo != null ? pesoVehiculo.hashCode() : 0);
        result = 31 * result + idAdministradorTransportista;
        result = 31 * result + estadoUnidad;
        return result;
    }

    public Collection<PedidosEntity> getPedidosByIdUnidadTransporte() {
        return pedidosByIdUnidadTransporte;
    }

    public void setPedidosByIdUnidadTransporte(Collection<PedidosEntity> pedidosByIdUnidadTransporte) {
        this.pedidosByIdUnidadTransporte = pedidosByIdUnidadTransporte;
    }

    public AdministradorTransportistaEntity getAdministradorTransportistaByIdAdministradorTransportista() {
        return administradorTransportistaEntity;
    }

    public void setAdministradorTransportistaByIdAdministradorTransportista(AdministradorTransportistaEntity administradorTransportistaEntity) {
        this.administradorTransportistaEntity = administradorTransportistaEntity;
    }

    public EstadosGeneralesEntity getEstadosGeneralesByEstadoUnidad() {
        return estadosGeneralesByEstadoUnidad;
    }

    public void setEstadosGeneralesByEstadoUnidad(EstadosGeneralesEntity estadosGeneralesByEstadoUnidad) {
        this.estadosGeneralesByEstadoUnidad = estadosGeneralesByEstadoUnidad;
    }
}
