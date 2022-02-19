package org.mn.tpspringconso.models;

public class Specialite {
    private String titre;
    private String description;
    private TypeSpecialite typeSpecialite;

    public Specialite() {
    }

    public Specialite(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public TypeSpecialite getTypeSpecialite() {
        return typeSpecialite;
    }

    public void setTypeSpecialite(TypeSpecialite typeSpecialite) {
        this.typeSpecialite = typeSpecialite;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Specialite{");
        sb.append("titre=").append(titre);
        sb.append(", description=").append(description);
        sb.append(", typeSpecialite=").append(typeSpecialite);
        sb.append('}');
        return sb.toString();
    }

}
