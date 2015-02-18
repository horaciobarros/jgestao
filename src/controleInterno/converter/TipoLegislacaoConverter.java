package controleInterno.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleInterno.model.TipoLegislacao;
import controleInterno.service.TipoLegislacaoService;

@Component("tipoLegislacaoConverter")
public class TipoLegislacaoConverter implements Converter {  
  
	@Autowired
	private TipoLegislacaoService rn;
	private TipoLegislacao obj;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value != null && value.trim().length() > 0 && !value.equals("Selecione") && !value.equals("Escolha")) {
			long id = Long.valueOf(value);
			try {
				
				return rn.buscaTipoLegislacaoPeloId(id);
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
			obj = (TipoLegislacao) value;
			return Long.toString(obj.getId());
		}
		
		return null;
	}
	
  
   
  
}  
