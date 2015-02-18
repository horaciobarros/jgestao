package controleInterno.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleInterno.model.Orgao;
import controleInterno.service.UnidadeOrcamentariaService;

@Component("orgaoConverter")

public class OrgaoConverter implements Converter {  
  
	@Autowired
	private UnidadeOrcamentariaService rn;
	private Orgao obj;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null && value.trim().length() > 0 && !value.equals("Selecione")) {
			long id = Long.valueOf(value);
			try {
				
				obj = rn.buscaOrgaoPeloId(id);
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
			obj = (Orgao) value;
			return Long.toString(obj.getId());
		}
		
		return null;
	}
	
  
   
  
}  
