package assist_mater.converter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import assist_mater.jsf.data.Contrat;

@Named
@RequestScoped
public class ConverterContrat implements Converter<Contrat> {

	@Override
	public Contrat getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Contrat value) {
		// TODO Auto-generated method stub
		return null;
	}

	// Actions

	/*@SuppressWarnings("unchecked")
	@Override
	public Categorie getAsObject(FacesContext context, UIComponent uic, String value) {

		if (value == null || value.isEmpty()) {
			return null;
		}

		List<Categorie> items = null;
		for (UIComponent c : uic.getChildren()) {
			if (c instanceof UISelectItems) {
				items = (List<Categorie>) ((UISelectItems) c).getValue();
				break;
			}
		}

		var id = Integer.valueOf("x"+value);
		for (Categorie item : items) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Categorie item) {

		if (item == null) {
			return "";
		}
		return String.valueOf(item.getId());
	}*/
}
