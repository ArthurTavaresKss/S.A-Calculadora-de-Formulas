
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/*
 * =============== BEM VINDO À CALCULADORA DE FÓRMULAS ================
 * ====================================================================
 * === PROJETO DESENVOLVIDO PARA UMA SITUAÇÃO DE APRENDIZAGEM (S.A) ===
 * 
 * O projeto parece complexo e grande, mas a maior parte do código é 
 * repetido, tentei implementar métodos pra deixar mais otimizado, mas
 * não funcionaram do jeito que queria e achei melhor fazer tudo na mão.
 * O projeto é dividido em dois arquivos, o "Fórmula", o qual contem as
 * fórmulas, e o MainApp. Dividi em 4 JFrames. Principal, Geometria Bá-
 * sica, Geometria Espacial e Matemática Financeira. Elas são conectadas
 * pela int "operacaoGeral" e pelo "painelVisivel". Os 3 de Fórmulas Fun-
 * cionam igualmente, só muda as fórmulas. O menu muda de acordo com o 
 * Frame ativo, e os menus de operações também. Fiz de um modo que o usu-
 * ário não percebe isso. Testei todas as fórmulas, e espero que não te-
 * nha nenhum erro. Obrigado pela atenção 😉
 */

public class MainApp {

        // Fontes
        static Font fonteTituloGrande = new Font("Serif", Font.BOLD, 46);
        static Font fonteButton = new Font("Arial", Font.PLAIN, 14);
        static Font fonteButton2 = new Font("Arial", Font.BOLD, 24);
        static Font fonteButton3 = new Font("Arial", Font.BOLD, 16);
        static Font fonteCampos = new Font("Arial", Font.PLAIN, 15);
        static Font fonteCampos2 = new Font("Arial", Font.PLAIN, 20);
        static Font fonteLabel = new Font("Arial", Font.BOLD, 14);
        static JFrame painelVisivel;
        static JFrame principalFrame = new JFrame("Calculadora de Fórmulas");
        static int operacaoGeral;

