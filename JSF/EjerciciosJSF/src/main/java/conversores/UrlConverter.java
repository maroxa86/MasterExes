/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.apache.commons.validator.UrlValidator;

/**
 *
 * @author Xavi
 */
@FacesConverter(value = "urlConverter")
public class UrlConverter implements Converter{

    /**
     * Creates a new instance of UrlConverter
     */
    public UrlConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String HTTP = "http://";
        StringBuilder url = new StringBuilder();

        
        if(!value.startsWith(HTTP, 0)){
                url.append(HTTP);
        }
        url.append(value);

        
        UrlValidator urlValidator = new UrlValidator();
        
        if(!urlValidator.isValid(url.toString())){

                FacesMessage msg = new FacesMessage("Error al converir la url.", "Formato URL invalido.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ConverterException(msg);
        }

        URLBookmark urlBookmark = new URLBookmark(url.toString());

        return urlBookmark;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
