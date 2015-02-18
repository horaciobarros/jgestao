package acesso.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

public class EmpresaConverter implements Converter {
	EmpresaDAO dao = new EmpresaDAO();

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null && value.trim().length() > 0 && !value.equals("Selecione")) {
			long id = Long.valueOf(value);
			try {
				return dao.buscaEmpresaUsuariaPeloId(id);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar a empresa de codigo " + 
						value + ". " + e.getMessage());
				
			}
		}
		return null;
	}
		
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null && value != "") {
			Empresa empresa = (Empresa) value;
			return Long.toString(empresa.getId());
		}
		
		return null;
	}
	
	
	

}