    public static void main(String[] args) throws Exception {

        // UIManager pra deixar o option pane mais bonito
        UIManager.put("OptionPane.background", new Color(215, 215, 215));
        UIManager.put("OptionPane.messageForeground", Color.BLACK);
        UIManager.put("Panel.background", new Color(215, 215, 215));
        UIManager.put("Button.font", fonteButton3);
        UIManager.put("Button.background", new Color(219, 219, 219));
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("Button.focus", new Color(0, 0, 0, 0)); // remove efeito de foco
        UIManager.put("Button.maximumSize", new Dimension(150, 40));
        UIManager.put("Button.border", new LineBorder(new Color(210, 210, 210), 2));


        // Frame Principal
        principalFrame.setSize(550, 700);
        principalFrame.setLocationRelativeTo(null);
        principalFrame.setResizable(false);
        principalFrame.getContentPane().setBackground(new Color(215, 215, 215));
        principalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel Principal
        JPanel principalPanel = new JPanel(new BorderLayout());
        principalPanel.setBackground(new Color(215, 215, 215));
        principalFrame.add(principalPanel);

        // ==== MENU ====

            // Panel Menu
            JPanel menuPanel = new JPanel(new BorderLayout());
            menuPanel.setBackground(new Color(219, 219, 219));
            menuPanel.setPreferredSize(new Dimension(0, 150));
            menuPanel.setBorder(new LineBorder(new Color(210, 210, 210), 2));

            // Panel Menu Cima
            JPanel menuCimaPanel = new JPanel(new BorderLayout());
            menuCimaPanel.setBackground(new Color(219, 219, 219));
            menuCimaPanel.setPreferredSize(new Dimension(0, 110));
            menuPanel.add(menuCimaPanel, BorderLayout.NORTH);

            // Título Menu
            JLabel tituloMenuCima = new JLabel("Calculadora de Fórmulas");
            tituloMenuCima.setForeground(Color.BLACK);
            tituloMenuCima.setFont(fonteTituloGrande);
            tituloMenuCima.setHorizontalAlignment(SwingConstants.CENTER);
            tituloMenuCima.setBorder(BorderFactory.createEmptyBorder(0 , 0, 13, 0));
            menuCimaPanel.add(tituloMenuCima, BorderLayout.SOUTH);

            // Panel Menu Baixo
            JPanel menuBaixoPanel = new JPanel(new GridBagLayout());
            menuBaixoPanel.setBackground(new Color(219, 219, 219));
            menuBaixoPanel.setPreferredSize(new Dimension(0, 40));
            menuPanel.add(menuBaixoPanel, BorderLayout.SOUTH);

            // Grid Bag Constrains Centro
            GridBagConstraints gbcCentro = new GridBagConstraints();
            gbcCentro.gridx = 0;
            gbcCentro.gridy = 0;
            gbcCentro.insets = new Insets(0, 0, 0, 10);

            // Panel Menu Baixo Flow
            JPanel menuBaixoFlowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            menuBaixoFlowPanel.setBackground(new Color(219, 219, 219));
            menuBaixoFlowPanel.setMinimumSize(new Dimension(400, 40));
            menuBaixoPanel.add(menuBaixoFlowPanel, gbcCentro);

            // Botão voltar ao início
            JButton botaoVoltarInicio = new JButton("Início");
            botaoVoltarInicio.setOpaque(false);
            botaoVoltarInicio.setContentAreaFilled(false);
            botaoVoltarInicio.setForeground(Color.BLACK);
            botaoVoltarInicio.setPreferredSize(new Dimension(50, 20));
            botaoVoltarInicio.setFont(fonteButton);
            botaoVoltarInicio.setFocusPainted(false);
            botaoVoltarInicio.setHorizontalTextPosition(SwingConstants.CENTER);
            botaoVoltarInicio.setBorder(null);
            menuBaixoFlowPanel.add(botaoVoltarInicio);

            // Mudar a cor com hover Início
                botaoVoltarInicio.addMouseListener(new java.awt.event.MouseAdapter() {
                    // Hover
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {botaoVoltarInicio.setForeground(new Color(155, 155, 155));}

                    // Sair do hover
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {botaoVoltarInicio.setForeground(new Color(10, 10, 10));}
                });

            // Action Listener Ínício
                botaoVoltarInicio.addActionListener(e -> {
                    painelVisivel.setVisible(false);
                    painelVisivel = principalFrame;
                    painelVisivel.setLocationRelativeTo(null);
                    principalPanel.add(menuPanel, BorderLayout.NORTH);
                    tituloMenuCima.setText("Calculadora de Fórmulas");
                    painelVisivel.setVisible(true);
                });
        
        // ==== /MENU ====

        // Panel Info Principal
        JPanel infoPrincipalPanel = new JPanel(new GridBagLayout());
        infoPrincipalPanel.setBackground(new Color(215, 215, 215));
        principalPanel.add(infoPrincipalPanel, BorderLayout.CENTER);

            // Panel Info Principal Border
            JPanel infoPrincipalBorderPanel = new JPanel(new BorderLayout());
            infoPrincipalBorderPanel.setBackground(new Color(215, 215, 215));
            infoPrincipalBorderPanel.setPreferredSize(new Dimension(400, 450));
            infoPrincipalBorderPanel.setBorder(new LineBorder(new Color(17, 17, 17), 2));
            infoPrincipalPanel.add(infoPrincipalBorderPanel, gbcCentro);

            // Panel Info Flow
            JPanel infoFlowPanel = new JPanel();
            infoFlowPanel.setLayout(new BoxLayout(infoFlowPanel, BoxLayout.Y_AXIS));
            infoFlowPanel.setBackground(new Color(215, 215, 215));
            infoPrincipalBorderPanel.add(infoFlowPanel, BorderLayout.CENTER);

                // Botão Geometria Básica
                JButton botaoGeometriaBasica = new JButton("Geometria Básica");
                botaoGeometriaBasica.setFont(fonteButton2);
                botaoGeometriaBasica.setBackground(new Color(219, 219, 219));
                botaoGeometriaBasica.setForeground(Color.BLACK);
                botaoGeometriaBasica.setFocusPainted(false);
                botaoGeometriaBasica.setAlignmentX(Component.CENTER_ALIGNMENT);
                botaoGeometriaBasica.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoGeometriaBasica.setMaximumSize(new Dimension(370, 75));

                // Botão Geometria Espacial
                JButton botaoGeometriaEspacial = new JButton("Geometria Espacial");
                botaoGeometriaEspacial.setFont(fonteButton2);
                botaoGeometriaEspacial.setBackground(new Color(219, 219, 219));
                botaoGeometriaEspacial.setForeground(Color.BLACK);
                botaoGeometriaEspacial.setFocusPainted(false);
                botaoGeometriaEspacial.setAlignmentX(Component.CENTER_ALIGNMENT);
                botaoGeometriaEspacial.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoGeometriaEspacial.setMaximumSize(new Dimension(370, 75));

                // Botão Matemática Financeira
                JButton botaoMatematicaFinanceira = new JButton("Matemática Financeira");
                botaoMatematicaFinanceira.setFont(fonteButton2);
                botaoMatematicaFinanceira.setBackground(new Color(219, 219, 219));
                botaoMatematicaFinanceira.setForeground(Color.BLACK);
                botaoMatematicaFinanceira.setFocusPainted(false);
                botaoMatematicaFinanceira.setAlignmentX(Component.CENTER_ALIGNMENT);
                botaoMatematicaFinanceira.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoMatematicaFinanceira.setMaximumSize(new Dimension(370, 75));

                infoFlowPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 50)));
                infoFlowPanel.add(botaoGeometriaBasica);
                infoFlowPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 60)));
                infoFlowPanel.add(botaoGeometriaEspacial);
                infoFlowPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 60)));
                infoFlowPanel.add(botaoMatematicaFinanceira);

        // ==== Painel Info Operandos ====

            // Panel Um Operando
            JPanel umOperandoPanel = new JPanel();
            umOperandoPanel.setLayout(new BoxLayout(umOperandoPanel, BoxLayout.Y_AXIS));
            umOperandoPanel.setBackground(new Color(215, 215, 215));

                // Panel Operando 1, um Operando
                    JPanel umOperando1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
                    umOperando1Panel.setBackground(new Color(215, 215, 215));
                    umOperando1Panel.setMaximumSize(new Dimension(400, 70));
                    umOperando1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

                        // Text Label Operando 1, um Operando
                        JLabel umOperando1Label = new JLabel("Operando 1:");
                        umOperando1Label.setForeground(Color.BLACK);
                        umOperando1Label.setFont(fonteLabel);
                        umOperando1Label.setPreferredSize(new Dimension(130, 30));

                        // JTextField Operando 1, um Operando
                        JTextField umOperando1TextField = new JTextField();
                        umOperando1TextField.setForeground(Color.BLACK);
                        umOperando1TextField.setBackground(new Color(219, 219, 219));
                        umOperando1TextField.setFont(fonteCampos);
                        umOperando1TextField.setHorizontalAlignment(SwingConstants.CENTER);
                        umOperando1TextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                        umOperando1TextField.setPreferredSize(new Dimension(230, 30));
                        umOperando1Panel.add(umOperando1Label);
                        umOperando1Panel.add(umOperando1TextField);

            // Adicionar ao um Operando
            umOperandoPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 80)));
            umOperandoPanel.add(umOperando1Panel);


            // Panel Dois Operandos
            JPanel doisOperandoPanel = new JPanel();
            doisOperandoPanel.setLayout(new BoxLayout(doisOperandoPanel, BoxLayout.Y_AXIS));
            doisOperandoPanel.setBackground(new Color(215, 215, 215));

                // Panel Operando 1, Dois Operandos
                    JPanel doisOperando1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
                    doisOperando1Panel.setBackground(new Color(215, 215, 215));
                    doisOperando1Panel.setMaximumSize(new Dimension(400, 70));
                    doisOperando1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

                        // Text Label Operando 1, Dois Operandos
                        JLabel doisOperando1Label = new JLabel("Operando 1:");
                        doisOperando1Label.setForeground(Color.BLACK);
                        doisOperando1Label.setFont(fonteLabel);
                        doisOperando1Label.setPreferredSize(new Dimension(130, 30));

                        // JTextField Operando 1, Dois Operandos
                        JTextField doisOperando1TextField = new JTextField();
                        doisOperando1TextField.setForeground(Color.BLACK);
                        doisOperando1TextField.setBackground(new Color(219, 219, 219));
                        doisOperando1TextField.setFont(fonteCampos);
                        doisOperando1TextField.setHorizontalAlignment(SwingConstants.CENTER);
                        doisOperando1TextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                        doisOperando1TextField.setPreferredSize(new Dimension(230, 30));
                        doisOperando1Panel.add(doisOperando1Label);
                        doisOperando1Panel.add(doisOperando1TextField);

                // Panel Operando 2, Dois Operandos
                    JPanel doisOperando2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
                    doisOperando2Panel.setBackground(new Color(215, 215, 215));
                    doisOperando2Panel.setMaximumSize(new Dimension(400, 70));
                    doisOperando2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

                        // Text Label Operando 2, Dois Operandos
                        JLabel doisOperando2Label = new JLabel("Operando 2:");
                        doisOperando2Label.setForeground(Color.BLACK);
                        doisOperando2Label.setFont(fonteLabel);
                        doisOperando2Label.setPreferredSize(new Dimension(130, 30));

                        // JTextField Operando 2, Dois Operandos
                        JTextField doisOperando2TextField = new JTextField();
                        doisOperando2TextField.setForeground(Color.BLACK);
                        doisOperando2TextField.setBackground(new Color(219, 219, 219));
                        doisOperando2TextField.setFont(fonteCampos);
                        doisOperando2TextField.setHorizontalAlignment(SwingConstants.CENTER);
                        doisOperando2TextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                        doisOperando2TextField.setPreferredSize(new Dimension(230, 30));
                        doisOperando2Panel.add(doisOperando2Label);
                        doisOperando2Panel.add(doisOperando2TextField);

            // Adicionar ao Dois Operandos
            doisOperandoPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 50)));
            doisOperandoPanel.add(doisOperando1Panel);
            doisOperandoPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 10)));
            doisOperandoPanel.add(doisOperando2Panel);

            // Panel Três Operandos
            JPanel tresOperandoPanel = new JPanel();
            tresOperandoPanel.setLayout(new BoxLayout(tresOperandoPanel, BoxLayout.Y_AXIS));
            tresOperandoPanel.setBackground(new Color(215, 215, 215));

                // Panel Operando 1, Três Operandos
                    JPanel tresOperando1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
                    tresOperando1Panel.setBackground(new Color(215, 215, 215));
                    tresOperando1Panel.setMaximumSize(new Dimension(400, 70));
                    tresOperando1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

                        // Text Label Operando 1, Três Operandos
                        JLabel tresOperando1Label = new JLabel("Operando 1:");
                        tresOperando1Label.setForeground(Color.BLACK);
                        tresOperando1Label.setFont(fonteLabel);
                        tresOperando1Label.setPreferredSize(new Dimension(130, 30));

                        // JTextField Operando 1, Três Operandos
                        JTextField tresOperando1TextField = new JTextField();
                        tresOperando1TextField.setForeground(Color.BLACK);
                        tresOperando1TextField.setBackground(new Color(219, 219, 219));
                        tresOperando1TextField.setFont(fonteCampos);
                        tresOperando1TextField.setHorizontalAlignment(SwingConstants.CENTER);
                        tresOperando1TextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                        tresOperando1TextField.setPreferredSize(new Dimension(230, 30));
                        tresOperando1Panel.add(tresOperando1Label);
                        tresOperando1Panel.add(tresOperando1TextField);

                // Panel Operando 2, Três Operandos
                    JPanel tresOperando2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
                    tresOperando2Panel.setBackground(new Color(215, 215, 215));
                    tresOperando2Panel.setMaximumSize(new Dimension(400, 70));
                    tresOperando2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

                        // Text Label Operando 2, Três Operandos
                        JLabel tresOperando2Label = new JLabel("Operando 2:");
                        tresOperando2Label.setForeground(Color.BLACK);
                        tresOperando2Label.setFont(fonteLabel);
                        tresOperando2Label.setPreferredSize(new Dimension(130, 30));

                        // JTextField Operando 2, Três Operandos
                        JTextField tresOperando2TextField = new JTextField();
                        tresOperando2TextField.setForeground(Color.BLACK);
                        tresOperando2TextField.setBackground(new Color(219, 219, 219));
                        tresOperando2TextField.setFont(fonteCampos);
                        tresOperando2TextField.setHorizontalAlignment(SwingConstants.CENTER);
                        tresOperando2TextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                        tresOperando2TextField.setPreferredSize(new Dimension(230, 30));
                        tresOperando2Panel.add(tresOperando2Label);
                        tresOperando2Panel.add(tresOperando2TextField);

                // Panel Operando 3, Três Operandos
                    JPanel tresOperando3Panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
                    tresOperando3Panel.setBackground(new Color(215, 215, 215));
                    tresOperando3Panel.setMaximumSize(new Dimension(400, 70));
                    tresOperando3Panel.setAlignmentX(Component.CENTER_ALIGNMENT);

                        // Text Label Operando 3, Três Operandos
                        JLabel tresOperando3Label = new JLabel("Operando 3:");
                        tresOperando3Label.setForeground(Color.BLACK);
                        tresOperando3Label.setFont(fonteLabel);
                        tresOperando3Label.setPreferredSize(new Dimension(130, 30));

                        // JTextField Operando 3, Três Operandos
                        JTextField tresOperando3TextField = new JTextField();
                        tresOperando3TextField.setForeground(Color.BLACK);
                        tresOperando3TextField.setBackground(new Color(219, 219, 219));
                        tresOperando3TextField.setFont(fonteCampos);
                        tresOperando3TextField.setHorizontalAlignment(SwingConstants.CENTER);
                        tresOperando3TextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                        tresOperando3TextField.setPreferredSize(new Dimension(230, 30));
                        tresOperando3Panel.add(tresOperando3Label);
                        tresOperando3Panel.add(tresOperando3TextField);

            // Adicionar ao Três Operandos
            tresOperandoPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 20)));
            tresOperandoPanel.add(tresOperando1Panel);
            tresOperandoPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 10)));
            tresOperandoPanel.add(tresOperando2Panel);
            tresOperandoPanel.add(new Box.Filler(new Dimension(0, 20), new Dimension(0, 20), new Dimension(0, 10)));
            tresOperandoPanel.add(tresOperando3Panel);

        // ==== /Painel Info Operandos ====


        // ==== Geometria Básica ====

        // Frame Geometria Básica
        JFrame geometriaBasicaFrame = new JFrame("Geometria Básica");
        geometriaBasicaFrame.setSize(550, 700);
        geometriaBasicaFrame.setLocationRelativeTo(null);
        geometriaBasicaFrame.setResizable(false);
        geometriaBasicaFrame.getContentPane().setBackground(new Color(215, 215, 215));
        geometriaBasicaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel Geometria Básica
        JPanel geometriaBasicaPanel = new JPanel(new BorderLayout());
        geometriaBasicaPanel.setBackground(new Color(215, 215, 215));
        geometriaBasicaFrame.add(geometriaBasicaPanel);

        // Panel Info Geometria Básica
        JPanel infoGeometriaBasicaPanel = new JPanel(new GridBagLayout());
        infoGeometriaBasicaPanel.setBackground(new Color(215, 215, 215));
        geometriaBasicaPanel.add(infoGeometriaBasicaPanel, BorderLayout.CENTER);

            // Panel Info Geometria Básica Border
            JPanel infoGeometriaBasicaBorderPanel = new JPanel(new BorderLayout());
            infoGeometriaBasicaBorderPanel.setBackground(new Color(215, 215, 215));
            infoGeometriaBasicaBorderPanel.setPreferredSize(new Dimension(400, 450));
            infoGeometriaBasicaBorderPanel.setBorder(new LineBorder(new Color(17, 17, 17), 2));
            infoGeometriaBasicaPanel.add(infoGeometriaBasicaBorderPanel, gbcCentro);

            // Panel Selecionar Operação Geometria Básica
            JPanel geometriaBasicaSelecionarOperacaoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
            geometriaBasicaSelecionarOperacaoPanel.setBackground(new Color(215, 215, 215));
            botaoGeometriaEspacial.setBorder(new LineBorder(new Color(210, 210, 210), 2));
            geometriaBasicaSelecionarOperacaoPanel.setPreferredSize(new Dimension(400, 75));
            infoGeometriaBasicaBorderPanel.add(geometriaBasicaSelecionarOperacaoPanel, BorderLayout.NORTH);

                // Botão Selecionar Operação Geometria Básica
                JButton botaoGeometriaBasicaSelecionarOperacao = new JButton("Selecionar Operação");
                botaoGeometriaBasicaSelecionarOperacao.setFont(fonteButton2);
                botaoGeometriaBasicaSelecionarOperacao.setBackground(new Color(219, 219, 219));
                botaoGeometriaBasicaSelecionarOperacao.setForeground(Color.BLACK);
                botaoGeometriaBasicaSelecionarOperacao.setFocusPainted(false);
                botaoGeometriaBasicaSelecionarOperacao.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoGeometriaBasicaSelecionarOperacao.setPreferredSize(new Dimension(380, 55));
                geometriaBasicaSelecionarOperacaoPanel.add(botaoGeometriaBasicaSelecionarOperacao);

            // Panel Resultado Geometria Básica
            JPanel geometriaBasicaResultadoPanel = new JPanel();
            geometriaBasicaResultadoPanel.setBackground(new Color(215, 215, 215));
            geometriaBasicaResultadoPanel.setLayout(new BoxLayout(geometriaBasicaResultadoPanel, BoxLayout.Y_AXIS));
            geometriaBasicaResultadoPanel.setBorder(new LineBorder(new Color(210, 210, 210), 2));
            geometriaBasicaResultadoPanel.setPreferredSize(new Dimension(400, 145));
            infoGeometriaBasicaBorderPanel.add(geometriaBasicaResultadoPanel, BorderLayout.SOUTH);

                // Botão Resultado Geometria Básica
                JButton botaoResultadoGeometriaBasica = new JButton("Resultado");
                botaoResultadoGeometriaBasica.setFont(fonteButton2);
                botaoResultadoGeometriaBasica.setBackground(new Color(219, 219, 219));
                botaoResultadoGeometriaBasica.setForeground(Color.BLACK);
                botaoResultadoGeometriaBasica.setFocusPainted(false);
                botaoResultadoGeometriaBasica.setAlignmentX(Component.CENTER_ALIGNMENT);
                botaoResultadoGeometriaBasica.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoResultadoGeometriaBasica.setMaximumSize(new Dimension(380, 55));

                // JTextField Resultado Geometria Básica
                JTextField geometriaBasicaResultadoTextField = new JTextField();
                geometriaBasicaResultadoTextField.setForeground(Color.BLACK);
                geometriaBasicaResultadoTextField.setBackground(new Color(219, 219, 219));
                geometriaBasicaResultadoTextField.setFont(fonteCampos2);
                geometriaBasicaResultadoTextField.setHorizontalAlignment(SwingConstants.CENTER);
                geometriaBasicaResultadoTextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                geometriaBasicaResultadoTextField.setEditable(false);
                geometriaBasicaResultadoTextField.setMaximumSize(new Dimension(370, 55));
                geometriaBasicaResultadoTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

                geometriaBasicaResultadoPanel.add(new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(0, 10)));
                geometriaBasicaResultadoPanel.add(botaoResultadoGeometriaBasica);
                geometriaBasicaResultadoPanel.add(new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(0, 10)));
                geometriaBasicaResultadoPanel.add(geometriaBasicaResultadoTextField);

        // ==== /Geometria Básica ====


        // ==== Geometria Espacial ====

        // Frame Geometria Espacial
        JFrame geometriaEspacialFrame = new JFrame("Geometria Espacial");
        geometriaEspacialFrame.setSize(550, 700);
        geometriaEspacialFrame.setLocationRelativeTo(null);
        geometriaEspacialFrame.setResizable(false);
        geometriaEspacialFrame.getContentPane().setBackground(new Color(215, 215, 215));
        geometriaEspacialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel Geometria Espacial
        JPanel geometriaEspacialPanel = new JPanel(new BorderLayout());
        geometriaEspacialPanel.setBackground(new Color(215, 215, 215));
        geometriaEspacialFrame.add(geometriaEspacialPanel);

        // Panel Info Geometria Espacial
        JPanel infogeometriaEspacialPanel = new JPanel(new GridBagLayout());
        infogeometriaEspacialPanel.setBackground(new Color(215, 215, 215));
        geometriaEspacialPanel.add(infogeometriaEspacialPanel, BorderLayout.CENTER);

            // Panel Info Geometria Espacial Border
            JPanel infoGeometriaEspacialBorderPanel = new JPanel(new BorderLayout());
            infoGeometriaEspacialBorderPanel.setBackground(new Color(215, 215, 215));
            infoGeometriaEspacialBorderPanel.setPreferredSize(new Dimension(400, 450));
            infoGeometriaEspacialBorderPanel.setBorder(new LineBorder(new Color(17, 17, 17), 2));
            infogeometriaEspacialPanel.add(infoGeometriaEspacialBorderPanel, gbcCentro);

            // Panel Selecionar Operação Geometria Espacial
            JPanel geometriaEspacialSelecionarOperacaoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
            geometriaEspacialSelecionarOperacaoPanel.setBackground(new Color(215, 215, 215));
            botaoGeometriaEspacial.setBorder(new LineBorder(new Color(210, 210, 210), 2));
            geometriaEspacialSelecionarOperacaoPanel.setPreferredSize(new Dimension(400, 75));
            infoGeometriaEspacialBorderPanel.add(geometriaEspacialSelecionarOperacaoPanel, BorderLayout.NORTH);

                // Botão Selecionar Operação Geometria Espacial
                JButton botaoGeometriaEspacialSelecionarOperacao = new JButton("Selecionar Operação");
                botaoGeometriaEspacialSelecionarOperacao.setFont(fonteButton2);
                botaoGeometriaEspacialSelecionarOperacao.setBackground(new Color(219, 219, 219));
                botaoGeometriaEspacialSelecionarOperacao.setForeground(Color.BLACK);
                botaoGeometriaEspacialSelecionarOperacao.setFocusPainted(false);
                botaoGeometriaEspacialSelecionarOperacao.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoGeometriaEspacialSelecionarOperacao.setPreferredSize(new Dimension(380, 55));
                geometriaEspacialSelecionarOperacaoPanel.add(botaoGeometriaEspacialSelecionarOperacao);

            // Panel Resultado Geometria Espacial
            JPanel geometriaEspacialResultadoPanel = new JPanel();
            geometriaEspacialResultadoPanel.setBackground(new Color(215, 215, 215));
            geometriaEspacialResultadoPanel.setLayout(new BoxLayout(geometriaEspacialResultadoPanel, BoxLayout.Y_AXIS));
            geometriaEspacialResultadoPanel.setBorder(new LineBorder(new Color(210, 210, 210), 2));
            geometriaEspacialResultadoPanel.setPreferredSize(new Dimension(400, 145));
            infoGeometriaEspacialBorderPanel.add(geometriaEspacialResultadoPanel, BorderLayout.SOUTH);

                // Botão Resultado Geometria Espacial
                JButton botaoResultadoGeometriaEspacial = new JButton("Resultado");
                botaoResultadoGeometriaEspacial.setFont(fonteButton2);
                botaoResultadoGeometriaEspacial.setBackground(new Color(219, 219, 219));
                botaoResultadoGeometriaEspacial.setForeground(Color.BLACK);
                botaoResultadoGeometriaEspacial.setFocusPainted(false);
                botaoResultadoGeometriaEspacial.setAlignmentX(Component.CENTER_ALIGNMENT);
                botaoResultadoGeometriaEspacial.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoResultadoGeometriaEspacial.setMaximumSize(new Dimension(380, 55));

                // JTextField Resultado Geometria Espacial
                JTextField geometriaEspacialResultadoTextField = new JTextField();
                geometriaEspacialResultadoTextField.setForeground(Color.BLACK);
                geometriaEspacialResultadoTextField.setBackground(new Color(219, 219, 219));
                geometriaEspacialResultadoTextField.setFont(fonteCampos2);
                geometriaEspacialResultadoTextField.setHorizontalAlignment(SwingConstants.CENTER);
                geometriaEspacialResultadoTextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                geometriaEspacialResultadoTextField.setEditable(false);
                geometriaEspacialResultadoTextField.setMaximumSize(new Dimension(370, 55));
                geometriaEspacialResultadoTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

                geometriaEspacialResultadoPanel.add(new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(0, 10)));
                geometriaEspacialResultadoPanel.add(botaoResultadoGeometriaEspacial);
                geometriaEspacialResultadoPanel.add(new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(0, 10)));
                geometriaEspacialResultadoPanel.add(geometriaEspacialResultadoTextField);

        // ==== /Geometria Espacial ====


        // ==== Matemática Financeira ====

        // Frame Matemática Financeira
        JFrame matematicaFinanceiraFrame = new JFrame("Matemática Financeira");
        matematicaFinanceiraFrame.setSize(550, 700);
        matematicaFinanceiraFrame.setLocationRelativeTo(null);
        matematicaFinanceiraFrame.setResizable(false);
        matematicaFinanceiraFrame.getContentPane().setBackground(new Color(215, 215, 215));
        matematicaFinanceiraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel Matemática Financeira
        JPanel matematicaFinanceiraPanel = new JPanel(new BorderLayout());
        matematicaFinanceiraPanel.setBackground(new Color(215, 215, 215));
        matematicaFinanceiraFrame.add(matematicaFinanceiraPanel);

        // Panel Info Matemática Financeira
        JPanel infoMatematicaFinanceiraPanel = new JPanel(new GridBagLayout());
        infoMatematicaFinanceiraPanel.setBackground(new Color(215, 215, 215));
        matematicaFinanceiraPanel.add(infoMatematicaFinanceiraPanel, BorderLayout.CENTER);

            // Panel Info Matemática Financeira Border
            JPanel infoMatematicaFinanceiraBorderPanel = new JPanel(new BorderLayout());
            infoMatematicaFinanceiraBorderPanel.setBackground(new Color(215, 215, 215));
            infoMatematicaFinanceiraBorderPanel.setPreferredSize(new Dimension(400, 450));
            infoMatematicaFinanceiraBorderPanel.setBorder(new LineBorder(new Color(17, 17, 17), 2));
            infoMatematicaFinanceiraPanel.add(infoMatematicaFinanceiraBorderPanel, gbcCentro);

            // Panel Selecionar Operação Matemática Financeira
            JPanel matematicaFinanceiraSelecionarOperacaoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
            matematicaFinanceiraSelecionarOperacaoPanel.setBackground(new Color(215, 215, 215));
            botaoMatematicaFinanceira.setBorder(new LineBorder(new Color(210, 210, 210), 2));
            matematicaFinanceiraSelecionarOperacaoPanel.setPreferredSize(new Dimension(400, 75));
            infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraSelecionarOperacaoPanel, BorderLayout.NORTH);

                // Botão Selecionar Operação Matemática Financeira
                JButton botaoMatematicaFinanceiraSelecionarOperacao = new JButton("Selecionar Operação");
                botaoMatematicaFinanceiraSelecionarOperacao.setFont(fonteButton2);
                botaoMatematicaFinanceiraSelecionarOperacao.setBackground(new Color(219, 219, 219));
                botaoMatematicaFinanceiraSelecionarOperacao.setForeground(Color.BLACK);
                botaoMatematicaFinanceiraSelecionarOperacao.setFocusPainted(false);
                botaoMatematicaFinanceiraSelecionarOperacao.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoMatematicaFinanceiraSelecionarOperacao.setPreferredSize(new Dimension(380, 55));
                matematicaFinanceiraSelecionarOperacaoPanel.add(botaoMatematicaFinanceiraSelecionarOperacao);

            // Panel Resultado Matemática Financeira
            JPanel matematicaFinanceiraResultadoPanel = new JPanel();
            matematicaFinanceiraResultadoPanel.setBackground(new Color(215, 215, 215));
            matematicaFinanceiraResultadoPanel.setLayout(new BoxLayout(matematicaFinanceiraResultadoPanel, BoxLayout.Y_AXIS));
            matematicaFinanceiraResultadoPanel.setBorder(new LineBorder(new Color(210, 210, 210), 2));
            matematicaFinanceiraResultadoPanel.setPreferredSize(new Dimension(400, 145));
            infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraResultadoPanel, BorderLayout.SOUTH);

                // Botão Resultado Matemática Financeira
                JButton botaoResultadoMatematicaFinanceira = new JButton("Resultado");
                botaoResultadoMatematicaFinanceira.setFont(fonteButton2);
                botaoResultadoMatematicaFinanceira.setBackground(new Color(219, 219, 219));
                botaoResultadoMatematicaFinanceira.setForeground(Color.BLACK);
                botaoResultadoMatematicaFinanceira.setFocusPainted(false);
                botaoResultadoMatematicaFinanceira.setAlignmentX(Component.CENTER_ALIGNMENT);
                botaoResultadoMatematicaFinanceira.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                botaoResultadoMatematicaFinanceira.setMaximumSize(new Dimension(380, 55));

                // JTextField Resultado Matemática Financeira
                JTextField matematicaFinanceiraResultadoTextField = new JTextField();
                matematicaFinanceiraResultadoTextField.setForeground(Color.BLACK);
                matematicaFinanceiraResultadoTextField.setBackground(new Color(219, 219, 219));
                matematicaFinanceiraResultadoTextField.setFont(fonteCampos2);
                matematicaFinanceiraResultadoTextField.setHorizontalAlignment(SwingConstants.CENTER);
                matematicaFinanceiraResultadoTextField.setBorder(new LineBorder(new Color(210, 210, 210), 2));
                matematicaFinanceiraResultadoTextField.setEditable(false);
                matematicaFinanceiraResultadoTextField.setMaximumSize(new Dimension(370, 55));
                matematicaFinanceiraResultadoTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

                matematicaFinanceiraResultadoPanel.add(new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(0, 10)));
                matematicaFinanceiraResultadoPanel.add(botaoResultadoMatematicaFinanceira);
                matematicaFinanceiraResultadoPanel.add(new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(0, 10)));
                matematicaFinanceiraResultadoPanel.add(matematicaFinanceiraResultadoTextField);

        // ==== /Matemática Financeira ====


        // Action Listeners Botões Principal

        // Geometria Básica
        botaoGeometriaBasica.addActionListener(e -> {
            painelVisivel.setVisible(false);
            painelVisivel = geometriaBasicaFrame;
            geometriaBasicaPanel.add(menuPanel, BorderLayout.NORTH);
            infoGeometriaBasicaBorderPanel.add(geometriaBasicaSelecionarOperacaoPanel, BorderLayout.NORTH);
            infoGeometriaBasicaBorderPanel.add(geometriaBasicaResultadoPanel, BorderLayout.SOUTH);
            tituloMenuCima.setText("Geometria Básica");
            painelVisivel.setLocationRelativeTo(null);
            painelVisivel.setVisible(true);
        });

        // Geometria Espacial
        botaoGeometriaEspacial.addActionListener(e -> {
            painelVisivel.setVisible(false);
            painelVisivel = geometriaEspacialFrame;
            geometriaEspacialPanel.add(menuPanel, BorderLayout.NORTH);
            infoGeometriaEspacialBorderPanel.add(geometriaEspacialSelecionarOperacaoPanel, BorderLayout.NORTH);
            infoGeometriaEspacialBorderPanel.add(geometriaEspacialResultadoPanel, BorderLayout.SOUTH);
            tituloMenuCima.setText("Geometria Espacial");
            painelVisivel.setLocationRelativeTo(null);
            painelVisivel.setVisible(true);
        });

        // Matemática Financeira
        botaoMatematicaFinanceira.addActionListener(e -> {
            painelVisivel.setVisible(false);
            painelVisivel = matematicaFinanceiraFrame;
            matematicaFinanceiraPanel.add(menuPanel, BorderLayout.NORTH);
            infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraSelecionarOperacaoPanel, BorderLayout.NORTH);
            infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraResultadoPanel, BorderLayout.SOUTH);
            tituloMenuCima.setText("Matemática Financeira");
            painelVisivel.setLocationRelativeTo(null);
            painelVisivel.setVisible(true);
        });

        // Operação Geometria Básica
        botaoGeometriaBasicaSelecionarOperacao.addActionListener(e -> {


            String[] operacoesString = {"Área do Quadrado", "Área do Retângulo", "Área do Triangulo", "Área do Circulo", "Circunferência do Circulo"};
            int operacao = JOptionPane.showOptionDialog(
                null, null, "Escolha uma operação", JOptionPane.DEFAULT_OPTION,
                JOptionPane.DEFAULT_OPTION, null, operacoesString, operacoesString[0]);

                infoGeometriaBasicaBorderPanel.removeAll();
                geometriaBasicaResultadoTextField.setText("");
                umOperando1TextField.setText("");
                doisOperando1TextField.setText("");
                doisOperando2TextField.setText("");
                tresOperando1TextField.setText("");
                tresOperando2TextField.setText("");
                tresOperando3TextField.setText("");
    
            if(operacao == 0) {
                operacaoGeral = 0;
                painelVisivel.setVisible(false);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaBasicaBorderPanel.add(umOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaBasica.setText("Área do Quadrado");
                umOperando1Label.setText("Lado:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 1) {
                operacaoGeral = 1;
                painelVisivel.setVisible(false);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaBasicaBorderPanel.add(doisOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaBasica.setText("Área do Retângulo");
                doisOperando1Label.setText("Lado:");
                doisOperando2Label.setText("Altura:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 2) {
                operacaoGeral = 2;
                painelVisivel.setVisible(false);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaBasicaBorderPanel.add(doisOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaBasica.setText("Área do Triângulo");
                doisOperando1Label.setText("Base:");
                doisOperando2Label.setText("Altura:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 3) {
                operacaoGeral = 3;
                painelVisivel.setVisible(false);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaBasicaBorderPanel.add(umOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaBasica.setText("Área do Circulo");
                umOperando1Label.setText("Raio:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 4) {
                operacaoGeral = 4;
                painelVisivel.setVisible(false);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaBasicaBorderPanel.add(geometriaBasicaResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaBasicaBorderPanel.add(umOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaBasica.setText("Circunferência do Circulo");
                umOperando1Label.setText("Raio:");
                painelVisivel.setVisible(true);
            }

        });

        // Resultado Geometria Básica
        botaoResultadoGeometriaBasica.addActionListener(a -> {
            geometriaBasicaResultadoTextField.setText("");

            if(operacaoGeral == 0) {

                String ladoString = umOperando1TextField.getText().replace(',', '.');
                BigDecimal lado = new BigDecimal(ladoString);

                try {

                    BigDecimal resultado = Formula.areaQuadrado(lado);
                    geometriaBasicaResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 1) {

                String ladoString = doisOperando1TextField.getText().replace(',', '.');
                BigDecimal lado = new BigDecimal(ladoString);
                String alturaString = doisOperando2TextField.getText().replace(',', '.');
                BigDecimal altura = new BigDecimal(alturaString);

                try {

                    BigDecimal resultado = Formula.areaRetangulo(lado, altura);
                    geometriaBasicaResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 2) {

                String baseString = doisOperando1TextField.getText().replace(',', '.');
                BigDecimal base = new BigDecimal(baseString);
                String alturaString = doisOperando2TextField.getText().replace(',', '.');
                BigDecimal altura = new BigDecimal(alturaString);

                try {

                    BigDecimal resultado = Formula.areaTriangulo(base, altura);
                    geometriaBasicaResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 3) {

                String raioString = umOperando1TextField.getText().replace(',', '.');
                BigDecimal raio = new BigDecimal(raioString);

                try {

                    BigDecimal resultado = Formula.areaCirculo(raio);
                    geometriaBasicaResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 4) {

                String raioString = umOperando1TextField.getText().replace(',', '.');
                BigDecimal raio = new BigDecimal(raioString);

                try {

                    BigDecimal resultado = Formula.circunferenciaCirculo(raio);
                    geometriaBasicaResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

        });

        // Operação Geometria Espacial
        botaoGeometriaEspacialSelecionarOperacao.addActionListener(e -> {

            String[] operacoesString = {"Volume do Cubo", "Volume do Paralelepípedo", "Volume da Esfera", "Volume do Cilindro", "Volume da Pirâmide"};
            int operacao = JOptionPane.showOptionDialog(
                null, null, "Escolha uma operação", JOptionPane.DEFAULT_OPTION,
                JOptionPane.DEFAULT_OPTION, null, operacoesString, operacoesString[0]);

                infoGeometriaEspacialBorderPanel.removeAll();
                geometriaEspacialResultadoTextField.setText("");
                umOperando1TextField.setText("");
                doisOperando1TextField.setText("");
                doisOperando2TextField.setText("");
                tresOperando1TextField.setText("");
                tresOperando2TextField.setText("");
                tresOperando3TextField.setText("");
    
            if(operacao == 0) {
                operacaoGeral = 5;
                painelVisivel.setVisible(false);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaEspacialBorderPanel.add(umOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaEspacial.setText("Volume do Cubo");
                umOperando1Label.setText("Lado:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 1) {
                operacaoGeral = 6;
                painelVisivel.setVisible(false);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaEspacialBorderPanel.add(tresOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaEspacial.setText("Volume do Paralelepípedo");
                tresOperando1Label.setText("LadoX:");
                tresOperando2Label.setText("LadoY:");
                tresOperando3Label.setText("Altura:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 2) {
                operacaoGeral = 7;
                painelVisivel.setVisible(false);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaEspacialBorderPanel.add(umOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaEspacial.setText("Volume da Esfera");
                umOperando1Label.setText("Raio:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 3) {
                operacaoGeral = 8;
                painelVisivel.setVisible(false);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaEspacialBorderPanel.add(doisOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaEspacial.setText("Volume do Cilindro");
                doisOperando1Label.setText("Raio:");
                doisOperando2Label.setText("Altura:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 4) {
                operacaoGeral = 9;
                painelVisivel.setVisible(false);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoGeometriaEspacialBorderPanel.add(geometriaEspacialResultadoPanel, BorderLayout.SOUTH);
                infoGeometriaEspacialBorderPanel.add(tresOperandoPanel, BorderLayout.CENTER);
                botaoResultadoGeometriaEspacial.setText("Volume da Pirâmide");
                tresOperando1Label.setText("LadoX:");
                tresOperando2Label.setText("LadoY:");
                tresOperando3Label.setText("Altura:");
                painelVisivel.setVisible(true);
            }

        });

        // Resultado Geometria Espacial
        botaoResultadoGeometriaEspacial.addActionListener(a -> {
            geometriaEspacialResultadoTextField.setText("");

            if(operacaoGeral == 5) {

                String ladoString = umOperando1TextField.getText().replace(',', '.');
                BigDecimal lado = new BigDecimal(ladoString);

                try {

                    BigDecimal resultado = Formula.volumeCubo(lado);
                    geometriaEspacialResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 6) {

                String ladoString = tresOperando1TextField.getText().replace(',', '.');
                BigDecimal lado = new BigDecimal(ladoString);
                String alturaString = tresOperando3TextField.getText().replace(',', '.');
                BigDecimal altura = new BigDecimal(alturaString);
                String profundidadeString = tresOperando2TextField.getText().replace(',', '.');
                BigDecimal profundidade = new BigDecimal(profundidadeString);

                try {

                    BigDecimal resultado = Formula.volumeParalelepipedo(lado, profundidade, altura);
                    geometriaEspacialResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 7) {

                String raioString = umOperando1TextField.getText().replace(',', '.');
                BigDecimal raio = new BigDecimal(raioString);

                try {

                    BigDecimal resultado = Formula.volumeEsfera(raio);
                    geometriaEspacialResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 8) {

                String raioString = doisOperando1TextField.getText().replace(',', '.');
                BigDecimal raio = new BigDecimal(raioString);
                String alturaString = doisOperando2TextField.getText().replace(',', '.');
                BigDecimal altura = new BigDecimal(alturaString);

                try {

                    BigDecimal resultado = Formula.volumeCilindro(raio, altura);
                    geometriaEspacialResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 9) {

                String ladoString = tresOperando1TextField.getText().replace(',', '.');
                BigDecimal lado = new BigDecimal(ladoString);
                String profundidadeString = tresOperando2TextField.getText().replace(',', '.');
                BigDecimal profundidade = new BigDecimal(profundidadeString);
                String alturaString = tresOperando3TextField.getText().replace(',', '.');
                BigDecimal altura = new BigDecimal(alturaString);

                try {

                    BigDecimal resultado = Formula.volumePiramide(lado, profundidade, altura);
                    geometriaEspacialResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

        });

        // Operação Matemãtica Financeira
        botaoMatematicaFinanceiraSelecionarOperacao.addActionListener(e -> {

            String[] operacoesString = {"Porcentagem", "Juros Simples", "Montante de Juros Simples", "Juros Compostos", "Montante de Juros Compostos"};
            int operacao = JOptionPane.showOptionDialog(
                null, null, "Escolha uma operação", JOptionPane.DEFAULT_OPTION,
                JOptionPane.DEFAULT_OPTION, null, operacoesString, operacoesString[0]);

                infoMatematicaFinanceiraBorderPanel.removeAll();
                matematicaFinanceiraResultadoTextField.setText("");
                umOperando1TextField.setText("");
                doisOperando1TextField.setText("");
                doisOperando2TextField.setText("");
                tresOperando1TextField.setText("");
                tresOperando2TextField.setText("");
                tresOperando3TextField.setText("");
    
            if(operacao == 0) {
                operacaoGeral = 10;
                painelVisivel.setVisible(false);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraResultadoPanel, BorderLayout.SOUTH);
                infoMatematicaFinanceiraBorderPanel.add(doisOperandoPanel, BorderLayout.CENTER);
                botaoResultadoMatematicaFinanceira.setText("Porcentagem");
                doisOperando1Label.setText("Valor Total:");
                doisOperando2Label.setText("Porcentagem %:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 1) {
                operacaoGeral = 11;
                painelVisivel.setVisible(false);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraResultadoPanel, BorderLayout.SOUTH);
                infoMatematicaFinanceiraBorderPanel.add(tresOperandoPanel, BorderLayout.CENTER);
                botaoResultadoMatematicaFinanceira.setText("Juros Simples");
                tresOperando1Label.setText("Cap. Inicial:");
                tresOperando2Label.setText("Taxa de Juros %:");
                tresOperando3Label.setText("Tempo:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 2) {
                operacaoGeral = 12;
                painelVisivel.setVisible(false);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraResultadoPanel, BorderLayout.SOUTH);
                infoMatematicaFinanceiraBorderPanel.add(tresOperandoPanel, BorderLayout.CENTER);
                botaoResultadoMatematicaFinanceira.setText("Montante de Juros Simples");
                tresOperando1Label.setText("Cap. Inicial:");
                tresOperando2Label.setText("Taxa de Juros: %");
                tresOperando3Label.setText("Tempo:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 3) {
                operacaoGeral = 13;
                painelVisivel.setVisible(false);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraResultadoPanel, BorderLayout.SOUTH);
                infoMatematicaFinanceiraBorderPanel.add(tresOperandoPanel, BorderLayout.CENTER);
                botaoResultadoMatematicaFinanceira.setText("Juros Compostos");
                tresOperando1Label.setText("Cap. Inicial:");
                tresOperando2Label.setText("Taxa de Juros %:");
                tresOperando3Label.setText("Tempo:");
                painelVisivel.setVisible(true);
            }
            if(operacao == 4) {
                operacaoGeral = 14;
                painelVisivel.setVisible(false);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraSelecionarOperacaoPanel, BorderLayout.NORTH);
                infoMatematicaFinanceiraBorderPanel.add(matematicaFinanceiraResultadoPanel, BorderLayout.SOUTH);
                infoMatematicaFinanceiraBorderPanel.add(tresOperandoPanel, BorderLayout.CENTER);
                botaoResultadoMatematicaFinanceira.setText("Montante de Juros Simples");
                tresOperando1Label.setText("Cap. Inicial:");
                tresOperando2Label.setText("Taxa de Juros %:");
                tresOperando3Label.setText("Tempo:");
                painelVisivel.setVisible(true);
            }

        });

        // Resultado Matemática Financeira
        botaoResultadoMatematicaFinanceira.addActionListener(a -> {
            matematicaFinanceiraResultadoTextField.setText("");

            if(operacaoGeral == 10) {

                String valorTotalString = doisOperando1TextField.getText().replace(',', '.');
                BigDecimal valorTotal = new BigDecimal(valorTotalString);
                String porcentagemString = doisOperando2TextField.getText().replace(',', '.');
                BigDecimal porcentagem = new BigDecimal(porcentagemString);

                try {

                    BigDecimal resultado = Formula.porcentagem(valorTotal, porcentagem);
                    matematicaFinanceiraResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 11) {

                String capitalInicialString = tresOperando1TextField.getText().replace(',', '.');
                BigDecimal capitalInicial = new BigDecimal(capitalInicialString);
                String taxaDeJurosString = tresOperando2TextField.getText().replace(',', '.');
                BigDecimal taxaDeJuros = new BigDecimal(taxaDeJurosString);
                String tempoString = tresOperando3TextField.getText().replace(',', '.');
                BigDecimal tempo = new BigDecimal(tempoString);

                try {

                    BigDecimal resultado = Formula.jurosSimples(capitalInicial, taxaDeJuros, tempo);
                    matematicaFinanceiraResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 12) {

                String capitalInicialString = tresOperando1TextField.getText().replace(',', '.');
                BigDecimal capitalInicial = new BigDecimal(capitalInicialString);
                String taxaDeJurosString = tresOperando2TextField.getText().replace(',', '.');
                BigDecimal taxaDeJuros = new BigDecimal(taxaDeJurosString);
                String tempoString = tresOperando3TextField.getText().replace(',', '.');
                BigDecimal tempo = new BigDecimal(tempoString);

                try {

                    BigDecimal resultado = Formula.montanteJurosSimples(capitalInicial, taxaDeJuros, tempo);
                    matematicaFinanceiraResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 13) {

                String capitalInicialString = tresOperando1TextField.getText().replace(',', '.');
                BigDecimal capitalInicial = new BigDecimal(capitalInicialString);
                String taxaDeJurosString = tresOperando2TextField.getText().replace(',', '.');
                BigDecimal taxaDeJuros = new BigDecimal(taxaDeJurosString);
                String tempoString = tresOperando3TextField.getText().replace(',', '.');
                BigDecimal tempo = new BigDecimal(tempoString);

                try {

                    BigDecimal resultado = Formula.jurosCompostos(capitalInicial, taxaDeJuros, tempo);
                    matematicaFinanceiraResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

            if(operacaoGeral == 14) {

                String capitalInicialString = tresOperando1TextField.getText().replace(',', '.');
                BigDecimal capitalInicial = new BigDecimal(capitalInicialString);
                String taxaDeJurosString = tresOperando2TextField.getText().replace(',', '.');
                BigDecimal taxaDeJuros = new BigDecimal(taxaDeJurosString);
                String tempoString = tresOperando3TextField.getText().replace(',', '.');
                BigDecimal tempo = new BigDecimal(tempoString);

                try {

                    BigDecimal resultado = Formula.montanteJurosCompostos(capitalInicial, taxaDeJuros, tempo);
                    matematicaFinanceiraResultadoTextField.setText(resultado.toString());

                } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog( null, "Digite um número válido.", null, JOptionPane.WARNING_MESSAGE);
            }}

        });


        // Mouse Listeners Botões

            // Botão Geometria Básica
            addMouseListenerMethod(botaoGeometriaBasica);

            // Botão Geometria Espacial
            addMouseListenerMethod(botaoGeometriaEspacial);

            // Botão Matemática Financeira
            addMouseListenerMethod(botaoMatematicaFinanceira);

            // Botão Selecionar Operação Geometria Básica
            addMouseListenerMethod(botaoGeometriaBasicaSelecionarOperacao);

            // Botão Resultado Geometria Básica
            addMouseListenerMethod(botaoGeometriaBasicaSelecionarOperacao);

            // Botão Selecionar Operação Geometria Espacial
            addMouseListenerMethod(botaoGeometriaEspacialSelecionarOperacao);

            // Botão Resultado Geometria Espacial
            addMouseListenerMethod(botaoResultadoGeometriaEspacial);

            // Botão Selecionar Operação Matematica Financeira
            addMouseListenerMethod(botaoMatematicaFinanceiraSelecionarOperacao);

            // Botão Resultado Matematica Financeira
            addMouseListenerMethod(botaoResultadoMatematicaFinanceira);

        // Iniciar
        painelVisivel = principalFrame;
        principalPanel.add(menuPanel, BorderLayout.NORTH);
        painelVisivel.setVisible(true);

    }

    // Método para Mouse Listener
    public static void addMouseListenerMethod(JButton butao) {
        butao.addMouseListener(new java.awt.event.MouseAdapter() {
                        // Sair do Hover
                        @Override
                        public void mouseExited(java.awt.event.MouseEvent evt) {butao.setBackground(new Color(219, 219, 219));}

                        // Hover
                        @Override
                        public void mouseEntered(java.awt.event.MouseEvent evt) {butao.setBackground(new Color(163, 163, 163));}
                    });
    }
}
