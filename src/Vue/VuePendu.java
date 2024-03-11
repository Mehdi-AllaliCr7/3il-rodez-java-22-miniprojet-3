package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VuePendu extends JFrame {
    private JLabel motLabel;
    private JLabel tentativesLabel;
    private JLabel lettresProposeesLabel;
    private JLabel imagePenduLabel;
    private JTextField lettreTextField;
    private JButton soumettreButton;
    private JTextField textFieldProposition;

    public VuePendu() {
        setTitle("Jeu du Pendu");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
        setVisible(true);
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        motLabel = new JLabel("");
        motLabel.setFont(new Font("Serif", Font.BOLD, 24));
        motLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        tentativesLabel = new JLabel("Tentatives restantes: ");
        tentativesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        lettresProposeesLabel = new JLabel("Lettres proposées: ");
        lettresProposeesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        imagePenduLabel = new JLabel();
        imagePenduLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Initialiser l'imagePenduLabel avec l'image de début du jeu si vous avez des images

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(motLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(tentativesLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(lettresProposeesLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(imagePenduLabel);

        getContentPane().add(panel);
    }

    public void afficherMot(String motAffiche) {
        motLabel.setText(motAffiche);
    }

    public void afficherTentatives(int tentativesRestantes) {
        tentativesLabel.setText("Tentatives restantes: " + tentativesRestantes);
    }

    public void afficherLettresProposees(List<Character> lettres) {
        String lettresTexte = lettres.stream().map(String::valueOf).collect(Collectors.joining(", "));
        lettresProposeesLabel.setText("Lettres proposées: " + lettresTexte);
    }

    public void miseAJourImagePendu(int nombreErreurs) {
        // Assurez-vous d'avoir les images dans votre dossier de ressources et changez les noms/path ici
        ImageIcon icon = new ImageIcon("pendu" + nombreErreurs + ".png");
        imagePenduLabel.setIcon(icon);
    }

    public void afficherFinJeu(boolean victoire) {
        JOptionPane.showMessageDialog(this,
                victoire ? "Félicitations, vous avez gagné !" : "Dommage, vous avez perdu. Essayez encore.",
                victoire ? "Victoire" : "Défaite",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void reinitialiserInterface() {
        afficherMot("_ _ _ _ _");
        afficherTentatives(0);
        afficherLettresProposees(List.of());
        // Réinitialiser à l'image de début du jeu
        ImageIcon icon = new ImageIcon("pendu0.png");
        imagePenduLabel.setIcon(icon);
    }

    public void ajouterListenerNouvelleLettre(ActionListener listener) {
        soumettreButton.addActionListener(listener);
        // Vous pouvez aussi ajouter le même listener au champ de texte pour réagir à la touche Entrée
        lettreTextField.addActionListener(listener);
    }

    public void afficherMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String getTexteProposition() {
        return textFieldProposition.getText().trim(); // trim() pour enlever les espaces inutiles
    }
}
