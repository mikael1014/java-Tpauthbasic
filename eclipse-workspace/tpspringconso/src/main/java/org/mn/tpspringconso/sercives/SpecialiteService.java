package org.mn.tpspringconso.sercives;

import java.util.List;

import org.mn.tpspringconso.models.Specialite;

public interface SpecialiteService {
	Specialite getById(long id);

	List<Specialite> lister();

	String ajouter(Specialite specialite);
}
