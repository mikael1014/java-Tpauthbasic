package org.mn.tpspringconso.sercives;

import java.util.List;

import org.mn.tpspringconso.models.Specialite;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Test implements CommandLineRunner{
	private final SpecialiteService specialiteService;
	
	public Test(SpecialiteService specialiteService) {
		this.specialiteService = specialiteService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Specialite specialite = specialiteService.getById(1);
		System.out.println(specialite);
		List<Specialite> specialites = specialiteService.lister();
        System.out.println(specialites);
        
        Specialite specialite2 = new Specialite("Spec conso spring", "Description spe conso spring");
        System.out.println(specialiteService.ajouter(specialite2));

	}

}
