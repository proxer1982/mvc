package ciclo3.mvc.entities;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;
    @javax.validation.constraints.NotEmpty
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @javax.validation.constraints.NotEmpty
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;
    @javax.validation.constraints.NotEmpty
    @Column(name = "cedula")
    private String cedula;
    @javax.validation.constraints.NotEmpty
    @Column(name = "correo", nullable = false)
    private String correo;
    @javax.validation.constraints.NotEmpty
    @Column(name = "username")
    private String username;
    @javax.validation.constraints.NotEmpty
    @Column(name = "pass", nullable = false)
    private String pass;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
    @Column(name = "perfil")
    private Perfil perfil;
    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", rol=" + rol +
                ", perfil=" + perfil +
                ", estado=" + estado +
                '}';
    }
}
