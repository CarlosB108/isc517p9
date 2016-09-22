package Beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@ManagedBean( name = "localeBean" )
@SessionScoped
public class localeBean implements Serializable {

    private String actual_language = "es";
    private Map<String, Object> langs;

    @PostConstruct
    private void init( ) {
        langs = new LinkedHashMap<>();
        langs.put("English", "en");
        langs.put("Español", "es");
        actual_language = "es";
    }

    public void changeLanguage(ValueChangeEvent event) {
        FacesContext.getCurrentInstance( ).getViewRoot( ).setLocale( new Locale( actual_language ) );
    }

    public String getActual_language( ){
        if( actual_language == null ) return "es";
        return actual_language;
    }

    public void setActual_language(String actual_language) {
        this.actual_language = actual_language;
    }

    public Map<String, Object> getLangs() {
        return langs;
    }

    public void setLangs(Map<String, Object> langs) {
        this.langs = langs;
    }
}