package Cliente;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente {
	private JFrame ventanaChat;
	private JButton botonEnviar;
	private JTextField textoEnviar;
	private JTextArea areaChat;
	private JPanel contenedorAreaChat;
	private JPanel contenedorEnviarMensaje;
	private JScrollPane scroll;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	public Cliente(){
		hacerInterfaz();
	}
	
	public void hacerInterfaz(){
		ventanaChat = new JFrame("Cliente");
		botonEnviar = new JButton("Enviar");
		textoEnviar = new JTextField(4);
		areaChat = new JTextArea(10,12);
		scroll = new JScrollPane(areaChat);
		
		contenedorAreaChat = new JPanel();
		contenedorAreaChat.setLayout(new GridLayout(1, 1));
		contenedorAreaChat.add(scroll);

		
		contenedorEnviarMensaje = new JPanel();
		contenedorEnviarMensaje.setLayout(new GridLayout(1, 2));
		contenedorEnviarMensaje.add(textoEnviar);
		contenedorEnviarMensaje.add(botonEnviar);
		
		ventanaChat.setLayout(new BorderLayout());
		ventanaChat.add(contenedorAreaChat, BorderLayout.NORTH);
		ventanaChat.add(contenedorEnviarMensaje, BorderLayout.SOUTH);
		ventanaChat.setSize(300, 225);
		ventanaChat.setVisible(true);
		ventanaChat.setResizable(false);
		ventanaChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Thread principal = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					socket = new Socket("localhost", 9000);
					while(true){
						leer();
						escribir();
					}
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		principal.start();
	}
	
	public void leer(){
		Thread leerHilo = new Thread(new Runnable(){
			public void run(){
				try {
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					while(true){
						String mensajeRecibido = br.readLine();
						areaChat.append("Servidor dice :" + mensajeRecibido + "\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		leerHilo.start();
	}
	
	
	public void escribir(){
		Thread escribirHilo = new Thread(new Runnable(){
			public void run(){
				try {
					pw = new PrintWriter(socket.getOutputStream(), true);
					botonEnviar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String mensajeEnviar = textoEnviar.getText();
							pw.println(mensajeEnviar);
							textoEnviar.setText("");
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		escribirHilo.start();
	}
	
	public static void main(String[] args){
		new Cliente();
	}
}
