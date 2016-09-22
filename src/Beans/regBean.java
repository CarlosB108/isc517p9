package Beans;

import Comunes.General;
import Entidades.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ResourceBundle;

@ManagedBean
@SessionScoped
public class regBean {
    String correo;
    String nombre;
    String password;

    public void reg( ) {
        try {
            if (!correo.equals("") && !correo.equals(null) && !password.equals("") && !password.equals(null)  && !nombre.equals("") && !nombre.equals(null) ) {
                for( Usuario user : General.Users ){
                    if( user.getCorreo().equals( correo ) ){
                        FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "", ResourceBundle.getBundle( "/messages" ).getString( "alert_ua_email"  ) );
                        FacesContext.getCurrentInstance( ).addMessage( "", msg);
                        return;
                    }
                }

                Usuario user = General.agregar_usuario( nombre, correo, password, false );
                General.usuario = user;

                FacesContext.getCurrentInstance( ).getExternalContext().redirect("productosDisponibles.xhtml");
            }
            else {
                FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "", ResourceBundle.getBundle( "/messages" ).getString( "alert_empty_inputs"  ) );
                FacesContext.getCurrentInstance( ).addMessage( "", msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
