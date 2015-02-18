package controleInterno.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleInterno.model.CodigoIrregularidade;
import controleInterno.service.CodigoIrregularidadeService;

@Component("codigoIrregularidadeConverter")
public class CodigoIrregularidadeConverter implements Converter {  
  
	@Autowired
	private CodigoIrregularidadeService rn;
	private CodigoIrregularidade obj;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null && value.trim().length() > 0 && !value.equals("Selecione")) {
			long id = Long.valueOf(value);
			try {
				
				return rn.buscaCodigoIrregularidadePeloId(id);
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
			obj = (CodigoIrregularidade) value;
			return Long.toString(obj.getId());
		}
		
		return null;
	}
	
  
   
  
}  