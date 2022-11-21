package pac;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		System.out.println("INICIO DEL PROGRAMA...");

		Configuration cfg = new Configuration().configure();

		SessionFactory sessionFactory = cfg
				.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sessionFactory.openSession();

		System.out.println("CONFIGURACION REALIZADA");

		Transaction tx = session.beginTransaction();

		Modulo modulo03B = new Modulo();
		modulo03B.setNombre("programacion B");
		modulo03B.setCodigo("M03B");
		session.save(modulo03B);
		System.out
				.println("Insert into modulo, nombre: " + modulo03B.getNombre() + ", codigo: " + modulo03B.getCodigo());

		Modulo modulo06 = new Modulo();
		modulo06.setNombre("Acceso a Datos");
		modulo06.setCodigo("M06");
		session.save(modulo06);
		System.out.println("Insert into modulo, nombre: " + modulo06.getNombre() + ", codigo: " + modulo06.getCodigo());

		Modulo modulo08 = new Modulo();
		modulo08.setNombre("Desarrollo de aplicaciones moviles");
		modulo08.setCodigo("M08");
		session.save(modulo08);
		System.out.println("Insert into modulo, nombre: " + modulo08.getNombre() + ", codigo: " + modulo08.getCodigo());

		Modulo modulo09 = new Modulo();
		modulo09.setNombre("Servicios y procesos");
		modulo09.setCodigo("M09");
		session.save(modulo09);
		System.out.println("Insert into modulo, nombre: " + modulo09.getNombre() + ", codigo: " + modulo09.getCodigo());

		Profesor profesor = new Profesor();
		profesor.setNombre("Alvaro");
		profesor.setSexo("Hombre");
		session.save(profesor);
		System.out.println("Insert into profesor, nombre: " + profesor.getNombre() + ", sexo: " + profesor.getSexo());

		Set<Modulo> setJuan = new HashSet<Modulo>();
		setJuan.add(modulo03B);
		setJuan.add(modulo06);
		setJuan.add(modulo08);
		setJuan.add(modulo09);

		Set<Modulo> setPedro = new HashSet<Modulo>();
		setPedro.add(modulo03B);
		setPedro.add(modulo06);
		setPedro.add(modulo09);

		Set<Modulo> setMarta = new HashSet<Modulo>();
		setMarta.add(modulo08);
		setMarta.add(modulo09);

		Set<Modulo> setCarla = new HashSet<Modulo>();
		setCarla.add(modulo06);
		setCarla.add(modulo08);
		setCarla.add(modulo09);

		Alumno alumno1 = new Alumno();
		alumno1.setNombre("Juan");
		alumno1.setNacionalidad("Espaniola");
		alumno1.setEdad(26);
		alumno1.setSexo("Hombre");
		alumno1.setModulos(setJuan);
		session.save(alumno1);
		System.out.println("Insert into alumno, nombre: " + alumno1.getNombre() + ", nacionalidad: "
				+ alumno1.getNacionalidad() + ", edad: " + alumno1.getEdad() + ", sexo: " + alumno1.getSexo()
				+ ", modulos: " + alumno1.getModulos().size());

		Alumno alumno2 = new Alumno();
		alumno2.setNombre("Pedro");
		alumno2.setNacionalidad("Andorrana");
		alumno2.setEdad(21);
		alumno2.setSexo("Hombre");
		alumno2.setModulos(setPedro);
		session.save(alumno2);
		System.out.println("Insert into alumno, nombre: " + alumno2.getNombre() + ", nacionalidad: "
				+ alumno2.getNacionalidad() + ", edad: " + alumno2.getEdad() + ", sexo: " + alumno2.getSexo()
				+ ", modulos: " + alumno2.getModulos().size());

		Alumno alumno3 = new Alumno();
		alumno3.setNombre("Marta");
		alumno3.setNacionalidad("Espaniola");
		alumno3.setEdad(19);
		alumno3.setSexo("Mujer");
		alumno3.setModulos(setMarta);
		session.save(alumno3);
		System.out.println("Insert into alumno, nombre: " + alumno3.getNombre() + ", nacionalidad: "
				+ alumno3.getNacionalidad() + ", edad: " + alumno3.getEdad() + ", sexo: " + alumno3.getSexo()
				+ ", modulos: " + alumno3.getModulos().size());

		Alumno alumno4 = new Alumno();
		alumno4.setNombre("Carla");
		alumno4.setNacionalidad("Francesa");
		alumno4.setEdad(35);
		alumno4.setSexo("Mujer");
		alumno4.setModulos(setCarla);
		session.save(alumno4);
		System.out.println("Insert into alumno, nombre: " + alumno4.getNombre() + ", nacionalidad: "
				+ alumno4.getNacionalidad() + ", edad: " + alumno4.getEdad() + ", sexo: " + alumno4.getSexo()
				+ ", modulos: " + alumno4.getModulos().size());

		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
