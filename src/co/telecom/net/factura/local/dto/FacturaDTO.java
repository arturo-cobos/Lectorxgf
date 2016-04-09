/*
 * Created on Aug 6, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package co.telecom.net.factura.local.dto;

import java.util.Collection;
import java.util.Vector;

/**
 * @author macblaster
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FacturaDTO {
   private EncabezadoDTO encabezado = null;
   private HistogramaDTO histograma = null;
   private Collection cargos = null;
   private Collection detalle = null;
   
   public FacturaDTO()
   {
   	encabezado = new EncabezadoDTO(); 
   	histograma = new HistogramaDTO();
   	cargos = new Vector();
   	detalle = new Vector();
   	}

   
   
   
public Collection getCargos() {
	return cargos;
}

public void setCargos(String linea, int noLinea) {
	CargosDTO cargo = new CargosDTO();
	cargo.setDescripcion(linea.substring(4,52).trim());
	cargo.setValor(linea.substring(52,70).trim());
	this.cargos.add(cargo);
	if (linea.length() > 70) {
		cargo = new CargosDTO();
		cargo.setDescripcion(linea.substring(71,122).trim());
		cargo.setValor(linea.substring(123,linea.length()).trim());
		this.cargos.add(cargo);
	}
}


public Collection getDetalle() {
	return detalle;
}

public void setDetalle(String linea, int noLinea) {

}

public EncabezadoDTO getEncabezado() {
	return encabezado;
}

public void setEncabezado(String linea, int noLinea) {
	switch (noLinea)
	{
	case 1:
		this.encabezado.setNombre(linea.substring(6,52).trim());
		this.encabezado.setPeríodo(linea.substring(52,linea.length()).trim());
		break;
	case 2:
		this.encabezado.setDireccion(linea.substring(10,52).trim());
		this.encabezado.setFactura(linea.substring(54,linea.length()).trim());
		break;
	case 3:
		this.encabezado.setBarrio(linea.substring(6,52).trim());
		this.encabezado.setDepartamento(linea.substring(59,linea.length()).trim());
		break;
	case 4:
		this.encabezado.setLocalidad(linea.substring(6,49).trim());
		this.encabezado.setPagina(linea.substring(49,linea.length()).trim());
		break;
	}
}

public HistogramaDTO getHistograma() {
	return histograma;
}

// Existen 2 tipso de sección para histograma
public void setHistograma(String linea, int seccion, int noLinea) {

}
}
