package hnch.referencia.web.test;

import java.util.ArrayList;
import java.util.List;

import gob.hnch.systems.ws.hnch.client.imp.PersonaServiceImp;
import gob.hnch.systems.ws.hnch.client.inf.PersonaService;
import gob.hnch.systems.ws.hnch.test.PersonaWSTest;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	List<UbigeoBean> lstProvincia = new ArrayList<UbigeoBean>();
		List<gob.hnch.systems.ws.ext.model.Persona> lstPersona = new ArrayList<gob.hnch.systems.ws.ext.model.Persona>();
		PersonaServiceImp persona = new PersonaServiceImp();
		
		gob.hnch.systems.ws.ext.model.Persona perso =persona.getPersona("44960406");
		lstPersona.add(perso);
		for (gob.hnch.systems.ws.ext.model.Persona persona2 : lstPersona) {
			System.out.println("persona2"+persona2.toString());
		}
		
	}

}
