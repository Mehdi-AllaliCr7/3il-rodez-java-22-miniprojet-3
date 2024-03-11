package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PenduFrame extends JFrame {
    private JLabel motLabel;
    private JPanel penduPanel;
    private int erreurCount; // Pour suivre le nombre d'erreurs
    private Set<Character> lettresProposees;
    private JTextField saisieLettre;

    public PenduFrame() {
        setTitle("Jeu du Pendu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Initialisation des composants
        motLabel = new JLabel("Mot à deviner");
        motLabel.setHorizontalAlignment(JLabel.CENTER);

        penduPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dessinerPendu(g);
            }
        };

        saisieLettre = new JTextField();
        saisieLettre.setColumns(10);
        saisieLettre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                // Gérer l'action lorsque l'utilisateur appuie sur la touche Entrée
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String lettre = saisieLettre.getText().toUpperCase();
                    if (lettre.length() == 1 && Character.isLetter(lettre.charAt(0))) {
                        if (lettresProposees.contains(lettre.charAt(0))) {
                            // Si la lettre a déjà été proposée, afficher un message et ne pas la compter comme une erreur
                            JOptionPane.showMessageDialog(PenduFrame.this, "La lettre a déjà été saisie !");
                        } else {
                            lettresProposees.add(lettre.charAt(0));
                            if (!motADevinerContientLettre(lettre.charAt(0))) {
                                erreurCount++; // Incrémente le nombre d'erreurs si la lettre n'est pas dans le mot à deviner
                            }
                        }
                        penduPanel.repaint(); // Mettre à jour l'affichage du pendu
                    }
                    saisieLettre.setText(""); // Effacer la saisie
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        // Agencement des composants dans la fenêtre
        setLayout(new BorderLayout());
        add(motLabel, BorderLayout.NORTH);
        add(penduPanel, BorderLayout.CENTER);
        add(saisieLettre, BorderLayout.SOUTH);

        lettresProposees = new HashSet<>();
    }

    // Méthode pour dessiner le pendu en fonction des erreurs
    private void dessinerPendu(Graphics g) {
        int largeur = penduPanel.getWidth();
        int hauteur = penduPanel.getHeight();

        g.setColor(Color.BLACK);

        // Dessiner le socle
        g.drawLine(20, hauteur - 20, largeur - 20, hauteur - 20);
        g.drawLine(20, hauteur - 20, 20, 20);
        g.drawLine(20, 20, largeur / 2, 20);

        // Dessiner le poteau vertical
        if (erreurCount > 0) {
            g.drawLine(largeur / 2, 20, largeur / 2, 50);
        }

        // Dessiner la corde
        if (erreurCount > 1) {
            g.drawLine(largeur / 2, 50, largeur / 2 + 50, 50);
        }

        // Dessiner la tête
        if (erreurCount > 2) {
            g.drawOval(largeur / 2 + 40, 50, 20, 20);
        }

        // Dessiner le corps
        if (erreurCount > 3) {
            g.drawLine(largeur / 2 + 50, 70, largeur / 2 + 50, 100);
        }

        // Dessiner le bras gauche
        if (erreurCount > 4) {
            g.drawLine(largeur / 2 + 50, 70, largeur / 2 + 30, 80);
        }

        // Dessiner le bras droit
        if (erreurCount > 5) {
            g.drawLine(largeur / 2 + 50, 70, largeur / 2 + 70, 80);
        }

        // Dessiner la jambe gauche
        if (erreurCount > 6) {
            g.drawLine(largeur / 2 + 50, 100, largeur / 2 + 30, 120);
        }

        // Dessiner la jambe droite
        if (erreurCount > 7) {
            g.drawLine(largeur / 2 + 50, 100, largeur / 2 + 70, 120);
        }

        // Afficher les lettres proposées
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        int x = 20;
        int y = hauteur - 40;
        for (char lettre : lettresProposees) {
            g.drawString(String.valueOf(lettre), x, y);
            x += 20;
        }
    }

    // Méthode pour vérifier si la lettre est dans le mot à deviner
    private boolean motADevinerContientLettre(char lettre) {
        String motADeviner = "PENDU"; // Exemple de mot à deviner

        // Vérifier si la lettre est présente dans le mot à deviner
        for (int i = 0; i < motADeviner.length(); i++) {
            if (motADeviner.charAt(i) == lettre) {
                return true; // La lettre est dans le mot à deviner
            }
        }
        return false; // La lettre n'est pas dans le mot à deviner
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PenduFrame penduFrame = new PenduFrame();
                penduFrame.setVisible(true);
            }
        });
    }
}
