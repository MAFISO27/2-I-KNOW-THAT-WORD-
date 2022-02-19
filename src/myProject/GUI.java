package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.5.0 date: 18/02/2022
 */

public class GUI extends JFrame {

    private Header headerProject;
    private controladordeclase model;
    private Escucha escucha;
    //Información en el botón de ayuda, en el panel del juego.
    private static final String Info1 =" Puede salir cuando desee.\n"
            +  "si la partida no ha terminado la próxima vez que ingreses se iniciará la misma. ";
    private JPanel panelInicio, panelGame, panelBotones, panelPalabras, panelOpciones;
    private JTextField entradaUsuario;
    private JTextArea intro;
    private JButton botonAceptar, botonAyuda, botonSalir,botonInstrucciones, botonSi, botonIniciar,  botonNo, botonContinuar;
    private JLabel labelUsername, labelNivel,labelInstrucciones,  labelTiempo, labelPalabra;
    private ImageIcon image;
    private String nombreJugador;
    private Timer timer;
    private GridBagConstraints constraints, layoutGame;//componente del layout del JFrame

    /**
     * Constructor of GUI class
     */
    public GUI() {
        this.setContentPane(new Design(1));// Pinta la imagen del fondo del Frame
        initGUI();
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {

        //Set up JFrame Container's Layout
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        //Create Listener Object or Control Object
        escucha = new Escucha();
        model = new controladordeclase();

        //Encabezado del frame
        headerProject = new Header("juego:I KNOW THAT WORD", new Color(9, 75, 78));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        //Creación de botones
        botonAyuda = new JButton();
        botonAyuda.addActionListener(escucha);
        botonAyuda.setPreferredSize(new Dimension(100, 80));
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/1ayuda.png")));
        botonAyuda.setIcon(new ImageIcon(image.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
        botonAyuda.setBorderPainted(false);
        botonAyuda.setContentAreaFilled(false);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(botonAyuda, constraints);

        botonSalir = new JButton();
        botonSalir.addActionListener(escucha);
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/cerrar.png")));
        botonSalir.setPreferredSize(new Dimension(110, 70));
        botonSalir.setIcon(new ImageIcon(image.getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH)));
        botonSalir.setBorderPainted(false);
        botonSalir.setContentAreaFilled(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(botonSalir, constraints);

        //panel que contiene el label del usuario, la entrada de texto y el botón de confirmación
        panelInicio = new JPanel(new GridBagLayout()); // Set up JPanel Container's Layout
        panelInicio.setPreferredSize(new Dimension(999, 666));
        panelInicio.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelInicio, constraints);
        componentesDelPanelInicio();
        revalidate();
        repaint();
    }

    /**
     * Este método crea los siguientes componentes y los agrega al panel de inicio:
     * labelUsername: Etiqueta para indicar lo que se desea que ingrese el usuario en la caja de texto
     * entradaUsuario: Componente para la entrada del texto
     * botonOk: Botón de confirmación luego de ingresar el nombre de usuario
     */


    public void componentesDelPanelInicio() {

        GridBagConstraints layoutStar = new GridBagConstraints();//Componente del layout

        labelUsername = new JLabel();
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/usuario.png")));
        labelUsername.setIcon(new ImageIcon(image.getImage().getScaledInstance(350, 120, Image.SCALE_SMOOTH)));
        layoutStar.gridx = 0;
        layoutStar.gridy = 0;
        layoutStar.gridwidth = 2;
        layoutStar.fill = GridBagConstraints.NONE;
        layoutStar.anchor = GridBagConstraints.CENTER;
        panelInicio.add(labelUsername, layoutStar);

        //Cajón de entrada del texto
        entradaUsuario = new JTextField();
        entradaUsuario.setPreferredSize(new Dimension(260, 45));
        entradaUsuario.setFont(new Font("Arial ", Font.PLAIN, 32));
        layoutStar.gridx = 0;
        layoutStar.gridy = 1;
        layoutStar.gridwidth = 1;
        layoutStar.fill = GridBagConstraints.NONE;
        layoutStar.anchor = GridBagConstraints.LINE_END;
        panelInicio.add(entradaUsuario, layoutStar);

        //Boton de confirmación
        botonAceptar = new JButton();
        botonAceptar.addActionListener(escucha);
        botonAceptar.setPreferredSize(new Dimension(59, 59));
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/aceptar.png")));
        botonAceptar.setIcon(new ImageIcon(image.getImage().getScaledInstance(59, 59, Image.SCALE_SMOOTH)));
        botonAceptar.setBorderPainted(false);
        botonAceptar.setContentAreaFilled(false);
        layoutStar.gridx = 1;
        layoutStar.gridy = 1;
        layoutStar.gridwidth = 1;
        layoutStar.fill = GridBagConstraints.NONE;
        layoutStar.anchor = GridBagConstraints.LINE_START;
        panelInicio.add(botonAceptar, layoutStar);
        revalidate();
        repaint();
    }


    /**
     * Este método retorna un objeto de tipo Icon y es el que crea el ícono del mensaje emergente del boton de ayuda
     * @param reference es la ubicacion de la imagen
     * @param width  medida del ancho que se desea que tenga el icono
     * @param height  medida del alto  que se desea que tenga el icono
     * */
   public Icon Mensaje(String reference, int width, int height) {
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource(reference)));
        image = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        return image;
    }



