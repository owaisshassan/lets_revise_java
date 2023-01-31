package com.bookLibrary.entityUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtil {

	private static EntityManagerFactory emf;

	static {
		emf=Persistence.createEntityManagerFactory("BookLibraryUnit");
	}

	public static EntityManager provideEntityManager() {
		return emf.createEntityManager();
	}
}



