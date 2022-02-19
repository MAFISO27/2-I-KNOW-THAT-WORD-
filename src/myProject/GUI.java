package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.2.0 date: 12/02/2022
 */

public class GUI extends JFrame {

    private Header headerProject;
    private controladordeclase model;
    private Escucha escucha;
    private static final String INFO2 =" Puede salir cuando desee.\n"
            +  "si la partida no ha terminado la próxima vez que ingreses se iniciará la misma. ";
    private JPanel panelInicio, panelGame, panelBotones, panelPalabras, panelOpciones;
    private JTextField entradaUsuario;
    private JTextArea intro;
    private JButton botonAceptar, botonAyuda, botonSalir, botonIniciar, botonInstrucciones, botonSi, botonNo, botonContinuar;
    private JLabel labelUsername, labelNivel,labelInstrucciones,  labelTiempo, labelPalabra;
    private ImageIcon image;
    private String nombreJugador;
    private Timer timer;
    private GridBagConstraints constraints, layoutGame;


    public GUI() {
        this.setContentPane(new Canvas(1));
        initGUI();
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void initGUI() {

        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        escucha = new Escucha();
        model = new controladordeclase();

        headerProject = new Header("I KNOW THAT WORD", new Color(9, 75, 78));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

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

    public void componentesDelPanelInicio() {

        GridBagConstraints layoutInicio = new GridBagConstraints();

        labelUsername = new JLabel();
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/usuario.png")));
        labelUsername.setIcon(new ImageIcon(image.getImage().getScaledInstance(350, 120, Image.SCALE_SMOOTH)));
        layoutInicio.gridx = 0;
        layoutInicio.gridy = 0;
        layoutInicio.gridwidth = 2;
        layoutInicio.fill = GridBagConstraints.NONE;
        layoutInicio.anchor = GridBagConstraints.CENTER;
        panelInicio.add(labelUsername, layoutInicio);

        entradaUsuario = new JTextField();
        entradaUsuario.setPreferredSize(new Dimension(260, 45));
        entradaUsuario.setFont(new Font("Arial ", Font.PLAIN, 32));
        layoutInicio.gridx = 0;
        layoutInicio.gridy = 1;
        layoutInicio.gridwidth = 1;
        layoutInicio.fill = GridBagConstraints.NONE;
        layoutInicio.anchor = GridBagConstraints.LINE_END;
        panelInicio.add(entradaUsuario, layoutInicio);

        botonAceptar = new JButton();
        botonAceptar.addActionListener(escucha);
        botonAceptar.setPreferredSize(new Dimension(59, 59));
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/myProject/recursos/aceptar.png")));
        botonAceptar.setIcon(new ImageIcon(image.getImage().getScaledInstance(59, 59, Image.SCALE_SMOOTH)));
        botonAceptar.setBorderPainted(false);
        botonAceptar.setContentAreaFilled(false);
        layoutInicio.gridx = 1;
        layoutInicio.gridy = 1;
        layoutInicio.gridwidth = 1;
        layoutInicio.fill = GridBagConstraints.NONE;
        layoutInicio.anchor = GridBagConstraints.LINE_START;
        panelInicio.add(botonAceptar, layoutInicio);
        revalidate();
        repaint();
    }


   public Icon iconoMessage(String reference, int width, int height) {
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource(reference)));
        image = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
        return image;
    }


    public void crearPanelGame() {
        panelGame = new Canvas(2);
        panelGame.setLayout(new GridBagLayout());
        layoutGame = new GridBagConstraints();
        panelGame.setPreferredSize(new Dimension(769, 407));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelGame, constraints);


        intro = new JTextArea("   ¡HOLA " + nombreJugador + "!\n" +
                "   Estas en el nivel " + model.getNivelActual() + "\n   Presiona PLAY para iniciar");
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
        crearPanelBotonesInicio();
        revalidate();
        repaint();
    }


    public void crearPanelBotonesInicio() {

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
        labelPalabra.setFont(new Font("Impact", Font.PLAIN, 52));
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
        intro.setText("\n               ¡Es hora de la verdad! \n   Demuestra cuánto has logrado\n   " +
                "memorizar ");
        intro.setBackground(new Color(250, 8, 45, 130));
        intro.setPreferredSize(new Dimension(400, 180));
        // finFase.setFont(new Font("Impact",Font.PLAIN,28));
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

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

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
                JOptionPane.showMessageDialog(null, INFO2, null, JOptionPane.INFORMATION_MESSAGE);

            if (e.getSource() == botonAceptar) {
                nombreJugador = entradaUsuario.getText();
                remove(panelInicio);
                model.buscarJugador(nombreJugador);
                crearPanelGame();
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
