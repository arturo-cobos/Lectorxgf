/*
 * Created on Aug 5, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package co.telecom.net.factura.local.dto;

/**
 * @author macblaster
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EncabezadoDTO {
 private String nombre;
 private String direccion;
 private String barrio;
 private String localidad;
 private String período;
 private String factura;
 private String departamento;
 private String pagina;


/**
 * @return Returns the barrio.
 */
public String getBarrio() {
	return barrio;
}
/**
 * @param barrio The barrio to set.
 */
public void setBarrio(String barrio) {
	this.barrio = barrio;
}
/**
 * @return Returns the departamento.
 */
public String getDepartamento() {
	return departamento;
}
/**
 * @param departamento The departamento to set.
 */
public void setDepartamento(String departamento) {
	this.departamento = departamento;
}
/**
 * @return Returns the direccion.
 */
public String getDireccion() {
	return direccion;
}
/**
 * @param direccion The direccion to set.
 */
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
/**
 * @return Returns the factura.
 */
public String getFactura() {
	return factura;
}
/**
 * @param factura The factura to set.
 */
public void setFactura(String factura) {
	this.factura = factura;
}
/**
 * @return Returns the localidad.
 */
public String getLocalidad() {
	return localidad;
}
/**
 * @param localidad The localidad to set.
 */
public void setLocalidad(String localidad) {
	this.localidad = localidad;
}
/**
 * @return Returns the nombre.
 */
public String getNombre() {
	return nombre;
}
/**
 * @param nombre The nombre to set.
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}
/**
 * @return Returns the pagina.
 */
public String getPagina() {
	return pagina;
}
/**
 * @param pagina The pagina to set.
 */
public void setPagina(String pagina) {
	this.pagina = pagina;
}
/**
 * @return Returns the período.
 */
public String getPeríodo() {
	return período;
}
/**
 * @param período The período to set.
 */
public void setPeríodo(String período) {
	this.período = período;
}
}
