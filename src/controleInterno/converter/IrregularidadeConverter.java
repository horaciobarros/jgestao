package controleInterno.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleInterno.model.Irregularidade;
import controleInterno.service.IrregularidadeService;

@Component("irregularidadeConverter")
public class IrregularidadeConverter implements Converter {  
  
	@Autowired
	private IrregularidadeService rn;
	private Irregularidade obj;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null && value.trim().length() > 0 && !value.equals("Selecione")) {
			long id = Long.valueOf(value);
			try {
				
				return rn.buscaIrregularidadePeloId(id);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar o registro " + 
						value + ". " + e.getMessage());
				
			}
		}
		return null;
	}
		
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null && value != "") {
			obj = (Irregularidade) value;
			return Long.toString(obj.getId());
		}
		
		return null;
	}
	
  
   
  
}  