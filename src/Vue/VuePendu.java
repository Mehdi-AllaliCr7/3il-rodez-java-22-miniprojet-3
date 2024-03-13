package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Vue graphique pour le jeu du Pendu.
 */
public class VuePendu extends JFrame {
    private JLabel motLabel;
    private JLabel definitionLabel;
    private JLabel penduLabel;
    private JLabel lettresProposeesLabel;
    private JTextField lettreField;
    private JButton proposerButton;

    /**
     * Constructeur de la classe VuePendu.
     * Initialise et configure les éléments graphiques de la fenêtre.
     */
    public VuePendu() {
        setTitle("Jeu du Pendu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        motLabel = new JLabel("Mot à deviner : ");
        add(motLabel, BorderLayout.NORTH);

        definitionLabel = new JLabel("Définition : ");
        add(definitionLabel, BorderLayout.CENTER);

        penduLabel = new JLabel("Pendu");
        add(penduLabel, BorderLayout.WEST);

        lettresProposeesLabel = new JLabel("Lettres proposées : ");
        add(lettresProposeesLabel, BorderLayout.SOUTH);

        JPanel panelTexte = new JPanel(new FlowLayout());
        lettreField = new JTextField(1);
        panelTexte.add(lettreField);

        proposerButton = new JButton("Proposer");
        panelTexte.add(proposerButton);

        add(panelTexte, BorderLayout.EAST);
    }

    /**
     * Récupère la lettre proposée par l'utilisateur depuis le champ texte.
     *
     * @return La lettre proposée par l'utilisateur.
     */
    public String getLettreProposee() {
        return lettreField.getText().toUpperCase();
    }

    /**
     * Met à jour l'affichage du mot à deviner.
     *
     * @param mot Le mot à deviner.
     */
    public void setMot(String mot) {
        motLabel.setText("Mot à deviner : " + mot);
    }

    /**
     * Met à jour l'affichage de la définition du mot à deviner.
     *
     * @param definition La définition du mot à deviner.
     */
    public void setDefinition(String definition) {
        definitionLabel.setText("Définition : " + definition);
    }

    /**
     * Met à jour l'affichage des lettres proposées par l'utilisateur.
     *
     * @param lettresProposees Les lettres proposées par l'utilisateur.
     */
    public void setLettresProposees(String lettresProposees) {
        lettresProposeesLabel.setText("Lettres proposées : " + lettresProposees);
    }

    /**
     * Ajoute un ActionListener au bouton "Proposer".
     *
     * @param listener L'ActionListener à ajouter.
     */
    public void addProposerListener(ActionListener listener) {
        proposerButton.addActionListener(listener);
    }

    /**
     * Met à jour l'affichage du mot à deviner avec une nouvelle version.
     *
     * @param nouveauMot Le nouveau mot à deviner.
     */
    public void mettreAJourMot(String nouveauMot) {
        motLabel.setText("Mot à deviner : " + nouveauMot);
    }

    public JLabel getLettresProposees() {
        return lettresProposeesLabel;
    }

    public JLabel getMot() {
        return motLabel;
    }

    public void mettreAJourPendu(int erreurs) {
        ImageIcon penduIcon = new ImageIcon(getClass().getResource("pendu" + erreurs + ".png"));
        penduLabel.setIcon(penduIcon);
    }
}
