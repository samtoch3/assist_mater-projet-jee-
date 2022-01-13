package assist_mater.commun.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public final class Roles {
	
	// Champs statiques
	
	public static final String NOUNOU	= "NOUNOU";
	public static final String PARENT		= "PARENT";
	
	
	private static final List<String>	roles = Collections.unmodifiableList( Arrays.asList( 
			NOUNOU,			
			PARENT
	) );

	private static final String[]	 	libellés = new String[] {
			"Nounou",
			"Parent",
	};
	
	
	// Constructeur privé qui empêche l'instanciation de la classe
	private Roles() {
	}
	
	
	// Actions

	public static List<String> getRoles() {
		return roles;
	}
	
	public static String getLibellé( String role ) {
		int index = roles.indexOf( role );
		if ( index == -1 ) {
			throw new IllegalArgumentException();
		} 
		return libellés[index];
	}

}