    /**
     * Este método crea el panel de inicio del juego luego de la confirmación de usuario
     *
     */
    public void crearInicioJuego() {
        panelGame = new Design(2);//Crea el panel con la imagen
        panelGame.setLayout(new GridBagLayout());//Set up JPanel Container's Layout
        layoutGame = new GridBagConstraints();//Componente del layout del panelGame
        panelGame.setPreferredSize(new Dimension(769, 407));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelGame, constraints);


        intro = new JTextArea("   ¡¡Que Tal " + nombreJugador + "!!\n" +
                "  Usted Esta en el nivel " + model.getNivelActual() + "\n   Presiona JUGAR para iniciar el juego");
        intro.setEditable(false);
        intro.setLineWrap(true);
        intro.setWrapStyleWord(true);
        intro.setBackground(new Color(25, 196, 192, 130));
        intro.setOpaque(true);
        intro.setPreferredSize(new Dimension(405, 155));
        intro.setFont(new Font("Impact", Font.PLAIN, 27));
        layoutGame.gridx = 0;
        layoutGame.gridy = 0;
        layoutGame.gridwidth = 1;
        layoutGame.fill = GridBagConstraints.NONE;
        layoutGame.anchor = GridBagConstraints.CENTER;
        panelGame.add(intro, layoutGame);

        crearPanelBotones();

