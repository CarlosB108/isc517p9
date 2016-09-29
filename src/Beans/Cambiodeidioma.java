package Beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class Cambiodelidioma implements Serializable {

    String idiomaSeleccion = "es";

    private Map<String, Object> idiomasMap;

    @PostConstruct
    private void inicializar(){
        idiomasMap = new LinkedHashMap<>();
        idiomasMap.put("Español", "es");
        idiomasMap.put("Ingles", "en");
    }

    public Map<String, Object> getListaIdiomas() {
        return idiomasMap;
    }

    /**
     *
     * @param event
     */
    public void cambiarIdioma(ValueChangeEvent event) {
        System.out.println("Idioma seleccionado: " + idiomaSeleccion);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(idiomaSeleccion));
    }

    public String getIdiomaSeleccion() {
        return idiomaSeleccion;
    }

    public void setIdiomaSeleccion(String idiomaSeleccion) {
        this.idiomaSeleccion = idiomaSeleccion;
    }

}