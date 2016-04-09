/*
 * Created on Aug 5, 2007
 *
 * El proposito de esta clase es transformar el archivo XGF. 
 * Window - Preferences - Java - Code Style - Code Templates
 */


package co.telecom.net.xgfLector;
import java.io.*;
import co.telecom.net.factura.local.io.*;

/**
 * @author macblaster
 *
 */
 class Lector {
	private static FileReader fr;
	
	public static int documento = 0;
	public static int pagina = 0;
	public static int seccion = 0;
	public static int noLinea = 0;
	public static int noFactura = 0;
	
	private static void finDeLinea(String pLinea , LectorLocal lectorLocal)
	{
		noLinea++;
		lectorLocal.interprete(pLinea, pagina, seccion, noLinea, noFactura);
	}

	private static void finDePagina()
	{
		System.out.print( "PAGINA") ;
	}

	private static void inicioDocumento(String tokenAnterior)
	{
		pagina = 1;
		inicioHoja(" ", tokenAnterior);
	}
	
	private static void inicioHoja(String pLinea, String tokenAnterior)
	{
		seccion = 0;
		if (tokenAnterior.compareTo("(forma2a.jdt)")==0) {
			pagina = 2;
		}
		else if (tokenAnterior.compareTo("(forma2r.jdt)")==0) {
			pagina = 2;
		}
		else if (tokenAnterior.compareTo("(detalle.jdt)")==0) {
			pagina = 3;
		}
		else if (tokenAnterior.compareTo("(telecomaM.jdt)")==0) {
			pagina = 1;
			noFactura++;
		}
		else if (tokenAnterior.compareTo("(telecomrM.jdt)")==0) {
			pagina = 1;
			noFactura++;
		}
		else {
			System.out.println( "****************************************************************" ) ;
			System.out.println( "*********************JDT.. No reconocido!***********************" ) ;
			System.out.println( "****************************************************************" ) ;			
		}
	}
	
	private static void iniciaSeccion(String pLinea,String tokenAnterior)
	{
		seccion = new Integer(tokenAnterior.substring(1,tokenAnterior.length()).trim()).intValue();
		//System.out.print( tokenAnterior ) ;	
		noLinea = 0;
	}
	
	
	public static void main(String [] arg) {
		LectorLocal lectorLocal;
		File archivo = null;
		int int1 = 0;
		 
		try {
			lectorLocal = new LectorLocal(); 
			archivo = new File ("C:\\files\\a.xgf");
			String linea = "";
			String token = "";
			String tokenAnterior = "";
			 fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			
			char anterior = XGFConst.Enter;
			String comando = "";
			boolean analizandoComando = false;
			
			while((int1 = br.read())!=-1) {

				switch ( int1) 
				{
				case XGFConst.Enter:
					if (analizandoComando) 
					{
						if (token.trim().compareTo(XGFConst.comando1)== 0 ) 
						{
							analizandoComando = false;
							inicioDocumento(tokenAnterior);
							comando = "";
						}
						else if (token.trim().compareTo(XGFConst.comando2)== 0) 
								{
							analizandoComando = false;
							inicioHoja(comando,tokenAnterior);
							comando = "";;
						} 
						else if (token.trim().compareTo(XGFConst.comando3)== 0) 
						{
							analizandoComando = false;
							iniciaSeccion(comando,tokenAnterior);
							comando = "";
						} 
						else 
						{
							comando = comando + linea;
							}
					}
					else 
					{					
						finDeLinea(linea,lectorLocal);
					}
					linea = "";
					token= "";
					break;
				case XGFConst.NuevaPagina:
					finDePagina();
					linea = "";
					token = "";
					analizandoComando = false;
					comando = "";
					break;
				case XGFConst.Porcentaje:
					if (((anterior == XGFConst.Enter) || (anterior == XGFConst.NuevaPagina)) && !(analizandoComando))
					   {
						analizandoComando = true;
						comando = "";
					   }
				case XGFConst.Espacio:
					linea = linea +(char) int1 ;
					break;
				default:
					linea = linea +(char) int1 ;
					if (anterior == (char) ' '){
						tokenAnterior = token;
						token = "";
					}
					token = token +(char) int1 ;
				}
				
				anterior= (char) int1;
				

			}
			
		}
		catch(IOException e){
                    System.out.println(e);
                }finally{
                        try{                    //el bloque finally se ejecuta siempre, por eso, si se cierra el fichero
                             if( fr != null){   //al final del primer try, y ha dado un error antes, pasaría
                                fr.close();     //al 1er catch y luego saldría, dejándolo abierto. Es conveniente
                             }                  //cerrarlo aquí, comprobando que no sea -por un error anterior, como
                           }catch (IOException e){ // no tener permisos de lectura o que no exista - de valor null.
                             System.out.println(e);
                           }
                 }
	}

}


