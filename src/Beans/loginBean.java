package Beans;

import Comunes.General;
import Entidades.Producto;
import Entidades.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ResourceBundle;

@ManagedBean(name = "loginBean")
@SessionScoped
public class loginBean {
    String username;
    String password;

    @PostConstruct
    public void init() {
        if( General.Users.size( ) == 0 ){
            Usuario admin = new Usuario( 0, "admin", "admin", "admin@local" );
            admin.setAdmin(true);

            General.Users.add( admin );

            General.Products.add( new Producto( 1, "Pan", 230, "Pita" ) );
            General.Products.add( new Producto( 1, "Pizza", 0, "Pita" ) );
            General.Products.add( new Producto( 1, "Queso", 0, "Industrial" ) );
            General.Products.add( new Producto( 1, "iPhone", 0, "7" ) );
        }
    }

    public void login( ) {
        try {
            if (!username.equals("") && !username.equals(null) && !password.equals("") && !password.equals(null)) {
                Usuario user = General.get_user( username, password );
                FacesContext.getCurrentInstance( ).getExternalContext().redirect("productosDisponibles.xhtml");

                if( user != null ) {
                    General.usuario = user;
                    FacesContext.getCurrentInstance( ).getExternalContext().redirect("productosDisponibles.xhtml");
                }
                else {
                    FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "", ResourceBundle.getBundle( "/messages" ).getString( "alert_empty_inputs"  ) );
                    FacesContext.getCurrentInstance( ).addMessage( null, msg);
                }
            }
            else {
                FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_INFO, "", ResourceBundle.getBundle( "/messages" ).getString( "alert_empty_inputs"  ) );
                FacesContext.getCurrentInstance( ).addMessage( "", msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername( ){
        return username;
    }

    public String getPassword( ){
        return password;
    }

    public void setUsername( String username ){
        this.username = username;
    }

    public void setPassword( String password ){
        this.password = password;
    }
}
