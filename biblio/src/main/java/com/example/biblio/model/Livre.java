package com.example.biblio.model;

import java.util.List;

//Creation de la classe Livre
public class Livre {
        private String titre;
        private String auteur;
        private String resume;
        private int colonne;
        private int range;
        private int parution;

        public Livre(String titre, String auteur, String resume, int colonne, int range, int parution) {
            this.titre = titre;
            this.auteur = auteur;
            this.resume = resume;
            this.colonne = colonne;
            this.range = range;
            this.parution = parution;
        }

        public String getTitre() {
            return titre;
        }

        public void setTitre(String titre) {
            this.titre = titre;
        }

        public String getAuteur() {
            return auteur;
        }

        public void setAuteur(String auteur) {
            this.auteur = auteur;
        }

        public String getResume() {
            return resume;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }

        public int getColonne() {
            return colonne;
        }

        public void setColonne(int colonne) {
            this.colonne = colonne;
        }

        public int getRange() {
            return range;
        }

        public void setRange(int range) {
            this.range = range;
        }

        public int getParution() {
            return parution;
        }

        public void setParution(int parution) {
            this.parution = parution;
        }

    public String toString() {
        String str = titre + auteur + resume + colonne + range + parution;
        return str;
    }
}
