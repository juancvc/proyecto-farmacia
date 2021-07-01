
package proyect.core.entity.seguridad;
import java.io.Serializable;

import javax.persistence.*;


import java.util.Date;

@NamedStoredProcedureQueries({	
	
	@NamedStoredProcedureQuery(name = "auditoria.listar", 
		procedureName = "usp_Auditoria_listar", 
		resultClasses = Auditoria.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioIngreso", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "ipIngreso", type = String.class)
	}),
	
	@NamedStoredProcedureQuery(name = "auditoria.insert", 
	procedureName = "usp_Auditoria_insertar", 
	resultClasses = Auditoria.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "idAuditoria", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "usuarioIngreso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "ipIngreso", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "swAcceso", type = int.class)
	}),
		
})

@Entity
@Table(name="Auditoria")
public class Auditoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idAuditoria")
	private String idAuditoria;
	
	@Column(name="usuarioIngreso")
	private String usuarioIngreso;
	  
	@Column(name="ipIngreso")
	private Integer ipIngreso;
	
	@Column(name="swAcceso")
	private int swAcceso;
	  
	public Auditoria() {
	
	}

	public String getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(String idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getUsuarioIngreso() {
		return usuarioIngreso;
	}

	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
	}

	public Integer getIpIngreso() {
		return ipIngreso;
	}

	public void setIpIngreso(Integer ipIngreso) {
		this.ipIngreso = ipIngreso;
	}

	public int getSwAcceso() {
		return swAcceso;
	}

	public void setSwAcceso(int swAcceso) {
		this.swAcceso = swAcceso;
	}
 
}