        revalidate();
        repaint();


    }

    /**
     * Este método crea el panel en que se ubican los botones del juego.
     * Además, crea los componentes:
     * Botón de Instrucciones
     * Botón de Iniciar Partida
     */


    public void crearPanelBotones() {

        panelBotones = new JPanel();
        panelBotones.setPreferredSize(new Dimension(977, 150));
        panelBotones.setOpaque(false);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelBotones, constraints);

        botonInstrucciones = new JButton();
        botonInstrucciones.addActionListener(escucha);
        botonInstrucciones.setPreferredSize(new Dimension(280, 85));
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/1nstruc.png")));
        botonInstrucciones.setIcon(new ImageIcon(image.getImage().getScaledInstance(280, 85, Image.SCALE_SMOOTH)));
        botonInstrucciones.setBorderPainted(false);
        botonInstrucciones.setContentAreaFilled(false);
        panelBotones.add(botonInstrucciones);

        botonIniciar = new JButton();
        botonIniciar.addActionListener(escucha);
        botonIniciar.setPreferredSize(new Dimension(280, 85));
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/jugar.png")));
        botonIniciar.setIcon(new ImageIcon(image.getImage().getScaledInstance(280, 85, Image.SCALE_SMOOTH)));
        botonIniciar.setBorderPainted(false);
        botonIniciar.setContentAreaFilled(false);
        panelBotones.add(botonIniciar);
    }


    public void crearComponentesPanelGame() {

        labelNivel = new JLabel("NIVEL: " + Integer.toString(model.getNivelActual()));
        labelNivel.setFont(new Font("Impact", Font.PLAIN, 27));
        layoutGame.gridx = 0;
        layoutGame.gridy = 0;
        layoutGame.gridwidth = 1;
        layoutGame.fill = GridBagConstraints.NONE;
        layoutGame.anchor = GridBagConstraints.LINE_START;
        panelGame.add(labelNivel, layoutGame);

        labelTiempo = new JLabel("00:00");
        labelTiempo.setFont(new Font("Impact", Font.PLAIN, 27));
        layoutGame.gridx = 1;
        layoutGame.gridy = 0;
        layoutGame.gridwidth = 1;
        layoutGame.fill = GridBagConstraints.NONE;
        layoutGame.anchor = GridBagConstraints.LINE_END;
        panelGame.add(labelTiempo, layoutGame);

        panelPalabras = new JPanel(new GridBagLayout());
        GridBagConstraints layoutPanelPalabras = new GridBagConstraints();
        panelPalabras.setPreferredSize(new Dimension(696, 357));
        panelPalabras.setOpaque(false);
        layoutGame.gridx = 0;
        layoutGame.gridy = 1;
        layoutGame.gridwidth = 2;
        layoutGame.fill = GridBagConstraints.NONE;
        layoutGame.anchor = GridBagConstraints.CENTER;
        panelGame.add(panelPalabras, layoutGame);

        labelPalabra = new JLabel();
        labelPalabra.setFont(new Font("Impact", Font.PLAIN, 60));
        layoutPanelPalabras.gridx = 0;
        layoutPanelPalabras.gridy = 0;
        layoutPanelPalabras.gridwidth = 1;
        layoutPanelPalabras.fill = GridBagConstraints.NONE;
        layoutPanelPalabras.anchor = GridBagConstraints.CENTER;
        panelPalabras.add(labelPalabra, layoutPanelPalabras);
        timer = new Timer(1000, escucha);
        revalidate();
        repaint();
    }


    public void inicioFase2() {
        intro.setText("\n               ¡Es tu momento! \n   Demuestra tu capacidad\n   " +
                "memorizar ");
        intro.setBackground(new Color(250, 8, 45, 130));
        intro.setPreferredSize(new Dimension(400, 180));
        intro.setForeground(Color.RED);
        layoutGame.gridx = 0;
        layoutGame.gridy = 0;
        layoutGame.gridwidth = 1;
        layoutGame.fill = GridBagConstraints.NONE;
        layoutGame.anchor = GridBagConstraints.CENTER;
        panelGame.add(intro, layoutGame);

        botonContinuar = new JButton();
        botonContinuar.addActionListener(escucha);
        botonContinuar.setPreferredSize(new Dimension(200, 65));
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/continuar.png")));
        botonContinuar.setIcon(new ImageIcon(image.getImage().getScaledInstance(200, 65, Image.SCALE_SMOOTH)));
        botonContinuar.setBorderPainted(false);
        botonContinuar.setContentAreaFilled(false);
        layoutGame.gridx = 0;
        layoutGame.gridy = 1;
        layoutGame.gridwidth = 1;
        layoutGame.fill = GridBagConstraints.NONE;
        layoutGame.anchor = GridBagConstraints.LINE_END;
        panelGame.add(botonContinuar, layoutGame);

        revalidate();
        repaint();

    }


    public void crearComponentesFase2() {
        panelOpciones = new JPanel();
        panelOpciones.setPreferredSize(new Dimension(690, 90));
        panelOpciones.setOpaque(false);
        layoutGame.gridx = 0;
        layoutGame.gridy = 2;
        layoutGame.gridwidth = 2;
        layoutGame.fill = GridBagConstraints.NONE;
        layoutGame.anchor = GridBagConstraints.CENTER;
        panelGame.add(panelOpciones, layoutGame);

        botonSi = new JButton();
        botonSi.addActionListener(escucha);
        botonSi.setPreferredSize(new Dimension(85, 85));
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/si.png")));
        botonSi.setIcon(new ImageIcon(image.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH)));
        botonSi.setBorderPainted(false);
        botonSi.setContentAreaFilled(false);
        panelOpciones.add(botonSi);

        botonNo = new JButton();
        botonNo.addActionListener(escucha);
        botonNo.setPreferredSize(new Dimension(85, 85));
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/no.png")));
        botonNo.setIcon(new ImageIcon(image.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH)));
        botonNo.setBorderPainted(false);
        botonNo.setContentAreaFilled(false);
        panelOpciones.add(botonNo);
        revalidate();
        repaint();
    }

    public void continuarNivel() {
        String textoFinal = "";
        int aciertos = model.getAciertos();
        int porcentaje = model.porcentajeAciertos();
        model.setNivelesAprobados();
        if (model.getApruebaNivel()) {
            textoFinal = "\n               Has superado el nivel. \n   Número de aciertos: " + aciertos +
                    "\n   porcentaje: " + porcentaje + "%";
        } else {
            textoFinal = "\n               No has superado el nivel. \n   Número de aciertos: " + aciertos +
                    "\n   porcentaje: " + porcentaje + "%";
        }
        intro.setText(textoFinal);
        layoutGame.gridx = 0;
        layoutGame.gridy = 0;
        layoutGame.gridwidth = 1;
        layoutGame.fill = GridBagConstraints.NONE;
        layoutGame.anchor = GridBagConstraints.CENTER;
        panelGame.add(intro, layoutGame);
        botonIniciar.setVisible(true);
        System.out.println(textoFinal);
        revalidate();
        repaint();

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is executed by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        private int counter, fase;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == timer) {
                labelTiempo.setText("00:0" + counter);
                counter++;

                if (fase == 1) {
                    if (counter > 5) {
                        labelPalabra.setText(model.getPalabrasMemorizar());
                        counter = 1;
                    }
                    if (Objects.equals(labelPalabra.getText(), "")) {
                        timer.stop();
                        panelGame.removeAll();
                        revalidate();
                        repaint();
                        inicioFase2();
                    }
                }
                if (fase == 2) {
                    if (counter > 7) {
                        labelPalabra.setText(model.getPalabrasAleatorias());
                        counter = 0;
                    }
                    if (Objects.equals(labelPalabra.getText(), "")) {
                        timer.stop();
                        panelGame.removeAll();
                        revalidate();
                        repaint();
                        continuarNivel();
                    }
                }

            }
            if (e.getSource() == botonSalir) System.exit(0);
            if (e.getSource() == botonAyuda)
                JOptionPane.showMessageDialog(null, Info1, null, JOptionPane.INFORMATION_MESSAGE);

            if (e.getSource() == botonAceptar) {
                nombreJugador = entradaUsuario.getText();
                remove(panelInicio);
                model.buscarJugador(nombreJugador);
                crearInicioJuego();
                revalidate();
                repaint();

            }
            if (e.getSource() == botonInstrucciones) {
                labelInstrucciones = new JLabel();
                image = new ImageIcon(getClass().getResource("/myProject/recursos/instrucciones.png"));
                labelInstrucciones.setIcon(new ImageIcon(image.getImage().getScaledInstance(600, 480,
                        Image.SCALE_SMOOTH)));
                JOptionPane.showMessageDialog(null, labelInstrucciones, null, JOptionPane.PLAIN_MESSAGE);

            }
            if (e.getSource() == botonIniciar) {
                panelGame.remove(intro);
                crearComponentesPanelGame();
                labelPalabra.setText(model.getPalabrasMemorizar());
                botonIniciar.setVisible(false);
                fase = 1;
                counter = 1;
                timer.start();

            }
            if (e.getSource() == botonSi) {
                model.validarPalabraCorrecta(labelPalabra.getText());
                labelPalabra.setText(model.getPalabrasAleatorias());
                counter = 1;
                revalidate();
                repaint();
            }
            if (e.getSource() == botonNo) {
                model.validarPalabraIncorrecta(labelPalabra.getText());
                labelPalabra.setText(model.getPalabrasAleatorias());
                counter = 1;
                revalidate();
                repaint();
            }
            if (e.getSource() == botonContinuar) {
                panelGame.remove(intro);
                panelGame.remove(botonContinuar);
                fase = 2;
                revalidate();
                repaint();
                crearComponentesPanelGame();
                panelPalabras.setPreferredSize(new Dimension(690, 260));
                crearComponentesFase2();
                labelPalabra.setText(model.getPalabrasAleatorias());
                timer.start();
            }
        }
    }
}
