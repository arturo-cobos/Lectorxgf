/*
 * Created on Aug 5, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package co.telecom.net.factura.local.io;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import co.telecom.net.factura.local.dao.facturaDAO;
import co.telecom.net.factura.local.dto.FacturaDTO;

/**
 * @author macblaster
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


public class LectorLocal {

	private  Collection facturas;
	private  FacturaDTO factura;
	private  int facturaAnterior ;
	
	public LectorLocal(){
		facturas = new Vector ();
		facturaAnterior =0;
	} 

	private  void persistirFacturas() 
	{
		Iterator i;
		i = facturas.iterator();
		while (i.hasNext())
		{
			factura = (FacturaDTO) i.next();
			facturaDAO.persist(factura);
		} 
	}
	
	//	Aca se analiza cada cuanto se deberá persistir la colección de facturas...
	private  void analizarPersistir() 
	{
		if (facturas.size() > 50) {
			persistirFacturas();
			facturas = new Vector ();	
		}
	}
	
	public  void interprete(String linea, int Pagina, int Seccion, int noLinea, int noFactura) 
	{
		if (facturaAnterior != noFactura) {
			facturaAnterior = noFactura;
			if (factura != null) {
				facturas.add(factura);
			}
			this.analizarPersistir();
			factura = new FacturaDTO();
		}

		switch (Pagina) 
		{
		case 1:
			switch (Seccion) 
			{
			case 1:
				// Encabezado
				factura.setEncabezado(linea,noLinea);
				break;
		    case 2:
				// Histograma
		    	break;
		    case 3:
		    	// histograma analisis consumo
		    	break;
		    case 4:
		    	// Fecha suspensión si aplica
		    	break;
		    case 5:
		    	// histograma segunda sección
		    	break;
		    case 6:
		    	// total pago oportuno
		    	break;		    	
		    case 7:
		    	// telefono, cliente
		    	break;
		    case 8:
		    	//cargos
		    	factura.setCargos(linea,noLinea);
		    	break;
		    case 9:
		    	//mensaje cobro
		    	break;
		    case 10:
		    	//titulo cupon
		    	break;
		    case 11:
		    	//valores cupon
		    	break;
		    case 12:
		    	//código barras
		    	break;
		    case 13:
		    	//valores cod barras
		    	break;
		    default:
		    	//mensaje
		    	break;
			}
			break;
	    case 2:
			switch (Seccion) 
			{
			case 1:
				// Encabezado
				break;
		    case 2:
				// No. meses vencidos
		    	break;
		    case 3:
		    	// No. facturas
		    	break;
		    case 4:
		    	// Cod Barras Ruteo
		    	break;
		    default:
		    	// Mensaje
		    	break;
			}
	    	break;
	    case 3:
			switch (Seccion) 
			{
			case 1:
				// Encabezado
				break;
		    case 2:
				// Movimiento
		    	break;
			}
	    	break;
		}
		
		
	}
	
}
