import java.util.LinkedList;


public class NodoABB {
	
	Integer dato;
	NodoABB izq;
	NodoABB der;
	
public NodoABB(){
		
	}
	
	NodoABB(int dato, NodoABB izq, NodoABB der){ // CONSTRUCTOR
		this.dato=dato;
		this.der=der;
		this.izq=izq;	
	}

static NodoABB inserta(NodoABB arbol, int dato){ //METODO PARA INSERTAR ELEMENTOS EN EL ArbolABB
	if (arbol==null)
		arbol=new NodoABB(dato, null, null);
	else{
		if(dato<arbol.dato)
			arbol.izq=inserta(arbol.izq, dato);
		else
			arbol.der=inserta(arbol.der, dato);
	}
	return arbol;
}

public NodoABB buscar (NodoABB nodo ,int x){
	if (nodo!=null)
		if(nodo.dato==x)
			return nodo;
		else
			if(x<nodo.dato)
				nodo=buscar(nodo.izq,x);
			else
				nodo=buscar(nodo.der,x);
	return nodo;
}
/*public NodoABB bus_min (NodoABB nodo){
	if (nodo==null){
		return null;
	}
	else{
		if(nodo.izq==null)
			return nodo;
		else
			nodo=bus_min(nodo.izq);
	}
	return nodo;
}	
public NodoABB bus_max (NodoABB nodo){
	if (nodo==null){
		return null;
	}
	else{
		if( nodo.der==null)
			return nodo;
		else
			nodo=bus_max(nodo.der);
	}
	return nodo;
}*/
public NodoABB bus_min (NodoABB nodo){
	if (nodo==null){
		return null;
	}
	else{
		if((nodo.izq==null)&&(nodo.der==null))
			return nodo;
		else
			if(nodo.izq==null)
				if(nodo.dato>nodo.izq.dato)
					nodo=bus_min(nodo.izq);
		return nodo;
	}
}	

public NodoABB bus_max (NodoABB nodo){
	if((nodo.izq==null)&&(nodo.der==null))
		return nodo;
	else
		if(nodo.der!=null)
			if(nodo.dato<nodo.der.dato)
				nodo=bus_max(nodo.der);
	return nodo;
	/*if (nodo==null){
		return 0;
	}
	else{
		if(nodo.der==null)
			return nodo.dato;
		else
			return nodo.dato=bus_max(nodo.der);
	}*/
}	

public String amplitud(NodoABB nodo){
	String a = " ";
	LinkedList<NodoABB> col;
	NodoABB aux=null;
	if(nodo!=null){
		col=new LinkedList<NodoABB>();
		col=encolar(col,nodo);
		while(!colavacia(col)){
			aux=desencolar(col,aux);
			a=a+aux.dato+" ";
			if(aux.izq!=null)
				col=encolar(col,aux.izq);
			if(aux.der!=null)
				col=encolar(col,aux.der);
		}
	}
	return a;
}
void Amplitud(NodoABB a){
	LinkedList<NodoABB> cola =new LinkedList<NodoABB>();
	LinkedList<NodoABB> colaaux= new LinkedList<NodoABB>();
	NodoABB aux;
	
	if(a!=null){
		cola.add(0,a);
		while(cola.get(0)!=null){
			colaaux.add(aux=cola.get(0));
			if(aux.izq!=null){
				cola.add(0,aux.izq);
			}
			if(aux.der!=null){
				cola.add(0,aux.der);
			}
				System.out.println(colaaux);			
		}//while 
	}	
}
private static NodoABB desencolar(LinkedList<NodoABB> cola, NodoABB aux) {
	aux=cola.get(0);
	cola.remove(0);
	return aux;
}
private static boolean colavacia(LinkedList<NodoABB> cola) {
	if(cola.size()==0)
		return true;
	return false;
}
private static LinkedList<NodoABB> encolar(LinkedList<NodoABB> cola, NodoABB arbol) {
	cola.add(arbol);
	return cola;
}

public static int EsVacio(NodoABB arb){
	if(arb!=null){
		return (1+EsVacio(arb.izq)+EsVacio(arb.der));
	}
	else
		return 0;
}
public  String orden(NodoABB m){
	String a = "";
	if(m!=null){
		a=a+orden(m.izq);
		a=a+(m.dato+" ");
		a=a+orden(m.der);
	}
	return a;
}

public  String  preorden(NodoABB m){
	String a = "";
	if(m!=null){
		a=a+(m.dato+" ");
		a=a+preorden(m.izq);
		a=a+preorden(m.der);
	}
	return a;
}

public  String posorden(NodoABB m){
	String a = "";
	if(m!=null){
		a=a+posorden(m.izq);
		a=a+posorden(m.der);
		a=a+(m.dato+" ");
	}
	return a;
}
public  NodoABB elimina(NodoABB nodo,int num){
	NodoABB aux=buscar(nodo, num);
	NodoABB NodPadre=NodoPadre(nodo,num,null);
	NodoABB naux;
	if((aux!=null)&&(NodPadre!=null)){
		if((aux.izq==null)&&(aux.der==null)){
			if(aux.dato<NodPadre.dato)
				buscar(NodPadre, NodPadre.dato).izq=null;
			else
				buscar(NodPadre, NodPadre.dato).der=null;
		}
		else 
			if((aux.izq!=null)&&(aux.der==null))
				if(aux.dato<NodPadre.dato)
					buscar(NodPadre,NodPadre.dato).izq=aux.izq;
				else
					buscar(NodPadre,NodPadre.dato).der=aux.izq;
			else
				if((aux.der!=null)&&(aux.izq==null))
					buscar(NodPadre,NodPadre.dato).izq=aux.der;
				else{
					nodo=ReordeSubABB(aux, NodPadre,nodo);
				}		
	}	
	else
		if(nodo.der!=null){
			naux=nodo;
			bus_min(nodo.der).izq=nodo.izq;
			nodo=nodo.der;
			naux.izq=null;
			naux.der=null;
		}				
		else{
			naux=nodo;
			nodo=nodo.izq;
			naux.izq=null;
			}
		
	return nodo;
}
private  NodoABB ReordeSubABB(NodoABB nodoAeliminar,NodoABB padre, NodoABB arbol) {
	NodoABB MaxMenor =bus_max(nodoAeliminar.izq);
	if(MaxMenor!=nodoAeliminar.izq){
		MaxMenor.izq=nodoAeliminar.izq;
		nodoAeliminar.izq.der=null;
	}
	MaxMenor.der=nodoAeliminar.der;
	if(nodoAeliminar.dato<padre.dato)
		padre.izq=MaxMenor;
	else
		padre.der=MaxMenor;
	nodoAeliminar.der=null;
	nodoAeliminar.izq=null;
	return arbol;
}
public static NodoABB NodoPadre(NodoABB arbol, Integer num, NodoABB refPadre) {
	if(arbol != null)
		if(arbol.dato==num)
			return refPadre;
		else
			if(num<arbol.dato)
				refPadre=NodoPadre(arbol.izq,num,arbol);
			else
				refPadre=NodoPadre(arbol.der,num,arbol);
	return refPadre;
}

}
