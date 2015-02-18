package acesso.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

import org.springframework.beans.factory.annotation.Autowired;

import acesso.service.UsuarioService;


public class UsuarioConverter implements Converter {
	
	@Autowired
	private UsuarioService service;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null && value.trim().length() > 0 && !value.equals("Selecione")) {
			Long id = Long.valueOf(value);
			try {
				return service.buscaPeloId(id);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar o usuario.id " + 
						value + ". " + e.getMessage());
				
			}
		}
		return null;
	}
		
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null && value != "") {
			Usuario usuario = (Usuario) value;
			return Long.toString(usuario.getId());
		}
		
		return null;
	}
	
	
	

}
