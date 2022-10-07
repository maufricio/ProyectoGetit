package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "getit")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_usuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "usuario", nullable = true)
    private Integer usuario;
    @Basic
    @Column(name = "admin_getit", nullable = true)
    private Integer adminGetit;
    @Basic
    @Column(name = "admin_transporte", nullable = true)
    private Integer adminTransporte;
    @Basic
    @Column(name = "motorista", nullable = true)
    private Integer motorista;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "Id_cliente")
    private ClientesEntity clientesEntity;
    @ManyToOne
    @JoinColumn(name = "admin_getit", referencedColumnName = "Id_administrador_getit")
    private AdministradorGetitEntity administradorGetitByAdminGetit;
    @ManyToOne
    @JoinColumn(name = "admin_transporte", referencedColumnName = "Id_administrador_transportista")
    private AdministradorTransportistaEntity administradorTransportistaEntity;
    @ManyToOne
    @JoinColumn(name = "motorista", referencedColumnName = "Id_motorista")
    private MotoristaEntity motoristaEntity;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getAdminGetit() {
        return adminGetit;
    }

    public void setAdminGetit(Integer adminGetit) {
        this.adminGetit = adminGetit;
    }

    public Integer getAdminTransporte() {
        return adminTransporte;
    }

    public void setAdminTransporte(Integer adminTransporte) {
        this.adminTransporte = adminTransporte;
    }

    public Integer getMotorista() {
        return motorista;
    }

    public void setMotorista(Integer motorista) {
        this.motorista = motorista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (idUsuario != that.idUsuario) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (adminGetit != null ? !adminGetit.equals(that.adminGetit) : that.adminGetit != null) return false;
        if (adminTransporte != null ? !adminTransporte.equals(that.adminTransporte) : that.adminTransporte != null)
            return false;
        if (motorista != null ? !motorista.equals(that.motorista) : that.motorista != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsuario;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (adminGetit != null ? adminGetit.hashCode() : 0);
        result = 31 * result + (adminTransporte != null ? adminTransporte.hashCode() : 0);
        result = 31 * result + (motorista != null ? motorista.hashCode() : 0);
        return result;
    }

    public AdministradorGetitEntity getAdministradorGetitByAdminGetit() {
        return administradorGetitByAdminGetit;
    }

    public void setAdministradorGetitByAdminGetit(AdministradorGetitEntity administradorGetitByAdminGetit) {
        this.administradorGetitByAdminGetit = administradorGetitByAdminGetit;
    }

    public AdministradorTransportistaEntity getAdministradorTransportistaEntity() {
        return administradorTransportistaEntity;
    }

    public void setAdministradorTransportistaEntity(AdministradorTransportistaEntity administradorTransportistaEntity) {
        this.administradorTransportistaEntity = administradorTransportistaEntity;
    }

    public MotoristaEntity getMotoristaEntity() {
        return motoristaEntity;
    }

    public void setMotoristaEntity(MotoristaEntity motoristaEntity) {
        this.motoristaEntity = motoristaEntity;
    }

    public ClientesEntity getClientesEntity() {
        return clientesEntity;
    }

    public void setClientesEntity(ClientesEntity clientesEntity) {
        this.clientesEntity = clientesEntity;
    }
}
