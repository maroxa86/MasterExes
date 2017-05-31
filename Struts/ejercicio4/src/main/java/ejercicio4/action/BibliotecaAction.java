package ejercicio4.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import ejercicio4.bean.Comida;
import ejercicio4.bean.Entorno;

public class BibliotecaAction extends ActionSupport {

	private static final long serialVersionUID = -4677493280136781716L;

	private String nombre;
	private String password;
	private String textArea;
	private boolean soyRobot;
	private Map<Integer, String> listaColores;
	private int colores;
	private Map<Integer, String> listaIntensidadColor;
	private Map<Integer, String> listaAnimales;
	private int animales;
	private List<Comida> listaComida;
	private int[] comida;
	private List<String> listaFrutas;
	private String fruta;
	private String parametro;
	private Date fechaActual;
	private Entorno entorno;
	
	public int getColores() {
		return colores;
	}

	public void setColores(int colores) {
		this.colores = colores;
	}

	public BibliotecaAction() {
		inicializacion();
	}

	@Actions({ @Action(value = "/", results = { @Result(name = "success", location = "jsp/biblioteca.jsp") }),
			@Action(value = "/bibliotecaAction", results = {
					@Result(name = "success", location = "jsp/biblioteca.jsp") }) })
	public String execute() {
		return SUCCESS;
	}

	@Action(value = "/resultadoAction", results = { @Result(name = "success", location = "jsp/resultado.jsp") })
	public String resultado() {
		return SUCCESS;
	}

	@Action(value = "/accionAction", results = { @Result(name = "success", location = "jsp/resultado.jsp") })
	public String actionTag() {
		List<String> nombres = new ArrayList<>();
		nombres.add("Jose");
		nombres.add("Antonio");
		nombres.add("Pepe");
		ServletActionContext.getRequest().setAttribute("nombres", nombres);
		return "success";
	}

	private void inicializacion() {
		fechaActual = new Date();
		
		entorno = new Entorno("Desarrollo");
		
		listaColores = new HashMap<Integer, String>();
		listaColores.put(1, "Azul");
		listaColores.put(2, "Rojo");
		listaColores.put(3, "Verde");

		listaIntensidadColor = new HashMap<Integer, String>();
		listaIntensidadColor.put(1, "Fuerte");
		listaIntensidadColor.put(2, "Normal");
		listaIntensidadColor.put(3, "Suave");

		listaAnimales = new HashMap<Integer, String>();
		listaAnimales.put(1, "Perro");
		listaAnimales.put(2, "Gato");
		listaAnimales.put(3, "Tortuga");
		listaAnimales.put(4, "Todos");
		listaAnimales.put(5, "Ninguno");

		listaComida = new ArrayList<>();
		listaComida.add(new Comida(1, "Pasta"));
		listaComida.add(new Comida(2, "Verdura"));
		listaComida.add(new Comida(3, "Legumbres"));

		listaFrutas = new ArrayList<>();
		listaFrutas.add("Manzana");
		listaFrutas.add("Pera");
		listaFrutas.add("Naranja");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTextArea() {
		return textArea;
	}

	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}

	public boolean isSoyRobot() {
		return soyRobot;
	}

	public void setSoyRobot(boolean soyRobot) {
		this.soyRobot = soyRobot;
	}

	public Map<Integer, String> getListaColores() {
		return listaColores;
	}

	public void setListaColores(Map<Integer, String> listaColores) {
		this.listaColores = listaColores;
	}

	public int getAnimales() {
		return animales;
	}

	public void setAnimales(int animales) {
		this.animales = animales;
	}

	public Map<Integer, String> getListaAnimales() {
		return listaAnimales;
	}

	public void setListaAnimales(Map<Integer, String> listaAnimales) {
		this.listaAnimales = listaAnimales;
	}

	public Map<Integer, String> getListaIntensidadColor() {
		return listaIntensidadColor;
	}

	public void setListaIntensidadColor(Map<Integer, String> listaIntensidadColor) {
		this.listaIntensidadColor = listaIntensidadColor;
	}

	public List<Comida> getListaComida() {
		return listaComida;
	}

	public void setListaComida(List<Comida> listaComida) {
		this.listaComida = listaComida;
	}

	public int[] getComida() {
		return comida;
	}

	public void setComida(int[] comida) {
		this.comida = comida;
	}

	public List<String> getListaFrutas() {
		return listaFrutas;
	}

	public void setListaFrutas(List<String> listaFrutas) {
		this.listaFrutas = listaFrutas;
	}

	public String getFruta() {
		return fruta;
	}

	public void setFruta(String fruta) {
		this.fruta = fruta;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

}
