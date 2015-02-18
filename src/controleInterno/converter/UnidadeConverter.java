package controleInterno.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleInterno.model.Unidade;
import controleInterno.service.UnidadeOrcamentariaService;

@Component("unidadeConverter")
public class UnidadeConverter implements Converter {  
  
	@Autowired
	private UnidadeOrcamentariaService rn;
	private Unidade obj;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null && value.trim().length() > 0 && !value.equals("Selecione")) {
			long id = Long.valueOf(value);
			try {
				
				obj = rn.buscaUnidadePeloId(id);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar o registro " + 
						value + ". " + e.getMessage());
				
			}
		}
		return obj;
	}
		
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null && value != "") {
			obj = (Unidade) value;
			return Long.toString(obj.getId());
		}
		
		return null;
	}
	
  
   
  
}  
